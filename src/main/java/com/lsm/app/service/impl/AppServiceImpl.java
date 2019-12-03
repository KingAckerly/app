package com.lsm.app.service.impl;

import com.lsm.app.dao.IAppDao;
import com.lsm.app.dto.AppDTO;
import com.lsm.app.feign.UserServerFeign;
import com.lsm.app.service.IAppService;
import db.BaseClient;
import db.impl.BaseClientImpl;
import entity.app.AppEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AppServiceImpl implements IAppService {

    private static Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    private UserServerFeign userServerFeign;

    @Resource
    private IAppDao appDao;

    //@Resource
    //private BaseClient baseClient;

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

    @Override
    public AppEntity getApp() {
        return appDao.getApp();
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public Integer saveApp(AppDTO appDTO) {
        BaseClient baseClient = new BaseClientImpl();
        return baseClient.save(buildFull(appDTO));
    }

    @Override
    public Integer removeApp(AppDTO appDTO) {
        return null;
    }

    private AppEntity buildFull(AppDTO appDTO) {
        return new AppEntity().setId(appDTO.getId()).setAppName(appDTO.getAppName()).setAppInfo(appDTO.getAppInfo())
                .setAppKey(appDTO.getAppKey());
    }
}
