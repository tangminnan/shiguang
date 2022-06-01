package com.shiguang.jiekou.domain;

import java.io.Serializable;


/**
 * RGP表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
public class RgpJKDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //角膜接触镜CRTid
    private Long rgpId;
    //处方类型
    private String rgpPrescriptionType;
    //卡号
    private String cardNumber;
    //验光号
    private String ptometryNumber;
    //医生
    private String rgpDoctor;
    //验光师
    private String rgpOptometryName;
    //球镜OD右
    private String rgpSphod;
    //球镜OS左
    private String rgpSphos;
    //柱镜OD
    private String rgpCylod;
    //柱镜OS
    private String rgpCylos;
    //轴向OD
    private String rgpAxialod;
    //轴向OS
    private String rgpAxialos;
    //屈光度OD
    private String rgpQgdod;
    //屈光度OS
    private String rgpQgdos;
    //BC(OD)
    private String rgpBcod;
    //BC(OS)
    private String rgpBcos;
    //DIA(OD)
    private String rgpDiaod;
    //DIA(OS)
    private String rgpDiaos;
    //散光(OD)
    private String rgpSgod;
    //散光(OS)
    private String rgpSgos;
    //备注
    private String rgpBeizhu;
    //删除状态（0已删除，1未删除）
    private String status;


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
    public void setRgpQgdod(String rgpQgdod) {
        this.rgpQgdod = rgpQgdod;
    }
    /**
     * 获取：屈光度OD
     */
    public String getRgpQgdod() {
        return rgpQgdod;
    }
    /**
     * 设置：屈光度OS
     */
    public void setRgpQgdos(String rgpQgdos) {
        this.rgpQgdos = rgpQgdos;
    }
    /**
     * 获取：屈光度OS
     */
    public String getRgpQgdos() {
        return rgpQgdos;
    }
    /**
     * 设置：BC(OD)
     */
    public void setRgpBcod(String rgpBcod) {
        this.rgpBcod = rgpBcod;
    }
    /**
     * 获取：BC(OD)
     */
    public String getRgpBcod() {
        return rgpBcod;
    }
    /**
     * 设置：BC(OS)
     */
    public void setRgpBcos(String rgpBcos) {
        this.rgpBcos = rgpBcos;
    }
    /**
     * 获取：BC(OS)
     */
    public String getRgpBcos() {
        return rgpBcos;
    }
    /**
     * 设置：DIA(OD)
     */
    public void setRgpDiaod(String rgpDiaod) {
        this.rgpDiaod = rgpDiaod;
    }
    /**
     * 获取：DIA(OD)
     */
    public String getRgpDiaod() {
        return rgpDiaod;
    }
    /**
     * 设置：DIA(OS)
     */
    public void setRgpDiaos(String rgpDiaos) {
        this.rgpDiaos = rgpDiaos;
    }
    /**
     * 获取：DIA(OS)
     */
    public String getRgpDiaos() {
        return rgpDiaos;
    }
    /**
     * 设置：散光(OD)
     */
    public void setRgpSgod(String rgpSgod) {
        this.rgpSgod = rgpSgod;
    }
    /**
     * 获取：散光(OD)
     */
    public String getRgpSgod() {
        return rgpSgod;
    }
    /**
     * 设置：散光(OS)
     */
    public void setRgpSgos(String rgpSgos) {
        this.rgpSgos = rgpSgos;
    }
    /**
     * 获取：散光(OS)
     */
    public String getRgpSgos() {
        return rgpSgos;
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
    /**
     * 设置：验光号
     */
    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }
    /**
     * 获取：验光号
     */
    public String getPtometryNumber() {
        return ptometryNumber;
    }
    /**
     * 设置：删除状态（0已删除，1未删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 获取：删除状态（0已删除，1未删除）
     */
    public String getStatus() {
        return status;
    }
    /**
     * 设置：球镜OD右
     */
    public void setRgpSphod(String rgpSphod) {
        this.rgpSphod = rgpSphod;
    }
    /**
     * 获取：球镜OD右
     */
    public String getRgpSphod() {
        return rgpSphod;
    }
    /**
     * 设置：球镜OS左
     */
    public void setRgpSphos(String rgpSphos) {
        this.rgpSphos = rgpSphos;
    }
    /**
     * 获取：球镜OS左
     */
    public String getRgpSphos() {
        return rgpSphos;
    }
    /**
     * 设置：柱镜OD
     */
    public void setRgpCylod(String rgpCylod) {
        this.rgpCylod = rgpCylod;
    }
    /**
     * 获取：柱镜OD
     */
    public String getRgpCylod() {
        return rgpCylod;
    }
    /**
     * 设置：柱镜OS
     */
    public void setRgpCylos(String rgpCylos) {
        this.rgpCylos = rgpCylos;
    }
    /**
     * 获取：柱镜OS
     */
    public String getRgpCylos() {
        return rgpCylos;
    }
    /**
     * 设置：轴向OD
     */
    public void setRgpAxialod(String rgpAxialod) {
        this.rgpAxialod = rgpAxialod;
    }
    /**
     * 获取：轴向OD
     */
    public String getRgpAxialod() {
        return rgpAxialod;
    }
    /**
     * 设置：轴向OS
     */
    public void setRgpAxialos(String rgpAxialos) {
        this.rgpAxialos = rgpAxialos;
    }
    /**
     * 获取：轴向OS
     */
    public String getRgpAxialos() {
        return rgpAxialos;
    }
}
