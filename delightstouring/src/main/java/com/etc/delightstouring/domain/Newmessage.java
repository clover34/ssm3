package com.etc.delightstouring.domain;

import java.io.Serializable;
import java.util.Date;

public class Newmessage implements Serializable {
    private String uid;//用户编号
    private String message;//留言内容
    private Date nmDate;//留言时间

    /*private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }*/

    public Newmessage() {
    }

    public Newmessage(String uid, String message, Date nmDate) {
        this.uid = uid;
        this.message = message;
        this.nmDate = nmDate;
    }

    @Override
    public String toString() {
        return "Newmessage{" +
                "uid='" + uid + '\'' +
                ", message='" + message + '\'' +
                ", nmDate=" + nmDate +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getNmDate() {
        return nmDate;
    }

    public void setNmDate(Date nmDate) {
        this.nmDate = nmDate;
    }
}
