package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 框架远用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 18:56:26
 */
public class KjyyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //框架远用id
    private Long kjyyId;
    //卡号
    private String cardNumber;
    //处方类型
    private String kjyyPrescriptionType;
    //医生
    private String kjyyDoctor;
    //验光师
    private String kjyyOptometryName;
    //球镜OD
    private Double kjyySphod;
    //球镜OS
    private Double kjyySphos;
    //柱镜OD
    private Double kjyyCylod;
    //柱镜OS
    private Double kjyyCylos;
    //轴向OD
    private Double kjyyAxialod;
    //轴向OS
    private Double kjyyAxialos;
    //三棱镜(OD)
    private Double kjyyPrismod;
    //三棱镜(OS)
    private Double kjyyPrismos;
    //基底(OD)
    private String kjyyJdod;
    //基底(OS)
    private String kjyyJdos;
    //远用瞳距(mm)(OD)
    private Double kjyyYytjod;
    //远用瞳距(mm)(OS)
    private Double kjyyYytjos;
    //瞳高(mm)(OD)
    private Double kjyyTgod;
    //瞳高(mm)(OS)
    private Double kjyyTgos;
    //远用va(OD)
    private Double kjyyVaod;
    //远用va(OS)
    private Double kjyyVaos;
    //建议镜片材质
    private String kjyyJpcz;
    //处理方式
    private String kjyyClfs;
    //建议框架
    private String kjyyJykj;
    //框架类型
    private String kjyyKjlx;
    //文本
    private String kjyyText;
    //备注
    private String kjyyBeizhu;

    /**
     * 设置：框架远用id
     */
    public void setKjyyId(Long kjyyId) {
        this.kjyyId = kjyyId;
    }

    /**
     * 获取：框架远用id
     */
    public Long getKjyyId() {
        return kjyyId;
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
    public void setKjyyPrescriptionType(String kjyyPrescriptionType) {
        this.kjyyPrescriptionType = kjyyPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getKjyyPrescriptionType() {
        return kjyyPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setKjyyDoctor(String kjyyDoctor) {
        this.kjyyDoctor = kjyyDoctor;
    }

    /**
     * 获取：医生
     */
    public String getKjyyDoctor() {
        return kjyyDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setKjyyOptometryName(String kjyyOptometryName) {
        this.kjyyOptometryName = kjyyOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getKjyyOptometryName() {
        return kjyyOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setKjyySphod(Double kjyySphod) {
        this.kjyySphod = kjyySphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getKjyySphod() {
        return kjyySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjyySphos(Double kjyySphos) {
        this.kjyySphos = kjyySphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getKjyySphos() {
        return kjyySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjyyCylod(Double kjyyCylod) {
        this.kjyyCylod = kjyyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getKjyyCylod() {
        return kjyyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjyyCylos(Double kjyyCylos) {
        this.kjyyCylos = kjyyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getKjyyCylos() {
        return kjyyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjyyAxialod(Double kjyyAxialod) {
        this.kjyyAxialod = kjyyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getKjyyAxialod() {
        return kjyyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjyyAxialos(Double kjyyAxialos) {
        this.kjyyAxialos = kjyyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getKjyyAxialos() {
        return kjyyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjyyPrismod(Double kjyyPrismod) {
        this.kjyyPrismod = kjyyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getKjyyPrismod() {
        return kjyyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjyyPrismos(Double kjyyPrismos) {
        this.kjyyPrismos = kjyyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getKjyyPrismos() {
        return kjyyPrismos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setKjyyJdod(String kjyyJdod) {
        this.kjyyJdod = kjyyJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getKjyyJdod() {
        return kjyyJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setKjyyJdos(String kjyyJdos) {
        this.kjyyJdos = kjyyJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getKjyyJdos() {
        return kjyyJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setKjyyYytjod(Double kjyyYytjod) {
        this.kjyyYytjod = kjyyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getKjyyYytjod() {
        return kjyyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjyyYytjos(Double kjyyYytjos) {
        this.kjyyYytjos = kjyyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getKjyyYytjos() {
        return kjyyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjyyTgod(Double kjyyTgod) {
        this.kjyyTgod = kjyyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getKjyyTgod() {
        return kjyyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjyyTgos(Double kjyyTgos) {
        this.kjyyTgos = kjyyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getKjyyTgos() {
        return kjyyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjyyVaod(Double kjyyVaod) {
        this.kjyyVaod = kjyyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getKjyyVaod() {
        return kjyyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjyyVaos(Double kjyyVaos) {
        this.kjyyVaos = kjyyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getKjyyVaos() {
        return kjyyVaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setKjyyJpcz(String kjyyJpcz) {
        this.kjyyJpcz = kjyyJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getKjyyJpcz() {
        return kjyyJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setKjyyClfs(String kjyyClfs) {
        this.kjyyClfs = kjyyClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getKjyyClfs() {
        return kjyyClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setKjyyJykj(String kjyyJykj) {
        this.kjyyJykj = kjyyJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getKjyyJykj() {
        return kjyyJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setKjyyKjlx(String kjyyKjlx) {
        this.kjyyKjlx = kjyyKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getKjyyKjlx() {
        return kjyyKjlx;
    }

    /**
     * 设置：文本
     */
    public void setKjyyText(String kjyyText) {
        this.kjyyText = kjyyText;
    }

    /**
     * 获取：文本
     */
    public String getKjyyText() {
        return kjyyText;
    }

    /**
     * 设置：备注
     */
    public void setKjyyBeizhu(String kjyyBeizhu) {
        this.kjyyBeizhu = kjyyBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getKjyyBeizhu() {
        return kjyyBeizhu;
    }
}