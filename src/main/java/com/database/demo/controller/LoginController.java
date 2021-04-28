package com.database.demo.controller;

import com.database.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginservice;

    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("username")String username,
                        @RequestParam("password")String password, HttpSession session, ModelAndView mv){
        String logresult = loginservice.signIn(username, password);
        if(logresult.equals("invalid username")||logresult.equals("wrong password")){
            mv.addObject("message",logresult);
            mv.setViewName("forward:/hello");
        }else{
            session.setAttribute("userSession",username);
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/signup")
    public ModelAndView signup(@RequestParam("username")String username,
                         @RequestParam("password")String password,
                         @RequestParam("role")String role,ModelAndView mv){
        if(loginservice.signUp(username, password, role)>=0){
            mv.addObject("message","signup success");
        }else{
            mv.addObject("message","signup failed");
        }
        mv.setViewName("redirect:/hello");
        return mv;
    }

}
