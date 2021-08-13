package com.shiguang.mfrs.domain;

import java.io.Serializable;


/**
 * 折射率维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 18:30:49
 */
public class RefractivityDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //折射率id
    private Integer refractivityid;
    //折射率编码
    private String refractivitynum;
    //折射率值
    private String refractivityvalue;
    //状态(0:删除1:未删除)
    private Long state;

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    /**
     * 设置：折射率id
     */
    public void setRefractivityid(Integer refractivityid) {
        this.refractivityid = refractivityid;
    }

    /**
     * 获取：折射率id
     */
    public Integer getRefractivityid() {
        return refractivityid;
    }

    /**
     * 设置：折射率编码
     */
    public void setRefractivitynum(String refractivitynum) {
        this.refractivitynum = refractivitynum;
    }

    /**
     * 获取：折射率编码
     */
    public String getRefractivitynum() {
        return refractivitynum;
    }

    /**
     * 设置：折射率值
     */
    public void setRefractivityvalue(String refractivityvalue) {
        this.refractivityvalue = refractivityvalue;
    }

    /**
     * 获取：折射率值
     */
    public String getRefractivityvalue() {
        return refractivityvalue;
    }
}
