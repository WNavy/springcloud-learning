1、Spring Cloud Eureka是Spring Cloud Netflix微服务套件中的一部分，基于Netflix Eureka做了二次封装，主要负责完成微服务架构中的服务治理功能
   主要用来实现各个微服务实例的自动化注册与发现

2、如果是单节点的服务注册中心，就需要设置不注册自己，同时不检索实例
    设置参数：
    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
    这两个参数默认为true

3、如果是高可用集群，那注册中心既是服务提供方也是服务消费方，第2步中的参数都设置为true