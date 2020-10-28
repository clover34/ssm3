package com.etc.delightstouring.domain;

public class Users {
    private String UUID; // UUID
    private String uId; // 用户编号
    private String uPhotopath; // 头像
    private String username; // 用户名
    private String password; // 密码
    private String uPhone; //手机号码
    private Integer uExists;// 用户是否存在 1：存在 0 :注销

    public Users() {
    }

    public Users(String UUID, String uId, String uPhotopath, String username, String password, String uPhone) {
        this.UUID = UUID;
        this.uId = uId;
        this.uPhotopath = uPhotopath;
        this.username = username;
        this.password = password;
        this.uPhone = uPhone;
    }

    public Users(String uId, String uPhotopath, String username, String password, String uPhone) {
        this.uId = uId;
        this.uPhotopath = uPhotopath;
        this.username = username;
        this.password = password;
        this.uPhone = uPhone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "UUID='" + UUID + '\'' +
                ", uId='" + uId + '\'' +
                ", uPhotopath='" + uPhotopath + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uExists=" + uExists +
                '}';
    }

    public Integer getuExists() {
        return uExists;
    }

    public void setuExists(Integer uExists) {
        this.uExists = uExists;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuPhotopath() {
        return uPhotopath;
    }

    public void setuPhotopath(String uPhotopath) {
        this.uPhotopath = uPhotopath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }
}
