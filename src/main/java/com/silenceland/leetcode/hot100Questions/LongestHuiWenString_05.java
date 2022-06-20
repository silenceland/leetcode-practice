package com.silenceland.leetcode.hot100Questions;

/**
 * @author silenceland
 * @description LongestHuiWenString_05
 * @date 2022/6/13
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 */
public class LongestHuiWenString_05 {

    public static void main(String[] args) {
        String s = "zaasdafvabcbavfadwqewe";
        System.out.println(longestPalindrome(s));
    }

    // 动态规划解法
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxlen = 1;
        int begin = 0;

        // dp[i][j]表示i到j是否是回文串
        boolean dp[][] = new boolean[len][len];
        // 对角线上都为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxlen);
    }
}
