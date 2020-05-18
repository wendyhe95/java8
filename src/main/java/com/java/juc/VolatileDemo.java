package com.java.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }

    public void addPlus(){
        // number++在多线程下是非线程安全的
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * @Author: 95
 * @Date: 2020/5/15
 *
 * 1. 验证volatile的可见性
 * 2. 验证volatile不保证原子性
 *      原子性：一个操作是不可中断的，要么全部执行成功要么全部执行失败
 *
 *      如何保证原子性： 加Sync/AtomicInteger
 */
public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {

            new Thread(() ->{
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlus();

                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 等待上面20个线程全部计算完成
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger number value:" + myData.atomicInteger);

    }

    // 可以保证可见性，及时通知其他线程 主物理内存的值已经修改
    public static void seeOKByVolatile(){
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");

            // 暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();

            System.out.println(Thread.currentThread().getName()+"\t update value to "+myData.number);

        },"AAA ").start();

        while(myData.number == 0){

            // main线程一直等待循环
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over,main get value:"+myData.number);

    }
}
