package com.etc.delightstouring.domain;

import java.io.Serializable;

/**
 * @ClassName Region
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/26 23:05
 * @Version 1.0
 **/
public class Region implements Serializable {
    private Integer rId;// 地区编号
    private String rName;// 地区名称
    private Integer pId;// 省份编号

    private Province province;// 所属省份

    public Region(Integer rId, String rName, Integer pId, Province province) {
        this.rId = rId;
        this.rName = rName;
        this.pId = pId;
        this.province = province;
    }

    public Region(String rName, Integer pId) {
        this.rName = rName;
        this.pId = pId;
    }

    public Region() {
    }

    @Override
    public String toString() {
        return "Region{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", pId=" + pId +
                ", province=" + province +
                '}';
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
