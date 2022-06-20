package com.silenceland.leetcode.hot100Questions;

/**
 * @author silenceland
 * @description RegExpressMatch_10
 * @date 2022/6/20
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/regular-expression-matching
 */
public class RegExpressMatch_10 {

    public static void main(String[] args) {

        String s = "ab", p = ".*";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        // 判断边界情况，p或s分别为null的情况
        if (p == null) {
            if (s == null) {
                return true;
            } else {
                return false;
            }
        }

        if (s == null && p.length() == 1) {
            return false;
        }

        // +1为处理为null的情况
        int m = s.length() + 1;
        int n = p.length() + 1;

        // 状态方程
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        // 处理第一行，所有的列
        for (int j = 2; j < n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        // r=1, m=1,从dp[][]的第二行第二列开始，因为r=0, m=0代表s和p都为空，上面第一行所有的列都已经处理完了
        for (int r = 1; r < m; r++) {
            // s字符串的下标
            int i = r - 1;
            for (int c = 1; c < n; c++) {
                // p字符串的下标
                int j = c - 1;
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[r][c] = dp[r-1][c-1];
                } else if (p.charAt(j) == '*') {
                    //p[j]='*',往前推一位
                    //p[j-1]=s[i] 或 p[j-1]='.', 则dp[r][c]的状态取决于dp[r-1][c]，即s[i]和p的匹配状态
                    //或dp[r][c]的状态取决于dp[r][c-2]，即s[i]和p[j-1]的匹配状态
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        dp[r][c] = dp[r-1][c] || dp[r][c-2];
                    } else {
                        // *匹配前一个字符的0个或多个，所以可以往前推两个
                        dp[r][c] = dp[r][c-2];
                    }
                } else {
                    dp[r][c] = false;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
