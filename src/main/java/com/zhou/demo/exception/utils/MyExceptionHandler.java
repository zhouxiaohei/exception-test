package com.zhou.demo.exception.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MyExceptionHandler
 * @Author JackZhou
 * @Date 2020/10/26  14:14
 **/
@Slf4j
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error("Exception in thread {}",  t.getName(), e);
    }

}
