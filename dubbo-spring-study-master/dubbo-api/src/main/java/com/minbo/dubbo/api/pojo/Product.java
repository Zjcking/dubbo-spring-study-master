package com.minbo.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private static final long serialVersionUID = -7442539232954496779L;

    private String id;

    private String name;

    private Double price;

    private String category;

    private String brand;
}
