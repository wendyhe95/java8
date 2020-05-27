package com.java.oom;

/**
 * @Author: 95
 * @Date: 2020/5/26
 *
 * 高并发请求服务器时，经常出现如下异常：java.lang.OutOfMemoryError：unable to create new native thread
 * 准确的来说native thread异常与对应的平台有关
 *
 * 导致原因：
 *      你的应用创建了太多线程，一个应用进程创建多个线程，超过系统负载极限
 *      你的服务起并不允许你的应用程序创建这么多线程，linux系统默认允许单个进程可以创建的线程数是1024
 *      你的应用创建超过了这个数量，就会报java.lang.OutOfMemoryError：unable to create new native thread
 *
 * 解决办法：
 * 1.降低应用程序创建线程的数量，分析应用是否真的需要创建这么多线程
 * 2.对于有的应用，确实需要创建很多线程，远超过linux默认的1024个，可以通过修改linux服务器配置，扩大linux限制
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {
        // java.lang.IllegalThreadStateException
//        Thread t1 = new Thread();
//        t1.start();
//        t1.start();

        for (int i = 0; ; i++) {

            System.out.println("=============== i: " + i);

            new Thread(() -> {
                 try { Thread.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }

            },""+i).start();
        }


    }

}
