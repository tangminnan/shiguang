package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 框架中用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:50:32
 */
public class ZyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //中用id
    private Long zyId;
    //卡号
    private String cardNumber;
    //销售单号
    private String saleNumber;
    //处方类型
    private String zyPrescriptionType;
    //医生
    private String zyDoctor;
    //验光师
    private String zyOptometryName;
    //球镜OD
    private String zySphod;
    //球镜OS
    private String zySphos;
    //柱镜OD
    private String zyCylod;
    //柱镜OS
    private String zyCylos;
    //轴向OD
    private String zyAxialod;
    //轴向OS
    private String zyAxialos;
    //三棱镜(OD)
    private String zyPrismod;
    //三棱镜(OS)
    private String zyPrismos;
    //基底(OD)
    private String zyJdod;
    //基底(OS)
    private String zyJdos;
    //中用瞳距(mm)(OD)
    private String zyZytjod;
    //中用瞳距(mm)(OS)
    private String zyZytjos;
    //瞳高(mm)(OD)
    private String zyTgod;
    //瞳高(mm)(OS)
    private String zyTgos;
    //中用va(OD)
    private String zyVaod;
    //中用va(OS)
    private String zyVaos;
    //建议镜片材质
    private String zyJpcz;
    //处理方式
    private String zyClfs;
    //建议镜框
    private String zyJyjk;
    //镜框类型
    private String zyJklx;
    //文本
    private String zyText;
    //备注
    private String zyBeizhu;
    //验光号
    private String ptometryNumber;

    public Long getZyId() {
        return zyId;
    }

    public void setZyId(Long zyId) {
        this.zyId = zyId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 销售单号
     */
    public void setSaleNumber(String saleNumber){this.saleNumber = saleNumber;}

    /**
     * 销售单号
     */
    public String getSaleNumber() {return saleNumber;}

    public String getZyPrescriptionType() {
        return zyPrescriptionType;
    }

    public void setZyPrescriptionType(String zyPrescriptionType) {
        this.zyPrescriptionType = zyPrescriptionType;
    }

    public String getZyDoctor() {
        return zyDoctor;
    }

    public void setZyDoctor(String zyDoctor) {
        this.zyDoctor = zyDoctor;
    }

    public String getZyOptometryName() {
        return zyOptometryName;
    }

    public void setZyOptometryName(String zyOptometryName) {
        this.zyOptometryName = zyOptometryName;
    }

    public String getZySphod() {
        return zySphod;
    }

    public void setZySphod(String zySphod) {
        this.zySphod = zySphod;
    }

    public String getZySphos() {
        return zySphos;
    }

    public void setZySphos(String zySphos) {
        this.zySphos = zySphos;
    }

    public String getZyCylod() {
        return zyCylod;
    }

    public void setZyCylod(String zyCylod) {
        this.zyCylod = zyCylod;
    }

    public String getZyCylos() {
        return zyCylos;
    }

    public void setZyCylos(String zyCylos) {
        this.zyCylos = zyCylos;
    }

    public String getZyAxialod() {
        return zyAxialod;
    }

    public void setZyAxialod(String zyAxialod) {
        this.zyAxialod = zyAxialod;
    }

    public String getZyAxialos() {
        return zyAxialos;
    }

    public void setZyAxialos(String zyAxialos) {
        this.zyAxialos = zyAxialos;
    }

    public String getZyPrismod() {
        return zyPrismod;
    }

    public void setZyPrismod(String zyPrismod) {
        this.zyPrismod = zyPrismod;
    }

    public String getZyPrismos() {
        return zyPrismos;
    }

    public void setZyPrismos(String zyPrismos) {
        this.zyPrismos = zyPrismos;
    }

    public String getZyJdod() {
        return zyJdod;
    }

    public void setZyJdod(String zyJdod) {
        this.zyJdod = zyJdod;
    }

    public String getZyJdos() {
        return zyJdos;
    }

    public void setZyJdos(String zyJdos) {
        this.zyJdos = zyJdos;
    }

    public String getZyZytjod() {
        return zyZytjod;
    }

    public void setZyZytjod(String zyZytjod) {
        this.zyZytjod = zyZytjod;
    }

    public String getZyZytjos() {
        return zyZytjos;
    }

    public void setZyZytjos(String zyZytjos) {
        this.zyZytjos = zyZytjos;
    }

    public String getZyTgod() {
        return zyTgod;
    }

    public void setZyTgod(String zyTgod) {
        this.zyTgod = zyTgod;
    }

    public String getZyTgos() {
        return zyTgos;
    }

    public void setZyTgos(String zyTgos) {
        this.zyTgos = zyTgos;
    }

    public String getZyVaod() {
        return zyVaod;
    }

    public void setZyVaod(String zyVaod) {
        this.zyVaod = zyVaod;
    }

    public String getZyVaos() {
        return zyVaos;
    }

    public void setZyVaos(String zyVaos) {
        this.zyVaos = zyVaos;
    }

    public String getZyJpcz() {
        return zyJpcz;
    }

    public void setZyJpcz(String zyJpcz) {
        this.zyJpcz = zyJpcz;
    }

    public String getZyClfs() {
        return zyClfs;
    }

    public void setZyClfs(String zyClfs) {
        this.zyClfs = zyClfs;
    }

    public String getZyJyjk() {
        return zyJyjk;
    }

    public void setZyJyjk(String zyJyjk) {
        this.zyJyjk = zyJyjk;
    }

    public String getZyJklx() {
        return zyJklx;
    }

    public void setZyJklx(String zyJklx) {
        this.zyJklx = zyJklx;
    }

    public String getZyText() {
        return zyText;
    }

    public void setZyText(String zyText) {
        this.zyText = zyText;
    }

    public String getZyBeizhu() {
        return zyBeizhu;
    }

    public void setZyBeizhu(String zyBeizhu) {
        this.zyBeizhu = zyBeizhu;
    }

    public String getPtometryNumber() {
        return ptometryNumber;
    }

    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }
}
