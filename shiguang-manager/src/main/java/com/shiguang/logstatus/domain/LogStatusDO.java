package com.shiguang.logstatus.domain;

import java.io.Serializable;

public class LogStatusDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //销售单号
    private String saleNumber;
    //物流状态
    private String logisticStatus;

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
}
