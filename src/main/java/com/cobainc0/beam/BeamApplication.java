package com.cobainc0.beam;

import com.cobainc0.beam.resources.Api;
import io.dropwizard.Application;
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
    public void run(BeamConfiguration configuration, Environment environment) throws Exception {

        //log the configuration data for app, template and default names
        BeamApplication.LOGGER.info("application name: {}", configuration.getAppName());
        BeamApplication.LOGGER.info("template name: {}", configuration.getTemplate());
        BeamApplication.LOGGER.info("defaultName name: {}", configuration.getDefaultName());

        environment.jersey().register(new Api());
    }
}
