package com.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: 95
 * @Date: 2020/5/27
 */
public class CollectionsMethod {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组1:"+ arrayList);

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(-3);
        arrayList2.add(-5);
        arrayList2.add(7);
        System.out.println("原始数组2:"+ arrayList);

        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse反转(arrayList):" +arrayList);

        // void rotate(List list, int distance)//旋转。
        // 当distance为正数时，将list后distance个元素整体移到前面。
        // 当distance为负数时，将list的前distance个元素整体移到后面。
        Collections.rotate(arrayList, 4);
        System.out.println("Collections.rotate(arrayList, 4):" +arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):" +arrayList);

        // void shuffle(List list),随机排序
        Collections.shuffle(arrayList);
        System.out.println("Collections.shuffle(arrayList):" +arrayList);

        // void swap(List list, int i , int j),交换两个索引位置的元素
        Collections.swap(arrayList, 2, 5);
        System.out.println("Collections.swap(arrayList, 2, 5):"+arrayList);

        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：" +arrayList);

        // int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
        System.out.println("Collections.max(arrayList):" +Collections.max(arrayList));
        System.out.println("Collections.min(arrayList):"+Collections.min(arrayList));

        // boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
        Collections.replaceAll(arrayList, 3, -3);
        System.out.println("Collections.replaceAll(arrayList, 3, -3):" +arrayList);

        // int frequency(Collection c, Object o)//统计元素出现次数
        System.out.println("Collections.frequency(arrayList, -3):" + Collections.frequency(arrayList, -3));

        // int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1
        System.out.println("Collections.indexOfSubList(arrayList, arrayList2):" + Collections.indexOfSubList(arrayList, arrayList2));


        // 对List进行二分查找，返回索引，List必须是有序的
        Collections.sort(arrayList);
        System.out.println("Collections.binarySearch(arrayList, 7):" + Collections.binarySearch(arrayList, 7));
    }
}
