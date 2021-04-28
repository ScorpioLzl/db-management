package com.database.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into zl_user(username,password,role)values(#{username},#{password},#{role})")
    public int signUp(String username,String password,String role);

    @Select("select password from zl_user where username = #{username}")
    public String getPassword(String username);

    @Select("select role from zl_user where username = #{username}")
    public String getRole(String username);
}
