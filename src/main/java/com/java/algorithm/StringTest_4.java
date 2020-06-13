package com.java.algorithm;

import java.util.Arrays;

/**
 * Created by wendyhe on 2018/8/7.
 */
public class StringTest_4 {
    /**
     * 模拟一个与trim()相同的方法，去掉两端的空格
     */
//    public static void main(String[] args){
//        String str="    a  bc   ";
//        str=byTrim(str);
//        System.out.println("-"+str+"-");
//    }
//    public static String byTrim(String str){
//        int start=0,end=str.length()-1;
//
//        //根据位置获取字符  charAt(int index);
//        while(start <= end && str.charAt(start) == ' '){
//            start++;
//        }
//        while(start <= end && str.charAt(end) == ' '){
//            end--;
//        }
//        return str.substring(start,end+1);
//    }

    /**
     * toString() 的经典实现
     * @param a
     * @return
     */
    public static String myToString(int[] a){
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
    public static void main(String[] args) {

        int[] arr = {3,1,5,6,3,6};
        System.out.println(Arrays.toString(arr));
        myToString(arr);
    }
}
