package com.rocky.algorithm.sort;

/**
 * Created by rocky on 18/4/27.
 */
public class ArrayUtil {
    public static void exchange(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
