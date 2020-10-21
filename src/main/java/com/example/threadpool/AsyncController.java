package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kurtl
 */
@Controller
@RequestMapping("/")
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @PostMapping("/asyncSimpleExample")
    @ResponseBody
    public void  asyncSimpleExample(){
        asyncService.asyncSimpleExample();
    }

    @PostMapping("/newCachedThreadPoolExample")
    @ResponseBody
    public void  newCachedThreadPoolExample(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            executorService.submit(()->{
                log.info("submit:"+LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

    }

    @PostMapping("/asyncInvalid")
    @ResponseBody
    public void  asyncInvalid(){
        asyncService.asyncInvalid();
    }


    @PostMapping("/asyncTransactDemo")
    @ResponseBody
    public void  asyncTransactDemo(){
        asyncService.asyncTransactDemo();
    }

    @PostMapping("/asyncRefuseRun")
    @ResponseBody
    public void  asyncRefuseRun(){
        asyncService.asyncRefuseRun();
    }

    @PostMapping("/asyncRunTest")
    @ResponseBody
    public void  asyncRunTest(){
        asyncService.asyncSimpleExample01();
        asyncService.asyncSimpleExample02();
    }

    @PostMapping("/asyncDiscardPolicy")
    @ResponseBody
    public void asyncDiscardPolicy(){
        asyncService.asyncDiscardPolicy();
    }
}
