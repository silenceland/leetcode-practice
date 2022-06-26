package com.silenceland.leetcode.week1;

import java.util.Arrays;

/**
 * @author silenceland
 * @description QuickSort
 * @date 2022/1/19
 *
 * 快速排序
 * 面试中常见小题
 * Aftership/腾讯PCG遇到过
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3,8,5,6,7,9,9,4};
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        if (i > j) {
            return;
        }

        int k = array[i];
        while (i < j) {
            while (i < j && array[j] > k) {
                j--;
            }

            while (i < j && array[i] <= k) {
                i ++;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        k = array[i];
        array[i] = array[low];
        array[low] = k;

        sort(array, low, i-1);
        sort(array, i+1, high);
    }
}
