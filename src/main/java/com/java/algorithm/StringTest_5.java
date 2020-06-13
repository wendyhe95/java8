package com.java.algorithm;

import java.util.Scanner;

/**
 * @Author: 95
 * @Date: 2020/5/30
 */
public class StringTest_5 {

    public static void main(String[] args) {
        int[] a = new int[50];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < 50; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int x = 0;x < n; x++){
            String string = sc.next();
            String result = "";

            for (int i = 0; i < string.length(); i++) {

                char c = string.charAt(i);

                c += a[i] % 26;

                if (c > 'z')
                    c -= 26;//向右超界

                    result += c;

            }
            System.out.println(result);

            if (x>=n)
                break;
        }

    }
}

