package com.database.demo.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private String bid;
    private String bname;
    private String topic;
    private String numOfCopies;

    public String getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(String numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
