package com.java.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"  自己持有" + lockA +"  尝试获得 " + lockB);
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"  自己持有" + lockB +"  尝试获得 " + lockA);
            }

        }
    }
}
/**
 * @Author: 95
 * @Date: 2020/5/21
 *
 * 死锁是指两个或两个以上的进程在执行过程中  因争夺资源造成的一种等待的现象
 * 若无外力干涉它们都将无法推进下去
 */
public class DeadLockDemo {
    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"threadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"threadBBB").start();

        /**
         * linux  ps -ef|grep  xxxx     ls -l
         * windows下的java查看进程命令   jsp    jsp -l
         *
         * jstack 进程号
         */
    }
}
