package com.util;

import javax.net.ssl.SSLContext;
import java.util.*;

public class SmallBallAly {

    public SmallBallAly() {
    }

    public String[] rep_space_spit(String str) {
        return str.replace("\n", ",").split(",");
    }


    //奇偶性分析
    public String parity_analy(String[] recent) {
        int even = 0;
        int odd = 0 ;
        for (String str2 : recent) {
            if (Integer.parseInt(str2) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return "odd:" + odd + ",even:" + even;
    }
    public Map<String,Integer> parity_analy_map(String[] recent){
        Map<String,Integer> map = new HashMap<>();
        int even = 0;
        int odd = 0;
        for (String str2 : recent) {
            if (Integer.parseInt(str2) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        map.put("even",even);
        map.put("odd",odd);
        return map;

    }
    public int parity_analy_bol(String[] recent){
        int even = 0;
        int odd = 0;
        for (String str2 : recent) {
            if (Integer.parseInt(str2) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if(odd<even){
            return 1;
        }else if(odd>even) {
            return 2;
        }
            return 0;
    }


    //奇偶性分析
    public String parity_analy(String recent) {
        String[] recent_arr = rep_space_spit(recent);
        return parity_analy(recent_arr);
    }



    //分组分析
    public String group_analy(String[] sixteen_list_arr, String[] recent_list_arr) {
        int[] int_arr1 = new int[sixteen_list_arr.length / 2];
        int[] int_arr2 = new int[sixteen_list_arr.length / 2];
        //分成两组第一个与最后一个绑定。以此类推。十指相扣分开成两组。
        for (int i = 0, j = 0, k = 0; i < sixteen_list_arr.length / 2; i++) {
            if (i % 2 == 0) {
                int_arr1[j] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr1[sixteen_list_arr.length / 2 - j - 1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length - i - 1]);
                j++;
            } else {
                int_arr2[k] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr2[sixteen_list_arr.length / 2 - k - 1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length - i - 1]);
                k++;
            }
        }
        int x1 = 0;
        int y1 = 0;
        for (String str2 : recent_list_arr) {
            boolean flag = true;
            for (int index : int_arr1) {
                if (Integer.parseInt(str2) == index) {
                    x1++;
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                continue;
            }
            for (int index : int_arr2) {
                if (Integer.parseInt(str2) == index) {
                    y1++;
                    break;
                }
            }
        }
        return "group1:" + x1 + ",group2:" + y1;
    }



    public boolean group_analy_bol(String[] sixteen_list_arr, String[] recent_list_arr) {
        int[] int_arr1 = new int[sixteen_list_arr.length / 2];
        int[] int_arr2 = new int[sixteen_list_arr.length / 2];
        //分成两组第一个与最后一个绑定。以此类推。十指相扣分开成两组。
        for (int i = 0, j = 0, k = 0; i < sixteen_list_arr.length / 2; i++) {
            if (i % 2 == 0) {
                int_arr1[j] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr1[sixteen_list_arr.length / 2 - j - 1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length - i - 1]);
                j++;
            } else {
                int_arr2[k] = Integer.parseInt(sixteen_list_arr[i]);
                int_arr2[sixteen_list_arr.length / 2 - k - 1] = Integer.parseInt(sixteen_list_arr[sixteen_list_arr.length - i - 1]);
                k++;
            }
        }
        int x1 = 0;
        int y1 = 0;
        for (String str2 : recent_list_arr) {
            boolean flag = true;
            for (int index : int_arr1) {
                if (Integer.parseInt(str2) == index) {
                    x1++;
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                continue;
            }
            for (int index : int_arr2) {
                if (Integer.parseInt(str2) == index) {
                    y1++;
                    break;
                }
            }
        }
        return x1<y1?true:false;
    }



    //分组分析
    public String group_analy(String sixteen_list, String recent_list) {
        String[] recent_list_arr = rep_space_spit(recent_list);
        String[] sixteen_list_arr = rep_space_spit(sixteen_list);
        return group_analy(sixteen_list_arr, recent_list_arr);
    }


    //平均数左右分析
    public String average_side_analy(String[] recent_list_arr) {
        int x = 0, y = 0;
        for (String str_temp : recent_list_arr) {
            if (Integer.parseInt(str_temp) > 8) {
                x++;
            } else {
                y++;
            }
        }
        return "upper:" + x + ",lower:" + y;
    }
    public Map<String,Integer> average_side_analy_map(String[] recent_list_arr) {
        Map<String,Integer> map = new HashMap<>();
        int x = 0, y = 0;
        for (String str_temp : recent_list_arr) {
            if (Integer.parseInt(str_temp) > 8) {
                x++;
            } else {
                y++;
            }
        }
        map.put("upper",x);
        map.put("lower",y);
        return map;
    }

    public int average_side_analy_bol(String[] recent_list_arr) {
        int x = 0, y = 0;
        for (String str_temp : recent_list_arr) {
            if (Integer.parseInt(str_temp) > 8) {
                x++;
            } else {
                y++;
            }
        }
        if(x<y){
            return 2;
        }else if(x>y) {
            return 1;
        }
        return 0;
//        return x>y?true:false;
    }

    public String average_side_analy(String recent_list) {
        return average_side_analy(rep_space_spit(recent_list));
    }
    public Set<Integer> get_same_num(int[] a, int[] b){
        Set<Integer> list = new HashSet<>();
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]==b[j]){
                list.add(a[i++]);
            }else if(a[i]<b[j]){
                i++;
            }else{
                j++;
            }
        }
        return list;
    }
    public int[] Integer_to_int(Integer[] a){
        int[] result = new int[a.length];
        for(int i =0;i<result.length;i++){
            result[i]=a[i];
        }
        return result;
    }
    public String[] Integer_to_String(Integer[] a){
        String[] result = new String[a.length];
        for(int i =0;i<result.length;i++){
            result[i]=String.valueOf(a[i]);
        }
        return result;
    }
    public String[] Set_to_String(Set<Integer> a){
        String[] result = new String[a.size()];
        int i=0;
        for(Integer index:a){
            result[i]=String.valueOf(index);
            i++;
        }
        return result;
    }


}
