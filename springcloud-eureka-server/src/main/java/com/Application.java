package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wuhaijun on 2018/1/8.
 */
//开启服务注册中心
@EnableEurekaServer
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
