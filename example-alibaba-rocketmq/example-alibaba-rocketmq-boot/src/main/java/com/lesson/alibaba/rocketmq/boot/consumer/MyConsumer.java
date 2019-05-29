package com.lesson.alibaba.rocketmq.boot.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author zhengshijun
 * @version created on 2019/5/29.
 */
@Service
@RocketMQMessageListener(
		topic = "TopicTest",
		consumerGroup = "please_rename_unique_group_name"
)
public class MyConsumer implements RocketMQListener<String> {
	@Override
	public void onMessage(String s) {

		System.out.println(s);

	}
}
