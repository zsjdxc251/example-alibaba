package com.lesson.alibaba.rocketmq.boot;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

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

	@Bean
	public ApplicationRunner applicationRunner(RocketMQTemplate rocketMQTemplate){

		return  args -> {

			Map<String,String> map = new HashMap<>();
			rocketMQTemplate.convertAndSend("TopicTest",map);

		};
	}

}
