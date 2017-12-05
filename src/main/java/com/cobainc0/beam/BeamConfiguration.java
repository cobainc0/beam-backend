package com.cobainc0.beam;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BeamConfiguration extends Configuration {

    @NotNull
    private String appName;

    @NotNull
    private String defaultName;

    @NotNull
    private String template;

    @NotNull
    private String adminPassword;

    //dataSourceFactory password
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // will skip it during serialization
    private String password = null;

    //dataSourceFactory
    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    //dataSourceFactory
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    //dataSourceFactory
    @JsonProperty
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    //dataSourceFactory
    @JsonProperty
    public void setPassword(String password){
        this.password = password;
    }

    //dataSourceFactory
//    @JsonProperty
//    public String getPassword() {
//        return password;
//    }

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

