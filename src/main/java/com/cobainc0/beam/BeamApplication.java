package com.cobainc0.beam;

import com.cobainc0.beam.auth.BeamAuthenticator;
import com.cobainc0.beam.core.User;
import com.cobainc0.beam.resources.BeamResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeamApplication extends Application<BeamConfiguration> {

   public static final Logger LOGGER = LoggerFactory.getLogger(BeamApplication.class);

   public static void main(String[] args) throws Exception {
        new BeamApplication().run(args);
    }


    @Override
    public String getName(){
        return "beam app";
    }


    @Override
    public void run(BeamConfiguration appConfig, Environment environment) throws Exception {

        //log the appConfig data for app, template and default names
        BeamApplication.LOGGER.info("application name: {}", appConfig.getAppName());
        BeamApplication.LOGGER.info("template name: {}", appConfig.getTemplate());
        BeamApplication.LOGGER.info("defaultName name: {}", appConfig.getDefaultName());

        environment.jersey()
                .register(
                new BeamResource()
        );

        //set up authenticator
        environment.jersey()
                .register(
                AuthFactory.binder(
                        new BasicAuthFactory<>(
                                new BeamAuthenticator(appConfig),
                                "SECURITY REALM",
                                User.class)
                )
        );
    }
}
