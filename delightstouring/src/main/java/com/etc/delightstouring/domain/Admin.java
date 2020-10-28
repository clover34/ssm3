package com.etc.delightstouring.domain;

public class Admin {
    private String UUID; // uuid
    private String aId; //管理员编号
    private String aName; // 管理员姓名
    private String password; // 密码
    private String aPhone; // 联系方式
    private String aRole; //  角色
    private Integer aExists;// 员工是否在在职 1：离职 0：在职

    public Admin() {
    }

    public Admin(String UUID, String aId, String aName, String password, String aPhone, String aRole, Integer aExists) {
        this.UUID = UUID;
        this.aId = aId;
        this.aName = aName;
        this.password = password;
        this.aPhone = aPhone;
        this.aRole = aRole;
        this.aExists = aExists;
    }

    public Admin(String aName, String password, String aPhone, String aRole, Integer aExists) {
        this.aName = aName;
        this.password = password;
        this.aPhone = aPhone;
        this.aRole = aRole;
        this.aExists = aExists;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "UUID='" + UUID + '\'' +
                ", aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", password='" + password + '\'' +
                ", aPhone='" + aPhone + '\'' +
                ", aRole='" + aRole + '\'' +
                ", aExists=" + aExists +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaRole() {
        return aRole;
    }

    public void setaRole(String aRole) {
        this.aRole = aRole;
    }

    public Integer getaExists() {
        return aExists;
    }

    public void setaExists(Integer aExists) {
        this.aExists = aExists;
    }
}
