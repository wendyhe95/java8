package com.java.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: 95
 * @Date: 2020/5/19
 *
 * 自旋锁好处：循环比较获取直到成功为止，没有类似await的阻塞
 *
 * 通过CAS操作完成自旋锁，A线程先来调用mylock()方法自己持有的锁5秒钟
 * B随后进来发现当前线程持有锁不为null， 只能通过自旋等待，直到A释放锁后B抢到
 */
public class SpinLockDemo {

    // 原子调用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t  come in ========");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+" invoke myUnlock()======");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo =new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.mylock();
            // 暂停5秒钟
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnlock();
        },"t1").start();

        // 暂停一秒钟
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }


        new Thread(() -> {
            spinLockDemo.mylock();
            spinLockDemo.myUnlock();
        },"t2").start();
    }
}
