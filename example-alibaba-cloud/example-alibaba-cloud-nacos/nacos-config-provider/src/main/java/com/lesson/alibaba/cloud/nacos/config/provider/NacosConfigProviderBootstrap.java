package com.lesson.alibaba.cloud.nacos.config.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhengshijun
 * @version created on 2018/11/20.
 */

@SpringBootApplication
@EnableConfigServer
public class NacosConfigProviderBootstrap {

    public static void main(String[] args){

        SpringApplication.run(NacosConfigProviderBootstrap.class,args);
    }
}
