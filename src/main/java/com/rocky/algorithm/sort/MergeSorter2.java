package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

import java.util.Arrays;

public class MergeSorter2 implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        mergeSort(origin, 0, origin.length -1);
        return origin;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] l1 = Arrays.copyOfRange(array, start, mid +1);
        int[] l2 = Arrays.copyOfRange(array, mid + 1, end + 1);
        int idx1 = 0;
        int idx2 = 0;
        for (int i=start; i <= end; i++) {
            if (idx1 < l1.length && idx2 < l2.length) {
                if (l1[idx1] < l2[idx2]) {
                    array[i] = l1[idx1];
                    idx1++;
                }else {
                    array[i] = l2[idx2];
                    idx2++;
                }
            }else if (idx1 < l1.length) {
                array[i] = l1[idx1];
                idx1++;
            }else {
                array[i] = l2[idx2];
                idx2++;
            }
        }
    }

    public static void main(String[] args) {
        Checker.check(new MergeSorter2());
    }
}
