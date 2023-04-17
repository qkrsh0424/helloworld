package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RuntimeKeyUtils {
    public final static String RUNTIME_KEY = UUID.randomUUID().toString();
}
