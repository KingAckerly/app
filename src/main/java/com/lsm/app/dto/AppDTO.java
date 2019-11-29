package com.lsm.app.dto;


import com.lsm.app.dto.groups.AppGroups;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AppDTO {

    //@NotNull(message = "APPID不能为空", groups = {AppGroups.Insert.class})
    private Integer id;
    @NotBlank(message = "APP名称不能为空", groups = {AppGroups.Insert.class})
    private String appName;

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

    @Override
    public String toString() {
        return "AppDTO{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                '}';
    }
}
