package com.database.demo.entity;

import java.io.Serializable;

public class Invoice implements Serializable {
    private String iid;
    private String idate;
    private float iamount;
    private String rid;
    private String pid;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getIdate() {
        return idate;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }

    public float getIamount() {
        return iamount;
    }

    public void setIamount(float iamount) {
        this.iamount = iamount;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
