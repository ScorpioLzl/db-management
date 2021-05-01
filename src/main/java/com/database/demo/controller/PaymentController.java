package com.database.demo.controller;

import com.database.demo.entity.Payment;
import com.database.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping("/payments")
    public ModelAndView getPayments(ModelAndView mv){
        List<Payment> list = paymentService.select_payments();
        mv.addObject("payments",list);
        return mv;
    }
    @GetMapping("/deletePayment/{id}")
    public ModelAndView delete_payment(@PathVariable Integer id, ModelAndView mv){
        paymentService.delete_payment(id);
        mv.setViewName("redirect:/payments");
        return mv;
    }
    @GetMapping("/updatePayment/{id}")
    public ModelAndView update_payment(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updatePayment");
        return mv;
    }
    @RequestMapping("/updatePayment")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updatePayment1")
    public ModelAndView doUpdate(ModelAndView mv,Payment payment){
        paymentService.update_payment(payment);
        mv.setViewName("redirect:/payments");
        return mv;
    }

    @RequestMapping("/insertPayment")
    public ModelAndView insert_payment(ModelAndView mv,Payment payment){
        paymentService.insert_payment(payment);
        mv.setViewName("redirect:/payments");
        return mv;
    }
}
