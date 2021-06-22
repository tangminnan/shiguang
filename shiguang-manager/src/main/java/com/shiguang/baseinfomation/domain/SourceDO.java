package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class SourceDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //来源编号
    private String sourceNumber;
    //来源名称
    private String sourceName;
    //状态(0:删除1:未删除)
    private Long status;

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
     * 设置：来源编号
     */
    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
    }
    /**
     * 获取：来源编号
     */
    public String getSourceNumber() {
        return sourceNumber;
    }
    /**
     * 设置：来源名称
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    /**
     * 获取：来源名称
     */
    public String getSourceName() {
        return sourceName;
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
