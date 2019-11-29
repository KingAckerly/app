package com.lsm.app.service;

import entity.app.AppEntity;

public interface IAppService {
    String test();

    void testElegantShutdown();

    AppEntity getApp();
}
