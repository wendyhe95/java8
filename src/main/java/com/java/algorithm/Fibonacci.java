package com.java.algorithm;

/**
 * @Author: 95
 * @Date: 2020/6/16
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 */
public class Fibonacci {


    public static void main(String[] args) {

        FibonacciDemo1(20);
        FibonacciDemo2(20);
    }

    /**
     * 迭代法
     */
    public static int FibonacciDemo1(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 递归
     */
    public static int FibonacciDemo2(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        return FibonacciDemo2(n - 2) + FibonacciDemo2(n - 1);

    }


}
