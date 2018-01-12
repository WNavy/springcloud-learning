package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuhaijun on 2018/1/9.
 * @EnableDiscoveryClient：让客户端注册为Eureka客户端，以获得服务发现的能力
 * @LoadBalanced：开启客户端的负载均衡
 * @EnableCircuitBreaker:开启断路功能
 * 以上三个注解可以使用@SpringCloudApplication注解代替
 */

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
