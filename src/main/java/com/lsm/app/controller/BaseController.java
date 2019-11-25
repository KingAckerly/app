package com.lsm.app.controller;

import base.Result;
import base.ReturnResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.BaseUtil;

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
