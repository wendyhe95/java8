package com.java.oom;

import java.util.Random;

/**
 * @Author: 95
 * @Date: 2020/5/26
 */
public class HeapSpaceDemo {
    public static void main(String[] args) {

        String str = "hello ";

        while (true){
            str = str + new Random().nextInt(1111111) + new Random().nextInt(2222222) ;
            str.intern();

        }
    }
}
