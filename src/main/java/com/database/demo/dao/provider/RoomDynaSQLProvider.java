package com.database.demo.dao.provider;

import com.database.demo.entity.Copy;
import com.database.demo.entity.Room;
import org.apache.ibatis.jdbc.SQL;

public class RoomDynaSQLProvider {
    public String insert_room(Room room){
        return new SQL(){
            {
                INSERT_INTO("zl_room");
                if(room.getRoomid()!=""){
                    VALUES("roomid","#{roomid}");
                }
                if(room.getCapacity()!="") {
                    VALUES("capacity", "#{capacity}");
                }
            }
        }.toString();
    }
    public String update_room(Room room){
        return new SQL(){
            {
                UPDATE("zl_room");
                if(room.getCapacity()!=""){
                    SET("capacity = #{capacity}");
                }
                WHERE("roomid = #{roomid}");
            }
        }.toString();
    }
}
