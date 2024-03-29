package com.example.demo.controller;

import com.example.demo.message.Message;
import com.example.demo.utils.RuntimeKeyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldApi {
    @Value("${app.server.message}")
    private String serverMessage;

    @GetMapping("")
    public ResponseEntity<?> helloworld() {
        Message message = new Message();
        StringBuilder sb = new StringBuilder();
        sb.append("[BuildTime Key : " + serverMessage);
        sb.append("], [");
        sb.append("RunTime Key : " + RuntimeKeyUtils.RUNTIME_KEY);
        sb.append("]");

        message.setStatus(HttpStatus.OK);
        message.setMessage(sb.toString());

        return new ResponseEntity<>(message, message.getStatus());
    }
}
