package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 框架双光/渐进表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 10:03:39
 */
public class SgjjDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //双光渐进id
    private Long sgjjId;
    //卡号
    private String cardNumber;
    //销售单号
    private String saleNumber;
    //处方类型
    private String sgjjPrescriptionType;
    //医生
    private String sgjjDoctor;
    //验光师
    private String sgjjOptometryName;
    //球镜OD
    private String sgjjSphod;
    //球镜OS
    private String sgjjSphos;
    //柱镜OD
    private String sgjjCylod;
    //柱镜OS
    private String sgjjCylos;
    //轴向OD
    private String sgjjAxialod;
    //轴向OS
    private String sgjjAxialos;
    //Add(OD)
    private String sgjjAddod;
    //Add(OS)
    private String sgjjAddos;
    //远用瞳距(mm)(OD)
    private String sgjjYytjod;
    //远用瞳距(mm)(OS)
    private String sgjjYytjos;
    //近用瞳距(mm)(OD)
    private String sgjjJytjod;
    //近用瞳距(mm)(OS)
    private String sgjjJytjos;
    //瞳高(mm)(OD)
    private String sgjjTgod;
    //瞳高(mm)(OS)
    private String sgjjTgos;
    //远用va(OD)
    private String sgjjYyvaod;
    //远用va(OS)
    private String sgjjYyvaos;
    //近用va(OD)
    private String sgjjJyvaod;
    //近用va(OS)
    private String sgjjJyvaos;
    //建议镜片材质
    private String sgjjJpcz;
    //处理方式
    private String sgjjClfs;
    //建议框架
    private String sgjjJykj;
    //框架类型
    private String sgjjKjlx;
    //文本
    private String sgjjText;
    //备注
    private String sgjjBeizhu;
    //删除状态
    private String status;
    //创建时间
    private Date createTime;

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
     * 设置：双光渐进id
     */
    public void setSgjjId(Long sgjjId) {
        this.sgjjId = sgjjId;
    }

    /**
     * 获取：双光渐进id
     */
    public Long getSgjjId() {
        return sgjjId;
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
    public void setSgjjPrescriptionType(String sgjjPrescriptionType) {
        this.sgjjPrescriptionType = sgjjPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getSgjjPrescriptionType() {
        return sgjjPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setSgjjDoctor(String sgjjDoctor) {
        this.sgjjDoctor = sgjjDoctor;
    }

    /**
     * 获取：医生
     */
    public String getSgjjDoctor() {
        return sgjjDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setSgjjOptometryName(String sgjjOptometryName) {
        this.sgjjOptometryName = sgjjOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getSgjjOptometryName() {
        return sgjjOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setSgjjSphod(String sgjjSphod) {
        this.sgjjSphod = sgjjSphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getSgjjSphod() {
        return sgjjSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSgjjSphos(String sgjjSphos) {
        this.sgjjSphos = sgjjSphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getSgjjSphos() {
        return sgjjSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSgjjCylod(String sgjjCylod) {
        this.sgjjCylod = sgjjCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getSgjjCylod() {
        return sgjjCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSgjjCylos(String sgjjCylos) {
        this.sgjjCylos = sgjjCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getSgjjCylos() {
        return sgjjCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSgjjAxialod(String sgjjAxialod) {
        this.sgjjAxialod = sgjjAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getSgjjAxialod() {
        return sgjjAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSgjjAxialos(String sgjjAxialos) {
        this.sgjjAxialos = sgjjAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getSgjjAxialos() {
        return sgjjAxialos;
    }

    /**
     * 设置：Add(OD)
     */
    public void setSgjjAddod(String sgjjAddod) {
        this.sgjjAddod = sgjjAddod;
    }

    /**
     * 获取：Add(OD)
     */
    public String getSgjjAddod() {
        return sgjjAddod;
    }

    /**
     * 设置：Add(OS)
     */
    public void setSgjjAddos(String sgjjAddos) {
        this.sgjjAddos = sgjjAddos;
    }

    /**
     * 获取：Add(OS)
     */
    public String getSgjjAddos() {
        return sgjjAddos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSgjjYytjod(String sgjjYytjod) {
        this.sgjjYytjod = sgjjYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getSgjjYytjod() {
        return sgjjYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSgjjYytjos(String sgjjYytjos) {
        this.sgjjYytjos = sgjjYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getSgjjYytjos() {
        return sgjjYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSgjjJytjod(String sgjjJytjod) {
        this.sgjjJytjod = sgjjJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public String getSgjjJytjod() {
        return sgjjJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSgjjJytjos(String sgjjJytjos) {
        this.sgjjJytjos = sgjjJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public String getSgjjJytjos() {
        return sgjjJytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setSgjjTgod(String sgjjTgod) {
        this.sgjjTgod = sgjjTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getSgjjTgod() {
        return sgjjTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setSgjjTgos(String sgjjTgos) {
        this.sgjjTgos = sgjjTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getSgjjTgos() {
        return sgjjTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSgjjYyvaod(String sgjjYyvaod) {
        this.sgjjYyvaod = sgjjYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getSgjjYyvaod() {
        return sgjjYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSgjjYyvaos(String sgjjYyvaos) {
        this.sgjjYyvaos = sgjjYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getSgjjYyvaos() {
        return sgjjYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSgjjJyvaod(String sgjjJyvaod) {
        this.sgjjJyvaod = sgjjJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public String getSgjjJyvaod() {
        return sgjjJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSgjjJyvaos(String sgjjJyvaos) {
        this.sgjjJyvaos = sgjjJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public String getSgjjJyvaos() {
        return sgjjJyvaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setSgjjJpcz(String sgjjJpcz) {
        this.sgjjJpcz = sgjjJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getSgjjJpcz() {
        return sgjjJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setSgjjClfs(String sgjjClfs) {
        this.sgjjClfs = sgjjClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getSgjjClfs() {
        return sgjjClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setSgjjJykj(String sgjjJykj) {
        this.sgjjJykj = sgjjJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getSgjjJykj() {
        return sgjjJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setSgjjKjlx(String sgjjKjlx) {
        this.sgjjKjlx = sgjjKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getSgjjKjlx() {
        return sgjjKjlx;
    }

    /**
     * 设置：文本
     */
    public void setSgjjText(String sgjjText) {
        this.sgjjText = sgjjText;
    }

    /**
     * 获取：文本
     */
    public String getSgjjText() {
        return sgjjText;
    }

    /**
     * 设置：备注
     */
    public void setSgjjBeizhu(String sgjjBeizhu) {
        this.sgjjBeizhu = sgjjBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getSgjjBeizhu() {
        return sgjjBeizhu;
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
