package com.database.demo.dao;

import com.database.demo.dao.provider.PaymentDynaSQLProvider;
import com.database.demo.entity.Payment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface PaymentDao {
    @Select("select * from zl_payment")
    List<Payment> get_list();

    @SelectProvider(type= PaymentDynaSQLProvider.class,method="insert_payment")
    void insert_payment(Payment payment);

    @SelectProvider(type= PaymentDynaSQLProvider.class,method="update_payment")
    void update_payment(Payment payment);

    @Delete("delete from zl_payments where pid = #{pid}")
    int delete_payment(int pid);
}
