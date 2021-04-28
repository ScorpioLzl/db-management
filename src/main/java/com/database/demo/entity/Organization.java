package com.database.demo.entity;

import java.io.Serializable;

public class Organization implements Serializable {
    private String sid;
    private String oname;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }
}
