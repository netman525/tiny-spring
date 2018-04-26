package com.zzjr.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/12
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException{
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        //4个线程
        for(int i = 0; i < 4;i++){
            new Thread(new Runnable() {
                @Override
                public void run(){
                    while (true){
                        try {
                            String log = queue.take();
                            parseLog(log);
                        }catch (Exception e){

                        }
                    }
                }
            }).start();
        }

        for(int i = 0;i < 16;i++){
            String log = (i + 1) + "----->  ";
            System.out.println(log);
            queue.put(log);
        }

    }


    public static void parseLog(String log){
        System.out.println(log + System.currentTimeMillis());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
