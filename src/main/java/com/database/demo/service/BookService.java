package com.database.demo.service;

import com.database.demo.dao.BookDao;
import com.database.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> select_books(){
        return bookDao.get_list();
    }

    public int insert_book(Book book){
        if(book.getBid()==null)
            return -1;
        bookDao.insert_book(book);
        return 0;
    }

    public void update_book(Book book){
        bookDao.update_book(book);
    }

    public int delete_book(int aid){
        return bookDao.delete_book(aid);
    }
}
