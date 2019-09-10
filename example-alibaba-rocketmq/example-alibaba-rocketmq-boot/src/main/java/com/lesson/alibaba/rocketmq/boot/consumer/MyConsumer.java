package com.lesson.alibaba.rocketmq.boot.consumer;

import com.lesson.alibaba.rocketmq.boot.ResultApi;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengshijun
 * @version created on 2019/5/29.
 */
@Service
@RocketMQMessageListener(
		topic = "TopicTest123",

		consumerGroup = "1111"
)
public class MyConsumer extends AbstractRocketMQListener<ResultApi> {
	@Override
	public void doOnMessage(ResultApi s) {

		System.out.println(s);

	}
}
