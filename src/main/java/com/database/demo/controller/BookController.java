package com.database.demo.controller;

import com.database.demo.entity.Book;
import com.database.demo.service.BookService;
import com.database.demo.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CopyService copyService;

    @RequestMapping("/books")
    public ModelAndView getBooks(ModelAndView mv){
        List<Book> list = bookService.select_books();
        for(Book b:list){
            String numOfCopy = copyService.countCopy(b.getBid());
            numOfCopy = numOfCopy == "" ? "0" : numOfCopy;
            b.setNumOfCopies(numOfCopy);
        }
        mv.addObject("books",list);
        return mv;
    }
    @GetMapping("/deleteBook/{id}")
    public ModelAndView delete_book(@PathVariable Integer id, ModelAndView mv){
        bookService.delete_book(id);
        mv.setViewName("redirect:/books");
        return mv;
    }
    @GetMapping("/updateBook/{id}")
    public ModelAndView update_book(@PathVariable String id,ModelAndView mv){
        mv.addObject("updateId",id);
        mv.setViewName("forward:/updateBook");
        return mv;
    }
    @RequestMapping("/updateBook")
    public ModelAndView updatePage(ModelAndView mv){
        return mv;
    }

    @RequestMapping("/updateBook1")
    public ModelAndView doUpdate(ModelAndView mv,Book book){
        bookService.update_book(book);
        mv.setViewName("redirect:/books");
        return mv;
    }

    @RequestMapping("/insertBook")
    public ModelAndView insert_book(ModelAndView mv,Book book){
        bookService.insert_book(book);
        mv.setViewName("redirect:/books");
        return mv;
    }
}
