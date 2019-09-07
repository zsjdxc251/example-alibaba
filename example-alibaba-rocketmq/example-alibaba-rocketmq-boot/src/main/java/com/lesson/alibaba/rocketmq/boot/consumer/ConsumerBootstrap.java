package com.lesson.alibaba.rocketmq.boot.consumer;

import com.lesson.alibaba.rocketmq.boot.provider.RocketmqBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
@SpringBootApplication(scanBasePackages = "com.lesson.alibaba.rocketmq.boot.consumer")
public class ConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class,args);
    }

}

