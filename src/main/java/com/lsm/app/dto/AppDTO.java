package com.lsm.app.dto;


import com.lsm.app.dto.groups.AppGroups;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AppDTO {

    //@NotNull(message = "APPID不能为空", groups = {AppGroups.Insert.class})
    private Integer id;
    @NotBlank(message = "APP名称不能为空", groups = {AppGroups.Insert.class})
    private String appName;
    private String appInfo;
    private String appKey;
    private Integer createrId;
    private Integer updaterId;

    public Integer getId() {
        return id;
    }

    public AppDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public AppDTO setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public AppDTO setAppInfo(String appInfo) {
        this.appInfo = appInfo;
        return this;
    }

    public String getAppKey() {
        return appKey;
    }

    public AppDTO setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public AppDTO setCreaterId(Integer createrId) {
        this.createrId = createrId;
        return this;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public AppDTO setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
        return this;
    }

    @Override
    public String toString() {
        return "AppDTO{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appInfo='" + appInfo + '\'' +
                ", appKey='" + appKey + '\'' +
                ", createrId=" + createrId +
                ", updaterId=" + updaterId +
                '}';
    }
}
