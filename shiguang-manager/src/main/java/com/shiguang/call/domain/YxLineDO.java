package com.shiguang.call.domain;

import java.io.Serializable;
import java.util.Date;

public class YxLineDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //会员卡号
    private String memberNumber;
    //会员姓名
    private String memberName;
    //性别
    private String sex;
    //联系方式
    private String phone;
    //检查类型
    private String type;
    //创建时间
    private Date createTime;

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
     * 设置：会员姓名
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    /**
     * 获取：会员姓名
     */
    public String getMemberName() {
        return memberName;
    }
    /**
     * 设置：性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 获取：联系方式
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：联系方式
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：检查类型
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：检查类型
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：创建时间
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
