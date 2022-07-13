package com.shiguang.line.domain;

import java.io.Serializable;
import java.util.Date;

public class OpticianDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String room;
    private String ygName;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getYgName() {
        return ygName;
    }

    public void setYgName(String ygName) {
        this.ygName = ygName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
