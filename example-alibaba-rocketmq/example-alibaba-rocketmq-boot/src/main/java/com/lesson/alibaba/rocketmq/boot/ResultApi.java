package com.lesson.alibaba.rocketmq.boot;

import lombok.Data;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
@Data
public class ResultApi<T> {

    private Long sysTime;

    private T data;
}

