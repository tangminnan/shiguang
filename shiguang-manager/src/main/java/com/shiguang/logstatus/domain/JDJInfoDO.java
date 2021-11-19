package com.shiguang.logstatus.domain;

import java.io.Serializable;

public class JDJInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Long id;
    //焦度计返回信息
    private String jdjInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJdjInfo() {
        return jdjInfo;
    }

    public void setJdjInfo(String jdjInfo) {
        this.jdjInfo = jdjInfo;
    }
}
