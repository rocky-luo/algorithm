package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

import java.util.Arrays;

/**
 * 归并排序
 * Created by rocky on 18/4/27.
 */
public class MergeSorter implements Sorter {
    @Override
    public int[] sort(int[] origin) {
        int[] s = ArrayUtil.copyOf(origin);
        mergeSort(s, 0, s.length-1);
        return s;
    }

    private void mergeSort(int[] a, int p, int r) {
        if (p == r) {
            return;
        }
        int m = (p + r) / 2;
        mergeSort(a, p, m);
        mergeSort(a, m + 1, r);
        merge(a, p, m, r);
    }


    private void merge(int[] a, int p, int q, int r) {
        // copyOfRange 不包括 to
        int[] l1 = Arrays.copyOfRange(a, p, q + 1);
        int[] l2 = Arrays.copyOfRange(a, q + 1, r + 1);
        int idx1 = 0;
        int idx2 = 0;
        for (int i = p; i <= r; i++) {
            if (idx1 < l1.length && idx2 < l2.length) {
                a[i] = l1[idx1] < l2[idx2] ? l1[idx1++] : l2[idx2++];
            } else if (idx1 < l1.length) {
                a[i] = l1[idx1++];
            } else {
                a[i] = l2[idx2++];
            }
        }
    }

    public static void main(String[] args) {
        Checker.check(new MergeSorter());
    }
}
