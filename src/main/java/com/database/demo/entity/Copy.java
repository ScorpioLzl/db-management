package com.database.demo.entity;

import java.io.Serializable;

public class Copy implements Serializable {
    private String copyid;
    private String cstatus;
    private String bid;
    private String rid;

    public String getCopyid() {
        return copyid;
    }

    public void setCopyid(String copyid) {
        this.copyid = copyid;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
