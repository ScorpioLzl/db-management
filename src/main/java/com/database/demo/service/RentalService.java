package com.database.demo.service;

import com.database.demo.dao.RentalDao;
import com.database.demo.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalDao rentalDao;

    public List<Rental> select_rentals(){
        return rentalDao.get_list();
    }

    public int insert_rental(Rental rental){
        if(rental.getRid()==null)
            return -1;
        rentalDao.insert_rental(rental);
        return 0;
    }

    public void update_rental(Rental rental){
        rentalDao.update_rental(rental);
    }

    public int delete_rental(int rid){
        return rentalDao.delete_rental(rid);
    }
}
