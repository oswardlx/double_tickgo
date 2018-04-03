package com.test;

import com.service.SmallBallAnalyService;

public class demo2 {
    public static void main(String[] args){
        SmallBallAnalyService smallBallAnalyService = new SmallBallAnalyService(64);
        smallBallAnalyService.get_smallball_list();
    }
}
