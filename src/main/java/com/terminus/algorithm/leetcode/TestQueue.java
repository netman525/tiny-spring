package com.terminus.algorithm.leetcode;

/**
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @description:
 * @date Create on 2020/4/14
 * @since version1.0 Copyright 2020 terminus.io All Rights Reserved.
 */
public class TestQueue {


    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.num = 0;
        bag.max = 5;
        new BagProducer(bag).start();
        new BagConsumer(bag).start();

    }

    static class BagProducer extends Thread{

        private Bag bag;

        public BagProducer(Bag bag){
            this.bag = bag;
        }

        @Override
        public void run() {
            while (true){
                synchronized(bag){
                    if(bag.num >= bag.max){
                        try {
                            bag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bag.num++;
                    System.out.println("正在生产,数量: "+ bag.num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bag.notify();
                }
            }
        }
    }

    static class BagConsumer extends Thread{

        private Bag bag;

        public BagConsumer(Bag bag){
            this.bag = bag;
        }

        @Override
        public void run() {
            while (true){
                synchronized(bag){
                    if(bag.num < 1){
                        try {
                            bag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bag.num--;
                    System.out.println("消费完成,数量: "+ bag.num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    bag.notify();
                }
            }
        }
    }

    static class Bag{

        private int num;

        private int max;
    }
}
