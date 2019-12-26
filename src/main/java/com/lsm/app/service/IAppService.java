package com.lsm.app.service;

import com.lsm.app.dto.AppDTO;
import com.lsm.entity.entity.app.AppEntity;

import java.util.List;

public interface IAppService {
    String test();

    void testElegantShutdown();

    Integer saveBatchApp(List<AppDTO> appDTOList, Integer userId);

    Integer removeApp(AppDTO appDTO, Integer userId);

    Integer removeBatchApp(List<Integer> ids, Integer userId);

    Integer deleteApp(AppDTO appDTO);

    Integer deleteBatchApp(List<Integer> ids);

    Integer updateApp(AppDTO appDTO, Integer userId);

    Integer updateBatchApp(List<AppDTO> appDTOList, Integer userId);

    Integer getAppCount(AppDTO appDTO);

    AppEntity getApp(AppDTO appDTO);

    List<AppEntity> listApp(AppDTO appDTO);
}
