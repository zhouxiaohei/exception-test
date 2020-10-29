package com.zhou.demo.exception.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName RunnableHnadlerDemo
 * @Author JackZhou
 * @Date 2020/10/26  14:22
 **/
@Slf4j
public class RunnableHnadlerDemo implements Runnable{


    boolean flag;

    public RunnableHnadlerDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        log.info("进入runnableDemo");
        if(flag){
            throw new NumberFormatException("RunnableDemo测试异常");
        }
        log.info("进入runnableDemo 结束");
    }

    public static void testRunnable(Boolean flag){
        Thread thread = new Thread(new RunnableDemo(flag));
        thread.start();
    }

    public static void testThreadPoolExec(Boolean flag){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(new RunnableDemo(flag));
        executorService.execute(thread);
    }

    public static void lambadThread(){
        Thread thread = new Thread(() -> {
            log.info("进入 lambadThread");
            if (true) {
                throw new NumberFormatException("lambadThread测试异常");
            }
            log.info("进入lambadThread 结束");
        });
        thread.start();
    }

    public static void testThreadPoolSumbit(Boolean flag){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(new RunnableDemo(flag));
        Future<?> submit = executorService.submit(thread);
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
        //testRunnable(true);
        //testThreadPoolExec(true);
        //lambadThread();
        testThreadPoolSumbit(true);

    }
}
