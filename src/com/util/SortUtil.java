package com.util;

public class SortUtil {
    private double s = 1.3;
    private boolean flag = false;
    public void quicksort(int[] a){
        int n = a.length;
        int j = n;
        int temp = 0;
        while (j > 1 || flag == true) {
            int i = 0;
            j = Math.max((int) (j / s), 1);
            flag = false;
            while (i + j < n) {
                if (a[i] > a[i + j]) {
                    temp = a[i];
                    a[i] = a[i + j];
                    a[i + j] = temp;
                    flag = true;
                }
                i = i + 1;
            }
        }
    }
}
