package com.database.demo.dao;

import com.database.demo.dao.provider.EventDynaSQLProvider;
import com.database.demo.entity.Event;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface EventDao {
    @Select("select * from zl_event")
    List<Event> get_list();

    @SelectProvider(type= EventDynaSQLProvider.class,method="insert_event")
    void insert_event(Event event);

    @SelectProvider(type= EventDynaSQLProvider.class,method="update_event")
    void update_event(Event event);

    @Delete("delete from zl_event where eid = #{eid}")
    int delete_event(int eid);
}
