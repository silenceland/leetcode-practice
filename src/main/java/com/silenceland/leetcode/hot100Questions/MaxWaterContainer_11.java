package com.silenceland.leetcode.hot100Questions;

/**
 * @author silenceland
 * @description MaxWaterContainer_11
 * @date 2022/6/21
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 */
public class MaxWaterContainer_11 {
    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }

    // 双指针法，左右两个指针分别向中间移动
    private static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
