package com.cobainc0.beam;

import com.cobainc0.beam.auth.BeamAuthenticator;
import com.cobainc0.beam.auth.BeamAuthoriser;
import com.cobainc0.beam.core.User;
import com.cobainc0.beam.core.Vendor;
import com.cobainc0.beam.core.VendorDA0;
import com.cobainc0.beam.resources.BeamResource;
import com.cobainc0.beam.resources.VendorResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BeamApplication extends Application<BeamConfiguration> {

    public static final Logger LOGGER = LoggerFactory.getLogger(BeamApplication.class);

    //hibernate bundle
    private final HibernateBundle<BeamConfiguration> hibernateBundle = new HibernateBundle<BeamConfiguration>(
            //pass all entity classes
            Vendor.class,
            User.class
    ) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(BeamConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };


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
        bootstrap.addBundle(hibernateBundle);

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

        final VendorDA0 vendorDA0 = new VendorDA0(hibernateBundle.getSessionFactory());
        environment
                .jersey()
                .register(new VendorResource(vendorDA0));
    }
        //debugging - throw new BeamException("MSG: BEAM EXCEPTION", new Throwable("CAUSE: BEAM CAUSE"));
}
