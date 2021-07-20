package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * RGP表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
public class RgpDO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long rgpId;
    //卡号
    private String cardNumber;
    //处方类型
    private String rgpPrescriptionType;
    //医生
    private String rgpDoctor;
    //验光师
    private String rgpOptometryName;
    //屈光度OD
    private Double rgpQgdod;
    //屈光度OS
    private Double rgpQgdos;
    //BC(OD)
    private Double rgpBcod;
    //BC(OS)
    private Double rgpBcos;
    //DIA(OD)
    private Double rgpDiaod;
    //DIA(OS)
    private Double rgpDiaos;
    //散光(OD)
    private Double rgpSgod;
    //散光(OS)
    private Double rgpSgos;
    //镜片颜色OD
    private String rgpJpysod;
    //镜片颜色OS
    private String rgpJpysos;
    //特殊设计OD
    private String rgpTssjod;
    //特殊设计OS
    private String rgpTssjos;
    //适用镜片OD
    private String rgpSyjpod;
    //适用镜片OS
    private String rgpSyjpos;
    //备注
    private String rgpBeizhu;

    /**
     * 设置：角膜接触镜CRTid
     */
    public void setRgpId(Long rgpId) {
        this.rgpId = rgpId;
    }

    /**
     * 获取：角膜接触镜CRTid
     */
    public Long getRgpId() {
        return rgpId;
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
    public void setRgpPrescriptionType(String rgpPrescriptionType) {
        this.rgpPrescriptionType = rgpPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getRgpPrescriptionType() {
        return rgpPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setRgpDoctor(String rgpDoctor) {
        this.rgpDoctor = rgpDoctor;
    }

    /**
     * 获取：医生
     */
    public String getRgpDoctor() {
        return rgpDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setRgpOptometryName(String rgpOptometryName) {
        this.rgpOptometryName = rgpOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getRgpOptometryName() {
        return rgpOptometryName;
    }

    /**
     * 设置：屈光度OD
     */
    public void setRgpQgdod(Double rgpQgdod) {
        this.rgpQgdod = rgpQgdod;
    }

    /**
     * 获取：屈光度OD
     */
    public Double getRgpQgdod() {
        return rgpQgdod;
    }

    /**
     * 设置：屈光度OS
     */
    public void setRgpQgdos(Double rgpQgdos) {
        this.rgpQgdos = rgpQgdos;
    }

    /**
     * 获取：屈光度OS
     */
    public Double getRgpQgdos() {
        return rgpQgdos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setRgpBcod(Double rgpBcod) {
        this.rgpBcod = rgpBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public Double getRgpBcod() {
        return rgpBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setRgpBcos(Double rgpBcos) {
        this.rgpBcos = rgpBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public Double getRgpBcos() {
        return rgpBcos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setRgpDiaod(Double rgpDiaod) {
        this.rgpDiaod = rgpDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public Double getRgpDiaod() {
        return rgpDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setRgpDiaos(Double rgpDiaos) {
        this.rgpDiaos = rgpDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public Double getRgpDiaos() {
        return rgpDiaos;
    }

    /**
     * 设置：散光(OD)
     */
    public void setRgpSgod(Double rgpSgod) {
        this.rgpSgod = rgpSgod;
    }

    /**
     * 获取：散光(OD)
     */
    public Double getRgpSgod() {
        return rgpSgod;
    }

    /**
     * 设置：散光(OS)
     */
    public void setRgpSgos(Double rgpSgos) {
        this.rgpSgos = rgpSgos;
    }

    /**
     * 获取：散光(OS)
     */
    public Double getRgpSgos() {
        return rgpSgos;
    }

    /**
     * 设置：镜片颜色OD
     */
    public void setRgpJpysod(String rgpJpysod) {
        this.rgpJpysod = rgpJpysod;
    }

    /**
     * 获取：镜片颜色OD
     */
    public String getRgpJpysod() {
        return rgpJpysod;
    }

    /**
     * 设置：镜片颜色OS
     */
    public void setRgpJpysos(String rgpJpysos) {
        this.rgpJpysos = rgpJpysos;
    }

    /**
     * 获取：镜片颜色OS
     */
    public String getRgpJpysos() {
        return rgpJpysos;
    }

    /**
     * 设置：特殊设计OD
     */
    public void setRgpTssjod(String rgpTssjod) {
        this.rgpTssjod = rgpTssjod;
    }

    /**
     * 获取：特殊设计OD
     */
    public String getRgpTssjod() {
        return rgpTssjod;
    }

    /**
     * 设置：特殊设计OS
     */
    public void setRgpTssjos(String rgpTssjos) {
        this.rgpTssjos = rgpTssjos;
    }

    /**
     * 获取：特殊设计OS
     */
    public String getRgpTssjos() {
        return rgpTssjos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setRgpSyjpod(String rgpSyjpod) {
        this.rgpSyjpod = rgpSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getRgpSyjpod() {
        return rgpSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setRgpSyjpos(String rgpSyjpos) {
        this.rgpSyjpos = rgpSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getRgpSyjpos() {
        return rgpSyjpos;
    }

    /**
     * 设置：备注
     */
    public void setRgpBeizhu(String rgpBeizhu) {
        this.rgpBeizhu = rgpBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getRgpBeizhu() {
        return rgpBeizhu;
    }
}