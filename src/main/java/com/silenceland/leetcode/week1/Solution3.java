package com.silenceland.leetcode.week1;

public class Solution3 {
    public static void main(String[] args) {

    }

    private static int area(int[] height) {
        int i = 0; int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, height[j - i] * height[i++]) :
                    Math.max(res, height[j - i] * height[j--]);
        }

        return res;

    }
}
