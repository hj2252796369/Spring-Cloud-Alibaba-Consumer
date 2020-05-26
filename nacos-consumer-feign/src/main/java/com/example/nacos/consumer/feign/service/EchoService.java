package com.example.nacos.consumer.feign.service;

import com.example.nacos.consumer.feign.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: Spring-Cloud-Alibaba-Consumer
 * @ClassName EchoService
 * @description:
 * @author: hujie
 * @create: 2020-05-26 11:07
 **/
@FeignClient(value = "nacos-provider", fallback = EchoServiceFallback.class)
public interface EchoService {
    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);
}
