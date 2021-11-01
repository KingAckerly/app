package com.lsm.app.async;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestAsync {
    public static void main(String[] args) {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        String url = "http://localhost:8763/app/async";
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", "zhangsan");
        requestMap.put("age", 30);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestMap, httpHeaders);
        asyncRestTemplate.postForEntity(url, httpEntity, Object.class);
        System.out.println("成功");
    }
}
