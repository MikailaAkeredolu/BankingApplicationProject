package com.bankingapplicationmain.bankingapplicationmain.models.enums;

public enum Type {

    @JsonProperty("Savings")
    SAVINGS,
    @JsonProperty("Checking")
    CHECKING,
    @JsonProperty("Credit")
    CREDIT;

    Type() {

    }

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }



}
