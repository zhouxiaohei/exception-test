package com.zhou.demo.exception.controller;

import com.zhou.demo.exception.utils.LogPrint;
import com.zhou.demo.exception.utils.RunnableDemo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName TestController
 * @Author JackZhou
 * @Date 2020/10/23  11:14
 **/
@RestController
@RequestMapping("/exception")
@Slf4j
@Api(tags = "异常测试")
public class TestController {

    @ApiOperation(value = "同步异常")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(@RequestParam boolean flag){
        log.info("同步异常测试开始");
        if(flag){
            throw new RuntimeException("测试同步异常");
        }
        log.info("同步异常测试结束");
    }

    @ApiOperation(value = "Future异步异常")
    @RequestMapping(value = "/testFutureAsync", method = RequestMethod.GET)
    public void testAsync(@RequestParam boolean flag){
        log.info("异步异常测试开始");
        CompletableFuture.runAsync(() -> {
            log.info("测试future执行");
            if (flag) {
                throw new RuntimeException("测试future异步异常");
            }
        });
    }

    @ApiOperation(value = "Future异步异常2")
    @RequestMapping(value = "/testFutureSupplyAsync", method = RequestMethod.GET)
    public void testAsync2(@RequestParam boolean flag){
        log.info("异步异常测试开始");
       CompletableFuture.supplyAsync( ()-> {
            log.info("测试future执行");
            if (flag) {
                throw new RuntimeException("测试future异步异常");
            }
            return "";
        });
    }

    @ApiOperation(value = "Runable异步异常")
    @RequestMapping(value = "/testAsyncRunable", method = RequestMethod.GET)
    public void testAsyncRunable(@RequestParam boolean flag){
        //TODO  logback 没有runable异常日志
        log.info("Runable异步异常测试开始");
        Thread thread = new Thread(new RunnableDemo(flag));
        thread.start();
        log.info("Runable异步异常测试结束");
    }

    @ApiOperation(value = "控制打印")
    @RequestMapping(value = "/printController", method = RequestMethod.GET)
    public void printController(@RequestParam boolean flag){
        LogPrint.setFlag(flag);
    }

}
