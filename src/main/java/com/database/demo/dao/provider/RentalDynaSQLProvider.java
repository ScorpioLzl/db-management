package com.database.demo.dao.provider;

import com.database.demo.entity.Event;
import com.database.demo.entity.Rental;
import org.apache.ibatis.jdbc.SQL;

public class RentalDynaSQLProvider {
    public String insert_rental(Rental rental){
        return new SQL(){
            {
                INSERT_INTO("zl_rental");
                if(rental.getRid()!=""){
                    VALUES("rid","#{rid}");
                }
                if(rental.getCopyid()!="") {
                    VALUES("copyid", "#{copyid}");
                }
                if(rental.getRstatus()!=""){
                    VALUES("rstatus","#{rstatus}");
                }
                if(rental.getBorrow_date()!=""){
                    VALUES("borrow_date","#{borrow_date}");
                }
                if(rental.getActual_rdate()!=""){
                    VALUES("actual_rdate","#{actual_rdate}");
                }
                if(rental.getExpected_rdate()!=""){
                    VALUES("expected_rdate","#{expected_rdate}");
                }
                if(rental.getIid()!=""){
                    VALUES("iid","#{iid}");
                }
            }
        }.toString();
    }
    public String update_rental(Rental rental){
        return new SQL(){
            {
                UPDATE("zl_rental");
                if(rental.getBorrow_date()!=""){
                    SET("borrow_date = #{borrow_date}");
                }
                if(rental.getExpected_rdate()!=""){
                    SET("expected_rdate = #{expected_rdate}");
                }
                if(rental.getActual_rdate()!=""){
                    SET("actual_rdate = #{actual_rdate}");
                }
                if(rental.getIid()!=""){
                    SET("iid = #{iid}");
                }
                if(rental.getCopyid()!=""){
                    SET("copyid = #{copyid}");
                }
                if(rental.getIid()!=""){
                    SET("iid = #{iid}");
                }
                if(rental.getRstatus()!=""){
                    SET("rstatus = #{rstatus}");
                }
                WHERE("rid = #{rid}");
            }
        }.toString();
    }
}
