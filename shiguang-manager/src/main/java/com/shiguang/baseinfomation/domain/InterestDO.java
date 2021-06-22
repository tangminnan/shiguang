package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class InterestDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //兴趣编码
    private String interestNumber;
    //兴趣名称
    private String imterestName;
    //状态(0:删除1:未删除)
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
     * 设置：兴趣编码
     */
    public void setInterestNumber(String interestNumber) {
        this.interestNumber = interestNumber;
    }
    /**
     * 获取：兴趣编码
     */
    public String getInterestNumber() {
        return interestNumber;
    }
    /**
     * 设置：兴趣名称
     */
    public void setImterestName(String imterestName) {
        this.imterestName = imterestName;
    }
    /**
     * 获取：兴趣名称
     */
    public String getImterestName() {
        return imterestName;
    }
    /**
     * 设置：状态(0:删除1:未删除)
     */
    public void setStatus(Long status) {
        this.status = status;
    }
    /**
     * 获取：状态(0:删除1:未删除)
     */
    public Long getStatus() {
        return status;
    }
}
