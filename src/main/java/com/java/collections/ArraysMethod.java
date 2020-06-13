package com.java.collections;

import java.util.Arrays;

/**
 * @Author: 95
 * @Date: 2020/5/27
 */
public class ArraysMethod {

    public static void main(String[] args) {

        int a[] = { 1, 3, 2, 7, 6, 5, 4, 9 };

        // sort(int[] a)方法按照数字顺序排列指定的数组。
//        Arrays.sort(a);
//        System.out.println("Arrays.sort(a):");
//        printArr(a);
//        System.out.println();
//        System.out.println("==============================");

        // // sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
//        Arrays.sort(a, 2, 6);
//        System.out.println("Arrays.sort(a, 2, 6):");
//        printArr(a);
//        System.out.println();
//        System.out.println("==============================");

        // parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
        Arrays.parallelSort(a);
        System.out.println("Arrays.parallelSort(a)：");
        printArr(a);
        System.out.println();
        System.out.println("==============================");


        // parallelSort给字符数组排序，sort也可以
        char d[] = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        Arrays.parallelSort(d);
        System.out.println("Arrays.parallelSort(d)：");
        for (char d2 : d) {
            System.out.print(d2);
        }
        System.out.println(Arrays.toString(d)); //返回指定数组的内容的字符串表示形式。
        System.out.println();
        System.out.println("==============================");


        // *************复制 copy****************
        // copyOf 方法实现数组复制,h为数组，6为复制的长度
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int i[] = Arrays.copyOf(h, 6);
        System.out.println("Arrays.copyOf(h, 6);：");

        for (int j : i) {
            System.out.print(j); // 输出结果：123333
        }
        System.out.println();
        System.out.println("==============================");


        // copyOfRange将指定数组的指定范围复制到新数组中
        int j[] = Arrays.copyOfRange(h, 6, 11);
        System.out.println("Arrays.copyOfRange(h, 6, 11)：");
        // 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
        for (int j2 : j) {
            System.out.print(j2);
        }

        // 数组中所有元素重新分配值
        Arrays.fill(h, 3);
        System.out.println("Arrays.fill(g, 3)：");
        // 输出结果：333333333
        for (int k : h) {
            System.out.print(k);
        }

        // 数组中指定范围元素重新分配值
        Arrays.fill(h, 0, 2, 9);
        System.out.println("Arrays.fill(h, 0, 2, 9);：");
        // 输出结果：993333666
        for (int k1 : h) {
            System.out.print(k1);
        }



    }

    public static void printArr(int[] a){
        for (int i : a) {
            System.out.print(i);
        }
    }
}
