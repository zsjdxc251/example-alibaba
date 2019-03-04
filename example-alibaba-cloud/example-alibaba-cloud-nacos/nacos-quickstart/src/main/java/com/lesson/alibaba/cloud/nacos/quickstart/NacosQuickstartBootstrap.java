package com.lesson.alibaba.cloud.nacos.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosQuickstartBootstrap {

    public static void main(String[] args){

        SpringApplication.run(NacosQuickstartBootstrap.class,args);
    }
}
