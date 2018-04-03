package com.test;

import com.service.SmallBallAnalyService;
import com.util.SmallBallAly;
import com.util.SortUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo3 {
    public static void main(String[] args) {
//        int[] a_arr = new int[]{1, 3, 5,11};
//        int[] b_arr = new int[]{2, 4, 5,6, 8, 11,3};
////        Set<Integer> list = new SmallBallAly().get_same_num(a_arr,b_arr);
////
////        for(int j :list){
////            System.out.println(j);
////        }
//        SortUtil su = new SortUtil();
//        su.quicksort(b_arr);
//        print_arr(b_arr);
//
////        for(int i :list){
////            System.out.println(i);
////        }
        String[] str_arr = new String[]{"13","8","10","1","15","11","3","9","6","2","5","4","14","12","7","16"};
        for(int i:get_group_arr(str_arr,true)){
            System.out.println(i);
        }


    }
    private static  void print_arr(int[] arr){
        for(int x :arr){
            System.out.println(x);
        }
    }
    private static  int[] get_group_arr(String[] str_arr,boolean flag) {
        int[] int_arr1 = new int[str_arr.length / 2];
        int[] int_arr2 = new int[str_arr.length / 2];
        //分成两组第一个与最后一个绑定。以此类推。十指相扣分开成两组。
        for (int i = 0, j = 0, k = 0; i < str_arr.length / 2; i++) {
            if (i % 2 == 0) {
                int_arr1[j] = Integer.parseInt(str_arr[i]);
                int_arr1[str_arr.length / 2 - j - 1] = Integer.parseInt(str_arr[str_arr.length - i - 1]);
                j++;
            } else {
                int_arr2[k] = Integer.parseInt(str_arr[i]);
                int_arr2[str_arr.length / 2 - k - 1] = Integer.parseInt(str_arr[str_arr.length - i - 1]);
                k++;
            }
        }
        if (flag) {
            return int_arr1;
        }
        return int_arr2;
    }
//    public static int[] sort_double_order()
}
