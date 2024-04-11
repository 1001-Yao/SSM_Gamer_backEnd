package com.ygq.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class T1 {
    @RequestMapping("/hi")
    public String t1(){
        System.out.println("controller===h1()-----");
        return "hi";
    }

}
