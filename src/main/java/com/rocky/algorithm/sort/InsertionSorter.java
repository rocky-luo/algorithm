package com.rocky.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * Created by rocky on 18/4/27.
 */
public class InsertionSorter implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        int[] s = Arrays.copyOf(origin, origin.length);
        if (s.length == 1) {
            return s;
        }
        for (int i = 1; i < s.length; i++) {
            for (int j = i; j > 0; j--) {
                if (s[j] < s[j-1]) {
                    ArrayUtil.exchange(s, j, j-1);
                }else {
                    break;
                }
            }
        }
        return s;
    }


    public static void main(String[] args) {
        Checker.check(new InsertionSorter());
    }
}
