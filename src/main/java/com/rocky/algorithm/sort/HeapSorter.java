package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

/**
 * Created by rocky on 18/6/2.
 */
public class HeapSorter implements Sorter {

    @Override
    public int[] sort(int[] origin) {
        int[] copy = ArrayUtil.copyOf(origin);
        if (copy.length == 1) return copy;
        for (int i = parentNum(copy.length - 1); i >= 0; i--) {
            maxAdapt(copy,copy.length-1, i);
        }
        for (int i = copy.length -1; i >= 0; i--) {
            maxAdapt(copy, i, 0);
            ArrayUtil.exchange(copy, 0, i);
        }
        return copy;

    }

    private static int parentNum(int childNum) {
        if (childNum <= 0) throw new RuntimeException("no parent!");
        return (childNum - 1) / 2;
    }

    private static int leftChildNum(int boundNum, int parentNum) {
        int leftNum = parentNum * 2 + 1;
        if (leftNum > boundNum) {
            return -1;
        }
        return leftNum;
    }

    private static int rightChildNum(int boundNum, int parentNum) {
        int rightNum = parentNum * 2 + 2;
        if (rightNum > boundNum) {
            return -1;
        }
        return rightNum;
    }

    /**
     *
     * @param heap
     * @param boundNum 堆边界
     * @param rootNum
     */
    private static void maxAdapt(int[] heap, int boundNum, int rootNum) {
        if (rootNum < 0 || rootNum > boundNum) {
            return;
        }
        int maxChildNum = -1;
        if (leftChildNum(boundNum, rootNum) < 0 && rightChildNum(boundNum, rootNum) < 0) {
            return;
        } else if (leftChildNum(boundNum, rootNum) < 0 && rightChildNum(boundNum, rootNum) >= 0) {
            maxChildNum = rightChildNum(boundNum, rootNum);
        } else if (leftChildNum(boundNum, rootNum) >= 0 && rightChildNum(boundNum, rootNum) < 0) {
            maxChildNum = leftChildNum(boundNum, rootNum);
        } else {
            maxChildNum = heap[leftChildNum(boundNum, rootNum)] > heap[rightChildNum(boundNum, rootNum)]
                    ? leftChildNum(boundNum, rootNum) : rightChildNum(boundNum, rootNum);
        }
        if (heap[rootNum] < heap[maxChildNum]) {
            ArrayUtil.exchange(heap, rootNum, maxChildNum);
            maxAdapt(heap, boundNum,maxChildNum);
        }
    }

    public static void main(String[] args) {
        Checker.check(new HeapSorter());
    }
}
