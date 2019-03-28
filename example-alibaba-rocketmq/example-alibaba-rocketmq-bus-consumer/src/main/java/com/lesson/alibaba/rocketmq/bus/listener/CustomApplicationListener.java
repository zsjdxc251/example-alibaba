package com.lesson.alibaba.rocketmq.bus.listener;

import com.lesson.alibaba.rocketmq.bus.api.event.SimpleRemoteApplicationEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @version created on 2019/3/27.
 */

public class CustomApplicationListener implements ApplicationListener<SimpleRemoteApplicationEvent> {
	@Override
	public void onApplicationEvent(SimpleRemoteApplicationEvent event) {

		System.out.println(event);
	}
}
