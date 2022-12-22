package com.distarise.credaegis.model;

public class CorefactorRequest {
    private String mobile;
    private String name;
    private String pan;
    private String email;

    private String cibilscore;

    private String description;
    private String file_download_url;


    public CorefactorRequest(String mobile, String name, String pan, String email, String cibilscore) {
        this.mobile = mobile;
        this.name = name;
        this.pan = pan;
        this.email = email;
        this.cibilscore = cibilscore;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCibilscore() {
        return cibilscore;
    }

    public void setCibilscore(String cibilscore) {
        this.cibilscore = cibilscore;
    }
}
