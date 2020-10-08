package com.rocky.algorithm.leetcode;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        boolean oneMid = true;
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 0) {
            oneMid = false;
        }
        int midIdx = totalLen /2;
        int mid = 0;
        int midBefore = 0;
        for (int idx = 0; idx1 < nums1.length || idx2 < nums2.length;idx++) {
            if (idx1 < nums1.length && idx2 < nums2.length) {
                boolean nums1Min = nums1[idx1] < nums2[idx2];

                if (!oneMid && idx == midIdx -1) {
                    midBefore = nums1Min ? nums1[idx1]:nums2[idx2];
                }
                if (idx == midIdx) {
                    mid = nums1Min ? nums1[idx1]:nums2[idx2];
                }
                if (nums1Min) {
                    idx1++;
                }else {
                    idx2++;
                }

            }else if (idx1 < nums1.length) {
                if (!oneMid && idx == midIdx -1) {
                    midBefore = nums1[idx1];
                }
                if (idx == midIdx) {
                    mid = nums1[idx1];
                }
                idx1++;
            }else {
                if (!oneMid && idx == midIdx -1) {
                    midBefore = nums2[idx2];
                }
                if (idx == midIdx) {
                    mid = nums2[idx2];
                }
                idx2++;
            }
        }
        if (oneMid) {
            return mid;
        }else {
            double midDouble = (double) mid;
            return (midBefore + midDouble) /2;
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3,4};
        double result =new Solution4().findMedianSortedArrays(num1, num2);

    }
}
