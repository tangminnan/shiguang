package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class PersonSortDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //人群编码
    private String crowdNumber;
    //人群分类名称
    private String crowdName;
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
     * 设置：人群编码
     */
    public void setCrowdNumber(String crowdNumber) {
        this.crowdNumber = crowdNumber;
    }
    /**
     * 获取：人群编码
     */
    public String getCrowdNumber() {
        return crowdNumber;
    }
    /**
     * 设置：人群分类名称
     */
    public void setCrowdName(String crowdName) {
        this.crowdName = crowdName;
    }
    /**
     * 获取：人群分类名称
     */
    public String getCrowdName() {
        return crowdName;
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
