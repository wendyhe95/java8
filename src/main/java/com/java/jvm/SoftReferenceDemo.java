package com.java.jvm;

import java.lang.ref.SoftReference;

/**
 * @Author: 95
 * @Date: 2020/5/22
 */
public class SoftReferenceDemo {

    // 内存够用就保留  不够用就回收
    public static void softRef_Memory_Enough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(softReference.get());
    }

    // 故意产生大对象并配置小内存 让内存不够用 产生OOM
    // -Xms5m -xMX5M -XX:+PrintGCDetails
    public static void softRef_Memory_NotEnough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];

        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(obj1);
            System.out.println(softReference.get());
        }

    }



    public static void main(String[] args) {
        softRef_Memory_Enough();
//        softRef_Memory_NotEnough();
    }
}
