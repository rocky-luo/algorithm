package com.rocky.algorithm.sort;

public class InsertionSorter2 implements Sorter{
    @Override
    public int[] sort(int[] origin) {
        for (int i=1; i < origin.length; i++) {
            for (int j=i; j > 0; j--) {
                if (origin[j-1] > origin[j]) {
                    int temp = origin[j-1];
                    origin[j-1] = origin[j];
                    origin[j] = temp;
                }else {
                    break;
                }
            }
        }
        return origin;
    }
    public static void main(String[] args) {
        Checker.check(new InsertionSorter2());
    }
}
