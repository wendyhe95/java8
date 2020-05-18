package com.java.test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Type;

/**
 *  java Class类的有关父类和接口的测试
 *
 * Created by wendyhe on 2019/6/29.
 */
public class DemoClassInterface {

    public static void main(String[] args){

//        try {
//            // 根据“类名”获取 对应的Class对象
//            Class<?> cls = Class.forName("com.java.test.PersonObj");
//
//            // 获取“Person”的父类
//            Type father = cls.getGenericSuperclass();
//
//            // 获取“Person”实现的全部接口
//            Type[] types = cls.getGenericInterfaces();
//
//            System.out.println("father ===" + father);
//
//            for(Type t : types)
//
//                System.out.println(" t = " + t);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        boolean bool = isPerfectSquare(14);

        System.out.println(bool);
    }

    public static boolean isPerfectSquare(int num) {
        for(int n = 1; num > 0; n += 2){
            num -= n;
        }
        return num == 0;
    }
}
