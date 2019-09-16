# iscp
微服务脚手架

## 相关依赖框架
* 1、spring-boot使用2.1.4.RELEASE
* 2、spring-cloud使用Greenwich.RELEASE
* 3、spring-cloud-alibaba使用2.1.0.RELEASE
* 4、nacos-server使用1.1.3
* 5、sentinel-dashboard使用1.6.3
* 6、apache-skywalking-apm使用6.3.0
>> 客户端使用（在jvm加入如下信息）
>>> -javaagent:skywalking-agent.jar绝对路径 (如：C:\\apache-skywalking\\agent\\skywalking-agent.jar)  
>>> -Dskywalking.agent.service_name=服务名字 (如：demo-consumer)  
>>> -Dskywalking.collector.backend_service=skywalking服务地址与端口 (如：127.0.0.1:11800)  
或  
>>> java -javaagent:skywalking-agent.jar绝对路径（如：C:\\apache-skywalking\\agent\\skywalking-agent.jar)  
>>>      -Dskywalking.agent.service_name=服务名字(如：demo-consumer)  
>>>      -Dskywalking.collector.backend_service=skywalking服务地址与端口(如：127.0.0.1:11800)  
>>>      -jar 项目jar包(如：iscp-nacos-0.0.1-SNAPSHOT.jar)  

## 项目模块介绍
>### [iscp-nacos项目](https://github.com/oyd505/iscp/tree/master/iscp-nacos)
* 1、使用alibaba-nacos管理服务
* 2、使用alibaba-nacos管理配置文件
* 3、使用SkyWalking实现分布式追踪
>### [iscp-feign-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-feign-sentinel)
* 1、使用openfeign声明式调用下游服务
* 2、使用alibaba-sentinel做熔断降级控制
* 3、使用alibaba-nacos存储服务降级规则
* 4、使用SkyWalking实现分布式追踪
>### [iscp-gateway-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-gateway-sentinel)
* 1、使用spring-cloud-gateway做api网关
* 2、使用alibaba-sentinel做限流控制
* 3、使用alibaba-nacos存储服务限流规则
* 4、使用SkyWalking实现分布式追踪

## 注意事项
* 1、namespase如果不是public，需要配置对应的命名空间ID（如：c6ef4ed4-1a37-4672-a8dc-53926e8e9b49）
* 2、使用监控spring-cloud-gateway,需要将apm-spring-cloud-gateway-2.x-plugin-6.3.0.jar插件从optional-plugins目录移到plugins目录,否则traceId不传递

## 参考资料
* 1、[spring-cloud](https://spring.io/projects/spring-cloud)、[Spring Cloud中文网](https://www.springcloud.cc/)、[Spring Cloud中国社区](http://springcloud.cn/)
* 2、[spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba)
* 3、[Nacos](https://nacos.io/zh-cn/)
* 4、[Sentinel](https://github.com/alibaba/Sentinel)
* 5、[SkyWalking](http://skywalking.apache.org/)、[OpenTracing文档中文版](https://wu-sheng.gitbooks.io/opentracing-io/content/)
