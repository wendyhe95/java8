package com.java.thread;

/**
 * Created by wendyhe on 2019/5/16.
 */
public class MyThread extends Thread {

    @Override
    public  void run(){

        System.out.println(Thread.currentThread().getName() + " is running ~~~~~~~");
    }
}
