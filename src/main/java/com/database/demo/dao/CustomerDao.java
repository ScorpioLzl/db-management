package com.database.demo.dao;

import com.database.demo.dao.provider.CustomerDynaSQLProvider;
import com.database.demo.entity.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface CustomerDao {
    @Select("select * from zl_customer")
    List<Customer> get_list();

    @SelectProvider(type= CustomerDynaSQLProvider.class,method="insert_customer")
    void insert_customer(Customer customer);

    @SelectProvider(type= CustomerDynaSQLProvider.class,method="update_customer")
    void update_customer(Customer customer);

    @Delete("delete from zl_customers where cid = #{cid}")
    int delete_customer(int cid);
}
