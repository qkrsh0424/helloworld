package com.example.demo.controller;

import com.example.demo.message.Message;
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

        message.setStatus(HttpStatus.OK);
        message.setMessage(serverMessage);

        return new ResponseEntity<>(message, message.getStatus());
    }
}
