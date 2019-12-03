package com.lsm.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//springboot默认自动支持了MongoDB,只要你pom里配了MongoDB的包,springboot启动就会加载MongoDB
//如果本地MongoDB连接没有配置,会报MongoDB连接异常,此处暂时不用,选择禁用MongoDB
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
//@ComponentScan(basePackages={"*"})
@MapperScan({"com.lsm.app.dao","dao"})
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
