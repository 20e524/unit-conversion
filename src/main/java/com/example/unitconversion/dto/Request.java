package com.example.unitconversion.dto;

import javax.validation.constraints.Positive;

public class Request {

    private Float fromValue;
    private String fromType;
    private String toType;

    public Request(Float fromValue, String fromType, String toType) {
        this.fromValue = fromValue;
        this.fromType = fromType;
        this.toType = toType;
    }

    public Float getFromValue() {
        return fromValue;
    }

    public String getFromType() {
        return fromType;
    }

    public String getToType() {
        return toType;
    }
}
