package com.database.demo.service;

import com.database.demo.dao.AuthorDao;
import com.database.demo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;

    public List<Author> select_authors(){
        return authorDao.get_list();
    }

    public int insert_author(Author author){
        if(author.getAid()==null)
            return -1;
        authorDao.insert_author(author);
        return 0;
    }

    public void update_author(Author author){
        authorDao.update_author(author);
    }

    public int delete_author(int aid){
        return authorDao.delete_author(aid);
    }
}
