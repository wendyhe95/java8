package com.java.thread;


import java.util.concurrent.*;

class MyThread implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t  ============ come in Callable ");

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        return 1024;
    }
}

/**
 * @Author: 95
 * @Date: 2020/5/20
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        MyThread thread = new MyThread();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(thread);
//        executor.submit(futureTask);
//        executor.shutdown();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyThread());
        new Thread(futureTask,"AAA").start();
        new Thread(futureTask2,"BBB").start();

        System.out.println(Thread.currentThread().getName()+" ********************");

        int result01 = 100;

//        while (!futureTask.isDone()){
//
//
//        }

        int result02=futureTask.get();
        System.out.println("============= result :" + (result01+result02));
    }
}
