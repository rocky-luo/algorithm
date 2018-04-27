package com.rocky.algorithm.sort;

/**
 * Created by rocky on 18/4/27.
 */
public class QuickSorter implements Sorter {
    @Override
    public int[] sort(int[] origin) {
        int[] s = ArrayUtil.copyOf(origin);
        quickSort(s, 0, s.length - 1);
        return s;
    }

    private void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }


    private int partition(int[] a, int p, int r) {
        int ref = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= ref) {
                i++;
                ArrayUtil.exchange(a, i, j);
            }
        }
        i++;
        ArrayUtil.exchange(a, i, r);
        return i;
    }

    public static void main(String[] args) {
        Checker.check(new QuickSorter());
    }
}
