package com.dao;

import com.entity.StageInfo;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

import java.util.ArrayList;
import java.util.List;

public class TicketDao extends Model<TicketDao> {
    public static final TicketDao dao = new TicketDao();
    public void saveTicketDao(List<StageInfo> list) {
        if (list.size() > 0) {
            try {
                int index;
                String appendsql = "";
                String singleParam = "";
                List<String> paramList = new ArrayList<>();
                for (index = 0; index < list.size(); index++) {
                    singleParam = "(" + listToString(list.get(index).getBigBallList(), ',') +","+ list.get(index).getSmallBall() + ")";
                    paramList.add(singleParam);
                }
                if(paramList.size()<0){
                    throw new RuntimeException("paramlist为空");
                }
                appendsql = listToString(paramList, ',');
                String sql = "INSERT INTO tickes_base (bigball1,bigball2,bigball3,bigball4,bigball5,bigball6,smallball,year_month_id) VALUES " + appendsql;
//                TicketDao.dao.find(sql);
                Db.update(sql);
            } catch (Throwable t) {
                t.printStackTrace();
                throw new RuntimeException("数据库操作失败");
            }
        }else{
            throw new RuntimeException("list为空");
        }
    }

    private String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i))).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() -1);
    }

}

