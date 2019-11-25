package com.lsm.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/setName", method = RequestMethod.GET)
    public String setName() {
        stringRedisTemplate.opsForValue().set("name1", "胡歌");
        redisTemplate.opsForValue().set("name2", "王俊凯");
        return "testRedis成功!";
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
        String value1 = stringRedisTemplate.opsForValue().get("name1");
        String value2 = redisTemplate.opsForValue().get("name2").toString();
        logger.info(value1);
        logger.info(value2);
        return value2;
    }
}
