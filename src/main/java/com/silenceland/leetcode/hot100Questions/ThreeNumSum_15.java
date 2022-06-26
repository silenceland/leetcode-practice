package com.silenceland.leetcode.hot100Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silenceland
 * @description ThreeNumSum_15
 * @date 2022/6/21
 *15. 三数之和
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 */
public class ThreeNumSum_15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> array = threeNumSum(nums);
        System.out.println(array);

    }

    // 双指针+排序
    public static List<List<Integer>> threeNumSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return ans;
        }

        // 数组升序排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int target = -nums[i];
            // 左右指针指向两端
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (target == nums[left] + nums[right]) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; right--;

                    // 去除掉重复的组合，判断是否左边等于前一个数，右边等于后一个数
                    //比如: [-2, -1, -1, -1, 3, 3, 3]
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                } else if (nums[left] + nums[right] < target){
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }


}
