package com.shiguang.mailInfo.domain;

import java.io.Serializable;
import java.util.Date;

public class MailInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //配镜单号
    private String saleNumber;
    //会员卡号
    private String cardMember;
    //顾客姓名
    private String memberName;
    //顾客电话
    private String memberTel;
    //顾客区号
    private String memberAreacode;
    //收件人
    private String consignee;
    //邮寄单
    private String mailForm;
    //录入人
    private String enterName;
    //邮寄日期
    private Date enterTimr;
    //地址
    private String address;
    //报价
    private Long insured;
    //保价价格
    private String insuredMoney;
    //状态
    private Long status;

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
     * 设置：配镜单号
     */
    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }
    /**
     * 获取：配镜单号
     */
    public String getSaleNumber() {
        return saleNumber;
    }
    /**
     * 设置：会员卡号
     */
    public void setCardMember(String cardMember) {
        this.cardMember = cardMember;
    }
    /**
     * 获取：会员卡号
     */
    public String getCardMember() {
        return cardMember;
    }
    /**
     * 设置：顾客姓名
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    /**
     * 获取：顾客姓名
     */
    public String getMemberName() {
        return memberName;
    }
    /**
     * 设置：顾客电话
     */
    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }
    /**
     * 获取：顾客电话
     */
    public String getMemberTel() {
        return memberTel;
    }
    /**
     * 设置：顾客区号
     */
    public void setMemberAreacode(String memberAreacode) {
        this.memberAreacode = memberAreacode;
    }
    /**
     * 获取：顾客区号
     */
    public String getMemberAreacode() {
        return memberAreacode;
    }
    /**
     * 设置：收件人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    /**
     * 获取：收件人
     */
    public String getConsignee() {
        return consignee;
    }
    /**
     * 设置：邮寄单
     */
    public void setMailForm(String mailForm) {
        this.mailForm = mailForm;
    }
    /**
     * 获取：邮寄单
     */
    public String getMailForm() {
        return mailForm;
    }
    /**
     * 设置：录入人
     */
    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }
    /**
     * 获取：录入人
     */
    public String getEnterName() {
        return enterName;
    }
    /**
     * 设置：邮寄日期
     */
    public void setEnterTimr(Date enterTimr) {
        this.enterTimr = enterTimr;
    }
    /**
     * 获取：邮寄日期
     */
    public Date getEnterTimr() {
        return enterTimr;
    }
    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：报价
     */
    public void setInsured(Long insured) {
        this.insured = insured;
    }
    /**
     * 获取：报价
     */
    public Long getInsured() {
        return insured;
    }
    /**
     * 设置：保价价格
     */
    public void setInsuredMoney(String insuredMoney) {
        this.insuredMoney = insuredMoney;
    }
    /**
     * 获取：保价价格
     */
    public String getInsuredMoney() {
        return insuredMoney;
    }
    public void setStatus(Long status) {this.status = status;}
    public Long getStatus(){return status;}
}
