package com.shiguang.system.domain;

import org.springframework.stereotype.Service;

import java.io.Serializable;

public class RoleTypeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //角色类型编码
    private Long roleNum;
    //角色类型
    private String type;

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
     * 设置：角色类型编码
     */
    public void setRoleNum(Long roleNum) {
        this.roleNum = roleNum;
    }
    /**
     * 获取：角色类型编码
     */
    public Long getRoleNum() {
        return roleNum;
    }
    /**
     * 设置：角色类型
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 获取：角色类型
     */
    public String getType() {
        return type;
    }
}
