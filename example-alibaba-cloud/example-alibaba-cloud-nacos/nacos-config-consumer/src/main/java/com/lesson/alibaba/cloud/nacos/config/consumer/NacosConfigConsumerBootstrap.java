package com.lesson.alibaba.cloud.nacos.config.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2018/11/20.
 */
@SpringBootApplication
public class NacosConfigConsumerBootstrap {

    public static void main(String[] args){

        SpringApplication.run(NacosConfigConsumerBootstrap.class,args);

    }
}
