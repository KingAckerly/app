package com.lsm.app.async;

import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

public class TestAsync {
    public static void main(String[] args) {
        String url = "http://localhost:8763/app/async";

        //同步调用
        //RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject(url, String.class);
        //System.out.println("成功");

        //异步调用
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        asyncRestTemplate.getForEntity(url, Object.class);
        System.out.println("成功");
    }
}
