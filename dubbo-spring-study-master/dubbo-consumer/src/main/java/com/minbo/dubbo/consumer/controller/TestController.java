package com.minbo.dubbo.consumer.controller;


import com.minbo.dubbo.api.pojo.Product;
import com.minbo.dubbo.api.service.ProductService;
import com.minbo.dubbo.provider.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试用的 Controller 类；
 */
@Controller
public class TestController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private ProductService productService;

    /**
     * 测试 JSON 接口；
     *
     * @param name 名字
     * @return
     */
    @ResponseBody
    @RequestMapping("/test/{name}")
    public JSONObject testJson(@PathVariable("name") String name) {
        JSONObject jsonObject = new JSONObject();
        System.out.println("服务消费者" + name);
        String testStr = demoService.sayHello(name);
        jsonObject.put("str", testStr);
        return jsonObject;
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product findById(@PathVariable(value = "id")String id){
        return this.productService.findById(id);
    }
}