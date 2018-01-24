package com.cobainc0.beam;

import com.cobainc0.beam.auth.BeamAuthenticator;
import com.cobainc0.beam.auth.BeamAuthoriser;
import com.cobainc0.beam.core.VendorDAO;
import com.cobainc0.beam.core.User;
import com.cobainc0.beam.resources.BeamResource;
import com.cobainc0.beam.resources.VendorResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BeamApplication extends Application<BeamConfiguration> {

    public static final Logger LOGGER = LoggerFactory.getLogger(BeamApplication.class);

    public BeamApplication(){}


   public static void main(String[] args) throws Exception {
       if (args == null || args.length == 0) {
           new BeamApplication().run("server", System.getenv("CONFIG_FILE"));
       } else {
           new BeamApplication().run(args);
       }
   }


    @Override
    public String getName(){
        return "beam app";
    }

    @Override
    public void initialize(Bootstrap<BeamConfiguration> bootstrap) {
        super.initialize(bootstrap);
        //allow dropwizard to substitute values in config file e.g ${PORT:-53000}
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

    }

    @Override
    public void run(BeamConfiguration appConfig, Environment environment) throws BeamException {

        //log the appConfig data for app, template and default names
        LOGGER.info("application name: {}", appConfig.getAppName());
        LOGGER.info("template name: {}", appConfig.getTemplate());
        LOGGER.info("defaultName name: {}", appConfig.getDefaultName());

        environment
                .jersey()
                .register(new BeamResource());

        //set up authenticator
        environment
                .jersey()
                .register(
                        new AuthDynamicFeature(
                                new BasicCredentialAuthFilter.Builder<User>()
                                        .setAuthenticator(new BeamAuthenticator(appConfig))
                                        .setAuthorizer(new BeamAuthoriser())
                                        .setRealm("SUPER SECRET STUFF")
                                        .buildAuthFilter()));
        environment
                .jersey()
                .register(RolesAllowedDynamicFeature.class);
        //Enable use of @Auth to inject a custom Principal type into a resource
        environment
                .jersey()
                .register(new AuthValueFactoryProvider.Binder<User>(User.class));

        //use JDBI instead of hibernate
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, appConfig.getDataSourceFactory(), "mysql");
        final VendorDAO vendorDA0 = jdbi.onDemand(VendorDAO.class);
        environment.jersey().register(new VendorResource(vendorDA0));
    }
        //debugging - throw new BeamException("MSG: BEAM EXCEPTION", new Throwable("CAUSE: BEAM CAUSE"));
}
