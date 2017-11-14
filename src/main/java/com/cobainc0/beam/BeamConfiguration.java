package com.cobainc0.beam;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BeamConfiguration extends Configuration {

    @NotEmpty
    private String appName;

    @NotEmpty
    private String defaultName;

    @NotEmpty
    private String template;

    @NotEmpty
    private String adminPassword;

    //database password
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // will skip it during serialization
    private String password = null;

    //database
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    //database
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    //database
    @JsonProperty
    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }

    //database
    @JsonProperty
    public void setPassword(String password){
        this.password = password;
    }

    //database
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

