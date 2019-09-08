package com.lesson.alibaba.rocketmq.quickstart.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2019/9/9.
 */
@SpringBootApplication(scanBasePackages = "com.lesson.alibaba.rocketmq.quickstart.tx")
public class TxBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(TxBootstrap.class,args);
    }
}

