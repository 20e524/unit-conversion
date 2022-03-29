package com.example.unitconversion.dto;

import javax.validation.constraints.Positive;

/**
 * This class is being used to form the request from the API
 */
public class Request {

    private Float fromValue;
    private String fromType;
    private String toType;

    /**
     * The Request class constructor
     *
     * @param fromValue The submitted from-value
     * @param fromType The submitted fromType
     * @param toType The submitted toType
     */
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
