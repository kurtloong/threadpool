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


}
