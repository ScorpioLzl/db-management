package com.database.demo.controller;

import com.database.demo.entity.Customer;
import com.database.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    public ModelAndView getCustomers(ModelAndView mv){
        List<Customer> list = customerService.select_customers();
        mv.addObject("customers",list);
        return mv;
    }
    @GetMapping("/deleteCustomer/{id}")
    public ModelAndView delete_customer(@PathVariable Integer id, ModelAndView mv){
        customerService.delete_customer(id);
        mv.setViewName("redirect:/customers");
        return mv;
    }
    @GetMapping("/updateCustomer/{id}")
    public ModelAndView update_customer(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateCustomer");
        return mv;
    }
    @RequestMapping("/updateCustomer")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateCustomer1")
    public ModelAndView doUpdate(ModelAndView mv,Customer customer){
        customerService.update_customer(customer);
        mv.setViewName("redirect:/customers");
        return mv;
    }

    @RequestMapping("/insertCustomer")
    public ModelAndView insert_customer(ModelAndView mv,Customer customer){
        customerService.insert_customer(customer);
        mv.setViewName("redirect:/customers");
        return mv;
    }
}
