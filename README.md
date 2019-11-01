# iscp  
微服务脚手架，相关技术spring-cloud、spring-cloud-alibaba、nacos、sentinel、skywalking、swagger2、yapi、ELK(ElasticSearch + LogStash + Kibana)  

## 相关依赖框架  
* 1、spring-boot使用2.1.6.RELEASE  
* 2、spring-cloud使用Greenwich.RELEASE  
* 3、spring-cloud-alibaba使用2.1.0.RELEASE  
* 4、nacos-server使用1.1.3  
* 5、sentinel-dashboard使用1.6.3  
* 6、apache-skywalking-apm使用6.3.0  
>> 客户端使用（在jvm加入如下信息）  
>>> -javaagent:skywalking-agent.jar绝对路径 (如：C:\\apache-skywalking\\agent\\skywalking-agent.jar)  
>>> -Dskywalking.agent.service_name=服务名字 (如：demo-consumer)  
>>> -Dskywalking.collector.backend_service=skywalking服务地址与端口 (如：127.0.0.1:11800)  
>>> 或  
>>> java -javaagent:skywalking-agent.jar绝对路径（如：C:\\apache-skywalking\\agent\\skywalking-agent.jar)  
>>>      -Dskywalking.agent.service_name=服务名字 (如：demo-consumer)  
>>>      -Dskywalking.collector.backend_service=skywalking服务地址与端口 (如：127.0.0.1:11800)  
>>>      -jar 项目jar包 (如：iscp-nacos-0.0.1-SNAPSHOT.jar)  
* 7、yapi使用1.83  
>> yapi安装  
>>> npm install -g yapi-cli --registry https://registry.npm.taobao.org  
>>> yapi server  
>> 服务管理  
>>> npm install pm2 -g  //安装pm2  
>>> cd  {项目目录}  
>>> pm2 start "vendors/server/app.js" --name yapi //pm2管理yapi服务  
>>> pm2 info yapi //查看服务信息  
>>> pm2 stop yapi //停止服务  
>>> pm2 restart yapi //重启服务  
* 8、zookeeper使用3.5.5  
>> 启动zookeeper  
>>> cmd，输入“zkServer“，运行Zookeeper  
* 9、Kafka使用2.12-2.3.0  
>> 启动Kafka  
>>> Kafka安装目录下执行.\bin\windows\kafka-server-start.bat .\config\server.properties  
* 10、ElasticSearch使用7.4.0  
>> 注册windows服务  
>>> elasticsearch-service.bat install  
>>> elasticsearch-service.bat manager  
* 11、LogStash使用7.4.0  
>> 启动LogStash  
>>> cd C:\elk\logstash-7.4.0  
>>> .\bin\logstash -f config\logstash-kafka.conf  
* 12、Kibana使用7.4.0  
>> 启动Kibana  
>>> 双击kibana.bat启动  

## 项目模块介绍  
>### [iscp-nacos项目](https://github.com/oyd505/iscp/tree/master/iscp-nacos)  
* 1、使用alibaba-nacos管理服务  
* 2、使用alibaba-nacos管理配置文件  
* 3、使用SkyWalking实现分布式追踪  

>### [iscp-feign-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-feign-sentinel)  
* 同上iscp-nacos项目  
* 1、使用openfeign声明式调用下游服务  
* 2、使用alibaba-sentinel做熔断降级控制  
* 3、使用alibaba-nacos存储服务降级规则  

>### [iscp-gateway-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-gateway-sentinel)  
* 同上iscp-nacos项目  
* 1、使用spring-cloud-gateway做api网关  
* 2、使用alibaba-sentinel做限流控制  
* 3、使用alibaba-nacos存储服务限流规则  

>### [iscp-authserver项目](https://github.com/oyd505/iscp/tree/master/iscp-authserver)  
* 同上iscp-nacos项目  
* 1、使用spring-cloud-oauth2实现认证服务器  

>### [iscp-resource项目](https://github.com/oyd505/iscp/tree/master/iscp-resource)  
* 同上iscp-nacos项目  
* 1、使用spring-cloud-oauth2实现资源服务器  

>### [iscp-swagger项目](https://github.com/oyd505/iscp/tree/master/iscp-swagger)  
* 同上iscp-nacos项目  
* 1、使用swagger2生成接口数据  
* 2、使用yapi自动同步swagger数据管理接口  

>### [iscp-kafka项目](https://github.com/oyd505/iscp/tree/master/iscp-kafka)  
* 同上iscp-nacos项目  
* 1、使用spring-kafka发布和订阅消息  

>### [iscp-stream项目](https://github.com/oyd505/iscp/tree/master/iscp-stream)  
* 同上iscp-nacos项目  
* 1、使用spring-cloud-stream发布和订阅消息  

>### [iscp-elk项目](https://github.com/oyd505/iscp/tree/master/iscp-elk)  
* 同上iscp-nacos项目  
* 1、使用kafka、logstash采集日志  
* 2、使用elasticsearch存储日志  
* 3、使用kibana展示日志  

## 测试  
* 获取token  
>> Grant Type: Authorization Code  
>> Callback URL: http://127.0.0.1:9005/login  
>> Auth URL: http://localhost:9103/oauth/authorize  
>> Access Token URL: http://localhost:9103/oauth/token  
>> Client ID: client1  
>> Client Secret: 123456  
* 访问资源  
>> url: http://localhost:9104/info/user  
>> headers: Authorization:Bearer 894fc69f-6a60-4cff-b762-374db6c0e033  
* 访问、同步与管理接口  
>> swagger界面url： http://localhost:9105/swagger-ui.html  
>> swagger数据url: http://localhost:9105/v2/api-docs  
>> yapi管理url: http://localhost:3000（默认密码为 ymfe.org）  
* ELK收集处理日志  
>> cmd输入“zkServer“，运行Zookeeper  
>> 运行.\bin\windows\kafka-server-start.bat .\config\server.properties启动kafka  
>> 启动ElasticSearch服务  
>> 运行logstash -f ..\config\logstash-kafka.conf启动LogStash  
>> 双击kibana.bat启动Kibana  
>> 浏览器访问http://localhost:5601管理Kibana  
>> Kibana的Management页面创建Index Patterns  
>> Kibana的Discover页面搜索日志数据  
* 构建、运行docker镜像  
>> 前提条件：windows系统安装好docker环境并与PowerShell建立链接（docker-machine env default | Invoke-Expression）  
>> 项目中编写Dockerfile文件  
>> 项目环境下执行如下命令（mvn dockerfile:build）  
>> 执行docker images命令查看docker镜像  
>> 运行docker镜像：docker run -idt -p 9100:9100 --name iscp-nacos 192.168.99.103:5000/iscp-nacos:0.0.1-SNAPSHOT  
>> 进入docker镜像内部：docker exec -it iscp-nacos /bin/sh  
* minikube运行应用    
>> 前提条件：搭建docker registry和minikube环境  
>> 编写iscp-nacos.yaml脚本并执行命令kubectl create -f iscp-nacos.yaml创建pod  
>> 执行kubectl get pods查看pod  
>> 使用kubectl port-forward iscp-nacos-pod 9100:9100实现pod端口临时转发  

## 注意事项  
* 1、namespase如果不是public，需要配置对应的命名空间ID（如：c6ef4ed4-1a37-4672-a8dc-53926e8e9b49）  
* 2、使用监控spring-cloud-gateway,需要将apm-spring-cloud-gateway-2.x-plugin-6.3.0.jar插件从optional-plugins目录移到plugins目录,否则traceId不传递  
* 3、单机测试时，认证服务器redirectUris一定要写成127.0.0.1，确保认证服务器和sso客户端不同域名，防止浏览器使用同一个cookie导致页面一直再login页重定向  
* 4、如果pom.xml文件第一行报错 Unknown Error，在pom中的properties里加上 <maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>就可以了  
* 5、日志中使用SkyWalking的apm-toolkit-logback-1.x增加TraceId，使用ConsoleAppender和KafkaAppender都能正确获取TraceId，但使用LogstashTcpSocketAppender获取不到TraceId  

## 参考资料  
* 1、[spring-cloud](https://spring.io/projects/spring-cloud)、[Spring Cloud中文网](https://www.springcloud.cc/)、[Spring Cloud中国社区](http://springcloud.cn/)  
* 2、[spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba)  
* 3、[Nacos](https://nacos.io/zh-cn/)  
* 4、[Sentinel](https://github.com/alibaba/Sentinel)  
* 5、[SkyWalking](http://skywalking.apache.org/)、[OpenTracing文档中文版](https://wu-sheng.gitbooks.io/opentracing-io/content/)  
* 6、[YApi](https://github.com/YMFE/yapi)  
* 7、[zookeeper](http://zookeeper.apache.org)  
* 8、[kafka](http://kafka.apache.org)  
* 9、[ELK](https://www.elastic.co/cn/products/elastic-stack)  
