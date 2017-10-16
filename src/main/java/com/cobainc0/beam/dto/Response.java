package com.cobainc0.beam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    private String status;

    //needed for deserialization
    public Response() {

    }

    public Response(String status) {
        this.status = status;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

}