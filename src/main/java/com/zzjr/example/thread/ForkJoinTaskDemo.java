package com.zzjr.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/12
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class ForkJoinTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 5);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println("1-5最终相加的结果:" + result.get());
        CountTask task2 = new CountTask(1, 100);
        Future<Integer> result2 = forkJoinPool.submit(task2);
        System.out.println("1-100最终相加的结果:" + result2.get());
        System.out.println("Thread Main End !!");
    }
}

class CountTask extends RecursiveTask<Integer> {

    private static int spiltSize = 2;
    private int start, end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        int sum = 0;
        boolean canCompute = (end - start) <= spiltSize;
        if (canCompute) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            CountTask firstTask = new CountTask(start, middle);
            CountTask secondTask = new CountTask(middle, end);
            firstTask.fork();
            secondTask.fork();
            int firstResult = firstTask.join();
            int secondResult = secondTask.join();
            sum = firstResult + secondResult;
        }
        return sum;
    }
}