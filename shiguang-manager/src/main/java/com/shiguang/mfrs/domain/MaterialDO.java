package com.shiguang.mfrs.domain;

import java.io.Serializable;


/**
 * 镜架材质表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 15:41:15
 */
public class MaterialDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //镜架材质id
    private Integer materialid;
    //镜架材质代码
    private String materialnum;
    //镜架材质名称
    private String materialname;
    //状态(0:删除1:未删除)
    private Long state;

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    /**
     * 设置：镜架材质id
     */
    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    /**
     * 获取：镜架材质id
     */
    public Integer getMaterialid() {
        return materialid;
    }

    /**
     * 设置：镜架材质代码
     */
    public void setMaterialnum(String materialnum) {
        this.materialnum = materialnum;
    }

    /**
     * 获取：镜架材质代码
     */
    public String getMaterialnum() {
        return materialnum;
    }

    /**
     * 设置：镜架材质名称
     */
    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    /**
     * 获取：镜架材质名称
     */
    public String getMaterialname() {
        return materialname;
    }
}
