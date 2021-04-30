package com.database.demo.controller;

import com.database.demo.entity.Author;
import com.database.demo.service.AuthorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping("/authors")
    public ModelAndView getAuthors(ModelAndView mv){
        List<Author> list = authorService.select_authors();
        mv.addObject("authors",list);
        return mv;
    }
    @GetMapping("/deleteAuthor/{id}")
    public ModelAndView delete_author(@PathVariable Integer id,ModelAndView mv){
        authorService.delete_author(id);
        mv.setViewName("redirect:/authors");
        return mv;
    }
    @GetMapping("/updateAuthor/{id}")
    public ModelAndView update_author(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateAuthor");
        return mv;
    }
    @RequestMapping("/updateAuthor")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateAuth")
    public ModelAndView doUpdate(ModelAndView mv,Author author){
        authorService.update_author(author);
        mv.setViewName("redirect:/authors");
        return mv;
    }

    @RequestMapping("/insertAuthor")
    public ModelAndView insert_author(ModelAndView mv,Author author){
        authorService.insert_author(author);
        mv.setViewName("redirect:/authors");
        return mv;
    }
}
