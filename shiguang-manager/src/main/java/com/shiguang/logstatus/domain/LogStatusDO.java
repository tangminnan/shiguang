package com.shiguang.logstatus.domain;

import java.io.Serializable;
import java.util.Date;

public class LogStatusDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //销售单号
    private String saleNumber;
    //物流状态
    private String logisticStatus;
    //发料人
    private String faliaoName;
    //发料日期
    private Date faliaoDate;
    //焦度计球镜(OD)
    private Double jdjSphRight1;
    //焦度计柱镜(OD)
    private Double jdjCylRight1;
    //焦度计轴向(OD)
    private Double jdjZxRight1;
    //
    private Double jdjSphRight2;
    //
    private Double jdjCylRight2;
    //
    private Double jdjZxRight2;
    //斜视
    private String xieshiRight;
    //add(OD)
    private Double addRight;
    //瞳距(OD)
    private Double tjRight;
    //
    private Double jdjSphLeft1;
    //
    private Double jdjCylLeft1;
    //
    private Double jdjZxLeft1;
    //
    private Double jdjSphLeft2;
    //
    private Double jdjCylLeft2;
    //
    private Double jdjZxLeft2;
    //
    private String xieshiLeft;
    //
    private Double addLeft;
    //
    private Double tjLeft;

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
     * 设置：销售单号
     */
    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }
    /**
     * 获取：销售单号
     */
    public String getSaleNumber() {
        return saleNumber;
    }
    /**
     * 设置：物流状态
     */
    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }
    /**
     * 获取：物流状态
     */
    public String getLogisticStatus() {
        return logisticStatus;
    }

    public void setFaliaoName(String faliaoName) {this.faliaoName = faliaoName;}

    public String getFaliaoName() {return faliaoName;}

    public void setFaliaoDate(Date faliaoDate) {this.faliaoDate = faliaoDate;}

    public Date getFaliaoDate() {return faliaoDate;}
    /**
     * 设置：焦度计球镜(OD)
     */
    public void setJdjSphRight1(Double jdjSphRight1) {
        this.jdjSphRight1 = jdjSphRight1;
    }
    /**
     * 获取：焦度计球镜(OD)
     */
    public Double getJdjSphRight1() {
        return jdjSphRight1;
    }
    /**
     * 设置：焦度计柱镜(OD)
     */
    public void setJdjCylRight1(Double jdjCylRight1) {
        this.jdjCylRight1 = jdjCylRight1;
    }
    /**
     * 获取：焦度计柱镜(OD)
     */
    public Double getJdjCylRight1() {
        return jdjCylRight1;
    }
    /**
     * 设置：焦度计轴向(OD)
     */
    public void setJdjZxRight1(Double jdjZxRight1) {
        this.jdjZxRight1 = jdjZxRight1;
    }
    /**
     * 获取：焦度计轴向(OD)
     */
    public Double getJdjZxRight1() {
        return jdjZxRight1;
    }
    /**
     * 设置：
     */
    public void setJdjSphRight2(Double jdjSphRight2) {
        this.jdjSphRight2 = jdjSphRight2;
    }
    /**
     * 获取：
     */
    public Double getJdjSphRight2() {
        return jdjSphRight2;
    }
    /**
     * 设置：
     */
    public void setJdjCylRight2(Double jdjCylRight2) {
        this.jdjCylRight2 = jdjCylRight2;
    }
    /**
     * 获取：
     */
    public Double getJdjCylRight2() {
        return jdjCylRight2;
    }
    /**
     * 设置：
     */
    public void setJdjZxRight2(Double jdjZxRight2) {
        this.jdjZxRight2 = jdjZxRight2;
    }
    /**
     * 获取：
     */
    public Double getJdjZxRight2() {
        return jdjZxRight2;
    }
    /**
     * 设置：斜视
     */
    public void setXieshiRight(String xieshiRight) {
        this.xieshiRight = xieshiRight;
    }
    /**
     * 获取：斜视
     */
    public String getXieshiRight() {
        return xieshiRight;
    }
    /**
     * 设置：add(OD)
     */
    public void setAddRight(Double addRight) {
        this.addRight = addRight;
    }
    /**
     * 获取：add(OD)
     */
    public Double getAddRight() {
        return addRight;
    }
    /**
     * 设置：瞳距(OD)
     */
    public void setTjRight(Double tjRight) {
        this.tjRight = tjRight;
    }
    /**
     * 获取：瞳距(OD)
     */
    public Double getTjRight() {
        return tjRight;
    }
    /**
     * 设置：
     */
    public void setJdjSphLeft1(Double jdjSphLeft1) {
        this.jdjSphLeft1 = jdjSphLeft1;
    }
    /**
     * 获取：
     */
    public Double getJdjSphLeft1() {
        return jdjSphLeft1;
    }
    /**
     * 设置：
     */
    public void setJdjCylLeft1(Double jdjCylLeft1) {
        this.jdjCylLeft1 = jdjCylLeft1;
    }
    /**
     * 获取：
     */
    public Double getJdjCylLeft1() {
        return jdjCylLeft1;
    }
    /**
     * 设置：
     */
    public void setJdjZxLeft1(Double jdjZxLeft1) {
        this.jdjZxLeft1 = jdjZxLeft1;
    }
    /**
     * 获取：
     */
    public Double getJdjZxLeft1() {
        return jdjZxLeft1;
    }
    /**
     * 设置：
     */
    public void setJdjSphLeft2(Double jdjSphLeft2) {
        this.jdjSphLeft2 = jdjSphLeft2;
    }
    /**
     * 获取：
     */
    public Double getJdjSphLeft2() {
        return jdjSphLeft2;
    }
    /**
     * 设置：
     */
    public void setJdjCylLeft2(Double jdjCylLeft2) {
        this.jdjCylLeft2 = jdjCylLeft2;
    }
    /**
     * 获取：
     */
    public Double getJdjCylLeft2() {
        return jdjCylLeft2;
    }
    /**
     * 设置：
     */
    public void setJdjZxLeft2(Double jdjZxLeft2) {
        this.jdjZxLeft2 = jdjZxLeft2;
    }
    /**
     * 获取：
     */
    public Double getJdjZxLeft2() {
        return jdjZxLeft2;
    }
    /**
     * 设置：
     */
    public void setXieshiLeft(String xieshiLeft) {
        this.xieshiLeft = xieshiLeft;
    }
    /**
     * 获取：
     */
    public String getXieshiLeft() {
        return xieshiLeft;
    }
    /**
     * 设置：
     */
    public void setAddLeft(Double addLeft) {
        this.addLeft = addLeft;
    }
    /**
     * 获取：
     */
    public Double getAddLeft() {
        return addLeft;
    }
    /**
     * 设置：
     */
    public void setTjLeft(Double tjLeft) {
        this.tjLeft = tjLeft;
    }
    /**
     * 获取：
     */
    public Double getTjLeft() {
        return tjLeft;
    }
}
