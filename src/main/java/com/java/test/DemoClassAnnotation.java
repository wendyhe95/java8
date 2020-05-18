package com.java.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * java Class类getAnnotation()的测试程序
 *
 * Created by wendyhe on 2019/6/29.
 */
public class DemoClassAnnotation {

    public static void main(String[] args){

        try {
            // 根据“类名”获取 对应的Class对象
            Class<?> cls = Class.forName("com.java.test.People");

            // 获取“Person类”的注解
            MyAnnotation myann = cls.getAnnotation(MyAnnotation.class);

            System.out.println("myann="+myann);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
