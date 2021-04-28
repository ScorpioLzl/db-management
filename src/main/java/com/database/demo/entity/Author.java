package com.database.demo.entity;

import java.io.Serializable;

public class Author implements Serializable {
    private String aid;
    private String afname;
    private String alname;
    private String st_addr;
    private String city;
    private String state;
    private String zipcode;
    private String a_email;
    private String eid;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAfname() {
        return afname;
    }

    public void setAfname(String afname) {
        this.afname = afname;
    }

    public String getAlname() {
        return alname;
    }

    public void setAlname(String alname) {
        this.alname = alname;
    }

    public String getSt_addr() {
        return st_addr;
    }

    public void setSt_addr(String st_addr) {
        this.st_addr = st_addr;
    }

    public String getA_email() {
        return a_email;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }
}
