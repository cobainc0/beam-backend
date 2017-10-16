package com.cobainc0.beam.resources;


import com.cobainc0.beam.dto.Response;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTest {


    @ClassRule
    public static final ResourceTestRule testRuleForApiTestClass = ResourceTestRule.builder()
            .addResource(new Api())
            .build();

    @Test
    public void getPassingRule() throws Exception {
        assertThat(ApiTest.testRuleForApiTestClass.target("api/jsonResponse").request().get(Response.class).getStatus())
                .isEqualTo("pass");

    }

    @Test
    public void getSaySomething() throws Exception {
        assertThat(ApiTest.testRuleForApiTestClass.target("api/stringResponse").request().get(String.class))
                .matches("Sshh");
    }

}
