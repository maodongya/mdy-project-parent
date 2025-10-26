package com.mdy.project;

import lombok.Data;
import org.junit.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * @author maodongya
 * @Description
 * @create 2021-07-07 7:13 PM
 */
@Data
@Service
public class ControllerBaseIT{
    private URL base;

    private RestTemplate template;

    public ControllerBaseIT() {
        template=new RestTemplate();
    }

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost");
    }
    public String getUrl(String path){
        return getBase()+"/"+path;
    }
    public String getUrl(int port,String path){
        return getBase().getHost()+port+"/"+path;
    }
}
