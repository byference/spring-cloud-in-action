## spring cloud 实战

![](https://img.shields.io/badge/spring--cloud--in--action-1.0--SNAPSHOT-green.svg)


    




> 本项目作为spring cloud各组件组合使用的实战（熟悉）项目，目前还在完善中，不涉及业务开发，
关于spring cloud脚手架项目敬请期待，因为Spring Cloud Netflix 进入维护模式，
所以准备替换部分组件：Hystrix -> Resilience4j, Zuul -> Spring Cloud Gateway




### TODO LIST

- [x] Zuul -> Spring Cloud Gateway
- [ ] Hystrix -> Resilience4j
- [ ] 将通用模块抽取到父pom中
- [ ] oauth2
- [ ] docker


### 模块说明


- api网关(zuul) api-gateway:9999
- api网关(spring-cloud-gateway) gateway:9999
- 注册中心 registry:9000
- 生产者 provider:9001
- 消费者 consumer:9002




### 使用说明


- 待添加



### 其他说明

- 注册中心地址: `http://localhost:9000/eureka/`
- swagger文档地址: `http://localhost:9999/swagger-ui.html#/`
- zipkin管理页面: `http://localhost:9411/`




### 其他
- zipkin：
    spring boot 2.x后官方就不推荐自行定制编译，推荐并提供了编译好的jar包供我们使用。
