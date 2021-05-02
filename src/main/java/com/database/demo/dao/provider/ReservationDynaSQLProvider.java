package com.database.demo.dao.provider;

import com.database.demo.entity.Reservation;
import org.apache.ibatis.jdbc.SQL;

public class ReservationDynaSQLProvider {
    public String insert_reservation(Reservation reservation){
        return new SQL(){
            {
                INSERT_INTO("reservation");
                if(reservation.getReservation_id()!=""){
                    VALUES("reservation_id","#{reservation_id}");
                }
                if(reservation.getSlot()!="") {
                    VALUES("slot", "#{slot}");
                }
                if(reservation.getCid()!=""){
                    VALUES("cid","#{cid}");
                }
                if(reservation.getRoomid()!=""){
                    VALUES("roomid","#{roomid}");
                }
            }
        }.toString();
    }
    public String update_reservation(Reservation reservation){
        return new SQL(){
            {
                UPDATE("reservation");
                if(reservation.getSlot()!=""){
                    SET("slot = #{slot}");
                }
                if(reservation.getRoomid()!=""){
                    SET("roomid = #{roomid}");
                }
                if(reservation.getCid()!=""){
                    SET("cid = #{cid}");
                }
                WHERE("reservation_id = #{reservation_id}");
            }
        }.toString();
    }
}
