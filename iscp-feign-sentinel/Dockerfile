# 基础镜像
FROM openjdk:8-jdk-alpine
VOLUME ["/agent","/tmp"]
# 对应pom.xml文件中的dockerfile-maven-plugin插件buildArgs配置项JAR_FILE的值
ARG JAR_FILE
# 复制打包完成后的jar文件到/opt目录下
COPY ${JAR_FILE} /opt/app.jar
# 启动容器时执行
ENTRYPOINT ["java","-javaagent:/agent/skywalking-agent.jar","-Dskywalking.agent.service_name=iscp-feign-sentinel","-Dskywalking.collector.backend_service=192.168.99.1:11800","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
# 使用端口9101
EXPOSE 9101