package com.lsm.app.controller;

import com.lsm.common.base.Result;
import com.lsm.common.base.ReturnResponse;
import com.lsm.common.util.BaseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    @RequestMapping(value = "/testRelease", method = RequestMethod.GET)
    public String testRelease() {
        BaseUtil.toBase();
        return "testRelease!";
    }

    @RequestMapping(value = "/responseResult", method = RequestMethod.GET)
    public Result responseResult() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", "result");
        return ReturnResponse.success(map);
    }
}
