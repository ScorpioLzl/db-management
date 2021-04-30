package com.database.demo.service;

import com.database.demo.dao.CustomerDao;
import com.database.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> select_customers(){
        return customerDao.get_list();
    }

    public int insert_customer(Customer customer){
        if(customer.getCid()==null)
            return -1;
        customerDao.insert_customer(customer);
        return 0;
    }

    public void update_customer(Customer customer){
        customerDao.update_customer(customer);
    }

    public int delete_customer(int cid){
        return customerDao.delete_customer(cid);
    }
}
