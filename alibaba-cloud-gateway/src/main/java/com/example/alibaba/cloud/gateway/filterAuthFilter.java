package com.example.alibaba.cloud.gateway;

import com.alibaba.nacos.api.common.ResponseCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import io.netty.handler.codec.http2.Http2CodecUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @program: Spring-Cloud-Alibaba-Consumer
 * @ClassName filterAuthFilter
 * @description:
 * @author: hujie
 * @create: 2020-05-26 13:39
 **/
@Component
public class filterAuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        if(token == null || token.isEmpty()){
            ServerHttpResponse response = exchange.getResponse();
            //封装错误信息
            Map<String, Object> result = Maps.newHashMap();
            result.put("code", 401);
            result.put("msg", "非法请求");
            result.put("case", "token为空");


            try {
                ObjectMapper objectMapper = new ObjectMapper();
                byte[] data = objectMapper.writeValueAsBytes(result);

                //输出到错误页面
                DataBuffer buffer = response.bufferFactory().wrap(data);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
