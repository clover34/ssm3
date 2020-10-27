package com.etc.delightstouring.domain;

import java.io.Serializable;

/**
 * @ClassName Status
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 11:23
 * @Version 1.0
 **/
public class Status implements Serializable {
    private Integer sId;// 状态编号
    private String sName;// 状态名称

    public Status(Integer sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    public Status(String sName) {
        this.sName = sName;
    }

    public Status() {
    }

    @Override
    public String toString() {
        return "Status{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                '}';
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
