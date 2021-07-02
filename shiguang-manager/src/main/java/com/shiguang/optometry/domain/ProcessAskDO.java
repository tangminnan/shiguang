package com.shiguang.optometry.domain;

import java.io.Serializable;

public class ProcessAskDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //加工要求编码
    private String processNum;
    //加工要求
    private String processName;

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
     * 设置：加工要求编码
     */
    public void setProcessNum(String processNum) {
        this.processNum = processNum;
    }
    /**
     * 获取：加工要求编码
     */
    public String getProcessNum() {
        return processNum;
    }
    /**
     * 设置：加工要求
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }
    /**
     * 获取：加工要求
     */
    public String getProcessName() {
        return processName;
    }
}
