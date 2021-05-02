package com.database.demo.service;

import com.database.demo.dao.ReservationDao;
import com.database.demo.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

    public List<Reservation> select_reservations(){
        return reservationDao.get_list();
    }

    public int insert_reservation(Reservation reservation){
        if(reservation.getReservation_id()==null)
            return -1;
        String slot = reservation.getSlot();
        List<String> booked_slots = reservationDao.get_slot(reservation.getRoomid());
        if(booked_slots.contains(slot))
            return -1;
        reservationDao.insert_reservation(reservation);
        return 0;
    }

    public void update_reservation(Reservation reservation){
        String slot = reservation.getSlot();
        List<String> booked_slots = reservationDao.get_slot(reservation.getRoomid());
        if(booked_slots.contains(slot))
            return;
        reservationDao.update_reservation(reservation);
    }

    public int delete_reservation(int reservation_id){
        return reservationDao.delete_reservation(reservation_id);
    }
}
