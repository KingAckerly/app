package com.lsm.app.service.impl;

import com.lsm.app.dao.IAppDao;
import com.lsm.app.dto.AppDTO;
import com.lsm.app.feign.UserServerFeign;
import com.lsm.app.service.IAppService;
import com.lsm.common.db.BaseClient;
import com.lsm.common.db.ExpressionEnum;
import com.lsm.common.db.Where;
import com.lsm.common.entity.app.AppEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AppServiceImpl implements IAppService {

    private static Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    private UserServerFeign userServerFeign;

    @Resource
    private IAppDao appDao;

    @Resource
    private BaseClient baseClient;

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

    /*@Override
    public AppEntity getApp() {
        return appDao.getApp();
    }*/

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public Integer saveApp(AppDTO appDTO) {
        return baseClient.save(buildFull(appDTO));
    }

    @Override
    public Integer removeApp(AppDTO appDTO) {
        Where where = new Where();
        where.and("app_key", ExpressionEnum.EQ.getExp(), appDTO.getAppKey());
        return baseClient.remove(buildFull(appDTO), where);
    }

    @Override
    public Integer updateApp(AppDTO appDTO) {
        Where where = new Where();
        where.and("app_key", ExpressionEnum.EQ.getExp(), appDTO.getAppKey());
        return baseClient.update(buildFull(appDTO), where);
    }

    @Override
    public Integer getAppCount(AppDTO appDTO) {
        Where where = new Where();
        where.and("app_name", ExpressionEnum.EQ.getExp(), appDTO.getAppName());
        return baseClient.getCount(buildFull(appDTO), where);
    }

    @Override
    public AppEntity getApp(AppDTO appDTO) {
        String[] str = {"id", "app_name"};
        List<String> selectColumns = Arrays.asList(str);
        Where where = new Where();
        where.and("app_name", ExpressionEnum.EQ.getExp(), appDTO.getAppName());
        where.and("app_key", ExpressionEnum.EQ.getExp(), appDTO.getAppKey());
        return (AppEntity) baseClient.get(buildFull(appDTO), where, selectColumns);
        //return (AppEntity) baseClient.get(buildFull(appDTO), where, null);
    }

    @Override
    public List<AppEntity> listApp(AppDTO appDTO) {
        String[] str = {"id", "app_name"};
        List<String> selectColumns = Arrays.asList(str);
        Where where = new Where();
        //where.and("app_name", "=", appDTO.getAppName());
        where.and("app_name", ExpressionEnum.LIKE.getExp(), "%" + appDTO.getAppName() + "%");
        where.and("id", ExpressionEnum.BETWEEN.getExp(), "1", "100");
        //where.and("app_info", ExpressionEnum.IS_NULL.getExp());
        where.and("app_info", ExpressionEnum.IS_NOT_NULL.getExp());
        //where.and("id", ExpressionEnum.NOT_BETWEEN.getExp(), "100", "200");
        return (List<AppEntity>) baseClient.list(buildFull(appDTO), where, selectColumns);
    }

    private AppEntity buildFull(AppDTO appDTO) {
        return (AppEntity) new AppEntity().setAppName(appDTO.getAppName()).setAppInfo(appDTO.getAppInfo()).setAppKey(appDTO.getAppKey())
                .setId(appDTO.getId()).setCreaterId(appDTO.getCreaterId()).setUpdaterId(appDTO.getUpdaterId());
    }
}
