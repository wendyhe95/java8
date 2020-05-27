package com.java.thread;

import java.util.concurrent.*;

/**
 * @Author: 95
 * @Date: 2020/5/21
 *
 *  - 创建大小不固定的线程池 newCachedThreadPool()
 *  - 创建固定数量线程的线程池 newFixedThreadPool()
 *  - 创建单线程的线程池 newSingleThreadExecutor()
 *  - 创建定时线程 newScheduledThreadPool()
 *  - java8新增 newWorkStealingPool()
 *
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService  threadPool = new ThreadPoolExecutor(
                2,  //核心2个
                5,  // 最大5个
                1,  // 超时1s
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 10 ; i++) {
                // execute()的作用是将任务添加到线程池中执行
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");

                });

                // 暂停一会儿线程
                try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }

    public static void threadPollInit(){

        //        System.out.println(Runtime.getRuntime().availableProcessors()); // cpu几核
        // 创建一个线程池，线程池的容量是5
//        ExecutorService  threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService  threadPool = Executors.newSingleThreadExecutor();
        ExecutorService  threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10 ; i++) {
                // execute()的作用是将任务添加到线程池中执行
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");

                });

                // 暂停一会儿线程
                try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
