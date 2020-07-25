package com.java.algorithm;

import java.util.HashSet;

/**
 * @Author: 95
 * @Date: 2020/6/19
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 *
 */
public class Palindrome {
    private int index, len;

    public static void main(String[] args) {

    }

    /**
     * 统计字符出现的次数即可，双数才能构成回文。
     * 因为允许中间一个数单独出现，比如“abcba”，所以如果最后有字母落单，总长度可以加 1。
     * 首先将字符串转变为字符数组。然后遍历该数组，判断对应字符是否在hashset中，
     * 如果不在就加进去，如果在就让count++，然后移除该字符！
     * 这样就能找到出现次数为双数的字符个数。
     */
    public  int longestPalindrome(String s) {
        if (s.length() == 0)
            return 0;
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }

    /**
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public  boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            // 从头和尾开始向中间遍历
            if (!Character.isLetterOrDigit(s.charAt(l))) {// 字符不是字母和数字的情况
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {// 字符不是字母和数字的情况
                r--;
            } else {
                // 判断二者是否相等
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                    return false;
                l++;
                r--;
            }
        }
        return true;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串
     */
    public String longestPalindrome1(String s) {

        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            PalindromeHelper(s, i, i);
            PalindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public void PalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }

}
