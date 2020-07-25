package com.java.algorithm;

import java.util.Scanner;

/**
 * @Author: 95
 * @Date: 2020/6/30
 * 输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
 *
 * 输出一个正整数,即这个序列的深度。
 */
public class BracketsDeep {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0, max = 0, i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            max = Math.max(max, cnt);
        }
        sc.close();
        System.out.println(max);
    }

}
