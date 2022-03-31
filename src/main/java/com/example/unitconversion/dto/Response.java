package com.example.unitconversion.dto;

/**
 * This class is being used to form the response to the API
 */
public class Response {
    private float result;
    private float fromValue;
    private String fromType;
    private String toType;

    /**
     * The Response class constructor
     *
     * @param result The calculated result
     * @param fromValue The given from-value
     * @param fromType The given fromType
     * @param toType The given toType
     */
    public Response(float result, float fromValue, String fromType, String toType) {
        this.result = result;
        this.fromValue = fromValue;
        this.fromType = fromType;
        this.toType = toType;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getFromValue() {
        return fromValue;
    }

    public void setFromValue(float fromValue) {
        this.fromValue = fromValue;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }
}
