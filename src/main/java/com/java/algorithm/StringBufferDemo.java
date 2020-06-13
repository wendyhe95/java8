package com.java.algorithm;

/**
 * Created by wendyhe on 2018/8/7.
 */
public class StringBufferDemo {
    public static void main(String[] args){
        StringBufferDemo_1();
    }
    private static void StringBufferDemo_1(){
        StringBuffer sb = new StringBuffer("abce");
        //sb.delete(1,3);  //ae
        //sb.replace(1, 3, "nba");  //anbae
        //sb.setCharAt(2, 'q');  //abqe
        //sb.setLength(10);
        //System.out.println("sb:"+sb); System.out.println("len:"+sb.length());
        //sb.append("haha");  //abcehaha
        //sb.insert(2,"qq");  //abqqce

        System.out.println(sb);


    }
}
