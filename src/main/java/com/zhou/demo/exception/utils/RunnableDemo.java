package com.zhou.demo.exception.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName RunnableDemo
 * @Author JackZhou
 * @Date 2020/10/23  11:31
 **/
@Slf4j
public class RunnableDemo implements Runnable{

    boolean flag;

    public RunnableDemo(boolean flag) {
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

    //TODO 有打印到控制台，不打印日志文件
    public static void testFuture(Boolean flag){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            log.info("进入CompletableFuture");
            if (flag) {
                throw new RuntimeException("测试异步异常");
            }
            log.info("进入CompletableFuture结束");
        });
        future.join();
    }


    public static void testFutureR(Boolean flag){
        CompletableFuture.runAsync(() -> {
            log.info("进入CompletableFuture");
            if (flag) {
                throw new RuntimeException("测试异步异常");
            }
            log.info("进入CompletableFuture结束");
        }).whenComplete((r, e) ->{
            if(e != null){
                log.error("执行未完成出现异常", e);
            }
        }).exceptionally(e -> {
            log.error("exceptionally出现异常", e);
            return null;
        }).handle((t, e) -> {
            log.error("hander 处理异常", e);
            return null;
        }).join();
    }

    //TODO 默认用ThreadGroup里面的uncaughtException
    //TODO  打印控制台，不打印配置文件
    //https://www.cnblogs.com/Laymen/p/11465881.html
    public static void testRunnable(Boolean flag){
        Thread thread = new Thread(new RunnableDemo(flag));
        thread.start();
    }

    //TODO 默认用ThreadGroup里面的uncaughtException
    //TODO  打印控制台，不打印配置文件
    public static void testThreadPoolExec(Boolean flag){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(new RunnableDemo(flag));
        executorService.execute(thread);
    }

    public static void testThreadPoolSumbit(Boolean flag){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(new RunnableDemo(flag));

        //TODO  没有以下，错误日志不会打印到控制台     e.printStackTrace()不会打印到logback日志  打印到日志使用log.error
        Future<?> submit = executorService.submit(thread);
        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //testRunnable(true);
        //testThreadPoolExec(true);
        //testThreadPoolSumbit(true);
        //testFuture(true);
        testFutureR(true);
    }
}
