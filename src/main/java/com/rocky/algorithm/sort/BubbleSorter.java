package com.rocky.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by rocky on 18/4/27.
 */
public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] origin) {
        int[] s = Arrays.copyOf(origin, origin.length);
        for (int i = s.length - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    ArrayUtil.exchange(s, j, j + 1);
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Checker.check(new BubbleSorter());
    }
}
