package com.bz.sort;

import java.util.Arrays;

public class QuickSortUtil {

    /**
     * 快速排序
     *
     * @param arr 待排序数组
     * @param n   数组大小
     */
    public static void quickSort(int[] arr, int n) {
        quickSortC(arr, 0, n - 1);
    }

    /**
     * 递归函数
     */
    private static void quickSortC(int[] arr, int first, int last) {
        if (first >= last) return;

        //分区点
        int q = partition2(arr, first, last);

        quickSortC(arr, first, q - 1);
        quickSortC(arr, q + 1, last);
    }

    /**
     * 随机选择一个元素作为 pivot（一般情况下，可以选择 p 到 r 区间的最后一个元素），
     * 然后对 A[p…r] 分区，函数返回 pivot 的下标。
     *
     * @param arr   原数组
     * @param first 数组起始下标
     * @param last  数组终点下标
     * @return pivot下标
     */
    private static int partition(int[] arr, int first, int last) {

        int[] temp1 = new int[last - first];
        int[] temp2 = new int[last - first];

        int t1 = 0;
        int t2 = 0;

        /**
         * q下标 之前元素全是小于a[q] 之后元素全是大于a[q]
         */
        int q;

        /**
         * 取数组最后一个元素为pivot，
         */
        int pivot = arr[last];

        /**
         * 将小于 pivot 的元素都拷贝到临时数组 X，将大于 pivot 的元素都拷贝到临时数组 Y，
         */
        for (int i = first; i < last; i++) {
            if (arr[i] <= pivot) {
                temp1[t1++] = arr[i];
            } else {
                temp2[t2++] = arr[i];
            }
        }

        /**
         * 最后再将数组 X 和数组 Y 中数据顺序拷贝到 A[p…r]。
         */
        for (int i = 0; i < t1; i++) {
            arr[first++] = temp1[i];
        }
        q = first++;
        arr[q] = pivot;
        for (int i = 0; i < t2; i++) {
            arr[first++] = temp2[i];
        }

        System.out.println(Arrays.toString(arr));
        return q;
    }

    private static int partition2(int[] arr, int first, int last) {

        /**
         * 通过游标 i 把 A[p…r-1] 分成两部分。
         * A[p…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
         * 我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，
         * 如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
         */
        int pivot = arr[last];

        int i = first;

        for (int j = first; j < last; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[last];
        arr[last] = temp;

        System.out.println(Arrays.toString(arr));
        return i;
    }
}
