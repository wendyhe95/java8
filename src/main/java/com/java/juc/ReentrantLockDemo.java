package com.java.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendMessage() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendMessage() ------");
        sendMail();
    }
    public synchronized void sendMail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendMail() ------");
    }

    // ReentrantLock
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        //lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoked get() ------");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //lock.unlock();
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoked set() ------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * @Author: 95
 * @Date: 2020/5/19
 * 可重入锁(也叫递归锁)
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码
 * 在同一线程在外层方法获取锁的时候，在进入内层方法时会自动获取锁。
 *
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 *
 * synchronized是典型的可重入锁。OUT:
 * t1	 invoked sendMessage() ------
 * t1	 invoked sendMail() ------
 * t2	 invoked sendMessage() ------
 * t2	 invoked sendMail() ------
 *
 *
 * synchronized是典型的可重入锁。OUT:
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() ->{
            try {
                phone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() ->{
            try {
                phone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        // 暂停3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");
        t3.start();
        t4.start();

    }
}
