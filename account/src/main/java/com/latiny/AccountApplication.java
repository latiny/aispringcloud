package com.latiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Latiny
 * @version 1.0
 * @description: AccountApplication
 * @date 2019/12/9 16:42
 */
@SpringBootApplication
@MapperScan("com.latiny.mapper")
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
