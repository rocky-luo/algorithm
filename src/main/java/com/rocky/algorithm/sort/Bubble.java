package com.rocky.algorithm.sort;

import java.util.Arrays;

/**
 * Created by rocky on 18/4/27.
 */
public class Bubble implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        int[] s = Arrays.copyOf(origin, origin.length);
        for (int i=0; i < s.length; i++) {
            for (int j=0; j < s.length - i -1; j++) {
                if (s[j] > s[j+1]) {
                    ArrayUtil.exchange(s, j, j+1);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Checker.check(new Bubble());
    }
}
