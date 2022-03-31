package com.example.unitconversion.service;

import com.example.unitconversion.dto.Request;
import com.example.unitconversion.strategy.ConversionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitConversionServiceTest {

    UnitConversionService unitConversionService;
    ConversionStrategy conversionStrategy;

    /*
    @BeforeEach
    void setup() {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("g to kg");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);
    }
     */

    @Test
    void convertCallsExecuteMethodGToKG() throws Exception {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("g to kg");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);

        Request mockRequest = new Request(55000f, "g", "kg");
        unitConversionService.convert(mockRequest);
        verify(conversionStrategy, times(1)).execute(anyFloat(), any(), any());
    }


    @Test
    void convertCallsExecuteMethodKGToG() throws Exception {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("kg to g");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);

        Request mockRequest = new Request(55000f, "kg", "g");
        unitConversionService.convert(mockRequest);
        verify(conversionStrategy, times(1)).execute(anyFloat(), any(), any());
    }

    @Test
    void convertCallsExecuteMethodFToC() throws Exception {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("F to C");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);

        Request mockRequest = new Request(55000f, "F", "C");
        unitConversionService.convert(mockRequest);
        verify(conversionStrategy, times(1)).execute(anyFloat(), any(), any());
    }

    @Test
    void convertCallsExecuteMethodCToF() throws Exception {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("C to F");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);

        Request mockRequest = new Request(55000f, "C", "F");
        unitConversionService.convert(mockRequest);
        verify(conversionStrategy, times(1)).execute(anyFloat(), any(), any());
    }

    @Test
    void convertThrowsExceptionWrongInput() throws Exception {
        conversionStrategy = mock(ConversionStrategy.class);
        when(conversionStrategy.getConversionCode()).thenReturn("g to kg");
        List<ConversionStrategy> list = new ArrayList<>();
        list.add(conversionStrategy);
        unitConversionService = new UnitConversionService(list);

        Request mockRequest = new Request(55000f, "gg", "kg");
        assertThrows(Exception.class, () -> unitConversionService.convert(mockRequest));
    }
}