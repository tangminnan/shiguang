package com.shiguang.logstatus.domain;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

public class WorkRecoedDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //员工账号
    private String userName;
    //类型
    private String type;
    //日期
    private Date dateTime;

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

    public void setUserName(String userName) {this.userName = userName;}

    public String getUserName() {return userName;}

    public void setType(String type) {this.type = type;}

    public String getType() {return type;}

    public void setDateTime(Date dateTime) {this.dateTime = dateTime;}

    public Date getDateTime() {return dateTime;}
}
