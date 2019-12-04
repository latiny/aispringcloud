package com.latiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Latiny
 * @version 1.0
 * @description: 启动类
 * @date 2019/12/2 9:28
 */
@SpringBootApplication
@MapperScan("com.latiny.repository")
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);
    }
}
