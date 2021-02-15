package com.rocky.algorithm.search;

public class BinarySearcher implements Searcher{
    @Override
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) /2;
            if (array[mid] == target) {
                return mid;
            }else if (array[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        Checker.check(new BinarySearcher());
    }
}
