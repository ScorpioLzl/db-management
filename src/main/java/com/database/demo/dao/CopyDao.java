package com.database.demo.dao;

import com.database.demo.dao.provider.CopyDynaSQLProvider;
import com.database.demo.entity.Copy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CopyDao {
    @Select("select * from zl_copies")
    List<Copy> get_list();

    @SelectProvider(type= CopyDynaSQLProvider.class,method="insert_copy")
    void insert_copy(Copy copy);

    @SelectProvider(type= CopyDynaSQLProvider.class,method="update_copy")
    void update_copy(Copy copy);

    @Delete("delete from zl_copies where copyid = #{copyid}")
    int delete_copy(int copyid);
}
