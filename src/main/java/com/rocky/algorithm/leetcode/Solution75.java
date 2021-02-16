package com.rocky.algorithm.leetcode;

import com.google.common.collect.Queues;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int idx0 = -1;
        int idx1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {

            }else if (nums[i] == 1) {
                idx1++;
                exchange(nums, idx1, i);
            }else {
                idx1++;
                exchange(nums, idx1, i);
                idx0++;
                exchange(nums, idx0, idx1);
            }
        }

    }

    public void exchange(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


}
