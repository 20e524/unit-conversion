package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

// taken and adapted from: <https://www.baeldung.com/spring-dynamic-autowire>
@Service
public class GToKG implements ConversionStrategy {

    private final static String CONVERSIONCODE = "g to kg";

    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (fromValue <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From value must be greater than 0!");
        }
        return fromValue / 1000;
    }
}
