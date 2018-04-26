package com.zzjr.example.inherit;

/**
 * Description:
 *
 * @author <a href="mailto:maoling@zuozh.com">maoling</a>
 * @date Create on 2018/4/18
 * @since version1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
public class TestDemo {

    {
        System.out.println("初始化代码块1");
    }

    public TestDemo(){
        System.out.println("构造器");
    }

    {
        System.out.println("初始化代码块2");
    }

    static{
        System.out.println("静态代码块");
    }

    public static void main(String[] args){

//
//        SuperClass superClass = new SubClass();
//        System.out.println(superClass.name);
//        System.out.println("<-------------------------->");

        {
            int a = 10;
            System.out.println("局部代码块");
        }

        new TestDemo();
        new TestDemo();
        new TestDemo();

    }
}
