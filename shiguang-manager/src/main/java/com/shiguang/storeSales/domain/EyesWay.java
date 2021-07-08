package com.shiguang.storeSales.domain;

import java.io.Serializable;

/**
 * 取镜方式
 */
public class EyesWay implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //会员卡号
    private String wayNum;
    //销售人员
    private String eyeWay;
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
    public void setWayNum(String wayNum) {this.wayNum = wayNum;}

    public String getWayNum(){return wayNum;}

    public void setEyeWay(String eyeWay) {this.eyeWay = eyeWay;}

    public String getEyeWay() {return eyeWay;}
}
