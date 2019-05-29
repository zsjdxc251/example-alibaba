package com.lesson.alibaba.rocketmq.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *  https://github.com/apache/rocketmq-spring
 *
 * @author zhengshijun
 * @version created on 2019/5/29.
 */
@SpringBootApplication
public class RocketmqBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(RocketmqBootstrap.class,args);
	}
}
