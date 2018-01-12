package com.whj.service;

import rx.Observable;

import java.util.concurrent.Future;

/**
 * Created by wuhaijun on 2018/1/11.
 */
public interface HelloService {
    /**
     * 执行HystrixCommand命令的同步执行
     * @return
     */
    public String hello();

    /**
     * 执行HystrixCommand命令的异步执行
     * @return
     */
    public Future<String> asyHello();

    /**
     * 执行HystrixObservableCommand命令
     * @return
     */
    public Observable<String> getHello();
}
