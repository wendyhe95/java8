package com.java.algorithm;

/**
 * Created by wendyhe on 2018/8/7.
 */
public class StringTest_3 {
    /**
     * 获取两个字符串的最大共有子串
     * @param args
     */
    public static void main(String[] args){
        String s1="qwerabcdtyui";
        String s2="dfabcdhjl";
        String s=getMax(s1,s2);
        System.out.println("s= "+s);

    }

    public static String getMax(String s1,String s2){
        String max = null;
        String min = null;
        max = (s1.length()>s2.length()?s1:s2);
        min = max.equals(s1)?s2:s1;
        System.out.println("max= " + max);
        System.out.println("min= " + min);

        for (int i = 0; i <min.length() ; i++) {
            for (int a=0,b=min.length()-i;b!=min.length()+1; a++,b++) {
                String sub=min.substring(a,b);
                if(max.contains(sub)){
                    return sub;
                }

            }

        }
        return null;

    }
}
