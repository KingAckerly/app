package com.lsm.app.async;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestAsync {
    public static void main(String[] args) {
        String url = "http://localhost:8763/app/async";
        //异步调用
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", "zhangsan");
        requestMap.put("age", 30);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestMap, headers);
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        asyncRestTemplate.postForEntity(url, httpEntity, Object.class);
        System.out.println("成功");
    }
}
