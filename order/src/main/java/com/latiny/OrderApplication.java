package com.latiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Latiny
 * @version 1.0
 * @description: 启动类
 * @date 2019/11/27 17:56
 */
@SpringBootApplication
@MapperScan("com.latiny.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
