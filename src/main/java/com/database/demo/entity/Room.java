package com.database.demo.entity;

import java.io.Serializable;

public class Room implements Serializable {
    private String roomid;
    private String capacity;

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
