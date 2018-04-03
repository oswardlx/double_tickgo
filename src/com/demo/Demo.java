package com.demo;

import com.jfinal.core.Controller;

public class Demo extends Controller {
    public void index(){
        renderText("Hello JFinal World");
    }
}
