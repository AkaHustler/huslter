package com.rookie.hustle.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author houzhongbo
 * @Date 2021/8/17 11:12 下午
 * @Version 1.0
 **/
@Controller
@Slf4j
@RequestMapping("/v1/api")
public class ApiController {

    @RequestMapping(value = "/leetcode")
    @ResponseBody
    public String leetCode() {
        return "我爱学习tm的！";
    }
}
