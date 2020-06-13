package com.java.algorithm;

/**
 * Created by wendyhe on 2018/8/7.
 */
public class StringTest_2 {
    /**
     *  获取子串在整串中出现的次数
     */
    public static void main(String[] args){
        String str="abcsjcnhabcjilkabc";
        String key="abc";
        int count=getCount(str,key);
        System.out.println("count: "+count);
    }

    public static int getCount(String str, String key){
        int count=0;
        int index=0;
        // indexOf 根据字符获取在字符串中的第一次出现的位置
        while((index = str.indexOf(key))!=-1){

            // String substring(int beginIndex);获取字符串中一部分字符串。也叫子串.
            str=str.substring(index+key.length());
            count++;
        }
        return count;
    }

}
