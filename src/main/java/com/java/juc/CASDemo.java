package com.java.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 95
 * @Date: 2020/5/15
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
        // compareAndSet(int expect, int update)
        // 主物理内存的值为5 期望值为5  相同返回true将当前值改为2019
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data :"+atomicInteger.get());

        // 当前值为2019  期望值为5  不相同返回false
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data :"+atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
