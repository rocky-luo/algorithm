package com.rocky.algorithm.utils;

import java.util.Arrays;

/**
 * Created by rocky on 18/4/27.
 */
public class ArrayUtil {
    public static void exchange(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static int[] copyOf(int[] o) {
        return Arrays.copyOf(o, o.length);
    }
}
