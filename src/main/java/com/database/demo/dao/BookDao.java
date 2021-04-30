package com.database.demo.dao;

import com.database.demo.dao.provider.BookDynaSQLProvider;
import com.database.demo.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from zl_books")
    List<Book> get_list();

    @SelectProvider(type= BookDynaSQLProvider.class,method="insert_book")
    void insert_book(Book book);

    @SelectProvider(type= BookDynaSQLProvider.class,method="update_book")
    void update_book(Book book);

    @Delete("delete from zl_books where bid = #{bid}")
    int delete_book(int bid);
}
