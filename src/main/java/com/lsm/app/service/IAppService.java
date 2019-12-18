package com.lsm.app.service;

import com.lsm.app.dto.AppDTO;
import com.lsm.common.entity.app.AppEntity;

public interface IAppService {
    String test();

    void testElegantShutdown();

    //AppEntity getApp();

    Integer saveApp(AppDTO appDTO);

    Integer removeApp(AppDTO appDTO);

    Integer updateApp(AppDTO appDTO);

    AppEntity getApp(AppDTO appDTO);
}
