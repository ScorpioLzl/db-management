package com.database.demo.dao;

import com.database.demo.dao.provider.RoomDynaSQLProvider;
import com.database.demo.entity.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface RoomDao {
    @Select("select * from zl_room")
    List<Room> get_list();

    @SelectProvider(type= RoomDynaSQLProvider.class,method="insert_room")
    void insert_room(Room room);

    @SelectProvider(type= RoomDynaSQLProvider.class,method="update_room")
    void update_room(Room room);

    @Delete("delete from zl_rooms where roomid = #{roomid}")
    int delete_room(int roomid);
}
