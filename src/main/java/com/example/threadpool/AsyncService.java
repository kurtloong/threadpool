package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {
    @Autowired
    private AsyncTask asyncTask;


    public void  asyncSimpleExample() {
        try {
            log.info("service start");
            asyncTask.asyncRun();
            log.info("service end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void  asyncInvalid() {
        try {
            log.info("service start");
            asyncInvalidExample();
            log.info("service end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void  asyncTransactDemo() {
        log.info("service start");
        asyncTask.asyncTransactDemo();
        log.info("service end");
    }

    public void  asyncRefuseRun() {
        for (int t = 0;t<2000;t++){
            log.info(""+t);
            try {
                asyncTask.asyncRefuseRun();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    @Async
    public void  asyncInvalidExample() throws InterruptedException{
        Thread.sleep(10);
        log.info(Thread.currentThread().getName()+":处理完成");
    }


}
