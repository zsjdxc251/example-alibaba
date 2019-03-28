package com.lesson.alibaba.rocketmq.bus.api.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @author zhengshijun
 * @version created on 2019/3/27.
 */
public class SimpleRemoteApplicationEvent extends RemoteApplicationEvent {

	public SimpleRemoteApplicationEvent() {
	}

	public SimpleRemoteApplicationEvent(String message, String originService,
			String destinationService) {
		super(message, originService, destinationService);
	}

	public String getMessage() {
		return (String) getSource();
	}
}
