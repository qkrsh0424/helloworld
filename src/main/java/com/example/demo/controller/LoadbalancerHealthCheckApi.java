package com.example.demo.controller;

import com.example.demo.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loadBalancer/healthCheck")
public class LoadbalancerHealthCheckApi {
    @GetMapping("")
    public ResponseEntity<?> healthCheck() {
        Message message = new Message();

        message.setStatus(HttpStatus.OK);
        message.setMessage("success");

        return new ResponseEntity<>(message, message.getStatus());
    }
}
