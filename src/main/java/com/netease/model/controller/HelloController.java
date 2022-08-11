package com.netease.model.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String hello(){
        return "请求成功";
    }

}
