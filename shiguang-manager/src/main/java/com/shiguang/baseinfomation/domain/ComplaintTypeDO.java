package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class ComplaintTypeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //投诉编码
    private String complaintCode;
    //投诉类型名称
    private String complaintName;
    //状态
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
     * 设置：投诉编码
     */
    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }
    /**
     * 获取：投诉编码
     */
    public String getComplaintCode() {
        return complaintCode;
    }
    /**
     * 设置：投诉类型名称
     */
    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }
    /**
     * 获取：投诉类型名称
     */
    public String getComplaintName() {
        return complaintName;
    }

    public void setStatus(Long status) {this.status = status;}

    public Long getStatus() {return status;}
}
