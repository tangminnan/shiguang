package com.shiguang.line.domain;

import java.io.Serializable;
import java.util.Date;

public class YgLineDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    private String memberNumber;
    //
    private String callStatus;

    private String memberName;

    private Long sex;

    private String sexx;

    private String consultRoom;

    private Date lineTime;

    private String lineDate;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    public void setMemberNumber(String memberNumber){this.memberNumber = memberNumber;}

    public String getMemberNumber(){return memberNumber;}

    public void setCallStatus(String callStatus){this.callStatus = callStatus;}

    public String getCallStatus(){return callStatus;}

    public void setMemberName(String memberName){this.memberName = memberName;}

    public String getMemberName(){return memberName;}

    public void setSex(Long sex){this.sex = sex;}

    public Long getSex(){return sex;}

    public void setSexx(String sexx){this.sexx = sexx;}

    public String getSexx(){return sexx;}

    public void setConsultRoom(String consultRoom){this.consultRoom = consultRoom;}

    public String getConsultRoom(){return consultRoom;}

    public void setLineTime(Date lineTime){this.lineTime = lineTime;}

    public Date getLineTime(){return lineTime;}

    public void setLineDate(String lineDate){this.lineDate = lineDate;}

    public String getLineDate(){return lineDate;}


}
