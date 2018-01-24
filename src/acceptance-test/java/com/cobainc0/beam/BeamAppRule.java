//package com.cobainc0.beam;
//
//import io.dropwizard.testing.ConfigOverride;
//import io.dropwizard.testing.junit.DropwizardAppRule;
//
//import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
//
//public class BeamAppRule extends DropwizardAppRule<BeamConfiguration> {
//    public BeamAppRule() {
//        super(
//                BeamApplication.class,
//                resourceFilePath("app-config.yml"),
//                ConfigOverride.config("server.applicationConnectors[0].port", "0"),
//                ConfigOverride.config("server.adminConnectors[0].port", "0")
//        );
//    }
//}
