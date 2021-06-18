package com.shiguang.optometry.domain;

import java.io.Serializable;
import java.util.Date;

public class OptometryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //会员卡号
    private String memberInumber;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
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
    //创建时间
    private Date createTime;

    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：会员卡号
     */
    public void setMemberInumber(String memberInumber) {
        this.memberInumber = memberInumber;
    }
    /**
     * 获取：会员卡号
     */
    public String getMemberInumber() {
        return memberInumber;
    }
    /**
     * 设置：是否散瞳(0:散瞳前1:散瞳后)
     */
    public void setMydriasis(Long mydriasis) {
        this.mydriasis = mydriasis;
    }
    /**
     * 获取：是否散瞳(0:散瞳前1:散瞳后)
     */
    public Long getMydriasis() {
        return mydriasis;
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
