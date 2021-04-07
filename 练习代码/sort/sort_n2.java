package sort;

import java.util.Arrays;

public class sort_n2 {
    //冒泡排序
    public int[] bubbleSort(int[] a, int n) {
        if (n<=1)return a;
        int temp;
        //外层循环代表数组有多少元素就循环多少次
        for (int i = 0; i <n-1 ; i++) {
            boolean flag = false;
            //内层循环是比较的次数，n个数比较n-1次，要减去排序好的数所以为n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j]>a[j+1]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]= temp;
                    flag =true;
                }
            }
            //表示没有数据交换，提前退出
            if (!flag)break;
        }
        return a;
    }
    // 插入排序，a表示数组，n表示数组大小
    public int[] insertionSort(int[] a, int n) {
        if (n<=1)return a;
        for (int i = 1; i <n ; i++) {
            int value = a[i];
            int j=i-1;
            for (;j>=0;j--){
                if (a[j]>value){
                    a[j+1]=a[j];
                }else {
                    break;
                }
            }
            a[j+1]=value;
        }
        return a;
    }
    public int[] selectSort(int[] a, int n){
        if (n<=1)return a;

        for (int i = 0; i <n-1 ; i++) {
            int min = i;
            for (int j = i+1; j <n ; j++) {
                if (a[j]<a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = {5,3,6,4,2};
        int[] ints = new sort_n2().insertionSort(a, 5);
        int[] ints1 = new sort_n2().bubbleSort(a, 5);
        int[] ints2 = new sort_n2().selectSort(a, 5);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
    }
}
