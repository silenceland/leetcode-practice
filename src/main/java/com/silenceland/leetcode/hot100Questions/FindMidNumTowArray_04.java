package com.silenceland.leetcode.hot100Questions;

/**
 * @author silenceland
 * @description FindMidNumTowArray_04
 * @date 2022/6/13
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 */
public class FindMidNumTowArray_04 {
    public static void main(String[] args) {

    }

    /**
     * 1、合并兩個数组，找到中间那位数
     * 2、二分法寻找第K个数
     * @param nums1
     * @param nums2
     * @return
     */
    private static double findMidNumTwoArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        // 奇数
        if (length % 2 == 1) {
            int midLength = length/2;
            double medinNum = getKthNum(nums1, nums2, midLength);
            return medinNum;
        } else {
            // 偶数
            int midLength1 = length/2 - 1;
            int midLength2 = length/2;

            double medinNum = getKthNum(nums1, nums2, midLength1) + getKthNum(nums1, nums2, midLength2) / 2;
            return medinNum;
        }
    }

    // 求第k个数
    public static int getKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 定义两个指针
        int index1 = 0, index2 = 0;
        int kthNum = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                // 一个数组为空
                return nums2[index2 + k - 1];
            }

            if (index2 == length2) {
                // 一个数组为空
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况，index1、index2作为起点，newIndex1、newIndex2作为比较点，不断变化
            int half = k/2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.max(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }
}
