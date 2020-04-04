package com.cloudnative.grokking.mercury.controller.rpc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
@Slf4j
public class PingController {
    @GetMapping
    @PostMapping
    public String ping() {
        return "pong";
    }
}
