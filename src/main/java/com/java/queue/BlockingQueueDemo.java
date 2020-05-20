package com.java.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 95
 * @Date: 2020/5/19
 * ArrayBlockingQueue  是一个基于数组结构的有界阻塞队列，按照FIFO原则对元素进行排序
 * LinkedBlockingQueue  一个基于链表的有界(Integer.MAX_VALUE)阻塞队列，按照FIFO进行排序，吞吐量通常高于ArrayBlockQueue
 * PriorityBlockingQueue  支持优先级排序的无界阻塞队列
 * DelayQueue 使用优先级队列实现的延迟无界阻塞队列
 * SynchronousQueue  一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态。吞吐量通常高于LinkedBlockingQueue
 * LinkedTransferQueue  由链表结构组成的无界阻塞队列
 * LinkedBlockingDeque  由链表结构组成的双向阻塞队列
 *
 * 重点ArrayBlockingQueue   LinkedBlockingQueue    SynchronousQueue
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        // add 队列已满抛异常  remove队列已空抛异常
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//
//        System.out.println(blockingQueue.element()); //查看队首
//        System.out.println(blockingQueue.remove()); //移除a


//        // offer时队列已满返回false  poll时队列为空返回null
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("a"));
//
//        System.out.println(blockingQueue.peek());//查看队首
//        System.out.println(blockingQueue.poll());

        // put时队列已满 会一直阻塞生产者线程直到成功或者响应中断退出
        // take时队列已空 会阻塞消费者线程直到队列可用
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        System.out.println("===================");
//        blockingQueue.put("x");
//
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();

        // offer(s,time,unit) 队列已满时  会阻塞队列一定时间后超时退出
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));



    }

}
