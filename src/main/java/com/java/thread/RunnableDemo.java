package com.java.thread;

import java.util.Date;
import java.util.concurrent.*;

class MyRunnable implements Runnable{

        private String command;
        public MyRunnable(String s){
            this.command =s;
        }
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " Start. Time ===========" + new Date());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " End. Time ************  " + new Date());
        }
}

/**
 * @Author: 95
 * @Date: 2020/6/1
 */
public class RunnableDemo  {

    public static void main(String[] args) {

        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 10; i++) {

            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }

        executor.shutdown();
        // isTerminated() : 当调用 shutdown() 方法后，并且所有提交的任务完成后返回为 true
        while(!executor.isTerminated()){

        }
        System.out.println("Finished all  ================== ");
    }

}
