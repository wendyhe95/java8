package com.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 95
 * @Date: 2020/5/27
 */
public class Test {
    public static void main(String[] args) throws IOException {

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;

        System.out.println(d1==d2); // false
        System.out.println(d3==d4); // false
        System.out.println("==========================");

        // Integer i1=40；Java 在编译的时候会直接将代码封装成 Integer i1=Integer.valueOf(40);从而使用常量池中的对象。
        //Integer i6 = new Integer(40);这种情况下会创建新的对象。
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = 200;
        Integer i5 = 200;
        Integer i6 = new Integer(40);
        Integer i7 = new Integer(40);
        Integer i8 = new Integer(0);

        System.out.println("i1=i2   " + (i1 == i2)); // true
        System.out.println("i4=i5   " + (i4 == i5)); // false
        System.out.println("i6=i7   " + (i6 == i7)); // false
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3)); //true
        System.out.println("i1=i6   " + (i1 == i6)); //false
        System.out.println("i1.equals(i6)   "+i1.equals(i6));  //true

        // i6 == i7 + i8，因为+这个操作符不适用于 Integer 对象，
        // 首先 i7 和 i8 进行自动拆箱操作，进行数值相加，即 i6 == 40。
        // 然后 Integer 对象无法与数值进行直接比较，所以 i6 自动拆箱转为 int 值 40，
        // 最终这条语句转为 40 == 40 进行数值比较。
        System.out.println("i6=i7+i8   " + (i6 == i7 + i8));  //true
        System.out.println("40=i7+i8   " + (40 == i7 + i8));  //true
        System.out.println("==========================");


        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999964
        System.out.println(a == b);// false

        System.out.println("==========================");
        /**
         *  获取键盘输入
         */
//        Scanner scanner = new Scanner(System.in);
//        String s= scanner.nextLine();
//        scanner.close();
//
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        String s1 = input.readLine();


        //当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素，而是数组对象本身！
        // 此时List 的唯一元素就是这个数组，这也就解释了上面的代码。
        //我们使用包装类型数组就可以解决这个问题
        //Integer[] myArray = { 1, 2, 3 };
        int[] myArray = { 1, 2, 3 };
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size()); //1
        System.out.println(myList.get(0)); //数组地址值
        System.out.println(myList.get(1)); //报错：ArrayIndexOutOfBoundsException

        // Arrays.asList() 方法返回的并不是 java.util.ArrayList
        // 而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException
    }
}
