package com.java.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: 95
 * @Date: 2020/5/16
 *
 * 集合类线程不安全的问题
 *  ArrayList
 *  HashSet
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {

        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 3 ; i++) {

            new Thread(() -> {
                map.put(Thread.currentThread().getName(),(UUID.randomUUID().toString().substring(0,8)));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
    public static void setNotSafe(){

//        Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 3 ; i++) {

            new Thread(() -> {
                set.add((UUID.randomUUID().toString().substring(0,8)));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    public static void listNotSafe(){
        // new出来一个数组 初始值为10  超过后扩容 新的容量=(原始容量x3)/2 + 1
        // new ArrayList<Integer>();

//        List<String> list = Arrays.asList("a","b","c","d");
//        list.forEach(System.out::println);

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        for(String element : list){
//            System.out.println(element);
//        }

//        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();
        // java.util.ConcurrentModificationException
        for (int i = 1; i <= 3 ; i++) {

            new Thread(() -> {
                list.add((UUID.randomUUID().toString().substring(0,8)));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * 1 故障现象  java.util.ConcurrentModificationException
         *
         * 2 导致原因  并发争抢修改导致
         *
         * 3 解决方案
         *      new Vector();
         *      new Collections.synchronizedList(new ArrayList<>());
         *      new CopyOnWriteArrayList();写时复制
         *
         * 4 优化建议
         */

    }
}
