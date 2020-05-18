package com.java.test;

import org.junit.Test;

/**
 * Created by wendyhe on 2019/11/12.
 */
public class DemoStep {

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println(f(40));  //165580141
        long end = System.currentTimeMillis();
        System.out.println(end -start); //456ms

        System.out.println(0.0 / 0.0);
    }

    public int f(int n ){

        if(n<1){
            throw new IllegalArgumentException(n + "不能小于1");

        }
        if(n==1 || n==2){
            return n;
        }
        return f(n-2)+f(n-1);

    }

}




