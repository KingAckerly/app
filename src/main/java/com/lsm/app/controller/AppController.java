package com.lsm.app.controller;


import com.lsm.app.dto.AppDTO;
import com.lsm.app.dto.RestTemplateRequest;
import com.lsm.app.dto.groups.AppGroups;
import com.lsm.app.service.IAppService;
import com.lsm.common.annotation.CustomAnnotation;
import com.lsm.common.annotation.WebLog;
import com.lsm.common.base.Result;
import com.lsm.common.base.ReturnResponse;
import com.lsm.common.enums.LogTypeEnum;
import com.lsm.entity.app.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    @Autowired
    IAppService appService;

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/restTemplateTest", method = RequestMethod.GET)
    public String restTemplateTest() {
        String url = "http://xxxxxx";
        RestTemplateRequest restTemplateRequest = new RestTemplateRequest();
        restTemplateRequest.setStr("str");
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<RestTemplateRequest> entity = new HttpEntity<>(restTemplateRequest, headers);
        Object o = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        System.out.println(o);
        return null;
    }

    @RequestMapping(value = "/async", method = RequestMethod.POST)
    public String async(@RequestBody Map<String, Object> map) {
        try {
            System.out.println("async!");
            System.out.println("name:" + map.get("name"));
            System.out.println("age:" + map.get("age"));
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "async";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return appService.test();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome!";
    }

    @RequestMapping(value = "/testGatewayFilterFactory", method = RequestMethod.GET)
    public String testGatewayFilterFactory() {
        return "testGatewayFilterFactory!";
    }

    @RequestMapping(value = "/testCustomAnnotation", method = RequestMethod.GET)
    public String testCustomAnnotation() {
        Class<AppEntity> clazz = AppEntity.class;
        // 获取类注解
        CustomAnnotation customAnnotation = clazz.getAnnotation(CustomAnnotation.class);
        System.out.println(customAnnotation.value());
        return customAnnotation.value();
    }

    /**
     * 新增APP
     *
     * @param appDTO
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/addApp", method = RequestMethod.POST)
    public Result addApp(@Validated(value = AppGroups.Insert.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success("新增APP成功");
    }

    /**
     * 测试优雅停机
     *
     * @return
     */
    @RequestMapping(value = "/testElegantShutdown", method = RequestMethod.GET)
    public String testElegantShutdown() {
        appService.testElegantShutdown();
        return "SUCCESS";
    }

    @RequestMapping(value = "/saveBatchApp", method = RequestMethod.POST)
    @WebLog(description = "批量新增", level = 1, type = LogTypeEnum.INSERT)
    public Result saveBatchApp(@Validated(value = AppGroups.Insert.class) @RequestBody List<AppDTO> appDTOList, BindingResult bindingResult, @RequestHeader(value = "userId") Integer userId) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.saveBatchApp(appDTOList, userId));
    }

    @RequestMapping(value = "/removeApp", method = RequestMethod.POST)
    public Result removeApp(@Validated(value = AppGroups.Delete.class) @RequestBody AppDTO appDTO, BindingResult bindingResult, @RequestHeader(value = "userId") Integer userId) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        if (null == userId) {
            return ReturnResponse.failParame("userId IS NULL.");
        }
        return ReturnResponse.success(appService.removeApp(appDTO, userId));
    }

    @RequestMapping(value = "/removeBatchApp", method = RequestMethod.POST)
    public Result removeBatchApp(@RequestBody List<Integer> ids, @RequestHeader(value = "userId") Integer userId) {
        if (CollectionUtils.isEmpty(ids)) {
            return ReturnResponse.failParame("ids IS NULL OR IS EMPTY.");
        }
        if (null == userId) {
            return ReturnResponse.failParame("userId IS NULL.");
        }
        return ReturnResponse.success(appService.removeBatchApp(ids, userId));
    }

    @RequestMapping(value = "/deleteApp", method = RequestMethod.POST)
    public Result deleteApp(@Validated(value = AppGroups.Delete.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.deleteApp(appDTO));
    }

    @RequestMapping(value = "/deleteBatchApp", method = RequestMethod.POST)
    public Result deleteBatchApp(@RequestBody List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return ReturnResponse.failParame("ids IS NULL OR IS EMPTY.");
        }
        return ReturnResponse.success(appService.deleteBatchApp(ids));
    }

    @RequestMapping(value = "/updateApp", method = RequestMethod.POST)
    public Result updateApp(@Validated(value = AppGroups.Update.class) @RequestBody AppDTO appDTO, BindingResult bindingResult, @RequestHeader(value = "userId") Integer userId) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        if (null == userId) {
            return ReturnResponse.failParame("userId IS NULL.");
        }
        return ReturnResponse.success(appService.updateApp(appDTO, userId));
    }

    @RequestMapping(value = "/updateBatchApp", method = RequestMethod.POST)
    public Result updateBatchApp(@Validated(value = AppGroups.Update.class) @RequestBody List<AppDTO> appDTOList, BindingResult bindingResult, @RequestHeader(value = "userId") Integer userId) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.updateBatchApp(appDTOList, userId));
    }

    @RequestMapping(value = "/getAppCount", method = RequestMethod.POST)
    public Result getAppCount(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.getAppCount(appDTO));
    }

    @RequestMapping(value = "/getApp", method = RequestMethod.POST)
    public Result getApp(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.getApp(appDTO));
    }

    @RequestMapping(value = "/listApp", method = RequestMethod.POST)
    public Result listApp(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.listApp(appDTO));
    }

    @RequestMapping(value = "/listPageApp", method = RequestMethod.POST)
    public Result listPageApp(@Validated(value = AppGroups.Select.class) @RequestBody AppDTO appDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnResponse.failParame(bindingResult.getFieldError().getDefaultMessage());
        }
        return ReturnResponse.success(appService.listPageApp(appDTO));
    }

    /**
     * 测试全局异常和自定义业务异常
     *
     * @return
     */
    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public Result testException() {
        appService.testException();
        return ReturnResponse.success("testException");
    }
}
