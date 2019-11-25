package com.lsm.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/producer", method = RequestMethod.GET)
    public String producer() {
        kafkaTemplate.send("test", "hello,kafka");
        return "success";
    }

    //如果本地没有配置kafka连接,这里的监听就需要注释起来
    //@KafkaListener(topics = {"test"})
    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String consumer(String message) {
        logger.info("test topic message : {}", message);
        return "success";
    }
}
