# iscp
微服务脚手架

## 相关依赖框架
* 1、spring-boot使用2.1.4.RELEASE
* 2、spring-cloud使用Greenwich.RELEASE
* 3、spring-cloud-alibaba使用2.1.0.RELEASE
* 4、nacos-server使用1.1.3
* 5、sentinel-dashboard使用1.6.3
* 6、apache-skywalking-apm使用6.3.0

## 项目模块介绍
>### [iscp-nacos项目](https://github.com/oyd505/iscp/tree/master/iscp-nacos)
* 1、使用alibaba-nacos管理服务
* 2、使用alibaba-nacos管理配置文件
>### [iscp-feign-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-feign-sentinel)
* 1、使用openfeign声明式调用下游服务
* 2、使用alibaba-sentinel做熔断降级控制
* 3、使用alibaba-nacos存储服务降级规则
>### [iscp-gateway-sentinel项目](https://github.com/oyd505/iscp/tree/master/iscp-gateway-sentinel)
* 1、使用spring-cloud-gateway做api网关
* 2、使用alibaba-sentinel做限流控制
* 3、使用alibaba-nacos存储服务限流规则

## 注意事项
* 1、namespase如果不是public，需要配置对应的命名空间ID（如：c6ef4ed4-1a37-4672-a8dc-53926e8e9b49）
* 2、使用监控spring-cloud-gateway,需要将apm-spring-cloud-gateway-2.x-plugin-6.3.0.jar插件从optional-plugins目录移到plugins目录,否则traceId不传递
