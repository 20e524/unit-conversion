package com.example.unitconversion.strategy;

public interface ConversionStrategy {

    String getConversionCode();

    float execute(Float fromValue, String fromType, String toType);

}
