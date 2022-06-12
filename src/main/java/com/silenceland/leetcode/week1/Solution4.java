package com.silenceland.leetcode.week1;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *  示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *  示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 */
public class Solution4 {
    public static void main(String[] args) {

    }

    private static void combine(String s) {
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            list.add(String.valueOf(chars[i]));
        }

        for (int i = 0; i < list.size(); i++) {
            String pre = list.get(i);
            StringBuilder stb = new StringBuilder(pre);
            int j = i + 1;
            while (j < list.size()) {
                stb.append(j);
                j++;
            }
        }


    }
}
