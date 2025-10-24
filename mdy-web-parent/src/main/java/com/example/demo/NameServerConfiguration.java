package com.example.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maodongya
 * @create 2025-10-21 16:23
 * @description
 */
@Configuration
public class NameServerConfiguration {
    @Bean("namingService")
    public NamingService namingService() throws NacosException {
        String serverAddr = "localhost:8848";
        NamingService namingService = NacosFactory.createNamingService(serverAddr);
        return namingService;
    }

}
