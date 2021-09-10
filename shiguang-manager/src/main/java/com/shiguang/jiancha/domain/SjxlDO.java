package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 视觉训练表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-17 09:43:36
 */
public class SjxlDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //视觉训练id
    private Long sjxlId;
    //卡号
    private String cardNumber;
    //处方类型
    private String sjxlPrescriptionType;
    //医生
    private String sjxlDoctor;
    //验光师
    private String sjxlOptometryName;
    //球镜OD
    private String sjxlSphod;
    //球镜OS
    private String sjxlSphos;
    //柱镜OD
    private String sjxlCylod;
    //柱镜OS
    private String sjxlCylos;
    //轴向OD
    private String sjxlAxialod;
    //轴向OS
    private String sjxlAxialos;
    //三棱镜(OD)
    private String sjxlSljod;
    //三棱镜(OS)
    private String sjxlSljos;
    //基底(OD)
    private String sjxlJdod;
    //基底(OS)
    private String sjxlJdos;
    //远用瞳距(mm)(OD)
    private String sjxlYytjod;
    //远用瞳距(mm)(OS)
    private String sjxlYytjos;
    //近用瞳距(mm)(OD)
    private String sjxlJytjod;
    //近用瞳距(mm)(OS)
    private String sjxlJytjos;
    //远用va(OD)
    private String sjxlYyvaod;
    //远用va(OS)
    private String sjxlYyvaos;
    //近用va(OD)
    private String sjxlJyvaod;
    //近用va(OS)
    private String sjxlJyvaos;
    //家庭训练
    private String sjxlJtxl;
    //训练室训练
    private String sjxlXlsxl;
    //备注
    private String sjxlBeizhu;
    //删除状态
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 设置：视觉训练id
     */
    public void setSjxlId(Long sjxlId) {
        this.sjxlId = sjxlId;
    }

    /**
     * 获取：视觉训练id
     */
    public Long getSjxlId() {
        return sjxlId;
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
    public void setSjxlPrescriptionType(String sjxlPrescriptionType) {
        this.sjxlPrescriptionType = sjxlPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getSjxlPrescriptionType() {
        return sjxlPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setSjxlDoctor(String sjxlDoctor) {
        this.sjxlDoctor = sjxlDoctor;
    }

    /**
     * 获取：医生
     */
    public String getSjxlDoctor() {
        return sjxlDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setSjxlOptometryName(String sjxlOptometryName) {
        this.sjxlOptometryName = sjxlOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getSjxlOptometryName() {
        return sjxlOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setSjxlSphod(String sjxlSphod) {
        this.sjxlSphod = sjxlSphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getSjxlSphod() {
        return sjxlSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSjxlSphos(String sjxlSphos) {
        this.sjxlSphos = sjxlSphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getSjxlSphos() {
        return sjxlSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSjxlCylod(String sjxlCylod) {
        this.sjxlCylod = sjxlCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getSjxlCylod() {
        return sjxlCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSjxlCylos(String sjxlCylos) {
        this.sjxlCylos = sjxlCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getSjxlCylos() {
        return sjxlCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSjxlAxialod(String sjxlAxialod) {
        this.sjxlAxialod = sjxlAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getSjxlAxialod() {
        return sjxlAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSjxlAxialos(String sjxlAxialos) {
        this.sjxlAxialos = sjxlAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getSjxlAxialos() {
        return sjxlAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setSjxlSljod(String sjxlSljod) {
        this.sjxlSljod = sjxlSljod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getSjxlSljod() {
        return sjxlSljod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setSjxlSljos(String sjxlSljos) {
        this.sjxlSljos = sjxlSljos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getSjxlSljos() {
        return sjxlSljos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setSjxlJdod(String sjxlJdod) {
        this.sjxlJdod = sjxlJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getSjxlJdod() {
        return sjxlJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setSjxlJdos(String sjxlJdos) {
        this.sjxlJdos = sjxlJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getSjxlJdos() {
        return sjxlJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSjxlYytjod(String sjxlYytjod) {
        this.sjxlYytjod = sjxlYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getSjxlYytjod() {
        return sjxlYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSjxlYytjos(String sjxlYytjos) {
        this.sjxlYytjos = sjxlYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getSjxlYytjos() {
        return sjxlYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSjxlJytjod(String sjxlJytjod) {
        this.sjxlJytjod = sjxlJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public String getSjxlJytjod() {
        return sjxlJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSjxlJytjos(String sjxlJytjos) {
        this.sjxlJytjos = sjxlJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public String getSjxlJytjos() {
        return sjxlJytjos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSjxlYyvaod(String sjxlYyvaod) {
        this.sjxlYyvaod = sjxlYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getSjxlYyvaod() {
        return sjxlYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSjxlYyvaos(String sjxlYyvaos) {
        this.sjxlYyvaos = sjxlYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getSjxlYyvaos() {
        return sjxlYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSjxlJyvaod(String sjxlJyvaod) {
        this.sjxlJyvaod = sjxlJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public String getSjxlJyvaod() {
        return sjxlJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSjxlJyvaos(String sjxlJyvaos) {
        this.sjxlJyvaos = sjxlJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public String getSjxlJyvaos() {
        return sjxlJyvaos;
    }

    /**
     * 设置：家庭训练
     */
    public void setSjxlJtxl(String sjxlJtxl) {
        this.sjxlJtxl = sjxlJtxl;
    }

    /**
     * 获取：家庭训练
     */
    public String getSjxlJtxl() {
        return sjxlJtxl;
    }

    /**
     * 设置：训练室训练
     */
    public void setSjxlXlsxl(String sjxlXlsxl) {
        this.sjxlXlsxl = sjxlXlsxl;
    }

    /**
     * 获取：训练室训练
     */
    public String getSjxlXlsxl() {
        return sjxlXlsxl;
    }

    /**
     * 设置：备注
     */
    public void setSjxlBeizhu(String sjxlBeizhu) {
        this.sjxlBeizhu = sjxlBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getSjxlBeizhu() {
        return sjxlBeizhu;
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
