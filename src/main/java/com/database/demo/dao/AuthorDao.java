package com.database.demo.dao;

import com.database.demo.dao.provider.AuthorDynaSQLProvider;
import com.database.demo.entity.Author;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface AuthorDao {
    @Select("select * from zl_authors")
    List<Author> get_list();

    @SelectProvider(type= AuthorDynaSQLProvider.class,method="insert_author")
    void insert_author(Author author);

    @SelectProvider(type= AuthorDynaSQLProvider.class,method="update_author")
    void update_author(Author author);

    @Delete("delete from zl_authors where aid = #{aid}")
    int delete_author(int aid);
}
