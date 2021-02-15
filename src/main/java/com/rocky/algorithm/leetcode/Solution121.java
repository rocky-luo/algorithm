package com.rocky.algorithm.leetcode;

public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxPro = 0;
        for (int i=0; i< prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            if (prices[i] - min > maxPro) {
                maxPro = prices[i] - min;
            }
        }
        return maxPro;
    }

}
