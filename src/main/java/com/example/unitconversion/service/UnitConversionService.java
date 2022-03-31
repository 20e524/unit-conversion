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

// taken and adapted from: <https://www.baeldung.com/spring-dynamic-autowire>

/**
 * This class delegates the request to the corresponding implementation of the ConversionStrategy Interface
 * and returns the correct response
 */
@Service
public class UnitConversionService {

    private final Map<String, ConversionStrategy> servicesByConversionCode;

    /**
     * The constructor goes through all the available Conversioncodes (private final Map<String, ConversionStrategy>)
     * and selects the corresponding service, which is given to servicesByConversionCode
     *
     * @param conversionStrategyList The List of all the conversion strategies
     */
    @Autowired
    public UnitConversionService(List<ConversionStrategy> conversionStrategyList) {
        servicesByConversionCode = conversionStrategyList.stream()
                .collect(Collectors.toMap(ConversionStrategy::getConversionCode, Function.identity()));
    }


    /**
     * This method takes the request and gives it to the corresponding implementation of this class, where the
     * conversion is being done, the calculated value is subsequently used for the response
     *
     * @param request The request received from the frontend, which consists of fromValue, fromType and toType
     * @return The Response with the result(value), fromValue, fromType and toType
     * @throws Exception An exception is being thrown in the case of a BAD_REQUEST (request deviates from expected request)
     */
    public Response convert(Request request) throws Exception {
        Float fromValue = request.getFromValue();
        String fromType = request.getFromType();
        String toType = request.getToType();

        String lookForConversionCode = fromType + " to " + toType;
        if (!servicesByConversionCode.containsKey(lookForConversionCode)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Input type combination does not exist");
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
