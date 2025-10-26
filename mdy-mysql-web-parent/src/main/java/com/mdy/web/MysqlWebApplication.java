package com.mdy.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dongya.mao
 * @date 2021/6/18
 * @describe
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.mdy.web.persistence.dao")
public class MysqlWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlWebApplication.class, args);
    }
}
