package com.example.unitconversion.service;

import com.example.unitconversion.dto.Request;
import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UnitConversionService {

    private final Map<String, ConversionStrategy> servicesByConversionCode;

    @Autowired
    CustomMapFromListDynamicAutowireService(List<ConversionStrategy> conversionStrategyList) {
        servicesByConversionCode = conversionStrategyList.stream()
                .collect(Collectors.toMap(ConversionStrategy::getConversionCode, Function.identity()));
    }


    public float convert(Float fromValue, String fromType, String toType) {

        String lookForConversionCode = fromType + " to " + toType;

        ConversionStrategy conversionStrategy = servicesByConversionCode.get(lookForConversionCode);

        return conversionStrategy.execute(fromValue, fromType, toType); //hier kommt unser Ergebniss rein statt boolean
    }
}
