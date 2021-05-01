package com.database.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/index_c")
    public String index_c(Model model){
        return "index_c";
    }

    @RequestMapping(value = "/index_a")
    public String index_a(Model model){
        return "index_a";
    }
}
