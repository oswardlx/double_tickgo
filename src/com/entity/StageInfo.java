package com.entity;

import java.util.List;

public class StageInfo {
    private List<String> bigBallList;
    private String smallBall;

    public List<String> getBigBallList() {
        return bigBallList;
    }

    public void setBigBallList(List<String> bigBallList) {
        this.bigBallList = bigBallList;
    }

    public String getSmallBall() {
        return smallBall;
    }

    public void setSmallBall(String smallBall) {
        this.smallBall = smallBall;
    }

    @Override
    public String toString() {
        return "StageInfo{" +
                "bigBallList=" + bigBallList +
                ", smallBall=" + smallBall +
                '}';
    }
}
