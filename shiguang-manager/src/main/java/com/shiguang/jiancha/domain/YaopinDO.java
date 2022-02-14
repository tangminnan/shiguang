package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * jc药品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
public class YaopinDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ypId;
    //卡号
    private String cardNumber;
    //处方类型
    private String ypPrescriptionType;
    //医生
    private String ypDoctor;
    //验光师
    private String ypOptometryName;
    //内容
    private String ypNr;
    //药名
    private String ypYm;
    //删除状态
    private String status;
    //创建时间
    private Date createTime;
    private String newOld;
    public String getNewOld() {
        return newOld;
    }

    public void setNewOld(String newOld) {
        this.newOld = newOld;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 设置：角膜接触镜CRTid
     */
    public void setYpId(Long ypId) {
        this.ypId = ypId;
    }

    /**
     * 获取：角膜接触镜CRTid
     */
    public Long getYpId() {
        return ypId;
    }

    /**
     * 设置：卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 获取：卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置：处方类型
     */
    public void setYpPrescriptionType(String ypPrescriptionType) {
        this.ypPrescriptionType = ypPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getYpPrescriptionType() {
        return ypPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setYpDoctor(String ypDoctor) {
        this.ypDoctor = ypDoctor;
    }

    /**
     * 获取：医生
     */
    public String getYpDoctor() {
        return ypDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setYpOptometryName(String ypOptometryName) {
        this.ypOptometryName = ypOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getYpOptometryName() {
        return ypOptometryName;
    }

    /**
     * 设置：内容
     */
    public void setYpNr(String ypNr) {
        this.ypNr = ypNr;
    }

    /**
     * 获取：内容
     */
    public String getYpNr() {
        return ypNr;
    }

    /**
     * 设置：药名
     */
    public void setYpYm(String ypYm) {
        this.ypYm = ypYm;
    }

    /**
     * 获取：药名
     */
    public String getYpYm() {
        return ypYm;
    }
    //验光号
    private String ptometryNumber;

    public String getPtometryNumber() {
        return ptometryNumber;
    }

    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }
}
