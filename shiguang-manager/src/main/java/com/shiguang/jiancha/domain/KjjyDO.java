package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 框架近用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 18:56:26
 */
public class KjjyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //框架近用id
    private Long kjjyId;
    //卡号
    private String cardNumber;
    //销售单号
    private String saleNumber;
    //处方类型
    private String kjjyPrescriptionType;
    //医生
    private String kjjyDoctor;
    //验光师
    private String kjjyOptometryName;
    //球镜OD
    private String kjjySphod;
    //球镜OS
    private String kjjySphos;
    //柱镜OD
    private String kjjyCylod;
    //柱镜OS
    private String kjjyCylos;
    //轴向OD
    private String kjjyAxialod;
    //轴向OS
    private String kjjyAxialos;
    //三棱镜(OD)
    private String kjjyPrismod;
    //三棱镜(OS)
    private String kjjyPrismos;
    //基底(OD)
    private String kjjyJdod;
    //基底(OS)
    private String kjjyJdos;
    //远用瞳距(mm)(OD)
    private String kjjyYytjod;
    //远用瞳距(mm)(OS)
    private String kjjyYytjos;
    //瞳高(mm)(OD)
    private String kjjyTgod;
    //瞳高(mm)(OS)
    private String kjjyTgos;
    //远用va(OD)
    private String kjjyVaod;
    //远用va(OS)
    private String kjjyVaos;
    //建议镜片材质
    private String kjjyJpcz;
    //处理方式
    private String kjjyClfs;
    //建议框架
    private String kjjyJykj;
    //框架类型
    private String kjjyKjlx;
    //文本
    private String kjjyText;
    //备注
    private String kjjyBeizhu;
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
     * 设置：框架近用id
     */
    public void setKjjyId(Long kjjyId) {
        this.kjjyId = kjjyId;
    }

    /**
     * 获取：框架近用id
     */
    public Long getKjjyId() {
        return kjjyId;
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
    public void setKjjyPrescriptionType(String kjjyPrescriptionType) {
        this.kjjyPrescriptionType = kjjyPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getKjjyPrescriptionType() {
        return kjjyPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setKjjyDoctor(String kjjyDoctor) {
        this.kjjyDoctor = kjjyDoctor;
    }

    /**
     * 获取：医生
     */
    public String getKjjyDoctor() {
        return kjjyDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setKjjyOptometryName(String kjjyOptometryName) {
        this.kjjyOptometryName = kjjyOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getKjjyOptometryName() {
        return kjjyOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setKjjySphod(String kjjySphod) {
        this.kjjySphod = kjjySphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getKjjySphod() {
        return kjjySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjjySphos(String kjjySphos) {
        this.kjjySphos = kjjySphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getKjjySphos() {
        return kjjySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjjyCylod(String kjjyCylod) {
        this.kjjyCylod = kjjyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getKjjyCylod() {
        return kjjyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjjyCylos(String kjjyCylos) {
        this.kjjyCylos = kjjyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getKjjyCylos() {
        return kjjyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjjyAxialod(String kjjyAxialod) {
        this.kjjyAxialod = kjjyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getKjjyAxialod() {
        return kjjyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjjyAxialos(String kjjyAxialos) {
        this.kjjyAxialos = kjjyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getKjjyAxialos() {
        return kjjyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjjyPrismod(String kjjyPrismod) {
        this.kjjyPrismod = kjjyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getKjjyPrismod() {
        return kjjyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjjyPrismos(String kjjyPrismos) {
        this.kjjyPrismos = kjjyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getKjjyPrismos() {
        return kjjyPrismos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setKjjyJdod(String kjjyJdod) {
        this.kjjyJdod = kjjyJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getKjjyJdod() {
        return kjjyJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setKjjyJdos(String kjjyJdos) {
        this.kjjyJdos = kjjyJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getKjjyJdos() {
        return kjjyJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setKjjyYytjod(String kjjyYytjod) {
        this.kjjyYytjod = kjjyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getKjjyYytjod() {
        return kjjyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjjyYytjos(String kjjyYytjos) {
        this.kjjyYytjos = kjjyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getKjjyYytjos() {
        return kjjyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjjyTgod(String kjjyTgod) {
        this.kjjyTgod = kjjyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getKjjyTgod() {
        return kjjyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjjyTgos(String kjjyTgos) {
        this.kjjyTgos = kjjyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getKjjyTgos() {
        return kjjyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjjyVaod(String kjjyVaod) {
        this.kjjyVaod = kjjyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getKjjyVaod() {
        return kjjyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjjyVaos(String kjjyVaos) {
        this.kjjyVaos = kjjyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getKjjyVaos() {
        return kjjyVaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setKjjyJpcz(String kjjyJpcz) {
        this.kjjyJpcz = kjjyJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getKjjyJpcz() {
        return kjjyJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setKjjyClfs(String kjjyClfs) {
        this.kjjyClfs = kjjyClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getKjjyClfs() {
        return kjjyClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setKjjyJykj(String kjjyJykj) {
        this.kjjyJykj = kjjyJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getKjjyJykj() {
        return kjjyJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setKjjyKjlx(String kjjyKjlx) {
        this.kjjyKjlx = kjjyKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getKjjyKjlx() {
        return kjjyKjlx;
    }

    /**
     * 设置：文本
     */
    public void setKjjyText(String kjjyText) {
        this.kjjyText = kjjyText;
    }

    /**
     * 获取：文本
     */
    public String getKjjyText() {
        return kjjyText;
    }

    /**
     * 设置：备注
     */
    public void setKjjyBeizhu(String kjjyBeizhu) {
        this.kjjyBeizhu = kjjyBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getKjjyBeizhu() {
        return kjjyBeizhu;
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
