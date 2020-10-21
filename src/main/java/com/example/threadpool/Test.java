package com.example.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class Test {

    public static void main(String[] args) throws InterruptedException {
        newFixedThreadPool();
    }

    public static void simpleAsyncTaskExecutor() throws InterruptedException {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        Thread.sleep(20000);
        while (true){
            simpleAsyncTaskExecutor.submit(()->{
                log.info("submit:"+ LocalDateTime.now());
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
    }

    public static void  newCachedThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread.sleep(20000);
        while (true){
            executorService.submit(()->{
                log.info("submit:"+ LocalDateTime.now());
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
    }

    public static void  newFixedThreadPool() throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread.sleep(20000);
        while (true){
            executorService.submit(()->{
                log.info("submit:"+ LocalDateTime.now());
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

    }
}
