package com.example.unitconversion.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.stereotype.Service;

@Service
public class gToKG implements ConversionStrategy {

    private final static String CONVERSIONCODE = "g to kg";

    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    @Override
    public float execute(Float fromValue, String fromType, String toType) {
        return fromValue / 1000;
    }

}
