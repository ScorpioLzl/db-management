package com.database.demo.service;

import com.database.demo.dao.RoomDao;
import com.database.demo.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomDao roomDao;

    public List<Room> select_rooms(){
        return roomDao.get_list();
    }

    public int insert_room(Room room){
        if(room.getRoomid()==null)
            return -1;
        roomDao.insert_room(room);
        return 0;
    }

    public void update_room(Room room){
        roomDao.update_room(room);
    }

    public int delete_room(int roomid){
        return roomDao.delete_room(roomid);
    }
}
