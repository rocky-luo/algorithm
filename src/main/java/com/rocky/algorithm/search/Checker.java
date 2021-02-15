package com.rocky.algorithm.search;

import org.junit.Assert;

public class Checker {
    public static void check(Searcher searcher) {
        int[] a = new int[]{1,4,6,7,9};
        int aIdx = searcher.search(a, 6);
        Assert.assertEquals(a[aIdx], 6);

        int[] b = new int[]{1,4,6};
        int bIdx = searcher.search(b, 6);
        Assert.assertEquals(b[bIdx], 6);

        int[] c = new int[]{1,4,6};
        int cIdx = searcher.search(b, 1);
        Assert.assertEquals(c[cIdx], 1);

        int[] d = new int[]{6,6,6};
        int dIdx = searcher.search(d, 6);
        Assert.assertEquals(d[dIdx], 6);

        int[] e = new int[]{1,4,6,7,9};
        int eIdx = searcher.search(e, 5);
        Assert.assertEquals(eIdx, -1);
    }
}
