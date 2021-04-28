package com.database.demo.entity;

import java.io.Serializable;

public class Sponsor implements Serializable {
    private String sid;
    private String stype;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }
}
