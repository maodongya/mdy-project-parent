package com.mdy.project;

import com.alibaba.fastjson2.JSON;
import com.mdy.project.uitl.R;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author maodongya
 * @Description
 * @create 2021-07-07 7:18 PM
 */
public class ChannelCompanyPayMethodControllerIT extends BaseTest{
    @Autowired
    private ControllerBaseIT controllerBaseIT;
    @Test
    public void payChannelRoute() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> params= new LinkedMultiValueMap<>();
        //添加请求的参数
        params.add("companyNo", "companyNo001");
        params.add("subCompanyNo", "subCompanyNo001");
        params.add("payMethodNo", "WEBPAY");
        params.add("currencyType", "CNY");
        params.add("cardType", "CREDIT");
        params.add("payOrderNo", "order00000001");
        params.add("singleOrBatch", "single");
        params.add("synchroniseOrAsynchronous", "synchronise");
        params.add("certificateNo", "certificateNo");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<R> response = controllerBaseIT.getTemplate().exchange(
                controllerBaseIT.getUrl("channel/channelcompanypaymethod/add"),
                HttpMethod.POST,
                requestEntity,
                R.class);
        R body=response.getBody();
        System.out.println(JSON.toJSONString(body));
    }
}