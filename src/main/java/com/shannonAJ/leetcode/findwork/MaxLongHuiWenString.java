package com.shannonAJ.leetcode.findwork;

/**
 * @author ShannonAJ
 * @description MaxLongHuiWenString
 * @date 2021/8/2
 * 最长回文字符子串
 * 解法1：动态规划
 * s: ababa
 */
public class MaxLongHuiWenString {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化，所有长度为1的子串都是回文串
        for (int i=0; i<len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        // 回文子串的长度，即可以认为是窗口大小
        for (int j = 1; j < len; j++) {
            // 枚举左边界，左边界上限设置可宽松一些
            for (int i = 0; i < j; i++) {
//                // 由wLen和 i 可以确定右边界, 即j-i+1 = wLen
//                int j = wLen + i - 1;
//                // 如果右边界越界，就可以退出当前循环
//                if (j > len) {
//                    break;
//                }

                // 左边界不等于右边界数，不是回文串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 左边界等于右边界
                    // 如果子串长度等于2或者3，则为回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 只要dp[i][wlen]= true成立，就表示子串s[i..wLen]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String res = longestPalindrome("ababa");
        System.out.println(res);
    }
}
