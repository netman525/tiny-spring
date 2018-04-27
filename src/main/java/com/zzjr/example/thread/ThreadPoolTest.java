package com.zzjr.example.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/27
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class ThreadPoolTest {

    private static ExecutorService asycControllerTheradPool = null;

    /**
     *
     */
    private static ThreadFactory asycControllerTheradPoolFactory = new ThreadFactoryBuilder().setNameFormat(
        "asyc-controller-linkInfo-%d").build();

    public static void main(String[] args){
        asycControllerTheradPool = new ThreadPoolExecutor(
            3,
            2,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(10),
            asycControllerTheradPoolFactory,
            new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for(int i = 0 ;i < 2 ;i ++){
            asycControllerTheradPool.execute(new Runnable() {
                @Override
                public void run(){
                    System.out.println("Hello " + i);
                }
            });
        }
    }
}
