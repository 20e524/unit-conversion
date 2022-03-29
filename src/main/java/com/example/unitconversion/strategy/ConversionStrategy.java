package com.example.unitconversion.strategy;

// taken and adapted from: <https://www.baeldung.com/spring-dynamic-autowire>
/**
 * This interface is being implemented by the concrete conversion classes and can be easily expanded
 */
public interface ConversionStrategy {

    /**
     * This method is responsible for returning the conversioncode String of the implementations
     *
     * @return The conversioncode
     */
    String getConversionCode();

    /**
     * This method does the actual calculation to convert one unit to another
     *
     * @param fromValue The value which will be converted
     * @param fromType The type of the current value
     * @param toType The type of the demanded conversion value
     * @return The converted value
     * @throws Exception An Exception is being thrown according to the specifications in the implementation classes
     */
    float execute(Float fromValue, String fromType, String toType) throws Exception;
}
