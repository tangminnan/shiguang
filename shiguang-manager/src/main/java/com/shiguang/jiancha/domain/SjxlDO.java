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
    private Double sjxlSphod;
    //球镜OS
    private Double sjxlSphos;
    //柱镜OD
    private Double sjxlCylod;
    //柱镜OS
    private Double sjxlCylos;
    //轴向OD
    private Double sjxlAxialod;
    //轴向OS
    private Double sjxlAxialos;
    //三棱镜(OD)
    private Double sjxlSljod;
    //三棱镜(OS)
    private Double sjxlSljos;
    //基底(OD)
    private String sjxlJdod;
    //基底(OS)
    private String sjxlJdos;
    //远用瞳距(mm)(OD)
    private Double sjxlYytjod;
    //远用瞳距(mm)(OS)
    private Double sjxlYytjos;
    //近用瞳距(mm)(OD)
    private Double sjxlJytjod;
    //近用瞳距(mm)(OS)
    private Double sjxlJytjos;
    //远用va(OD)
    private Double sjxlYyvaod;
    //远用va(OS)
    private Double sjxlYyvaos;
    //近用va(OD)
    private Double sjxlJyvaod;
    //近用va(OS)
    private Double sjxlJyvaos;
    //家庭训练
    private String sjxlJtxl;
    //训练室训练
    private String sjxlXlsxl;
    //备注
    private String sjxlBeizhu;

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
    public void setSjxlSphod(Double sjxlSphod) {
        this.sjxlSphod = sjxlSphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getSjxlSphod() {
        return sjxlSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSjxlSphos(Double sjxlSphos) {
        this.sjxlSphos = sjxlSphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getSjxlSphos() {
        return sjxlSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSjxlCylod(Double sjxlCylod) {
        this.sjxlCylod = sjxlCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getSjxlCylod() {
        return sjxlCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSjxlCylos(Double sjxlCylos) {
        this.sjxlCylos = sjxlCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getSjxlCylos() {
        return sjxlCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSjxlAxialod(Double sjxlAxialod) {
        this.sjxlAxialod = sjxlAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getSjxlAxialod() {
        return sjxlAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSjxlAxialos(Double sjxlAxialos) {
        this.sjxlAxialos = sjxlAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getSjxlAxialos() {
        return sjxlAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setSjxlSljod(Double sjxlSljod) {
        this.sjxlSljod = sjxlSljod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getSjxlSljod() {
        return sjxlSljod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setSjxlSljos(Double sjxlSljos) {
        this.sjxlSljos = sjxlSljos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getSjxlSljos() {
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
    public void setSjxlYytjod(Double sjxlYytjod) {
        this.sjxlYytjod = sjxlYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getSjxlYytjod() {
        return sjxlYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSjxlYytjos(Double sjxlYytjos) {
        this.sjxlYytjos = sjxlYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getSjxlYytjos() {
        return sjxlYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSjxlJytjod(Double sjxlJytjod) {
        this.sjxlJytjod = sjxlJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public Double getSjxlJytjod() {
        return sjxlJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSjxlJytjos(Double sjxlJytjos) {
        this.sjxlJytjos = sjxlJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public Double getSjxlJytjos() {
        return sjxlJytjos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSjxlYyvaod(Double sjxlYyvaod) {
        this.sjxlYyvaod = sjxlYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getSjxlYyvaod() {
        return sjxlYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSjxlYyvaos(Double sjxlYyvaos) {
        this.sjxlYyvaos = sjxlYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getSjxlYyvaos() {
        return sjxlYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSjxlJyvaod(Double sjxlJyvaod) {
        this.sjxlJyvaod = sjxlJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public Double getSjxlJyvaod() {
        return sjxlJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSjxlJyvaos(Double sjxlJyvaos) {
        this.sjxlJyvaos = sjxlJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public Double getSjxlJyvaos() {
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
}
