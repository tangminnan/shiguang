package com.shiguang.line.domain;

import java.io.Serializable;

public class LineMemberDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //会员卡号
    private String memberNumber;
    //姓名
    private String name;
    //性别
    private Long sex;
    //诊室
    private String consultRoom;

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
    /**
     * 设置：会员卡号
     */
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    /**
     * 获取：会员卡号
     */
    public String getMemberNumber() {
        return memberNumber;
    }
    /**
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：性别
     */
    public void setSex(Long sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别
     */
    public Long getSex() {
        return sex;
    }
    /**
     * 设置：诊室
     */
    public void setConsultRoom(String consultRoom) {
        this.consultRoom = consultRoom;
    }
    /**
     * 获取：诊室
     */
    public String getConsultRoom() {
        return consultRoom;
    }

}
