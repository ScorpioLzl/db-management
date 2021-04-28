package com.database.demo.entity;

import java.io.Serializable;

public class Payment implements Serializable {
    private String pid;
    private String pdate;
    private String method;
    private String holder_fname;
    private String holder_lname;
    private float pamount;
    private String cid;
    private String iid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHolder_fname() {
        return holder_fname;
    }

    public void setHolder_fname(String holder_fname) {
        this.holder_fname = holder_fname;
    }

    public String getHolder_lname() {
        return holder_lname;
    }

    public void setHolder_lname(String holder_lname) {
        this.holder_lname = holder_lname;
    }

    public float getPamount() {
        return pamount;
    }

    public void setPamount(float pamount) {
        this.pamount = pamount;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }
}
