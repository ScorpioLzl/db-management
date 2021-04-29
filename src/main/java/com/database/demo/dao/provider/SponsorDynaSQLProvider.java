package com.database.demo.dao.provider;

import com.database.demo.entity.Room;
import com.database.demo.entity.Sponsor;
import org.apache.ibatis.jdbc.SQL;

public class SponsorDynaSQLProvider {
    public String insert_sponsor(Sponsor sponsor){
        return new SQL(){
            {
                INSERT_INTO("zl_sponsor");
                if(sponsor.getSid()!=""){
                    VALUES("sid","#{sid}");
                }
                if(sponsor.getStype()!="") {
                    VALUES("stype", "#{stype}");
                }
            }
        }.toString();
    }
    public String update_sponsor(Sponsor sponsor){
        return new SQL(){
            {
                UPDATE("zl_sponsor");
                if(sponsor.getStype()!=""){
                    SET("stype = #{stype}");
                }
                WHERE("roomid = #{roomid}");
            }
        }.toString();
    }
}
