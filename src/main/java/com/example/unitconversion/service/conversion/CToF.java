package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CToF implements ConversionStrategy {

    private final static String CONVERSIONCODE = "C to F";

    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (fromValue < -273.15) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From Value must be greater than -273.15°C");
        }
        return fromValue * 9/5 + 32;
    }
}
