package com.example.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Spring-Cloud-Alibaba-Consumer
 * @ClassName EchoControlelr
 * @description:
 * @author: hujie
 * @create: 2020-05-26 10:59
 **/
@RestController
public class EchoControlelr {
    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message) {
        return "Hello Nacos Discovery " + message;
    }
}
