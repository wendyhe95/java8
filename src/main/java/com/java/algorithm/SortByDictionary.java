package com.java.algorithm;

/**
 * Created by wendyhe on 2018/8/7.
 */
public class SortByDictionary {
    /**
     * 对于给定的字符串 按字典顺序进行排序
     * @param args
     */
    public static void main(String[] args){
        String [] arr={"nba","abc","cba","zz","qq","haha","gdp"};
        System.out.print("before: ");
        printArray(arr);
        sort(arr);
        System.out.print("after: ");
        printArray(arr);
    }
    public static void printArray(String[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1){
                System.out.print(arr[i]+",");
            }else {
                System.out.println(arr[i]+"]");
            }
        }
    }

    public static void sort(String[] arr){
        for(int i=0;i<arr.length-1;i++){
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0){
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

            }
        }
    }

}
