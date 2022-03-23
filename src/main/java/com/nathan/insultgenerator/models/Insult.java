package com.nathan.insultgenerator.models;

public class Insult {
    private String personToInsult;
    private String insultText;


    public Insult() {
    }

    public Insult(String personToInsult, String insultText) {
        this.personToInsult = personToInsult;
        this.insultText = insultText;
    }

    public String getPersonToInsult() {
        return this.personToInsult;
    }

    public void setPersonToInsult(String personToInsult) {
        this.personToInsult = personToInsult;
    }

    public String getInsultText() {
        return this.insultText;
    }

    public void setInsultText(String insultText) {
        this.insultText = insultText;
    }



}
