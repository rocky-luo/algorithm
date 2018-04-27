package com.rocky.algorithm.sort;


import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by rocky on 18/4/26.
 */
public class Checker {
    public static void check(Sorter sorter) {
        for (int i = 0; i < 10; i++) {
            checkRandomArraySort(sorter);
        }
    }

    private static int[] randomArray(int length) {
        int[] l = new int[length];
        for (int i = 0; i < length; i++) {
            l[i] = new Random().nextInt(100);
        }
        return l;
    }

    private static void checkRandomArraySort(Sorter sorter) {
        int length = new Random().nextInt(100);
        int[] l = randomArray(length);
        int[] s = Arrays.copyOf(l, l.length);
        Arrays.sort(s);
        int[] sorterArray = sorter.sort(Arrays.copyOf(l, l.length));

        Assert.assertArrayEquals("\n期待的结果是:\n" + arrayToString(s) +"\n实际结果是:\n" + arrayToString(sorterArray) + "\n",
                s, sorterArray);
    }

    private static String arrayToString(int[] l) {
        Joiner joiner = Joiner.on(",").skipNulls();
        return joiner.join(Ints.asList(l));
    }
}
