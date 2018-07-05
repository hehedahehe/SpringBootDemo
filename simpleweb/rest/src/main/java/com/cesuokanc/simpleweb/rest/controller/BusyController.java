package com.cesuokanc.simpleweb.rest.controller;

import com.cesuokanc.simpleweb.logic.LogicService;
import com.cesuokanc.simpleweb.rest.common.RestResult;
import com.cesuokanc.simpleweb.rest.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试超时的接口
 * @author liruibo
 * @date 2018/5/24
 */
@Slf4j
@RestController
@RequestMapping("/busy")
public class BusyController {

    @Resource
    LogicService logicService;

    @GetMapping(value = "/user/{id}")
    public RestResult<User> getUser(@PathVariable(value = "id") Integer userId){
        User user = new User(userId, "小明");
        try{
            //线程沉睡10s
            Thread.sleep(10000);
        }catch (Exception e){
            log.error("---getUser--error--");
        }
        RestResult<User> res = RestResult.getSuccessRest(user);
        return res;
    }


}
