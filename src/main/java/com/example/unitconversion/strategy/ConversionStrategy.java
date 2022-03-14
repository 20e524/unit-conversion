package com.example.unitconversion.strategy;

// taken and adapted from: <https://www.baeldung.com/spring-dynamic-autowire>
public interface ConversionStrategy {

    String getConversionCode();

    float execute(Float fromValue, String fromType, String toType) throws Exception;
}
