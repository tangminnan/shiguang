package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-03 17:10:26
 */
public class TryresultsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //试戴镜结果id
    private Long id;
    //球镜(右眼OD)
    private Double sphereRight;
    //球镜(左眼OS)
    private Double sphereLeft;
    //柱镜(右眼OD)
    private Double cylinderRight;
    //柱镜(左眼OS)
    private Double cylinderLeft;
    //轴向(右眼-OD)
    private Double axialRight;
    //轴向(左眼OS)
    private Double axialLeft;
    //DVA(右眼OD)
    private Double dvaRight;
    //DVA(左眼OS)
    private Double dvaLeft;
    //NVA(OD)
    private Double nvaRight;
    //NVA(OS)
    private Double nvaLeft;
    //三棱镜(OD)
    private Double prismRight;
    //三棱镜(OS)
    private Double prismLeft;
    //基底(OD)
    private String basalRight;
    //基底(OS)
    private String basalLeft;
    //瞳高(mm)(OD)
    private Double heightRight;
    //瞳高(mm)(OS)
    private Double heightLeft;
    //Add(OD)
    private Double addRight;
    //Add(OS)
    private Double addLeft;
    //远用瞳孔距(mm)(OD)
    private Double farRight;
    //远用瞳孔距(mm)(OS)
    private Double farLeft;
    //近用瞳孔距(mm)(OD)
    private Double nearRight;
    //近用瞳孔距(mm)(OS)
    private Double nearLeft;
    //验光号
    private String ptometryNumber;
    //验光师
    private String optometryName;
    //创建时间
    private Date createTime;

    /**
     * 设置：试戴镜结果id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：试戴镜结果id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRight(Double sphereRight) {
        this.sphereRight = sphereRight;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public Double getSphereRight() {
        return sphereRight;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeft(Double sphereLeft) {
        this.sphereLeft = sphereLeft;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public Double getSphereLeft() {
        return sphereLeft;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRight(Double cylinderRight) {
        this.cylinderRight = cylinderRight;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public Double getCylinderRight() {
        return cylinderRight;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeft(Double cylinderLeft) {
        this.cylinderLeft = cylinderLeft;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public Double getCylinderLeft() {
        return cylinderLeft;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRight(Double axialRight) {
        this.axialRight = axialRight;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public Double getAxialRight() {
        return axialRight;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeft(Double axialLeft) {
        this.axialLeft = axialLeft;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public Double getAxialLeft() {
        return axialLeft;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRight(Double dvaRight) {
        this.dvaRight = dvaRight;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public Double getDvaRight() {
        return dvaRight;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLeft(Double dvaLeft) {
        this.dvaLeft = dvaLeft;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public Double getDvaLeft() {
        return dvaLeft;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRight(Double nvaRight) {
        this.nvaRight = nvaRight;
    }

    /**
     * 获取：NVA(OD)
     */
    public Double getNvaRight() {
        return nvaRight;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLeft(Double nvaLeft) {
        this.nvaLeft = nvaLeft;
    }

    /**
     * 获取：NVA(OS)
     */
    public Double getNvaLeft() {
        return nvaLeft;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRight(Double prismRight) {
        this.prismRight = prismRight;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getPrismRight() {
        return prismRight;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLeft(Double prismLeft) {
        this.prismLeft = prismLeft;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getPrismLeft() {
        return prismLeft;
    }

    /**
     * 设置：基底(OD)
     */
    public void setBasalRight(String basalRight) {
        this.basalRight = basalRight;
    }

    /**
     * 获取：基底(OD)
     */
    public String getBasalRight() {
        return basalRight;
    }

    /**
     * 设置：基底(OS)
     */
    public void setBasalLeft(String basalLeft) {
        this.basalLeft = basalLeft;
    }

    /**
     * 获取：基底(OS)
     */
    public String getBasalLeft() {
        return basalLeft;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setHeightRight(Double heightRight) {
        this.heightRight = heightRight;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getHeightRight() {
        return heightRight;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setHeightLeft(Double heightLeft) {
        this.heightLeft = heightLeft;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getHeightLeft() {
        return heightLeft;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRight(Double addRight) {
        this.addRight = addRight;
    }

    /**
     * 获取：Add(OD)
     */
    public Double getAddRight() {
        return addRight;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLeft(Double addLeft) {
        this.addLeft = addLeft;
    }

    /**
     * 获取：Add(OS)
     */
    public Double getAddLeft() {
        return addLeft;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setFarRight(Double farRight) {
        this.farRight = farRight;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public Double getFarRight() {
        return farRight;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setFarLeft(Double farLeft) {
        this.farLeft = farLeft;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public Double getFarLeft() {
        return farLeft;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRight(Double nearRight) {
        this.nearRight = nearRight;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public Double getNearRight() {
        return nearRight;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLeft(Double nearLeft) {
        this.nearLeft = nearLeft;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public Double getNearLeft() {
        return nearLeft;
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
     * 设置：验光师
     */
    public void setOptometryName(String optometryName) {
        this.optometryName = optometryName;
    }

    /**
     * 获取：验光师
     */
    public String getOptometryName() {
        return optometryName;
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
}
