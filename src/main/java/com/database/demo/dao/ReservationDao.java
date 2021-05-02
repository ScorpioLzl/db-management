package com.database.demo.dao;

import com.database.demo.dao.provider.ReservationDynaSQLProvider;
import com.database.demo.entity.Reservation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ReservationDao {
    @Select("select * from reservation")
    List<Reservation> get_list();

    @Select("select slot from reservation where roomid = #{roomid}")
    List<String> get_slot(String roomid);

    @SelectProvider(type= ReservationDynaSQLProvider.class,method="insert_reservation")
    void insert_reservation(Reservation reservation);

    @SelectProvider(type= ReservationDynaSQLProvider.class,method="update_reservation")
    void update_reservation(Reservation reservation);

    @Delete("delete from reservation where reservation_id = #{reservation_id}")
    int delete_reservation(int reservation_id);
}
