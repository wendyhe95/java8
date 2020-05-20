package com.java.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResource{
    private volatile boolean FLag = true;  // 默认开启  进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduct() throws InterruptedException {
        String data = null;
        boolean retValue;
        while(FLag){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t FLag=false =============== 生产结束");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while(FLag){

            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                FLag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2s未取到，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");

        }
    }

    public void stop(){
        this.FLag =false;
    }
}

/**
 * @Author: 95
 * @Date: 2020/5/20
 */
public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Product").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("5s之后  main线程叫停==========");
        myResource.stop();
    }
}
