package com.zzjr.example.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/12
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class AotmicIntegerTest {

    public static void main(String[] args){
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println(ai.get());
        System.out.println(ai.getAndSet(5));
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.getAndDecrement());
        System.out.println(ai.getAndAdd(10));
        System.out.println(ai.get());
    }
}
