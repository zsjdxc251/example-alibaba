package com.lesson.alibaba.rocketmq.boot.consumer;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.aop.framework.AopProxyUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author zhengshijun
 * @version created on 2019/9/10.
 */
public abstract class AbstractRocketMQListener<T> implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {


        T entity = JSON.parseObject(message).toJavaObject(getMessageType());

        doOnMessage(entity);

    }


    public abstract void doOnMessage(T message);

//    private Type getMessageType() {
//        Type genericSuperclass = this.getClass().getGenericSuperclass();
//        if (genericSuperclass instanceof ParameterizedType) {
//            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass)
//                    .getActualTypeArguments();
//            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
//                return actualTypeArguments[0];
//            }
//        }
//        return null;
//    }

    private Type getMessageType(){

        Type interfaces = this.getClass().getGenericSuperclass();

        if (Objects.nonNull(interfaces)) {
            if (interfaces instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) interfaces;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (Objects.nonNull(actualTypeArguments) && actualTypeArguments.length > 0) {
                    return actualTypeArguments[0];
                } else {
                    return Object.class;
                }
            }

            return Object.class;
        } else {
            return Object.class;
        }
    }
}

