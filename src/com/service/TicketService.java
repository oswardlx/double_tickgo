package com.service;

import com.dao.TicketDao;
import com.entity.StageInfo;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private  int  PAGESIZE = 200;
    public boolean saveTicketList(ArrayList<StageInfo> ticketList){
        int listSize = ticketList.size();
        saveTicketListByPage(ticketList);
        return false;
    }
    private void saveTicketListByPage(ArrayList<StageInfo> list) {
        //分页处理
        try {
            int tempindex2;
            TicketDao td = new TicketDao();
            if (list != null) {
                for (int tempindex = 0; tempindex < list.size(); tempindex += PAGESIZE) {
                    tempindex2 = tempindex + PAGESIZE;
                    if (tempindex2 >= list.size()) {
                        tempindex2 = list.size();
                    }
                    List<StageInfo> listtemp = list.subList(tempindex, tempindex2);
                    td.saveTicketDao(listtemp);
                }
            }
        }catch (Throwable t1){
            t1.printStackTrace();
            throw new RuntimeException("数据保存失败，"+t1.getMessage());

        }
    }
}
