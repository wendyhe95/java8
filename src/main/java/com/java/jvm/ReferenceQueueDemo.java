package com.java.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: 95
 * @Date: 2020/5/26
 *
 * java 提供4种引用类型，在垃圾回收的时候都有各自的特点
 * ReferenceQueue是用来配合引用工作的 没有ReferenceQueue一样可以运行
 *
 * 创建引用的时候可以指定关联的队列 当GC释放对象内存的时候 会将引用加入到引用队列
 * 这相当于一种通知机制
 *
 * 当关联的引用队列中有数据的时候  意味着引用只想的堆内存中的对象被回收。
 * 通过这种方式，JVM允许我们在对象销毁后做一些我们自己想做的事情
 *
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(obj1,referenceQueue);

        System.out.println(obj1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("======================");
        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
