package com.zzjr.example.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Description: 同步计数器
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/12
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker("Java 程序员1",latch);
        Worker worker2 = new Worker("Java 程序员2",latch);
        Worker worker3 = new Worker("Java 程序员3",latch);
        worker1.start();
        worker2.start();
        worker3.start();
        latch.await();
        System.out.println("Main Thread end !");
    }


    static class Worker extends Thread{
        private String workName;
        private CountDownLatch latch;

        public Worker(String workName,CountDownLatch latch){
            this.workName = workName;
            this.latch = latch;
        }

        @Override
        public void run(){
            try{
                System.out.println("Worker:" + workName + " is begin.");
                Thread.sleep(1000);
                System.out.println("Worker:" + workName + " is end.");
            }catch (Exception e){

            }
            latch.countDown();
        }
    }
}
