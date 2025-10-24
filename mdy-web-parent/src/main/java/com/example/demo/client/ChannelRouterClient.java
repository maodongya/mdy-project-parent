package com.example.demo.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maodongya
 * @create 2021-07-27 4:29 PM
 * @description
 */
@FeignClient(name="mdy-pay-channel")
//@FeignClient(name="mdy-pay-channel",url="localhost:18082")
public interface ChannelRouterClient {

    @RequestMapping("/channel/finance-channel/echo/{message}")
    String echo(@PathVariable(value="message") String message);
}
