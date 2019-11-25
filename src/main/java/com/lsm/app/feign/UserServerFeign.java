package com.lsm.app.feign;

import com.lsm.app.hystrix.UserServerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-server",fallback = UserServerHystrix.class)
public interface UserServerFeign {

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    String login();
}
