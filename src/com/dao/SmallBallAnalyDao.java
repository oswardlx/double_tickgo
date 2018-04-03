package com.dao;

import com.entity.RecentNum;
import com.entity.SmallBallSort;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

public class SmallBallAnalyDao {
    public List<SmallBallSort> get_sixteen() {
        String sql = "SELECT\n" +
                "\tCOUNT(smallball) a,\n" +
                "\tsmallball\n" +
                "FROM\n" +
                "\ttickes_base\n" +
                "-- where year_month_id<2018029\n" +
                "GROUP BY\n" +
                "\tsmallball\n" +
                "ORDER BY\n" +
                "\ta;";
        List<Record> sixteen_list = Db.find(sql);
        List<SmallBallSort> sbs_list = new ArrayList<>();
        for (Record re : sixteen_list) {
            SmallBallSort sbs = new SmallBallSort();
            sbs.setRanking(re.getInt("a"));
            sbs.setNum(re.getInt("smallball"));
            sbs_list.add(sbs);
        }
        return sbs_list;
    }

    public List<RecentNum> get_recent_num(int mount) {
        String sql = "SELECT\n" +
                "\t@rownum:=@rownum+1 AS rownum,\n" +
                "\tt.smallball,t.year_month_id\n" +
                "FROM\n" +
                "(SELECT @rownum:=0) r,\n" +
                "\ttickes_base t\n" +
                "-- where year_month_id<2018029\n" +
                "ORDER BY year_month_id desc\n" +
                "LIMIT "+mount+"; ";
        List<Record> recent_list = Db.find(sql);
        List<RecentNum> rn_list = new ArrayList<>();
        for (Record re : recent_list) {
            RecentNum rn = new RecentNum();
            rn.setRecent_num(re.getInt("smallball"));
            rn_list.add(rn);
        }
        return rn_list;
    }
}
