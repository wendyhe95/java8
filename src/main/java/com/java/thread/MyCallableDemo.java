package com.java.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        return Thread.currentThread().getName();
    }
}

/**
 * @Author: 95
 * @Date: 2020/6/1
 */
public class MyCallableDemo {

    public static void main(String[] args) {

        ExecutorService executors = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<FutureTask<String>> futureList = new ArrayList<>();

        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            //提交任务到线程池
            Future<String> future = executors.submit(callable);
            //将返回值 future 添加到 list，我们可以通过 future 获得 执行 Callable 得到的返回值
            futureList.add((FutureTask<String>) future);
        }
        for (Future<String> fut : futureList) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        executors.shutdown();

    }
}
