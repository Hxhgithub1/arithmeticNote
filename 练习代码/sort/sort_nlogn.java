package com.zondy.spark.leetcode.sort;

import com.clearspring.analytics.stream.frequency.CountMinSketch;



public class sort_nlogn {
    //归并排序：递归的将待排序数组从中间分开直至两边的数量为1，然后逐层合并两边的数组并排序
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r)  {
        if(p>=r) return;

        int q = p +(r-p)/2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        merge(a,p,q,r);
    }

    private static void merge(int[] a,int p ,int q, int r) {
        int[] b = new int[r-p+1];
        int i = p;
        int j = q+1;
        int k = 0;

        while (i<=q&&j<=r){
            if (a[i]<=a[j]){
                b[k++] = a[i++];

            }else {
                b[k++] = a[j++];

            }
        }
        if (i>q){
            while (j<=r){
                b[k++] = a[j++];
            }
        }else {
            while (i<=q){
                b[k++] = a[i++];
            }
        }

        for (int l = 0; l < r - p + 1; l++) {
            a[p+l] = b[l];
        }
    }


    //快排
}
