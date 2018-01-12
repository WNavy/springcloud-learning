package com;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by wuhaijun on 2018/1/8.
 */
//@EnableDiscoveryClient注解让客户端注册为Eureka客户端，以获得服务发现的能力
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
