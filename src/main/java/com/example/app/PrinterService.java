package com.example.app;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class PrinterService {

    @ServiceActivator
    public void printValue(String value){
        System.out.println(value);
    }
}
