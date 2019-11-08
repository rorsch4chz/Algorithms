package com.bz.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {43, 23, 12, 64, 45, 67, 65, 34, 22, 9, 98, 78};
        System.out.println(Arrays.toString(arr));
//        MergeSortUtil.mergeSort(arr, arr.length);

        QuickSortUtil.quickSort(arr, arr.length);

//        QuickSortUtil.getValue(arr, arr.length, 8);
    }
}
