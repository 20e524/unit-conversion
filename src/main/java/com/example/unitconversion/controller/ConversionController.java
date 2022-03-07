package com.example.unitconversion.controller;

import com.example.unitconversion.service.UnitConversionService;
import com.example.unitconversion.dto.Response;
import com.example.unitconversion.dto.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConversionController {

    private UnitConversionService unitConversionService;

    public ConversionController(UnitConversionService unitConversionService) {
        this.unitConversionService = unitConversionService;
    }

    @PostMapping("/api/convert")
    public Response convert(@RequestBody @Valid Request request) {
        Float fromValue = request.getFromValue();
        String fromType = request.getFromType();
        String toType = request.getToType();
        float result = unitConversionService.convert(fromValue, fromType, toType);
        return new Response(result, fromValue, fromType, toType);
    }
}
