package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class DepartmentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //部门编码
    private String departNumber;
    //部门名称
    private String departName;
    //部门类型
    private String departType;
    //所属公司
    private String company;
    //负责人
    private String personCharge;
    //部门状态(0:禁用1:启用)
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
     * 设置：部门编码
     */
    public void setDepartNumber(String departNumber) {
        this.departNumber = departNumber;
    }
    /**
     * 获取：部门编码
     */
    public String getDepartNumber() {
        return departNumber;
    }
    /**
     * 设置：部门名称
     */
    public void setDepartName(String departName) {
        this.departName = departName;
    }
    /**
     * 获取：部门名称
     */
    public String getDepartName() {
        return departName;
    }
    /**
     * 设置：部门类型
     */
    public void setDepartType(String departType) {
        this.departType = departType;
    }
    /**
     * 获取：部门类型
     */
    public String getDepartType() {
        return departType;
    }
    /**
     * 设置：所属公司
     */
    public void setCompany(String company) {
        this.company = company;
    }
    /**
     * 获取：所属公司
     */
    public String getCompany() {
        return company;
    }
    /**
     * 设置：负责人
     */
    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
    }
    /**
     * 获取：负责人
     */
    public String getPersonCharge() {
        return personCharge;
    }
    /**
     * 设置：部门状态(0:禁用1:启用)
     */
    public void setStatus(Long status) {
        this.status = status;
    }
    /**
     * 获取：部门状态(0:禁用1:启用)
     */
    public Long getStatus() {
        return status;
    }
}
