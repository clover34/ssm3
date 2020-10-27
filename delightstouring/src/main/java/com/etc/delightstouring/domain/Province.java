package com.etc.delightstouring.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Province
 * @Description TODO 省份
 * @Author Administrator
 * @Date 20/10/26 18:45
 * @Version 1.0
 **/
public class Province implements Serializable {
    private Integer pId;// 省份编号
    private String pName;// 省份名称
    private List<Region> regions;// 地区集合

    public Province(Integer pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public Province(String pName) {
        this.pName = pName;
    }

    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", regions=" + regions +
                '}';
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
