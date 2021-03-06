package com.example.nacos.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class NacosConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerFeignApplication.class, args);
    }

}
