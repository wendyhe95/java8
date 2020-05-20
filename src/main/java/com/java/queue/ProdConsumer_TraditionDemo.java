package com.java.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {

        lock.lock();
        try {
            // 判断不为0时
            while(number != 0){
                // 等待  不能生产
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {

        lock.lock();
        try {
            // 判断不为0时
            while(number == 0){
                // 等待  不能生产
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
/**
 * @Author: 95
 * @Date: 2020/5/20
 *
 * 生产者消费者传统模式  wait notify
 *
 * 1  线程  操作  资源类
 * 2  判断  干活  通知
 * 3  防止虚假唤醒
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 1; i <= 5 ; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5 ; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}
