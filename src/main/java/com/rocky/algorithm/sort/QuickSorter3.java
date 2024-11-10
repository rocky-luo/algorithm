package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

public class QuickSorter3 implements Sorter{

    @Override
    public int[] sort(int[] origin) {
        quickSort(origin, 0, origin.length - 1);
        return origin;
    }


    private void quickSort(int[] origin, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = partion(origin, start, end);

        quickSort(origin, start, mid);
        quickSort(origin, mid + 1, end);

    }

    private int partion(int[] origin, int start, int end) {
        int ref = origin[end];
        int mid = start - 1;
        for (int i = start; i < end; i ++) {
            if (origin[i] <= ref) {
                ArrayUtil.exchange(origin, ++mid, i);
            }
        }
        ArrayUtil.exchange(origin, ++mid, end);
        return mid;
    }

    public static void main(String[] args) {
        Checker.check(new QuickSorter3());
    }
}
