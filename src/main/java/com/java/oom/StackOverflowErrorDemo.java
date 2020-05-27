package com.java.oom;

/**
 * @Author: 95
 * @Date: 2020/5/26
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError(); //Exception in thread "main" java.lang.StackOverflowError
    }
}
