package com.zzjr.example.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
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

    public static void main(String[] args){

        ExecutorService asycControllerTheradPool = new ThreadPoolExecutor(
            3,
            10,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(10),
            new ThreadFactoryBuilder().setNameFormat("asyc-controller-linkInfo-%d").build(),
            new ThreadPoolExecutor.DiscardOldestPolicy()
        );


                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run(){
                        try {
                            Thread.sleep(10000);
                            System.out.println(Thread.currentThread().getName() + " run");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                };

                asycControllerTheradPool.execute(myRunnable);
                asycControllerTheradPool.execute(myRunnable);
    }
}
