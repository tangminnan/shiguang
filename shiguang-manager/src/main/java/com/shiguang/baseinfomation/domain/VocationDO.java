package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class VocationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //职业编码
    private String vocationNumber;
    //职业名称
    private String vocationName;
    //状态(0:删除1:未删除)
    private Long status;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：职业编码
     */
    public void setVocationNumber(String vocationNumber) {
        this.vocationNumber = vocationNumber;
    }
    /**
     * 获取：职业编码
     */
    public String getVocationNumber() {
        return vocationNumber;
    }
    /**
     * 设置：职业名称
     */
    public void setVocationName(String vocationName) {
        this.vocationName = vocationName;
    }
    /**
     * 获取：职业名称
     */
    public String getVocationName() {
        return vocationName;
    }
    /**
     * 设置：状态(0:删除1:未删除)
     */
    public void setStatus(Long status) {
        this.status = status;
    }
    /**
     * 获取：状态(0:删除1:未删除)
     */
    public Long getStatus() {
        return status;
    }
}
