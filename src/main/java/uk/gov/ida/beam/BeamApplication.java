package uk.gov.ida.beam;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ida.beam.resources.TestResource;

public class BeamApplication extends Application<BeamConfiguration> {

   public static final Logger LOGGER = LoggerFactory.getLogger(BeamApplication.class);

   public static void main(String[] args) throws Exception {
        new BeamApplication().run(args);
    }

//    @Override
//    public String getName() {
//        return "beam-client";
//    }

    @Override
    public void run(final BeamConfiguration configuration, final Environment environment) throws Exception {
//        environment.jersey().register(new TestResource());
        LOGGER.info("Application name: {}", configuration.getAppName()); //log the app name
    }
}
