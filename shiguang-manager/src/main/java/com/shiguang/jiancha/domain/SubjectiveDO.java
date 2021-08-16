package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 主观验光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 10:22:52
 */
public class SubjectiveDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主观验光id
    private Long id;
    //卡号
    private String cardNumber;
    //球镜(右眼OD)
    private String sphereRightz;
    //球镜(左眼OS)
    private String sphereLeftz;
    //柱镜(右眼OD)
    private String cylinderRightz;
    //柱镜(左眼OS)
    private String cylinderLeftz;
    //轴向(右眼-OD)
    private String axialRightz;
    //轴向(左眼OS)
    private String axialLeftz;
    //DVA(右眼OD)
    private String dvaRightz;
    //DVA(左眼OS)
    private String dvaLeftz;
    //NVA(OD)
    private String nvaRightz;
    //NVA(OS)
    private String nvaLeftz;
    //三棱镜(OD)
    private String prismRightz;
    //三棱镜(OS)
    private String prismLeftz;
    //基底(OD)
    private String jdrZ;
    //基底(OS)
    private String jdlZ;
    //Add(OD)
    private String addRightz;
    //Add(OS)
    private String addLeftz;
    //远用瞳孔距(mm)(OD)
    private String yuanRz;
    //远用瞳孔距(mm)(OS)
    private String yuanLz;
    //近用瞳孔距(mm)(OD)
    private String nearRightz;
    //近用瞳孔距(mm)(OS)
    private String nearLeftz;

    /**
     * 设置：主观验光id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主观验光id
     */
    public Long getId() {
        return id;
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
     * 设置：球镜(右眼OD)
     */
    public void setSphereRightz(String sphereRightz) {
        this.sphereRightz = sphereRightz;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRightz() {
        return sphereRightz;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeftz(String sphereLeftz) {
        this.sphereLeftz = sphereLeftz;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLeftz() {
        return sphereLeftz;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRightz(String cylinderRightz) {
        this.cylinderRightz = cylinderRightz;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRightz() {
        return cylinderRightz;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeftz(String cylinderLeftz) {
        this.cylinderLeftz = cylinderLeftz;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLeftz() {
        return cylinderLeftz;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRightz(String axialRightz) {
        this.axialRightz = axialRightz;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRightz() {
        return axialRightz;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeftz(String axialLeftz) {
        this.axialLeftz = axialLeftz;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLeftz() {
        return axialLeftz;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRightz(String dvaRightz) {
        this.dvaRightz = dvaRightz;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public String getDvaRightz() {
        return dvaRightz;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLeftz(String dvaLeftz) {
        this.dvaLeftz = dvaLeftz;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public String getDvaLeftz() {
        return dvaLeftz;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRightz(String nvaRightz) {
        this.nvaRightz = nvaRightz;
    }

    /**
     * 获取：NVA(OD)
     */
    public String getNvaRightz() {
        return nvaRightz;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLeftz(String nvaLeftz) {
        this.nvaLeftz = nvaLeftz;
    }

    /**
     * 获取：NVA(OS)
     */
    public String getNvaLeftz() {
        return nvaLeftz;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRightz(String prismRightz) {
        this.prismRightz = prismRightz;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getPrismRightz() {
        return prismRightz;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLeftz(String prismLeftz) {
        this.prismLeftz = prismLeftz;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getPrismLeftz() {
        return prismLeftz;
    }

    /**
     * 设置：基底(OD)
     */
    public void setJdrZ(String jdrZ) {
        this.jdrZ = jdrZ;
    }

    /**
     * 获取：基底(OD)
     */
    public String getJdrZ() {
        return jdrZ;
    }

    /**
     * 设置：基底(OS)
     */
    public void setJdlZ(String jdlZ) {
        this.jdlZ = jdlZ;
    }

    /**
     * 获取：基底(OS)
     */
    public String getJdlZ() {
        return jdlZ;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRightz(String addRightz) {
        this.addRightz = addRightz;
    }

    /**
     * 获取：Add(OD)
     */
    public String getAddRightz() {
        return addRightz;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLeftz(String addLeftz) {
        this.addLeftz = addLeftz;
    }

    /**
     * 获取：Add(OS)
     */
    public String getAddLeftz() {
        return addLeftz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRz(String yuanRz) {
        this.yuanRz = yuanRz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public String getYuanRz() {
        return yuanRz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLz(String yuanLz) {
        this.yuanLz = yuanLz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public String getYuanLz() {
        return yuanLz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRightz(String nearRightz) {
        this.nearRightz = nearRightz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public String getNearRightz() {
        return nearRightz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLeftz(String nearLeftz) {
        this.nearLeftz = nearLeftz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public String getNearLeftz() {
        return nearLeftz;
    }
}
