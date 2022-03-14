package com.example.unitconversion.service;

import com.example.unitconversion.dto.Request;
import com.example.unitconversion.strategy.ConversionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitConversionServiceTest {

    UnitConversionService unitConversionService;
    ConversionStrategy conversionStrategy;

    @BeforeEach
    void setup() {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("g to kg");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);
    }

    @Test
    void convertCallsExecuteMethod() throws Exception {
        Request mockRequest = new Request(55000f, "g", "kg");
        unitConversionService.convert(mockRequest);
        verify(conversionStrategy, times(1)).execute(anyFloat(), any(), any());
    }

    @Test
    void convertThrowsExceptionWrongInput() throws Exception {
        Request mockRequest = new Request(55000f, "hh", "kg");
        assertThrows(Exception.class, () -> unitConversionService.convert(mockRequest));
    }
}