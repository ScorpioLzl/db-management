package com.database.demo.dao.provider;

import com.database.demo.entity.Author;
import com.database.demo.entity.Book;
import org.apache.ibatis.jdbc.SQL;

public class BookDynaSQLProvider {
    public String insert_book(Book book){
        return new SQL(){
            {
                INSERT_INTO("zl_books");
                if(book.getBid()!=""){
                    VALUES("bid","#{bid}");
                }
                if(book.getBname()!="") {
                    VALUES("bname", "#{bname}");
                }
                if(book.getTopic()!=""){
                    VALUES("topic","#{topic}");
                }

            }
        }.toString();
    }

    public String update_book(Book book){
        return new SQL(){
            {
                UPDATE("zl_books");
                if(book.getBname()!=""){
                    SET("bname = #{bname}");
                }
                if(book.getTopic()!=""){
                    SET("topic = #{topic}");
                }
                WHERE("bid = #{bid}");
            }
        }.toString();
    }
}
