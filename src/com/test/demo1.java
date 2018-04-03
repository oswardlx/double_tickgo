package com.test;

import com.util.SmallBallAly;

public class demo1 {
    public static void main(String[] args){
        SmallBallAly sba = new SmallBallAly();
        String sixteen = "15\n" +
                "13\n" +
                "8\n" +
                "10\n" +
                "1\n" +
                "11\n" +
                "3\n" +
                "9\n" +
                "2\n" +
                "6\n" +
                "4\n" +
                "14\n" +
                "5\n" +
                "12\n" +
                "7\n" +
                "16";
        String recent  ="6\n" +
                "6\n" +
                "14\n" +
                "7\n" +
                "5\n" +
                "16\n" +
                "5\n" +
                "4\n" +
                "14\n" +
                "2\n" +
                "16\n" +
                "3\n" +
                "14\n" +
                "5\n" +
                "9\n" +
                "7\n" +
                "12\n" +
                "16\n" +
                "15\n" +
                "7\n" +
                "6\n" +
                "12\n" +
                "11\n" +
                "3\n" +
                "7\n" +
                "13\n" +
                "12\n" +
                "11\n" +
                "6\n" +
                "11\n" +
                "4\n" +
                "16\n" +
                "4\n" +
                "5\n" +
                "16\n" +
                "5\n" +
                "16\n" +
                "8\n" +
                "13\n" +
                "12\n" +
                "14\n" +
                "10\n" +
                "12\n" +
                "9\n" +
                "14\n" +
                "6\n" +
                "5\n" +
                "8\n";

        System.out.println(sba.parity_analy(recent));
        System.out.println(sba.group_analy(sba.rep_space_spit(sixteen),sba.rep_space_spit(recent)));
        System.out.println(sba.average_side_analy(recent));

    }
}
