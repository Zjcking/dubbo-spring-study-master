package com.minbo.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.minbo.dubbo.api.pojo.Product;
import com.minbo.dubbo.api.service.ProductService;


@Service(version = "1.0.0")
public class ProductServiceImpl implements ProductService {

    public Product findById(String id) {
        Product product = new Product();
        product.setId(id);
        product.setName("雷锋哥");
        product.setBrand("华华的");
        product.setCategory("欧阳锋");
        product.setPrice(2699d);
        System.out.println("我的dubbo" + product);
        return product;
    }
}
