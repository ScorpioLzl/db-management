package com.database.demo.controller;

import com.database.demo.entity.Sponsor;
import com.database.demo.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SponsorController {
    @Autowired
    SponsorService sponsorService;

    @RequestMapping("/sponsors")
    public ModelAndView getSponsors(ModelAndView mv){
        List<Sponsor> list = sponsorService.select_sponsors();
        mv.addObject("sponsors",list);
        return mv;
    }
    @GetMapping("/deleteSponsor/{id}")
    public ModelAndView delete_sponsor(@PathVariable Integer id, ModelAndView mv){
        sponsorService.delete_sponsor(id);
        mv.setViewName("redirect:/sponsors");
        return mv;
    }
    @GetMapping("/updateSponsor/{id}")
    public ModelAndView update_sponsor(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateSponsor");
        return mv;
    }
    @RequestMapping("/updateSponsor")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateSponsor1")
    public ModelAndView doUpdate(ModelAndView mv,Sponsor sponsor){
        sponsorService.update_sponsor(sponsor);
        mv.setViewName("redirect:/sponsors");
        return mv;
    }

    @RequestMapping("/insertSponsor")
    public ModelAndView insert_sponsor(ModelAndView mv,Sponsor sponsor){
        sponsorService.insert_sponsor(sponsor);
        mv.setViewName("redirect:/sponsors");
        return mv;
    }
}
