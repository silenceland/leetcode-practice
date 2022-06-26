package com.silenceland.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Silenceland
 * @description Solution23
 * @date 2022/6/6
 *
 * 兴业数金笔试题
 * 找寻有序数组中缺失的整数
 */
public class Solution23 {

    public static void main(String[] args) {
        int[] input = {1,2,4,6};
        int[] res = getMissNums(input);
        System.out.println(res);
    }

    private static int[] getMissNums(int[] remainTickets) {
        int n = remainTickets.length;
        int min = remainTickets[0];
        int max = remainTickets[0];

        for (int i = 0; i < n; i ++) {
            if (remainTickets[i] > max) {
                max = remainTickets[i];
            }

            if (remainTickets[i] < min) {
                min = remainTickets[i];
            }
        }

        Set<Integer> set = Arrays.stream(remainTickets).boxed().collect(Collectors.<Integer>toSet());
        List<Integer> res = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
