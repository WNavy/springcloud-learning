package com.whj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2018/1/5.
 */
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${from}")
    private String fromValue;

    @RequestMapping(value = "/from")
    public String getFromValue(){
        return this.fromValue;
    }
}
