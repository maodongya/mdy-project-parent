package com.example.demo;

import com.example.demo.client.ChannelRouterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("nacos")
public class NacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ChannelRouterClient channelRouterClient;

    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/echo/app-name2")
    public String echoAppName2() {
        System.out.println("request url:"+appName);
        return channelRouterClient.echo(appName);
    }
}