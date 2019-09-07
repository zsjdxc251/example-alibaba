package com.lesson.alibaba.rocketmq.boot.provider;

import com.lesson.alibaba.rocketmq.boot.ResultApi;
import org.apache.rocketmq.client.producer.SendResult;
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
@SpringBootApplication(scanBasePackages = "com.lesson.alibaba.rocketmq.boot.provider")
public class RocketmqBootstrap {



	public static void main(String[] args) {
		SpringApplication.run(RocketmqBootstrap.class,args);
	}

	@Bean
	public ApplicationRunner applicationRunner(RocketMQTemplate rocketMQTemplate){

		return  args -> {


			ResultApi<ResultApi<String>> resultApi = new ResultApi<>();
			resultApi.setData(new ResultApi<>());
			SendResult sendResult =  rocketMQTemplate.syncSend("TopicTest123",resultApi);

			System.out.println(sendResult);



		};
	}

}
