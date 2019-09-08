package com.lesson.alibaba.rocketmq.quickstart.tx;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.Executors;

/**
 * @author zhengshijun
 * @version created on 2019/9/9.
 */
public class Provider {

    public static void main(String[] args) throws MQClientException {
        TransactionMQProducer producer
                = new TransactionMQProducer("tx_product");
        producer.setNamesrvAddr("121.196.232.248:9876");
        producer.setExecutorService(Executors.newCachedThreadPool());
        producer.setTransactionListener(new LocalTransactionListener());
        producer.start();

        Message message = new Message("order_topic-1","TagA","orderId-1","主键".getBytes());

        producer.sendMessageInTransaction(message,"orderId-1");
    }
}

