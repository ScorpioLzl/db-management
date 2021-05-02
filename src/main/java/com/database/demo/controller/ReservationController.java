package com.database.demo.controller;

import com.database.demo.entity.Reservation;
import com.database.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/reservations")
    public ModelAndView getReservations(ModelAndView mv){
        List<Reservation> list = reservationService.select_reservations();
        mv.addObject("reservations",list);
        return mv;
    }
    @GetMapping("/deleteReservation/{id}")
    public ModelAndView delete_reservation(@PathVariable Integer id, ModelAndView mv){
        reservationService.delete_reservation(id);
        mv.setViewName("redirect:/reservations");
        return mv;
    }
    @GetMapping("/updateReservation/{id}")
    public ModelAndView update_reservation(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateReservation");
        return mv;
    }
    @RequestMapping("/updateReservation")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateReservation1")
    public ModelAndView doUpdate(ModelAndView mv,Reservation reservation){
        reservationService.update_reservation(reservation);
        mv.setViewName("redirect:/reservations");
        return mv;
    }

    @RequestMapping("/insertReservation")
    public ModelAndView insert_reservation(ModelAndView mv,Reservation reservation){
        int result = reservationService.insert_reservation(reservation);
        if(result<0){
            mv.addObject("message","insert failed");
        }
        mv.setViewName("redirect:/reservations");
        return mv;
    }
}
