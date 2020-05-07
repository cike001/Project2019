package net.gwy.demo.data;

import java.util.Arrays;

/**
 * @author gwy
 * @time 2020-05-07 22:40
 * @desc 归并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {1,3,5,6,2,4,8,7};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if (left < right) {
            int mid = (left+right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1, right,temp);
            // 合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并
     * @param arr 需要排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 临时数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int t = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }

        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
