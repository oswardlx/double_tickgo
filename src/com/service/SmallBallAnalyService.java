package com.service;

import com.dao.SmallBallAnalyDao;
import com.entity.RecentNum;
import com.entity.SmallBallSort;
import com.util.SmallBallAly;
import com.util.SortUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallBallAnalyService {
    private String[] sixteen_arr;
    private String[] recent_arr;

    //初始化sixteen_arr,recent_arr
    public SmallBallAnalyService(int mount) {
        SmallBallAnalyDao dao = new SmallBallAnalyDao();
        List<SmallBallSort> sbs_list = dao.get_sixteen();
        sixteen_arr = new String[sbs_list.size()];
        List<RecentNum> rn_list = dao.get_recent_num(mount);
        recent_arr = new String[rn_list.size()];
        for (int i = 0; i < sbs_list.size(); i++) {
            sixteen_arr[i] = String.valueOf(sbs_list.get(i).getNum());
        }
        for (int i = 0; i < rn_list.size(); i++) {
            recent_arr[i] = String.valueOf(rn_list.get(i).getRecent_num());
        }
    }

    //获得三种分析数量结果
    public String[] get_sixteen() {
        SmallBallAly sba = new SmallBallAly();
        String parity_str = sba.parity_analy(recent_arr);
        String group_str = sba.group_analy(sixteen_arr, recent_arr);
        String average_str = sba.average_side_analy(recent_arr);
        String[] result = new String[]{parity_str, group_str, average_str};
        return result;
    }

    public Map<String, Integer> get_sixteen_map() {
        SmallBallAly sba = new SmallBallAly();
        Map<String, Integer> parity_str_map = sba.parity_analy_map(recent_arr);
        parity_str_map.putAll(sba.average_side_analy_map(recent_arr));
        return parity_str_map;
    }

    //获取smallball推荐结果
    public String[] get_smallball_list() {
        try {
            SmallBallAly sba = new SmallBallAly();
            int parity_flag = sba.parity_analy_bol(recent_arr);
            int average_flag = sba.average_side_analy_bol(recent_arr);
            int[] arr_parity = get_parity_arr(sixteen_arr, parity_flag);
            int[] arr_average = get_average_arr(sixteen_arr, average_flag);
            SortUtil su = new SortUtil();
            su.quicksort(arr_parity);
            su.quicksort(arr_average);
            Set<Integer> set1 = sba.get_same_num(arr_parity, arr_average);
            return sba.Set_to_String(set1);
        }catch (RuntimeException re){
            return new String[]{"-1"};
        }
    }

    //获取奇/偶数组   flag==true 奇数
    private int[] get_parity_arr(String[] str_arr, int flag) {
        if (flag == 0) {

            throw new RuntimeException("flag=0");
        }
        int[] arr_parity = new int[str_arr.length / 2];
        for (int i = 0, j = 0; i < str_arr.length; i++) {
            if (flag == 1 && Integer.parseInt(str_arr[i]) % 2 != 0) {
                arr_parity[j] = Integer.parseInt(str_arr[i]);
                j++;
            }
            if (flag == 2 && Integer.parseInt(str_arr[i]) % 2 == 0) {
                arr_parity[j] = Integer.parseInt(str_arr[i]);
                j++;
            }
        }
        return arr_parity;
    }

    //获取分组数组   flag==true 返回第一组
    private int[] get_group_arr(String[] str_arr, boolean flag) {
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

    //获取平均数分析数组  1 小于等于8，2大于8
    private int[] get_average_arr(String[] str_arr, int flag) {
        if (flag == 0) {
            throw new RuntimeException("flag=0");
        }
        int[] int_arr1 = new int[str_arr.length / 2];
        int[] int_arr2 = new int[str_arr.length / 2];
        for (int i = 0, k = 0, j = 0; i < str_arr.length; i++) {
            if (Integer.parseInt(str_arr[i]) <= 8) {
                int_arr1[k] = Integer.parseInt(str_arr[i]);
                k++;
            } else {
                int_arr2[j] = Integer.parseInt(str_arr[i]);
                j++;
            }
        }
        if (flag == 1) {
            return int_arr1;
        } else if (flag == 2) {
            return int_arr2;
        }
        return null;
    }

    //遍历输出数组里的数
    private void print_arr(int[] arr) {
        for (int x : arr) {
            System.out.println(x);
        }
    }

}
