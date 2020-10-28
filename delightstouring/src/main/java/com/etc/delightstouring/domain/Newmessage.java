package com.etc.delightstouring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Newmessage implements Serializable {
    private Integer nmId;// 留言编号
    private String uId;//用户编号
    private String message;//留言内容
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GBT+8")
    private Date nmDate;//留言时间

    private Users users;

    public Newmessage(Integer nmId, String uId, String message, Date nmDate, Users users) {
        this.nmId = nmId;
        this.uId = uId;
        this.message = message;
        this.nmDate = nmDate;
        this.users = users;
    }

    public Newmessage(String uId, String message, Date nmDate, Users users) {
        this.uId = uId;
        this.message = message;
        this.nmDate = nmDate;
        this.users = users;
    }

    public Newmessage() {
    }

    @Override
    public String toString() {
        return "Newmessage{" +
                "nmId=" + nmId +
                ", uId='" + uId + '\'' +
                ", message='" + message + '\'' +
                ", nmDate=" + nmDate +
                ", users=" + users +
                '}';
    }

    public Integer getNmId() {
        return nmId;
    }

    public void setNmId(Integer nmId) {
        this.nmId = nmId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
