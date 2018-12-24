package com.minbo.dubbo.provider.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/dubbo.properties")
@ImportResource({"classpath:spring/*.xml"})
public class DubboConfig {
}
