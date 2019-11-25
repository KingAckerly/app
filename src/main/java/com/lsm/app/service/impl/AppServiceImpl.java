package com.lsm.app.service.impl;

import com.lsm.app.feign.UserServerFeign;
import com.lsm.app.service.IAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements IAppService {

    private static Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    UserServerFeign userServerFeign;

    @Override
    public String test() {
        return userServerFeign.login();
    }

    @Override
    public void testElegantShutdown() {
        logger.info("开始测试优雅停机,跑一个线程休眠ing...");
        try {
            Thread.sleep(1000 * 60 * 3);
            logger.info("线程休眠已经结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
