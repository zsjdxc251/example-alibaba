package com.lesson.alibaba.rocketmq.bus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2019/3/27.
 */
@SpringBootApplication
public class RocketMqBusProviderBootstrap {

	@Autowired
	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(RocketMqBusProviderBootstrap.class, args);
	}
//
//	@EventListener
//	public void onAckEvent(AckRemoteApplicationEvent event)
//			throws JsonProcessingException {
//		System.out.printf("Server listeners on %s\n",
//				objectMapper.writeValueAsString(event));
//	}
}
