package com.mdy.project;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author dongya.mao
 * @date 2021/6/22
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebClientApplication.class)
@Configuration
public class BaseTest {
}

