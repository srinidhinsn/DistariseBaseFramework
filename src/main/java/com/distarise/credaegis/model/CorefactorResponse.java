package com.distarise.credaegis.model;

public class CorefactorResponse {
    private String response;
    private String unique_id;
    private String response_code;
    private String response_type;

    public CorefactorResponse(String response, String unique_id, String response_code, String response_type) {
        this.response = response;
        this.unique_id = unique_id;
        this.response_code = response_code;
        this.response_type = response_type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }
}
