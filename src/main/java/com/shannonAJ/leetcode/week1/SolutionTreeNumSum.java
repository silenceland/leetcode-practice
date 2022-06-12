package com.shannonAJ.leetcode.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTreeNumSum {

    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSums(S);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSums(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int first =0; first < n; first++) {
            if (nums[first] > 0) {
                break;
            }

            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }

            int left = first + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    left ++;
                    right --;
                } else if (sum < 0){
                    left ++;
                } else if (sum > 0) {
                    right --;
                }

            }

        }

        return res;
    }
}
