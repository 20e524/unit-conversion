package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.lang.Float.compare;

@Service
public class FToC implements ConversionStrategy {

    private final static String CONVERSIONCODE = "F to C";

    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (compare(fromValue, -459.67f) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From Value must be greater than or equal to -459.67°F");
        }
        return (float) 5/9 * (fromValue - 32);
    }
}
