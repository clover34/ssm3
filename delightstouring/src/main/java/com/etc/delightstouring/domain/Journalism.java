package com.etc.delightstouring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Journalism
 * @Description TODO 新闻资讯
 * @Author Administrator
 * @Date 20/10/27 14:48
 * @Version 1.0
 **/
public class Journalism implements Serializable {
    private Integer jId;// 新闻编号
    private String jDescribe;// 新闻描述
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jIssuedate;// 发布时间
    private String jSrc;// 新闻链接
    private Integer jHits;// 点击量

    public Journalism(Integer jId, String jDescribe, Date jIssuedate, String jSrc, Integer jHits) {
        this.jId = jId;
        this.jDescribe = jDescribe;
        this.jIssuedate = jIssuedate;
        this.jSrc = jSrc;
        this.jHits = jHits;
    }

    public Journalism(String jDescribe, Date jIssuedate, String jSrc, Integer jHits) {
        this.jDescribe = jDescribe;
        this.jIssuedate = jIssuedate;
        this.jSrc = jSrc;
        this.jHits = jHits;
    }

    public Journalism() {
    }

    @Override
    public String toString() {
        return "Journalism{" +
                "jId=" + jId +
                ", jDescribe='" + jDescribe + '\'' +
                ", jIssuedate=" + jIssuedate +
                ", iSrc='" + jSrc + '\'' +
                ", j_hits=" + jHits +
                '}';
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjDescribe() {
        return jDescribe;
    }

    public void setjDescribe(String jDescribe) {
        this.jDescribe = jDescribe;
    }

    public Date getjIssuedate() {
        return jIssuedate;
    }

    public void setjIssuedate(Date jIssuedate) {
        this.jIssuedate = jIssuedate;
    }

    public String getjSrc() {
        return jSrc;
    }

    public void setjSrc(String jSrc) {
        this.jSrc = jSrc;
    }

    public Integer getjHits() {
        return jHits;
    }

    public void setjHits(Integer jHits) {
        this.jHits = jHits;
    }
}
