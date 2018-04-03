package com.demo;


import com.controller.GetBallListController;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.controller.SmallBallAnalyController;

import java.io.InputStream;

public class DemoConfig extends JFinalConfig {
    private Log4jLogFactory log4jLogFactory = new Log4jLogFactory();
    private  Log log = log4jLogFactory.getLog(DemoConfig.class);
    public void configConstant(Constants me) {
        try {
            me.setDevMode(true);
//            String path = this.getClass().getResourceAsStream("/jdbc.properties");
//            loadPropertyFile("/classes/jdbc.properties");
            PropKit.use("jdbc.properties");
//            me.setDevMode(getPropertyToBoolean("devMode", false).booleanValue());
//            me.setMaxPostSize(1024*1024*1024);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("加载常量（configConstant）出错，请解决问题后重新启动tomcat！！！");
        }
    }
    public void configRoute(Routes me) {
        log.debug("1312312");
        me.add("/hello",HelloController.class);
        me.add("/demo",Demo.class);
        me.add("/getlist",GetList.class);
        me.add("/add_a_tick",AddATick.class);
        me.add("/get_smallball_analy",SmallBallAnalyController.class);
        me.add("/get_ball_list",GetBallListController.class);
    }


    public void configEngine(Engine me) {

    }


    public void configPlugin(Plugins me) {
        DruidPlugin druidPlugin = new DruidPlugin("jdbc:mysql://10.10.6.133:3306/tickes","root","123456");
        me.add(druidPlugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        me.add(arp);
        arp.addMapping("tickes_base","id",Tickes.class);
    }


    public void configInterceptor(Interceptors me) {

    }


    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler());
    }

    public static void main(String[] args) {
        InputStream resourceAsStream = DemoConfig.class.getResourceAsStream("/jdbc.properties");

        System.out.println(resourceAsStream);
    }
}
