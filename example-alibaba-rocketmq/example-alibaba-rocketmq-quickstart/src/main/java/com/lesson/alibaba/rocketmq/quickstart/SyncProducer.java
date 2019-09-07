package com.lesson.alibaba.rocketmq.quickstart;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author zhengshijun
 * @version created on 2019/3/25.
 */
public class SyncProducer {

	public static void main(String[] args) throws UnsupportedEncodingException, MQClientException, RemotingException, InterruptedException, MQBrokerException {
		//Instantiate with a producer group name.
		DefaultMQProducer producer = new
				DefaultMQProducer("please_rename_unique_group_name222");
		// Specify name server addresses.

		producer.setNamesrvAddr("121.196.232.248:9876");


		//Launch the instance.
		producer.start();
		//producer.createTopic(producer.getCreateTopicKey(),"TopicTest",1);

		// producer.createTopic(producer.getCreateTopicKey(),"TopicTest",100);
		for (int i = 0; i < 100; i++) {
			//Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest" /* Topic */,
					"TagA" /* Tag */,
					("Hello RocketMQ " +i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			//Call send message to deliver message to one of brokers.
			SendResult sendResult = producer.send(msg);
			System.out.printf("%s%n", sendResult);
		}
		//Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}
}
