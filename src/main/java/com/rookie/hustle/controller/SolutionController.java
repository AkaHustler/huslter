package com.rookie.hustle.controller;

import com.rookie.hustle.service.SolutionService;

/**
 * @Description
 * @Author houzhongbo
 * @Date 2021/9/8 7:49 下午
 * @Version 1.0
 **/
public class SolutionController {

    public void reflect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.rookie.hustle.service.SolutionService");
        SolutionService solutionService = (SolutionService) aClass.newInstance();

    }
}