package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

public class QuickSorter2 implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        quick(origin, 0, origin.length - 1);
        return origin;
    }

    private void quick(int[] l, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = partition(l, start,end);
        quick(l, start, mid -1);
        quick(l, mid+1, end);
    }

    private int partition(int[] l, int start, int end) {
        if (start == end) {
            return start;
        }
        int i = start-1;
        for (int j= start; j< end; j++) {
            if (l[j] <= l[end]) {
                i++;
                ArrayUtil.exchange(l, i, j);
            }
        }
        i++;
        ArrayUtil.exchange(l,end, i);
        return i;
    }

    public static void main(String[] args) {
        Checker.check(new QuickSorter2());
    }
}
