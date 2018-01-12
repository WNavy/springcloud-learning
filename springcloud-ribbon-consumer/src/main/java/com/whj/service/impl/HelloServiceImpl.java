package com.whj.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.whj.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * Created by wuhaijun on 2018/1/11.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        return restTemplate.getForObject("http://HELLO-SERVER/hello",String.class);
    }

    @HystrixCommand(fallbackMethod = "helloFallback",groupKey = "helloGroup",threadPoolKey = "helloThread")
    public Future<String> asyHello(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://HELLO-SERVER/hello",String.class);
            }
        };
    }

    /**
     * 使用HystrixObservableCommand命令
     * 通过observableExecutionMode参数指定指定observer()还是toObservable()
     * ObservableExecutionMode.EAGER → observer()
     * ObservableExecutionMode.LAZY → toObservable()
     * @return
     */
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY,fallbackMethod = "helloFallback")
    public Observable<String> getHello(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try{
                    if(!subscriber.isUnsubscribed()){
                        String response = restTemplate.getForObject("http://HELLO-SERVER/hello",String.class);
                        subscriber.onNext(response);
                        subscriber.onCompleted();
                    }
                } catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

    public String helloFallback(){
        return "error";
    }
}
