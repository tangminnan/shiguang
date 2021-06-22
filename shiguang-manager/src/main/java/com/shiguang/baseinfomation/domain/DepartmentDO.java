package com.shiguang.baseinfomation.domain;

import java.io.Serializable;
import java.util.Date;

public class DepartmentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //部门编码
    private String departNumber;
    //部门名称
    private String departName;
    //部门全称
    private String departFullName;
    //部门电话
    private String departTel;
    //部门地址
    private String departAddress;
    //部门类型
    private String departType;
    //所属公司
    private Integer companyId;
    //所属公司名称
    private String name;
    //负责人
    private String personCharge;
    //部门状态(0:禁用1:启用)
    private Long status;
    //所属加工中心
    private String fanuc;
    //成品取镜时间
    private Long mirror;
    //销售方式(0:验光+销售+收银1:验光+销售)
    private Long sellWays;
    //隐形和护理液同单销售(0:可以同单销售1:不可以同单销售2:未设置)
    private Long sameSell;
    //读取读卡器方式
    private Long readCard;
    //公司名称
    private String companyName;
    //状态(0:删除1:未删除)
    private Long state;

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
     * 设置：部门全称
     */
    public void setDepartFullName(String departFullName) {
        this.departFullName = departFullName;
    }
    /**
     * 获取：部门全称
     */
    public String getDepartFullName() {
        return departFullName;
    }
    /**
     * 设置：部门电话
     */
    public void setDepartTel(String departTel) {
        this.departTel = departTel;
    }
    /**
     * 获取：部门电话
     */
    public String getDepartTel() {
        return departTel;
    }
    /**
     * 设置：部门地址
     */
    public void setDepartAddress(String departAddress) {
        this.departAddress = departAddress;
    }
    /**
     * 获取：部门地址
     */
    public String getDepartAddress() {
        return departAddress;
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
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    /**
     * 获取：所属公司
     */
    public Integer getCompanyId() {
        return companyId;
    }
    /**
     * 设置：所属公司名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：所属公司名称
     */
    public String getName() {
        return name;
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
    /**
     * 设置：所属加工中心
     */
    public void setFanuc(String fanuc) {
        this.fanuc = fanuc;
    }
    /**
     * 获取：所属加工中心
     */
    public String getFanuc() {
        return fanuc;
    }
    /**
     * 设置：成品取镜时间
     */
    public void setMirror(Long mirror) {
        this.mirror = mirror;
    }
    /**
     * 获取：成品取镜时间
     */
    public Long getMirror() {
        return mirror;
    }
    /**
     * 设置：销售方式(0:验光+销售+收银1:验光+销售)
     */
    public void setSellWays(Long sellWays) {
        this.sellWays = sellWays;
    }
    /**
     * 获取：销售方式(0:验光+销售+收银1:验光+销售)
     */
    public Long getSellWays() {
        return sellWays;
    }
    /**
     * 设置：隐形和护理液同单销售(0:可以同单销售1:不可以同单销售2:未设置)
     */
    public void setSameSell(Long sameSell) {
        this.sameSell = sameSell;
    }
    /**
     * 获取：隐形和护理液同单销售(0:可以同单销售1:不可以同单销售2:未设置)
     */
    public Long getSameSell() {
        return sameSell;
    }
    /**
     * 设置：读取读卡器方式
     */
    public void setReadCard(Long readCard) {
        this.readCard = readCard;
    }
    /**
     * 获取：读取读卡器方式
     */
    public Long getReadCard() {
        return readCard;
    }
    /**
     * 设置：公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    /**
     * 获取：公司名称
     */
    public String getCompanyName() {
        return companyName;
    }
    /**
     * 设置：状态(0:删除1:未删除)
     */
    public void setState(Long state) {
        this.state = state;
    }
    /**
     * 获取：状态(0:删除1:未删除)
     */
    public Long getState() {
        return state;
    }
}
