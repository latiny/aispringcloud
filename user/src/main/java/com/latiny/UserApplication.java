package com.latiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Latiny
 * @version 1.0
 * @description: Starter
 * @date 2019/12/9 9:15
 */
@SpringBootApplication
@MapperScan("com.latiny.repository")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
