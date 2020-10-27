package com.etc.delightstouring.domain;

import java.io.Serializable;

public class Scenicspot implements Serializable {
    private String UUID;//UUID
    private String ssId;//景点编号
    private String ssName;//景点名称
    private int pId;//省份编号
    private int rId;//地区编号
    private String ssDescribe;//景点描述
    private String ssAddress;//景点地址
    private String ssPhotopath;//景点图片
    private String ssOpendate;//开放时间
    private Province province;
    private Region region;

    public Scenicspot() {
    }

    public Scenicspot(String UUID, String ssId, String ssName, int pId, int rId, String ssDescribe, String ssAddress, String ssPhotopath, String ssOpendate) {
        this.UUID = UUID;
        this.ssId = ssId;
        this.ssName = ssName;
        this.pId = pId;
        this.rId = rId;
        this.ssDescribe = ssDescribe;
        this.ssAddress = ssAddress;
        this.ssPhotopath = ssPhotopath;
        this.ssOpendate = ssOpendate;
    }

    @Override
    public String toString() {
        return "Scenicspot{" +
                "UUID='" + UUID + '\'' +
                ", ssId='" + ssId + '\'' +
                ", ssName='" + ssName + '\'' +
                ", ssDescribe='" + ssDescribe + '\'' +
                ", ssAddress='" + ssAddress + '\'' +
                ", ssPhotopath='" + ssPhotopath + '\'' +
                ", ssOpendate='" + ssOpendate + '\'' +
                ", pId=" + pId +
                ", rId=" + rId +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }

    public String getSsDescribe() {
        return ssDescribe;
    }

    public void setSsDescribe(String ssDescribe) {
        this.ssDescribe = ssDescribe;
    }

    public String getSsAddress() {
        return ssAddress;
    }

    public void setSsAddress(String ssAddress) {
        this.ssAddress = ssAddress;
    }

    public String getSsPhotopath() {
        return ssPhotopath;
    }

    public void setSsPhotopath(String ssPhotopath) {
        this.ssPhotopath = ssPhotopath;
    }

    public String getSsOpendate() {
        return ssOpendate;
    }

    public void setSsOpendate(String ssOpendate) {
        this.ssOpendate = ssOpendate;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
