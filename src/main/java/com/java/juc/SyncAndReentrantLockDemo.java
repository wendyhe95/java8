package com.java.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 95
 * @Date: 2020/5/20
 * synchronized和lock区别,用新的lock有什么好处？
 *     1.原始构成
 *         * synchronized是关键字属于JVM层面。
 *             monitorenter和monitorexit
 *         * lock是具体类(java.until.concurrent.locks.lock)是api层面的锁
 *     2.使用方法
 *         * synchronized不需要用户去手动释放锁，当synchronized代码执行之后系统会自动让线程释放对锁的占用
 *         * ReentrantLock则需要用户手动释放锁，如没有主动释放则可能出现死锁现象
 *     3.等待是否可中断
 *         * synchronized不可中断，除非抛出异常或正常运行
 *         * ReentrantLock可中断，设置超时方法trylock(long timeout,TimeUnit unit)或lockInterruptibly()放代码块中调用interrupt()方法可中断
 *     4.加锁是否公平
 *         * synchronized非公平锁
 *         * ReentrantLock两者都可以。默认非公平锁。构造方法可以传入boolean值，true为公平锁，false为非公平锁
 *     5.锁绑定多个条件Condition
 *         * synchronized没有
 *         * ReentrantLock用来实现分组唤醒需要唤醒的线程们，可精确唤醒。synchronized随机唤醒一个线程或者唤醒全部线程。
 *
 *  eg: 多线程之间按顺序调用 实现A-B-C三个线程启动
 *  AA打印5次 通知BB打印10次  通知CC打印15次
 *  紧接着 AA打印5次 通知BB打印10次  通知CC打印15次
 *  ...
 *  10轮
 *
 */
class ShareResource{
    private int number =1;
    private Lock lock = new ReentrantLock();
    private Condition c1= lock.newCondition();
    private Condition c2= lock.newCondition();
    private Condition c3= lock.newCondition();

    public void print5(){
        lock.lock();
        try {

            while(number != 1){
                c1.await();
            }
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number =2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {

            while(number != 2){
                c2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number =3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {

            while(number != 3){
                c3.await();
            }
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
