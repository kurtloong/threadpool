package com.fantasi.threadpool;


import com.fantasi.newrank.common.theadpool.util.ThreadPoolMonitorUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author newrank
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor test01(){
        return new ThreadPoolMonitorUtil(16,32,60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),"test01");
    }

    @Bean
    public ThreadPoolExecutor test02(){
        return new ThreadPoolMonitorUtil(8,16,60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),"test02");
    }
    @Bean
    public ThreadPoolExecutor discardPolicy(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolMonitor(8,16,60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20),"discardPolicy");
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        return threadPoolExecutor;
    }

}
