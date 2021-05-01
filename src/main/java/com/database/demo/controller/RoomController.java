package com.database.demo.controller;

import com.database.demo.entity.Room;
import com.database.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping("/rooms")
    public ModelAndView getRooms(ModelAndView mv){
        List<Room> list = roomService.select_rooms();
        mv.addObject("rooms",list);
        return mv;
    }
    @GetMapping("/deleteRoom/{id}")
    public ModelAndView delete_room(@PathVariable Integer id, ModelAndView mv){
        roomService.delete_room(id);
        mv.setViewName("redirect:/rooms");
        return mv;
    }
    @GetMapping("/updateRoom/{id}")
    public ModelAndView update_room(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateRoom");
        return mv;
    }
    @RequestMapping("/updateRoom")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateRoom1")
    public ModelAndView doUpdate(ModelAndView mv,Room room){
        roomService.update_room(room);
        mv.setViewName("redirect:/rooms");
        return mv;
    }

    @RequestMapping("/insertRoom")
    public ModelAndView insert_room(ModelAndView mv,Room room){
        roomService.insert_room(room);
        mv.setViewName("redirect:/rooms");
        return mv;
    }
}
