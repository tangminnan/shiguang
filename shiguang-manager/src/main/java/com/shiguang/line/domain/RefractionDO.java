package com.shiguang.line.domain;

import java.io.Serializable;

public class RefractionDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //验光室
    private String refractionName;
    //验光师
    private String name;

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

    public void setRefractionName(String refractionName){this.refractionName = refractionName;}

    public String getRefractionName(){return refractionName;}

    public void setName(String name){this.name = name;}

    public String getName(){return name;}
}
