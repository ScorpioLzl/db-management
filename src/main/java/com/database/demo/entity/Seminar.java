package com.database.demo.entity;

import java.io.Serializable;

public class Seminar implements Serializable {
    private String eid;
    private String invitation_id;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(String invitation_id) {
        this.invitation_id = invitation_id;
    }
}
