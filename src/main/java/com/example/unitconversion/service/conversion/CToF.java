package com.example.unitconversion.service.conversion;

import com.example.unitconversion.strategy.ConversionStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.lang.Float.compare;

/**
 * This class implements the ConversionStrategy and provides the attributes and methods to convert Celsius to Fahrenheit
 */
@Service
public class CToF implements ConversionStrategy {

    private final static String CONVERSIONCODE = "C to F";

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
     * This method does the calculation necessary to convert a Celsius value to a Fahrenheit value and return it
     *
     * @param fromValue The value which will be converted
     * @param fromType The type of the current value, in this case C
     * @param toType The type of the demanded conversion value, in this case F
     * @return The converted value
     * @throws Exception An Exception is being thrown if the temperature is below 0 Kelvin
     */

    @Override
    public float execute(Float fromValue, String fromType, String toType) throws Exception {
        if (compare(fromValue, -273.15f) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From Value must be greater than or equal to -273.15°C");
        }
        return fromValue * 9/5 + 32;
    }
}
