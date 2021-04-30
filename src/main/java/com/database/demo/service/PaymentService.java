package com.database.demo.service;

import com.database.demo.dao.PaymentDao;
import com.database.demo.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentDao paymentDao;

    public List<Payment> select_payments(){
        return paymentDao.get_list();
    }

    public int insert_payment(Payment payment){
        if(payment.getPid()==null)
            return -1;
        paymentDao.insert_payment(payment);
        return 0;
    }

    public void update_payment(Payment payment){
        paymentDao.update_payment(payment);
    }

    public int delete_payment(int pid){
        return paymentDao.delete_payment(pid);
    }
}
