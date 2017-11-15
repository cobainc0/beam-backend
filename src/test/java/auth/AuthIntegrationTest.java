package auth;

import com.cobainc0.beam.BeamApplication;
import com.cobainc0.beam.BeamConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class AuthIntegrationTest {

    private static final String CONFIG_PATH = "src/dist/app-config.yml";
    private static final String HTTP_TARGET = "http://localhost:53000";
    private static final String HTTPS_TARGET = "https://localhost:8443";
    private static final String PATH_TO_SECURE_API = "/api/secured";
    private Client client;

    private static final HttpAuthenticationFeature AUTHENTICATION_FEATURE =
            HttpAuthenticationFeature.basic("coba", "pa55word");



    //used to enable SSLConnection
    private static final String HTTPS_KEYSTORE = "beam.keystore";
    private static final String HTTPS_PASSWORD = "pa55word";


    @ClassRule
    public static final DropwizardAppRule<BeamConfiguration> RULE
            = new DropwizardAppRule<BeamConfiguration>(BeamApplication.class, CONFIG_PATH);

    //allow tests to accept SSL/HTTPS - without a cert
    @Before
    public void setUpWithSSL(){
        SslConfigurator sslConfigurator = SslConfigurator.newInstance()
                .trustStoreFile(HTTPS_KEYSTORE)
                .trustStorePassword(HTTPS_PASSWORD);

        SSLContext sslContext = sslConfigurator.createSSLContext();
        client = ClientBuilder.newBuilder() //add ssl context to client
                .sslContext(sslContext)
                .build();
    }



// client without SSL configuration & context
//    @Before
//    public void setUpWithoutSSL(){
//        client = ClientBuilder.newClient();
//    }

    @After
    public void tearDown(){
        client.close();
    }

     @Test
    public void testSadPath(){ //expect 401
        int expectedStatusCode = Response.Status.UNAUTHORIZED.getStatusCode();

        //actual response
        Response response = client
                .target(HTTPS_TARGET)
                .path(PATH_TO_SECURE_API)
                .request()
                .get();

        int actualCode = response.getStatus();

        assertEquals(expectedStatusCode, actualCode);
    }

    @Test
    public void testHappy(){
        String expectedText = "Hello secured world";

        client.register(
                AUTHENTICATION_FEATURE
        ); // add Authentication resource

        //actual response
        String responseText = client
                .target(HTTPS_TARGET)
                .path(PATH_TO_SECURE_API)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class); //specify response type

        assertEquals(expectedText, responseText);
    }


}
