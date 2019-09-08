package com.lesson.alibaba.rocketmq.quickstart.tx;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author zhengshijun
 * @version created on 2019/9/9.
 */
public class LocalTransactionListener implements TransactionListener {


    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {

        System.out.println(msg);
        System.out.println(arg);

        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        System.out.println(msg);
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}

