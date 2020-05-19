package com.java.juc;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;


enum CountryEnum{
    ONE(1,"齐"),TWO(1,"楚"),THREE(1,"燕"),
    FOUR(1,"韩"),FIVE(1,"赵"),SIX(1,"魏");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for(CountryEnum element : myArray){
            if(element.getRetCode() ==index){
                return element;
            }
        }
        return null;
    }
}

/**
 * @Author: 95
 * @Date: 2020/5/19
 * CountDownLatch对象设置一个初始的数字作为计数值，任何调用这个对象上的await()方法都会阻塞，
 * 直到这个计数器的计数值被其他的线程减为0为止。
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

//        CountDownLatch countDownLatch = new CountDownLatch(6);
//
//        for (int i = 1; i <= 6 ; i++) {
//
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"国，被灭");
//                countDownLatch.countDown();
//            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
//
//        }
//        countDownLatch.await();
//
//        System.out.println(Thread.currentThread().getName()+"\t  秦国统一 =======");

        closeDoor();
    }

    // 倒计时
    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 陆续出门=====");
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t  最后出门的关门======");
    }
}
