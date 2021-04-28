package com.database.demo.entity;

import java.io.Serializable;
import java.sql.Date;

public class Rental implements Serializable {
    private String rid;
    private String rstatus;
    private String borrow_date;
    private String expected_rdate;
    private String actual_rdate;
    private String copyid;
    private String iid;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getExpected_rdate() {
        return expected_rdate;
    }

    public void setExpected_rdate(String expected_rdate) {
        this.expected_rdate = expected_rdate;
    }

    public String getActual_rdate() {
        return actual_rdate;
    }

    public void setActual_rdate(String actual_rdate) {
        this.actual_rdate = actual_rdate;
    }

    public String getCopyid() {
        return copyid;
    }

    public void setCopyid(String copyid) {
        this.copyid = copyid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }
}
