package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class AsyncTask {
    @Async
    public void  asyncRun() throws InterruptedException {
        Thread.sleep(10);
        log.info(Thread.currentThread().getName()+":处理完成");
    }


    /**
     * 在这段注释中有两个非常重要的部分
     * 1.使用@Async的方法只能返回Void 或者 Future类型
     * 2.表明了@Async是通过org.springframework.core.task.TaskExecutor
     * 或者java.util.concurrent.Executor来创建线程池
     * 3.写了@Async的作用范围 在类上使用@Async会覆盖方法上的@Async
     */
}
