package com.silenceland.leetcode.week1;

public class Solution24 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 5, 0, 7, 9};
        moveZero(nums);
        System.out.println(nums);
    }

    public static void moveZero(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            throw new RuntimeException("nums[] length less than 1, error");
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
