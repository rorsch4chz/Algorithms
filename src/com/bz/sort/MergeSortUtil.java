package com.bz.sort;

import java.util.Arrays;

public class MergeSortUtil {

    /**
     * 归并排序
     *
     * @param arr 待排序数组
     * @param n   数组大小
     */
    public static void mergeSort(int[] arr, int n) {
        int[] temp = new int[n];
        mergeSortC(arr, 0, n - 1, temp);
    }

    /**
     * 递归函数
     */
    private static void mergeSortC(int[] arr, int first, int last, int[] temp) {
        //递归终止条件
        if (first >= last) return;

        int middle = (first + last) / 2;

        //递归
        mergeSortC(arr, first, middle, temp);
        mergeSortC(arr, middle + 1, last, temp);
        mergeArray(arr, first, middle, last, temp);
    }


    /**
     * 将有二个有序数列a[first...mid]和a[mid...last]合并。
     *
     * @param arr    原数组
     * @param first  第一个数组起始下标
     * @param middle 第一个数组终点下标 （middle+1） 第二个数组起始下标
     * @param last   第二个数组终点下标
     * @param temp   临时数组
     */
    private static void mergeArray(int[] arr, int first, int middle, int last, int[] temp) {
        int i = first, j = middle + 1;

        int k = 0;

        /**
         * 先遍历两个数组从小到大取出数组中的数据放入temp数组
         * 当某一个数组没有数据时，把另一个数组的数据全部放入temp数组
         */
        while (i <= middle && j <= last) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //如果第一个数组还有数据，将数据放入temp数组
        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        //如果第二个数组还有数据，将数据放入temp数组
        while (j <= last) {
            temp[k++] = arr[j++];
        }

        //把temp数组中的数据，按起始下标位置放入arr数组中
        for (i = 0; i < k; i++) {
            arr[first + i] = temp[i];
        }

        //打印出排序过程
        System.out.println(Arrays.toString(arr));
    }
}
