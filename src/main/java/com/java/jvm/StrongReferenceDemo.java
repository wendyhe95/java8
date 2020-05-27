package com.java.jvm;

/**
 * @Author: 95
 * @Date: 2020/5/22
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;

        obj1 = null;
        System.gc();
        System.out.println(obj2);

    }
}
