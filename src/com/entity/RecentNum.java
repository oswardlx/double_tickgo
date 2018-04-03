package com.entity;

public class RecentNum {
    private int recent_num;

    public RecentNum() {
    }

    public int getRecent_num() {
        return recent_num;
    }

    public void setRecent_num(int recent_num) {
        this.recent_num = recent_num;
    }

    @Override
    public String toString() {
        return "RecentNum{" +
                "recent_num=" + recent_num +
                '}';
    }

    public RecentNum(int recent_num) {
        this.recent_num = recent_num;
    }
}
