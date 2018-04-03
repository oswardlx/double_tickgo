package com.entity;

import com.jfinal.plugin.activerecord.Model;

public class SmallBallSort  extends Model{
    private int ranking;
    private int num;

    public SmallBallSort() {
    }

    public SmallBallSort(int ranking, int num) {
        this.ranking = ranking;
        this.num = num;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SmallBallSort{" +
                "ranking=" + ranking +
                ", num=" + num +
                '}';
    }
}
