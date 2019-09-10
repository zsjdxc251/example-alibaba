package com.lesson.alibaba.rocketmq.boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultApi<T> {

    private Long sysTime;

    private T data;
}

