package com.demo;

import com.jfinal.core.Controller;

import java.util.List;

public class GetList extends Controller {
    public void index(){
        getList();
    }
    public void getList(){
        List<Tickes> tickes = Tickes.dao.find("Select * from tickes_base");
        renderJson(tickes);
    }
}
