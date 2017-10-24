package com.cobainc0.beam.resources;

import com.cobainc0.beam.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;


public class BeamResourceTest {


    private static final Authenticator<BasicCredentials, User> STUB_AUTHENTICATOR =
            new Authenticator<BasicCredentials, User>() {
                @Override
                public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
                    return Optional.of(new User());
                }
            };

    //jersey client feature
   private static final HttpAuthenticationFeature FEATURE
           = HttpAuthenticationFeature.basic("u", "p");

    //use credentials for each method
    @BeforeClass
    public static void setUpClass(){
        TEST_RULE_FOR_API_TEST_CLASS
                .getJerseyTest()
                .client()
                .register(FEATURE);
    }

    @ClassRule//start/stop app
    public static final ResourceTestRule TEST_RULE_FOR_API_TEST_CLASS = ResourceTestRule
            .builder()
            .addProvider(AuthFactory.binder(new BasicAuthFactory<>(
                    STUB_AUTHENTICATOR,
                    "test secure realm",
                    User.class
            )))
            .setTestContainerFactory(
                    new GrizzlyWebTestContainerFactory()
            )
            .addResource(new BeamResource())
            .build();



     @Test
     public void getPassingRule() throws Exception{
        String expected = "{\"status\":\"pass\"}";
        String actual = TEST_RULE_FOR_API_TEST_CLASS
                .getJerseyTest() //Jersey test class - connects to jersey resource
                .target("api/jsonResponse") //where
                .request(MediaType.APPLICATION_JSON) //request type
                .get(String.class); //return instance of this type
         assertEquals(expected, actual);
     }


    @Test
    public void getSaySomething() throws Exception {
        String expected = "Sshh";
        String actual = TEST_RULE_FOR_API_TEST_CLASS
                .getJerseyTest()
                .target("api/stringResponse")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
    }

    @Test
    public void getAuthentication() throws Exception{
         String expected = "Hello secured world";
         String actual = TEST_RULE_FOR_API_TEST_CLASS
                 .getJerseyTest()
                 .target("api/secured")
                 .request(MediaType.TEXT_PLAIN)
                 .get(String.class);
        assertEquals(expected, actual);
    }

}
