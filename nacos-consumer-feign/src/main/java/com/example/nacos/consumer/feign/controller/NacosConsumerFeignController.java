package com.example.nacos.consumer.feign.controller;

import com.example.nacos.consumer.feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Spring-Cloud-Alibaba-Consumer
 * @ClassName NacosConsumerFeignController
 * @description:
 * @author: hujie
 * @create: 2020-05-26 11:08
 **/
@RestController
public class NacosConsumerFeignController {
    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/hi")
    public String echo() {
        return echoService.echo("Hi Feign");
    }
}
