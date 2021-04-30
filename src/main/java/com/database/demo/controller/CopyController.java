package com.database.demo.controller;

import com.database.demo.entity.Copy;
import com.database.demo.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CopyController {
    @Autowired
    CopyService copyService;

    @RequestMapping("/copies")
    public ModelAndView getCopys(ModelAndView mv){
        List<Copy> list = copyService.select_copies();
        mv.addObject("copies",list);
        return mv;
    }
    @GetMapping("/deleteCopy/{id}")
    public ModelAndView delete_copy(@PathVariable Integer id, ModelAndView mv){
        copyService.delete_copy(id);
        mv.setViewName("redirect:/copies");
        return mv;
    }
    @GetMapping("/updateCopy/{id}")
    public ModelAndView update_copy(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateCopy");
        return mv;
    }
    @RequestMapping("/updateCopy")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateCopy1")
    public ModelAndView doUpdate(ModelAndView mv,Copy copy){
        copyService.update_copy(copy);
        mv.setViewName("redirect:/copies");
        return mv;
    }

    @RequestMapping("/insertCopy")
    public ModelAndView insert_copy(ModelAndView mv,Copy copy){
        copyService.insert_copy(copy);
        mv.setViewName("redirect:/copies");
        return mv;
    }
}
