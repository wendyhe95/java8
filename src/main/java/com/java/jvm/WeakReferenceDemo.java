package com.java.jvm;

import java.lang.ref.WeakReference;

/**
 * @Author: 95
 * @Date: 2020/5/26
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj1);
        System.out.println(obj1);
        System.out.println(weakReference.get());

        obj1 = null;
        System.gc();
        System.out.println("======================");

        System.out.println(obj1);
        System.out.println(weakReference.get());
    }

}
