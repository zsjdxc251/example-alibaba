package com.lesson.alibaba.rocketmq.bus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson.alibaba.rocketmq.bus.api.event.SimpleRemoteApplicationEvent;
import com.lesson.alibaba.rocketmq.bus.listener.CustomApplicationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.event.EventListener;

/**
 * @author zhengshijun
 * @version created on 2019/3/27.
 */
@SpringBootApplication
@RemoteApplicationEventScan(basePackageClasses = {SimpleRemoteApplicationEvent.class})
public class RocketMqBusConsumerBootstrap {
	@Autowired
	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(RocketMqBusConsumerBootstrap.class, args).addApplicationListener(new CustomApplicationListener());
	}


	@EventListener
	public void onEvent(SimpleRemoteApplicationEvent event) {
		System.out.printf("Server listeners on %s\n",
				event);
	}

//	@EventListener
//	public void onAckEvent(AckRemoteApplicationEvent event)
//			throws JsonProcessingException {
//		System.out.printf("Server listeners on %s\n",
//				objectMapper.writeValueAsString(event));
//	}
}
