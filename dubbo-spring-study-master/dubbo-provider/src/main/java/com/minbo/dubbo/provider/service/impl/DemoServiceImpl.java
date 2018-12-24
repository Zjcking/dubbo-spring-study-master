package com.minbo.dubbo.provider.service.impl;

import com.minbo.dubbo.provider.service.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        System.out.println("欢迎来到我的Dubbo，我是服务提供者");
        return "Welcome to My Dubbo, Hello " + name;
    }

}
