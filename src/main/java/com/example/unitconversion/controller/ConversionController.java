package com.example.unitconversion.controller;

import com.example.unitconversion.service.UnitConversionService;
import com.example.unitconversion.dto.Response;
import com.example.unitconversion.dto.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class provides the controller of the API and the single communication route
 */
@RestController
public class ConversionController {

    private UnitConversionService unitConversionService;

    /**
     * The constructor of the ConversionController
     *
     * @param unitConversionService This parameter is an instance of the UnitConversionService
     */
    public ConversionController(UnitConversionService unitConversionService) {
        this.unitConversionService = unitConversionService;
    }

    /**
     * This method provides the route for the communication with the frontend and hands the request over to the
     * correct unitConversionService for the conversion
     *
     * @param request The request according to the Request class
     * @return The response according to the Response class
     * @throws Exception An exception is being thrown in the case of a BAD_REQUEST
     */
    @PostMapping("/api/convert")
    public Response convert(@RequestBody @Valid Request request) throws Exception {
        return unitConversionService.convert(request);
    }
}
