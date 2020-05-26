package com.example.nacos.consumer.feign.fallback;

import com.example.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * @program: Spring-Cloud-Alibaba-Consumer
 * @ClassName EchoServiceFallback
 * @description:
 * @author: hujie
 * @create: 2020-05-26 11:17
 **/
@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String message) {
        return "echo fallback";
    }
}
