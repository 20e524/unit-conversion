package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

// taken and adapted from: <https://www.baeldung.com/spring-dynamic-autowire>
/**
 * This class implements the ConversionStrategy and provides the attributes and methods to convert Gram to Kilogram
 */
@Service
public class GToKG implements ConversionStrategy {

    private final static String CONVERSIONCODE = "g to kg";

    /**
     * This method returns the private final static String CONVERSIONCODE which the UnitConversionService needs to implement the corresponding class
     *
     * @return the conversioncode which consists ou auf the fromType followed by " to " and the toType
     */
    @Override
    public String getConversionCode() {
        return CONVERSIONCODE;
    }

    /**
     * This method does the calculation necessary to convert a Gram value to a Kilogram value and return it
     *
     * @param fromValue The value which will be converted
     * @param fromType The type of the current value, in this case G
     * @param toType The type of the demanded conversion value, in this case KG
     * @return The converted value
     * @throws Exception An Exception is being thrown if the value is equal or lower than 0
     */
    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (fromValue <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From value must be greater than 0!");
        }
        return fromValue / 1000;
    }
}
