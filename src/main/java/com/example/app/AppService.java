package com.example.app;

import org.springframework.stereotype.Component;

@Component
public class AppService {

    public String message(String value) {
        return "Dear " + value +" your payment was accepted !";
    }
}
