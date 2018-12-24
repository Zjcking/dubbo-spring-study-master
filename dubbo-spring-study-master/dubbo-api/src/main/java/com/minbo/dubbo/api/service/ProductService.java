package com.minbo.dubbo.api.service;

import com.minbo.dubbo.api.pojo.Product;

public interface ProductService {

    public Product findById(String id);
}
