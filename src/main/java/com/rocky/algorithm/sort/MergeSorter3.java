package com.rocky.algorithm.sort;

import com.rocky.algorithm.utils.ArrayUtil;

import java.util.Arrays;

public class MergeSorter3 implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        if (origin == null) {
            return origin;
        }
        mergeSort(origin, 0, origin.length -1);
        return origin;
    }

    private void mergeSort(int[] origin, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(origin, start, mid);
        mergeSort(origin, mid+1, end);
        merge(origin, start, mid, end);

    }

    private void merge(int[] origin, int start, int mid, int end) {
        int[] lArray = Arrays.copyOfRange(origin, start, mid + 1);
        int[] rArray = Arrays.copyOfRange(origin, mid+1, end+1);
        int l = 0;
        int r = 0;

        for (int i=start; i <= end; i++) {
            if (l < lArray.length && r < rArray.length) {
                if (lArray[l] < rArray[r]) {
                    origin[i] = lArray[l++];
                }else {
                    origin[i] = rArray[r++];
                }
            }else if (l < lArray.length) {
                origin[i] = lArray[l++];
            }else {
                origin[i] = rArray[r++];
            }
        }

    }

//    private void merge(int[] origin, int start, int mid, int end) {
//        // 不使用额外空间的归并排序
//        int leftIdx = start;
//        int rightIdx = mid + 1;
//        boolean leftOver = false;
//        boolean rightOver = false;
//        for (int i = start; i <= end; i++) {
//            if (!leftOver && !rightOver) {
//                if (origin[leftIdx] < origin[rightIdx]) {
//                    if (leftIdx > mid) {
//                        ArrayUtil.exchange(origin, leftIdx, i);
//                        if (leftIdx + 1 == rightIdx) {
//                            leftIdx = i + 1;
//                            if (leftIdx > mid) {
//                                leftOver = true;
//                            }
//                        }else {
//                            leftIdx++;
//                            if (leftIdx == rightIdx) {
//                                leftOver =true;
//                            }
//                        }
//                    }else {
//                        leftIdx++;
//                        if (leftIdx > mid) {
//                            leftOver = true;
//                        }
//                    }
//
//                }else {
//                    ArrayUtil.exchange(origin, rightIdx, i);
//                    if (i == leftIdx) {
//                        leftIdx = rightIdx;
//                    }
//                    rightIdx++;
//                    if (rightIdx > end) {
//                        rightOver = true;
//                    }
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
//        MergeSorter3 m3 = new MergeSorter3();
//        int[] l = new int[] {4,8,5,6,7};
//        m3.merge(l,0,1, l.length-1);

        Checker.check(new MergeSorter3());
    }
}
