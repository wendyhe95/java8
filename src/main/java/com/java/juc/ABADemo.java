package com.java.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: 95
 * @Date: 2020/5/16
 *
 * ABA问题的解决  AtomicStampedReference
 *
 *
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1)
;
    public static void main(String[] args) {

        System.out.println("================= ABA产生");
        new Thread(() -> {
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(() -> {
            // 暂停一秒钟 保证t1完成ABA操作
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println(atomicReference.compareAndSet(100,2020)+"\t"+atomicReference.get());

        },"t2").start();




        /**
         * ABA 的解决
         */

        // 暂停3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("================= ABA解决");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号： "+stamp);

            // 暂停一秒钟
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第2次版本号： "+atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第3次版本号： "+atomicStampedReference.getStamp());
        },"t3").start();


        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号： "+stamp);

            // 暂停一秒钟  保证t3完成ABA
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

            boolean result = atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);

            System.out.println(Thread.currentThread().getName()+"\t 是否修改成功: "+result);
            System.out.println(Thread.currentThread().getName()+"\t 当前实际最新版本号："+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前最新值："+atomicStampedReference.getReference());
        },"t4").start();
    }
}
