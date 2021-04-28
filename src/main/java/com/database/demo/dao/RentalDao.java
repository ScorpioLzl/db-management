package com.database.demo.dao;

import com.database.demo.dao.provider.RentalDynaSQLProvider;
import com.database.demo.entity.Rental;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface RentalDao {
    @Select("select * from zl_rental")
    List<Rental> get_list();

    @SelectProvider(type= RentalDynaSQLProvider.class,method="insert_rental")
    void insert_rental(Rental rental);

    @SelectProvider(type= RentalDynaSQLProvider.class,method="update_rental")
    void update_rental(Rental rental);

    @Delete("delete from zl_rentals where rid = #{rid}")
    int delete_rental(int rid);
}
