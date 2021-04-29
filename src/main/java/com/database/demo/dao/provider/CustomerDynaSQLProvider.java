package com.database.demo.dao.provider;

import com.database.demo.entity.Customer;
import org.apache.ibatis.jdbc.SQL;

public class CustomerDynaSQLProvider {
    public String insert_customer(Customer customer){
        return new SQL(){
            {
                INSERT_INTO("zl_customer");
                if(customer.getCid()!=""){
                    VALUES("cid","#{cid}");
                }
                if(customer.getEid()!="") {
                    VALUES("eid", "#{eid}");
                }
                if(customer.getFname()!=""){
                    VALUES("fname","#{fname}");
                }
                if(customer.getLname()!=""){
                    VALUES("lname","#{lname}");
                }
                if(customer.getPhone()!=""){
                    VALUES("phone","#{phone}");
                }
                if(customer.getEmail()!=""){
                    VALUES("email","#{email}");
                }
                if(customer.getId_type()!=""){
                    VALUES("id_type","#{id_type}");
                }
                if(customer.getId_number()!=""){
                    VALUES("id_number","#{id_number}");
                }
            }
        }.toString();
    }
    public String update_customer(Customer customer){
        return new SQL(){
            {
                UPDATE("zl_customer");
                if(customer.getFname()!=""){
                    SET("fname = #{fname}");
                }
                if(customer.getLname()!=""){
                    SET("lname = #{lname}");
                }
                if(customer.getEmail()!=""){
                    SET("email = #{email}");
                }
                if(customer.getPhone()!=""){
                    SET("phone = #{phone}");
                }
                if(customer.getId_type()!=""){
                    SET("id_type = #{id_type}");
                }
                if(customer.getId_number()!=""){
                    SET("id_number = #{id_number}");
                }
                if(customer.getEid()!=""){
                    SET("eid = #{eid}");
                }
                WHERE("cid = #{cid}");
            }
        }.toString();
    }
}
