package com.database.demo.dao.provider;

import com.database.demo.entity.Copy;
import org.apache.ibatis.jdbc.SQL;

public class CopyDynaSQLProvider {
    public String insert_copy(Copy copy){
        return new SQL(){
            {
                INSERT_INTO("zl_copies");
                if(copy.getCopyid()!=""){
                    VALUES("copyid","#{copyid}");
                }
                if(copy.getStatus()!="") {
                    VALUES("status", "#{status}");
                }
                if(copy.getBid()!=""){
                    VALUES("bid","#{bid}");
                }
                if(copy.getRid()!=""){
                    VALUES("rid","#{rid}");
                }
            }
        }.toString();
    }
    public String update_copy(Copy copy){
        return new SQL(){
            {
                UPDATE("zl_copies");
                if(copy.getStatus()!=""){
                    SET("status = #{status}");
                }
                if(copy.getBid()!=""){
                    SET("bid = #{bid}");
                }
                if(copy.getRid()!=""){
                    SET("rid = #{rid}");
                }
                WHERE("copyid = #{copyid}");
            }
        }.toString();
    }
}
