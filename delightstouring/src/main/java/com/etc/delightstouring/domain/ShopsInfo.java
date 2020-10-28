package com.etc.delightstouring.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ShopsInfo
 * @Description TODO 商铺信息
 * @Author Administrator
 * @Date 20/10/27 13:55
 * @Version 1.0
 **/
public class ShopsInfo implements Serializable {
    private String UUID;// UUID
    private String siId;// 店铺编号
    private String siName;// 店铺名称
    private String siBusinesslicense;// 营业执照
    private String siPaotopath;// 门店图片
    private String siAddress;// 详细地址
    private String siDescribe;// 店铺描述
    private Integer siExists;// 店铺是否下线 0:下线,1：上线
    private String siOpendate;// 营业时间
    private String siPhone;// 联系方式
    private String uId;// 用户编号
    private Integer rId;// 地区编号
    private Integer pId;// 省份编号

    private Region region;// 地区编号
    private Province province;// 省份信息
    private Users users;// 所属用户



    public ShopsInfo() {
    }

    @Override
    public String toString() {
        return "ShopsInfo{" +
                "UUID='" + UUID + '\'' +
                ", siId='" + siId + '\'' +
                ", siName='" + siName + '\'' +
                ", siBusinesslicense='" + siBusinesslicense + '\'' +
                ", siPaotopath='" + siPaotopath + '\'' +
                ", siAddress='" + siAddress + '\'' +
                ", siDescribe='" + siDescribe + '\'' +
                ", siExists=" + siExists +
                ", siOpendate=" + siOpendate +
                ", siPhone='" + siPhone + '\'' +
                ", uId='" + uId + '\'' +
                ", rId=" + rId +
                ", pId=" + pId +
                ", region=" + region +
                ", province=" + province +
                ", users=" + users +
                '}';
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSiId() {
        return siId;
    }

    public void setSiId(String siId) {
        this.siId = siId;
    }

    public String getSiName() {
        return siName;
    }

    public void setSiName(String siName) {
        this.siName = siName;
    }

    public String getSiBusinesslicense() {
        return siBusinesslicense;
    }

    public void setSiBusinesslicense(String siBusinesslicense) {
        this.siBusinesslicense = siBusinesslicense;
    }

    public String getSiPaotopath() {
        return siPaotopath;
    }

    public void setSiPaotopath(String siPaotopath) {
        this.siPaotopath = siPaotopath;
    }

    public String getSiAddress() {
        return siAddress;
    }

    public void setSiAddress(String siAddress) {
        this.siAddress = siAddress;
    }

    public String getSiDescribe() {
        return siDescribe;
    }

    public void setSiDescribe(String siDescribe) {
        this.siDescribe = siDescribe;
    }

    public Integer getSiExists() {
        return siExists;
    }

    public void setSiExists(Integer siExists) {
        this.siExists = siExists;
    }

    public String getSiOpendate() {
        return siOpendate;
    }

    public void setSiOpendate(String siOpendate) {
        this.siOpendate = siOpendate;
    }

    public String getSiPhone() {
        return siPhone;
    }

    public void setSiPhone(String siPhone) {
        this.siPhone = siPhone;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
