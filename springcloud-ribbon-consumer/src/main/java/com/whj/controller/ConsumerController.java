package com.whj.controller;

import com.whj.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscription;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;

/**
 * Created by wuhaijun on 2018/1/9.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer-syn",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/ribbon-consumer-asyn",method = RequestMethod.GET)
    public String helloConsumerAsy() throws Exception {
        return helloService.asyHello().get();
    }

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String getHello() throws Exception {
        Iterator<String> iterator = helloService.getHello().toBlocking().getIterator();
        return iterator.next();
        /*while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return "test";*/
    }
}
