package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.atomic.AtomicInteger;


@Component
@Slf4j
public class AsyncTask {
    private static AtomicInteger n = new AtomicInteger(0);
    @Autowired
    private TheadPoolDemoMapper theadPoolDemoMapper;


    @Async
    public void  asyncRun() throws InterruptedException {
        Thread.sleep(10);
        log.info(Thread.currentThread().getName()+":处理完成");
    }
    @Transactional(rollbackFor = RuntimeException.class)
    @Async
    public void  asyncTransactDemo(){
        TheadPoolDemo theadPoolDemo = new TheadPoolDemo();
        theadPoolDemo.setId(1);
        theadPoolDemo.setUsername("test01");
        theadPoolDemo.setPassword("test");
        theadPoolDemoMapper.insert(theadPoolDemo);
        TheadPoolDemo demo = new TheadPoolDemo();
        demo.setId(2);
        demo.setUsername("test01");
        demo.setPassword("test1");
        theadPoolDemoMapper.insert(demo);
    }


    @Async
    public void  asyncRefuseRun() throws InterruptedException {
        Thread.sleep(5000000);
    }

    /**
     * 在这段注释中有两个非常重要的部分
     * 1.使用@Async的方法只能返回Void 或者 Future类型
     * 2.表明了@Async是通过org.springframework.core.task.TaskExecutor
     * 或者java.util.concurrent.Executor来创建线程池
     * 3.写了@Async的作用范围 在类上使用@Async会覆盖方法上的@Async
     */
}
