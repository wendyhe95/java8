package com.java.algorithm;

import java.util.Scanner;

/**
 * @Author: 95
 * @Date: 2020/5/28
 * 有一个数组a[N],要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 */
public class TheLastDeleteNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        if(len > 999){
            len = 999;
        }
        int lastIndex = getLastIndex(len);
        System.out.println(lastIndex);

    }

    public static  int getLastIndex(int len){

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }

        int isDel= len + 1;  // 删除标志
        int currentSize = len;  // 当前数组长度
        int i = 0;  // 数组循环遍历下标
        int j = 0;
        int lastIndex = 0 ; // 最后被删除的元素的下标

        while (currentSize > 0){
            if (arr[i] != isDel) {
                if(j ++ == 2){
                    arr[i] = isDel;
                    lastIndex = i ;
                    currentSize -- ;
                    j = 0;
                }
            }
            i = (i + 1) % len;
        }
        return  lastIndex;
    }
}
