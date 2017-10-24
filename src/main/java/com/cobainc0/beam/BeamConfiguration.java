package com.cobainc0.beam;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class BeamConfiguration extends Configuration {

    @NotEmpty
    private String appName;

    @NotEmpty
    private String defaultName;

    @NotEmpty
    private String template;

    @NotEmpty
    private String adminPassword;



    @JsonProperty
    public String getAppName() {
        return this.appName;
    }

    @JsonProperty
    public void setAppName(String appName) {
        this.appName = appName;
    }


    @JsonProperty
    public String getTemplate(){
        return this.template;
    }

    @JsonProperty
    public void setTemplate(String template){
        this.template = template;
    }


    @JsonProperty
    public String getDefaultName(){
        return this.defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }

    @JsonProperty
    public String getAdminPassword(){
        return adminPassword;
    }

    @JsonProperty
    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }
}

