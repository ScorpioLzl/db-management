package com.database.demo.dao.provider;

import com.database.demo.entity.Author;
import org.apache.ibatis.jdbc.SQL;

public class AuthorDynaSQLProvider {
    public String insert_author(Author author){
       return new SQL(){
           {
               INSERT_INTO("zl_authors");
                if(author.getAid()!=""){
                    VALUES("aid","#{aid}");
                }
                if(author.getEid()!="") {
                    VALUES("eid", "#{eid}");
                }
                if(author.getA_email()!=""){
                    VALUES("a_email","#{a_email}");
                }
                if(author.getAfname()!=""){
                    VALUES("afname","#{afname}");
                }
                if(author.getAlname()!=""){
                    VALUES("alname","#{alname}");
                }
                if(author.getCity()!=""){
                    VALUES("city","#{city}");
                }
                if(author.getSt_addr()!=""){
                    VALUES("st_addr","#{st_addr}");
                }
                if(author.getState()!=""){
                    VALUES("state","#{state}");
                }
                if(author.getZipcode()!=""){
                    VALUES("zipcode","#{zipcode}");
                }
           }
       }.toString();
    }

    public String update_author(Author author){
        return new SQL(){
            {
                UPDATE("zl_authors");
                if(author.getEid()!=""){
                   SET("eid=#{eid}");
                }
                if(author.getA_email()!=""){
                    SET("a_email = #{a_email}");
                }
                if(author.getAfname()!=""){
                    SET("afname = #{afname}");
                }
                if(author.getAlname()!=""){
                    SET("alname = #{alname}");
                }
                if(author.getCity()!=""){
                    SET("city = #{city}");
                }
                if(author.getSt_addr()!=""){
                    SET("st_addr = #{st_addr}");
                }
                if(author.getState()!=""){
                    SET("state = #{state}");
                }
                if(author.getZipcode()!=""){
                    SET("zipcode = #{zipcode}");
                }
                WHERE("aid = #{aid}");
            }
        }.toString();
    }
}
