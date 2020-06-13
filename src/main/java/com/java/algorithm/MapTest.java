package com.java.algorithm;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wendyhe on 2018/8/10.
 */
public class MapTest {


    /**
     * 获取字符串中每一个字母出现的次数
     * 要求打印结果是:a(2) b(1)...
     */
    public static void main(String[] args){

        String str="fdg+aqAdC  bs5Dda9c- dfsZ";
        String s = getCharCount(str);
        System.out.println(s);

    }

    public static String getCharCount(String str) {
        //将字符串变成字符数组
        char[] chs = str.toCharArray();
        //定义map集合表
        Map<Character,Integer> map = new TreeMap<Character,Integer>();

        for (int i = 0; i < chs.length; i++) {
            if(!(chs[i]>='a' && chs[i]<='z' || chs[i]>='A' && chs[i]<='Z'))
            //if(!(Character.toLowerCase(chs[i])>='a' && Character.toLowerCase(chs[i]<='z')))
                continue;
            Integer value = map.get(chs[i]);
            int count = 1;

            //判断值是否为null.
            if(value!=null){
                count = value+1;
            }
            //count++;
            map.put(chs[i], count);
            /**
             if(value==null){
                map.put(chs[i], 1);
             }else {
                map.put(chs[i], value+1);
             }
             */
        }
       return mapToString(map);
    }

    private static String mapToString(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = map.keySet().iterator();
        while(it.hasNext()){
            Character key = it.next();
            Integer value = map.get(key);
            sb.append(key+"("+value+") "); }
        return sb.toString();
    }

}
