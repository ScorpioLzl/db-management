package com.database.demo.controller;

import com.database.demo.entity.Event;
import com.database.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping("/events")
    public ModelAndView getEvents(ModelAndView mv){
        List<Event> list = eventService.select_events();
        mv.addObject("events",list);
        return mv;
    }
    @GetMapping("/deleteEvent/{id}")
    public ModelAndView delete_event(@PathVariable Integer id, ModelAndView mv){
        eventService.delete_event(id);
        mv.setViewName("redirect:/events");
        return mv;
    }
    @GetMapping("/updateEvent/{id}")
    public ModelAndView update_event(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateEvent");
        return mv;
    }
    @RequestMapping("/updateEvent")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateEvent1")
    public ModelAndView doUpdate(ModelAndView mv,Event event){
        eventService.update_event(event);
        mv.setViewName("redirect:/events");
        return mv;
    }

    @RequestMapping("/insertEvent")
    public ModelAndView insert_event(ModelAndView mv,Event event){
        eventService.insert_event(event);
        mv.setViewName("redirect:/events");
        return mv;
    }
}
