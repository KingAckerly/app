package com.lsm.app.hystrix;

import com.lsm.app.feign.UserServerFeign;
import org.springframework.stereotype.Component;

@Component
public class UserServerHystrix implements UserServerFeign {
    @Override
    public String login() {
        return "请求失败,执行断路器";
    }
}
