package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class KgToG implements ConversionStrategy {

    private final static String CONVERSIONCODE = "kg to g";

    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (fromValue <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "from value must be greater than 0!");
        }
        return fromValue * 1000;
    }
}