package com.rocky.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int l = 0;
        int r = 0;
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> idxList = new LinkedList<>();
        while (r <= nums.length) {
            if (r - l == k) {
                r++;
                l++;
                if (idxList.getFirst() < l) {
                    idxList.removeFirst();
                }
                if (idxList.getLast() > nums[r-1]) {
                    idxList.offerLast(r-1);
                }else {
                    idxList.offerLast(r-1);
                    for (int i = idxList.size() -2; i >=0; i--) {
                        if (idxList.get(i) <= nums[r-1]) {
                            idxList.remove(i);
                        }
                    }
                }
                res.add(idxList.getFirst());
            }else {
                r++;
                if (idxList.isEmpty()) {
                    idxList.offerLast(r-1);
                }else if (idxList.getLast() > nums[r-1]) {
                    idxList.offerLast(r-1);
                }else {
                    idxList.offerLast(r-1);
                    for (int i = idxList.size() -2; i >=0; i--) {
                        if (idxList.get(i) <= nums[r-1]) {
                            idxList.remove(i);
                        }
                    }
                }

            }
        }
        int[] result = new int[res.size()];
        for (int i=0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
