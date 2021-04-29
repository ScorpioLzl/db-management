package com.database.demo.dao.provider;

import com.database.demo.entity.Event;
import org.apache.ibatis.jdbc.SQL;

public class EventDynaSQLProvider {
    public String insert_event(Event event){
        return new SQL(){
            {
                INSERT_INTO("zl_event");
                if(event.getEid()!=""){
                    VALUES("eid","#{eid}");
                }
                if(event.getEname()!="") {
                    VALUES("ename", "#{ename}");
                }
                if(event.getEtype()!=""){
                    VALUES("etype","#{etype}");
                }
                if(event.getStarttime()!=""){
                    VALUES("starttime","#{starttime}");
                }
                if(event.getStoptime()!=""){
                    VALUES("stoptime","#{stoptime}");
                }
            }
        }.toString();
    }
    public String update_event(Event event){
        return new SQL(){
            {
                UPDATE("zl_event");
                if(event.getEname()!=""){
                    SET("ename = #{ename}");
                }
                if(event.getEtype()!=""){
                    SET("etype = #{etype}");
                }
                if(event.getStarttime()!=""){
                    SET("starttime = #{starttime}");
                }
                if(event.getStoptime()!=""){
                    SET("stoptime = #{stoptime}");
                }
                WHERE("eid = #{eid}");
            }
        }.toString();
    }
}
