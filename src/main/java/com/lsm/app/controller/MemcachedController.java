package com.lsm.app.controller;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/memcached")
public class MemcachedController {

    @Autowired
    private MemCachedClient memCachedClient;

    /**
     * memcache缓存
     */
    @RequestMapping(value = "/memcache", method = RequestMethod.GET)
    public String memcache(){
        // 放入缓存
        boolean flag = memCachedClient.set("mem", "name");
        // 取出缓存
        Object value = memCachedClient.get("mem");
        System.out.println(value);//name
        return "success";
    }
}
