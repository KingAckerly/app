package com.lsm.app.service;

import com.lsm.app.dto.AppDTO;
import com.lsm.common.entity.app.AppEntity;

import java.util.List;

public interface IAppService {
    String test();

    void testElegantShutdown();

    //AppEntity getApp();

    //    Integer saveApp(AppDTO appDTO);
//
    Integer saveBatchApp(List<AppDTO> appDTOList, Integer userId);

    //    Integer removeApp(AppDTO appDTO);
//
//    Integer deleteApp(AppDTO appDTO);
    Integer deleteBatchApp(List<Integer> ids);
//
//    Integer updateApp(AppDTO appDTO);
//
//    Integer getAppCount(AppDTO appDTO);
//
//    AppEntity getApp(AppDTO appDTO);
//
//    List<AppEntity> listApp(AppDTO appDTO);
}
