package com.shiguang.line.domain;

import com.sun.xml.internal.rngom.digested.DTextPattern;

import java.io.Serializable;
import java.util.Date;

public class RefractionLineDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //验光师
    private String refractionName;
    //会员姓名
    private String memberName;
    //叫号次数
    private String refractionStatus;
    //验光室
    private String refraction;
    //排队时间
    private Date refractionTime;
    private String refractionDate;

    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }

    public void setRefractionName(String refractionName){this.refractionName = refractionName;}

    public String getRefractionName(){return refractionName;}

    public void setMemberName(String memberName){this.memberName = memberName;}

    public String getMemberName(){return memberName;}

    public void setRefractionStatus(String refractionStatus){this.refractionStatus = refractionStatus;}

    public String getRefractionStatus(){return refractionStatus;}

    public void setRefractionTime(Date refractionTime){this.refractionTime = refractionTime;}

    public Date getRefractionTime(){return refractionTime;}

    public void setRefractionDate(String refractionDate){this.refractionDate = refractionDate;}

    public String getRefractionDate(){return refractionDate;}

    public void setRefraction(String refraction) {this.refraction = refraction;}

    public String getRefraction(){return refraction;}
}
