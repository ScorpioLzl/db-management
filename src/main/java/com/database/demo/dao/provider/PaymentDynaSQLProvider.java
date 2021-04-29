package com.database.demo.dao.provider;

import com.database.demo.entity.Event;
import com.database.demo.entity.Payment;
import org.apache.ibatis.jdbc.SQL;

public class PaymentDynaSQLProvider {
    public String insert_payment(Payment payment){
        return new SQL(){
            {
                INSERT_INTO("zl_payment");
                if(payment.getPid()!=""){
                    VALUES("pid","#{pid}");
                }
                if(payment.getHolder_fname()!="") {
                    VALUES("holder_fname", "#{holder_fname}");
                }
                if(payment.getHolder_lname()!=""){
                    VALUES("holder_lname","#{holder_lname}");
                }
                if(payment.getMethod()!=""){
                    VALUES("method","#{method}");
                }
                if(payment.getPdate()!=""){
                    VALUES("pdate","#{pdate}");
                }
                if(payment.getPamount()!= -1){
                    VALUES("pamount","#{pamount}");
                }
                if(payment.getCid()!=""){
                    VALUES("cid","#{cid}");
                }
                if(payment.getIid()!=""){
                    VALUES("iid","#{iid}");
                }
            }
        }.toString();
    }
    public String update_payment(Payment payment){
        return new SQL(){
            {
                UPDATE("zl_payment");
                if(payment.getHolder_fname()!=""){
                    SET("holder_fname = #{holder_fname}");
                }
                if(payment.getHolder_lname()!=""){
                    SET("holder_lname = #{holder_lname}");
                }
                if(payment.getMethod()!=""){
                    SET("method = #{method}");
                }
                if(payment.getPamount()!= -1){
                    SET("pamount = #{pamount}");
                }
                if(payment.getPdate()!=""){
                    SET("pdate = #{pdate}");
                }
                if(payment.getCid()!=""){
                    SET("cid = #{cid}");
                }
                if(payment.getIid()!=""){
                    SET("iid = #{iid}");
                }
                WHERE("pid = #{pid}");
            }
        }.toString();
    }
}
