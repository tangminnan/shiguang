package com.shiguang.jiekou.domain;

import java.io.Serializable;


/**
 * 框架远用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 18:56:26
 */
public class KjyyJKDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //框架远用id
    private Long kjyyId;
    //处方类型
    private String kjyyPrescriptionType;
    //卡号
    private String cardNumber;
    //销售单号
    private String saleNumber;
    //医生
    private String kjyyDoctor;
    //验光师
    private String kjyyOptometryName;
    //球镜OD
    private String kjyySphod;
    //球镜OS
    private String kjyySphos;
    //柱镜OD
    private String kjyyCylod;
    //柱镜OS
    private String kjyyCylos;
    //轴向OD
    private String kjyyAxialod;
    //轴向OS
    private String kjyyAxialos;
    //三棱镜(OD)
    private String kjyyPrismod;
    //三棱镜(OS)
    private String kjyyPrismos;
    //基底(OD)
    private String kjyyJdod;
    //基底(OS)
    private String kjyyJdos;
    //远用瞳距(mm)(OD)
    private String kjyyYytjod;
    //远用瞳距(mm)(OS)
    private String kjyyYytjos;
    //瞳高(mm)(OD)
    private String kjyyTgod;
    //瞳高(mm)(OS)
    private String kjyyTgos;
    //远用va(OD)
    private String kjyyVaod;
    //远用va(OS)
    private String kjyyVaos;
    //备注
    private String kjyyBeizhu;
    //删除状态
    private String status;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
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
     * 销售单号
     */
    public void setSaleNumber(String saleNumber){this.saleNumber = saleNumber;}

    /**
     * 销售单号
     */
    public String getSaleNumber() {return saleNumber;}

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
    public void setKjyySphod(String kjyySphod) {
        this.kjyySphod = kjyySphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getKjyySphod() {
        return kjyySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjyySphos(String kjyySphos) {
        this.kjyySphos = kjyySphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getKjyySphos() {
        return kjyySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjyyCylod(String kjyyCylod) {
        this.kjyyCylod = kjyyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getKjyyCylod() {
        return kjyyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjyyCylos(String kjyyCylos) {
        this.kjyyCylos = kjyyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getKjyyCylos() {
        return kjyyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjyyAxialod(String kjyyAxialod) {
        this.kjyyAxialod = kjyyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getKjyyAxialod() {
        return kjyyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjyyAxialos(String kjyyAxialos) {
        this.kjyyAxialos = kjyyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getKjyyAxialos() {
        return kjyyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjyyPrismod(String kjyyPrismod) {
        this.kjyyPrismod = kjyyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getKjyyPrismod() {
        return kjyyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjyyPrismos(String kjyyPrismos) {
        this.kjyyPrismos = kjyyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getKjyyPrismos() {
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
    public void setKjyyYytjod(String kjyyYytjod) {
        this.kjyyYytjod = kjyyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getKjyyYytjod() {
        return kjyyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjyyYytjos(String kjyyYytjos) {
        this.kjyyYytjos = kjyyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getKjyyYytjos() {
        return kjyyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjyyTgod(String kjyyTgod) {
        this.kjyyTgod = kjyyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getKjyyTgod() {
        return kjyyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjyyTgos(String kjyyTgos) {
        this.kjyyTgos = kjyyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getKjyyTgos() {
        return kjyyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjyyVaod(String kjyyVaod) {
        this.kjyyVaod = kjyyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getKjyyVaod() {
        return kjyyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjyyVaos(String kjyyVaos) {
        this.kjyyVaos = kjyyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getKjyyVaos() {
        return kjyyVaos;
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
    private String ptometryNumber;

    public String getPtometryNumber() {
        return ptometryNumber;
    }

    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }
}
