package com.shiguang.logstatus.domain;

import java.io.Serializable;

public class LensMeterDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Long id;
    //球镜右
    private String rightSph;
    //柱镜右
    private String rightCyl;
    //轴向右
    private String rightZx;
    //球镜左
    private String leftSph;
    //柱镜左
    private String leftCyl;
    //轴向左
    private String leftZx;

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
     * 设置：球镜右
     */
    public void setRightSph(String rightSph) {
        this.rightSph = rightSph;
    }
    /**
     * 获取：球镜右
     */
    public String getRightSph() {
        return rightSph;
    }
    /**
     * 设置：柱镜右
     */
    public void setRightCyl(String rightCyl) {
        this.rightCyl = rightCyl;
    }
    /**
     * 获取：柱镜右
     */
    public String getRightCyl() {
        return rightCyl;
    }
    /**
     * 设置：轴向右
     */
    public void setRightZx(String rightZx) {
        this.rightZx = rightZx;
    }
    /**
     * 获取：轴向右
     */
    public String getRightZx() {
        return rightZx;
    }
    /**
     * 设置：球镜左
     */
    public void setLeftSph(String leftSph) {
        this.leftSph = leftSph;
    }
    /**
     * 获取：球镜左
     */
    public String getLeftSph() {
        return leftSph;
    }
    /**
     * 设置：柱镜左
     */
    public void setLeftCyl(String leftCyl) {
        this.leftCyl = leftCyl;
    }
    /**
     * 获取：柱镜左
     */
    public String getLeftCyl() {
        return leftCyl;
    }
    /**
     * 设置：轴向左
     */
    public void setLeftZx(String leftZx) {
        this.leftZx = leftZx;
    }
    /**
     * 获取：轴向左
     */
    public String getLeftZx() {
        return leftZx;
    }

}
