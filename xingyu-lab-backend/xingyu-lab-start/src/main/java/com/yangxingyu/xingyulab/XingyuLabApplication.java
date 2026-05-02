package com.yangxingyu.xingyulab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yangxingyu.xingyulab")
@MapperScan("com.yangxingyu.xingyulab.**.mapper")
public class XingyuLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(XingyuLabApplication.class, args);
    }
}
