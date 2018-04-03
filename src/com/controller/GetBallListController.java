package com.controller;

import com.jfinal.core.Controller;
import com.service.SmallBallAnalyService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetBallListController extends Controller {
    public void index() {
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
        int x = 0;
        Map<String, Object> map = new HashMap<>();
        for (String str : sbas.get_smallball_list()) {
            map.put(x + "", str);
            x++;
        }
        System.out.println("result:1111");
        Set<Map.Entry<String,Integer>> entrySet = get_result().entrySet();
        for ( Map.Entry<String,Integer> e : entrySet) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
        System.out.println("result:2222");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("list", map);
        map2.put("success", true);
        renderJson(map2);
    }

    private static Map<String,Integer> get_result() throws RuntimeException {
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0,a5=0;
        Map<String,Integer> map_resutl = new HashMap<>();

        for (int i = 2; i <= 300; i++) {
            SmallBallAnalyService sbas = new SmallBallAnalyService(i);
            System.out.println("["+i+"]"+sbas.get_smallball_list()[0]);
            if(sbas.get_smallball_list()[0].equals("1")){
                a1++;
            }else if(sbas.get_smallball_list()[0].equals("2")){
                a2++;
            }else if(sbas.get_smallball_list()[0].equals("9")){
                a3++;
            }else if(sbas.get_smallball_list()[0].equals("16")){
                a4++;
            }else if(sbas.get_smallball_list()[0].equals("-1")){
                a5++;
            }
        }
        map_resutl.put("a1",a1);
        map_resutl.put("a2",a2);
        map_resutl.put("a3",a3);
        map_resutl.put("a4",a4);
        map_resutl.put("a5",a5);
        return map_resutl;
    }
}
