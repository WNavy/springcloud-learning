1、用来指定获取config-server的配置。文件名必须交bootstrap.properties，
   这样config-server中的配置信息才能被正确加载

2、根据springboot配置文件加载优先级，从配置中心读取的配置文件高于本身设置的配置文件，所以重复的内容将不再被加载
