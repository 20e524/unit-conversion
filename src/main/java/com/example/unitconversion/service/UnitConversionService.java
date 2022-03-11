package com.example.unitconversion.service;

import com.example.unitconversion.dto.Request;
import com.example.unitconversion.dto.Response;
import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UnitConversionService {

    private final Map<String, ConversionStrategy> servicesByConversionCode;

    @Autowired
    public UnitConversionService(List<ConversionStrategy> conversionStrategyList) {
        servicesByConversionCode = conversionStrategyList.stream()
                .collect(Collectors.toMap(ConversionStrategy::getConversionCode, Function.identity()));
    }

    public Response convert(Request request) throws Exception {
        Float fromValue = request.getFromValue();
        String fromType = request.getFromType();
        String toType = request.getToType();

        String lookForConversionCode = fromType + " to " + toType;
        if (!servicesByConversionCode.containsKey(lookForConversionCode)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input type combination does not exists");
        }
        ConversionStrategy conversionStrategy = servicesByConversionCode.get(lookForConversionCode);
        try {
            float result = conversionStrategy.execute(fromValue, fromType, toType);
            System.out.println(result);
            return new Response (result, fromValue, fromType, toType);
        } catch (Exception e) {
            throw e;
        }
    }
}
