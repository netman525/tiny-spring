package com.zzjr.example.thread;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/11
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class ThreadInterruptDemo implements Runnable{

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new ThreadInterruptDemo(),"InterruptDemo Thread");
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println("线程是否中断:" + thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    @Override
    public void run(){
        boolean stop = false;
        while(!stop){
            System.out.println("My Thread is running ......");
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis() - time) < 1000){

            }
            try {
                Thread.sleep(3L);
            }catch (InterruptedException e){
                break;
            }


            //处理中断请求
//            if(Thread.currentThread().isInterrupted()){
//                System.out.println("收到中断请求...");
//                break;
//            }

        }
        System.out.println("My Thread exiting under request ......");
    }
}
