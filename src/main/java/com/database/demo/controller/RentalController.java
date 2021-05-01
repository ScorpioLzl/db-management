package com.database.demo.controller;

import com.database.demo.entity.Rental;
import com.database.demo.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;

    @RequestMapping("/rentals")
    public ModelAndView getRentals(ModelAndView mv){
        List<Rental> list = rentalService.select_rentals();
        mv.addObject("rentals",list);
        return mv;
    }
    @GetMapping("/deleteRental/{id}")
    public ModelAndView delete_rental(@PathVariable Integer id, ModelAndView mv){
        rentalService.delete_rental(id);
        mv.setViewName("redirect:/rentals");
        return mv;
    }
    @GetMapping("/updateRental/{id}")
    public ModelAndView update_rental(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateRental");
        return mv;
    }
    @RequestMapping("/updateRental")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateRental1")
    public ModelAndView doUpdate(ModelAndView mv,Rental rental){
        rentalService.update_rental(rental);
        mv.setViewName("redirect:/rentals");
        return mv;
    }

    @RequestMapping("/insertRental")
    public ModelAndView insert_rental(ModelAndView mv,Rental rental){
        rentalService.insert_rental(rental);
        mv.setViewName("redirect:/rentals");
        return mv;
    }
}
