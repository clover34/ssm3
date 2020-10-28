package com.etc.delightstouring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName JoinInfo
 * @Description TODO 店铺加盟信息
 * @Author Administrator
 * @Date 20/10/27 13:45
 * @Version 1.0
 **/
public class JoinInfo implements Serializable {
    private String UUID;// UUID
    private String jiName;// 店铺名称
    private String jiBusinesslicense;// 营业执照
    private String jiAddress;// 详细地址
    private String jiPaotopath;// 门店图片
    private String jiPhone;// 联系方式
    private String jiJoinexplain;// 加盟说明
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jiApplyfordate;// 申请时间
    private String uId;// 用户编号
    private Integer rId;// 地区编号
    private Integer pId;// 省份编号
    private Integer sId;// 申请状态编号

    private Region region;// 地区编号
    private Province province;// 省份信息
    private Status status;// 状态表信息
    private Users users;

    public JoinInfo() {
    }

    public JoinInfo(String UUID, String jiName, String jiBusinesslicense,
                    String jiAddress, String jiPaotopath, String jiPhone,
                    String jiJoinexplain, Date jiApplyfordate, String uId,
                    Integer rId, Integer pId, Integer sId, Region region,
                    Province province, Status status, Users users) {
        this.UUID = UUID;
        this.jiName = jiName;
        this.jiBusinesslicense = jiBusinesslicense;
        this.jiAddress = jiAddress;
        this.jiPaotopath = jiPaotopath;
        this.jiPhone = jiPhone;
        this.jiJoinexplain = jiJoinexplain;
        this.jiApplyfordate = jiApplyfordate;
        this.uId = uId;
        this.rId = rId;
        this.pId = pId;
        this.sId = sId;
        this.region = region;
        this.province = province;
        this.status = status;
        this.users = users;
    }

    @Override
    public String toString() {
        return "JoinInfo{" +
                "UUID='" + UUID + '\'' +
                ", jiName='" + jiName + '\'' +
                ", jiBusinesslicense='" + jiBusinesslicense + '\'' +
                ", jiAddress='" + jiAddress + '\'' +
                ", jiPaotopath='" + jiPaotopath + '\'' +
                ", jiPhone='" + jiPhone + '\'' +
                ", jiJoinexplain='" + jiJoinexplain + '\'' +
                ", jiApplyfordate=" + jiApplyfordate +
                ", uId='" + uId + '\'' +
                ", rId=" + rId +
                ", pId=" + pId +
                ", sId=" + sId +
                ", region=" + region +
                ", province=" + province +
                ", status=" + status +
                ", users=" + users +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getJiName() {
        return jiName;
    }

    public void setJiName(String jiName) {
        this.jiName = jiName;
    }

    public String getJiBusinesslicense() {
        return jiBusinesslicense;
    }

    public void setJiBusinesslicense(String jiBusinesslicense) {
        this.jiBusinesslicense = jiBusinesslicense;
    }

    public String getJiAddress() {
        return jiAddress;
    }

    public void setJiAddress(String jiAddress) {
        this.jiAddress = jiAddress;
    }

    public String getJiPaotopath() {
        return jiPaotopath;
    }

    public void setJiPaotopath(String jiPaotopath) {
        this.jiPaotopath = jiPaotopath;
    }

    public String getJiPhone() {
        return jiPhone;
    }

    public void setJiPhone(String jiPhone) {
        this.jiPhone = jiPhone;
    }

    public String getJiJoinexplain() {
        return jiJoinexplain;
    }

    public void setJiJoinexplain(String jiJoinexplain) {
        this.jiJoinexplain = jiJoinexplain;
    }

    public Date getJiApplyfordate() {
        return jiApplyfordate;
    }

    public void setJiApplyfordate(Date jiApplyfordate) {
        this.jiApplyfordate = jiApplyfordate;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
