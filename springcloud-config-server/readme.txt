1、访问配置信息的URL与配置文件的映射关系如下：
url:/{application}/{profile}/{label}
这种路径会映射如下命名的配置文件：
{application}-{profile}.yml/{application}-{profile}.properties/{application}.yml/{application}.properties;
/{label}/{application}-{profile}.properties

2、不带{label}分支信息，默认访问master分支

3、每次获取配置的时候，从Git远程仓库获取最新的配置到本地，然后在本地Git仓库中读取并返回。当远程仓库无法获取时，直接将本地内容返回
