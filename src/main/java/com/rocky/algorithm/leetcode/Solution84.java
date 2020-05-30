package com.rocky.algorithm.leetcode;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int largest = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentH = heights[i];
            int m = i;
            int n = i;

            for(; m > 0; m--) {
                if (currentH > heights[m-1]) {
                    break;
                }
            }
            for(; n < heights.length-1; n++) {
                if (currentH > heights[n+1]) {
                    break;
                }
            }

            int currentMax = (n-m+1) * currentH;
            largest = Math.max(currentMax, largest);
        }
        return largest;
    }
}
