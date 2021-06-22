package com.shiguang.baseinfomation.domain;

import java.io.Serializable;
/**
 * 读卡器维护
 *
 * @author cyl
 * @email bushuo@163.com
 * @date 2021-06-10 09:49:35
 */
public class ReadDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //读卡方式id
    private String cardId;
    //读卡方式名称
    private String cardName;
    //扇区号
    private String areaCode;
    //块号
    private String blockCode;
    //密钥类型
    private String simpleType;
    //密钥值
    private String simpleValue;
    //数据转换类型
    private String dataFormat;
    //排序字段
    private String orderField;
    //是否截取字符串
    private String isCut;
    //备注
    private String remark;
    //状态(0:删除1:未删除)
    private Long status;

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
     * 设置：读卡方式id
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    /**
     * 获取：读卡方式id
     */
    public String getCardId() {
        return cardId;
    }
    /**
     * 设置：读卡方式名称
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    /**
     * 获取：读卡方式名称
     */
    public String getCardName() {
        return cardName;
    }
    /**
     * 设置：扇区号
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    /**
     * 获取：扇区号
     */
    public String getAreaCode() {
        return areaCode;
    }
    /**
     * 设置：块号
     */
    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }
    /**
     * 获取：块号
     */
    public String getBlockCode() {
        return blockCode;
    }
    /**
     * 设置：密钥类型
     */
    public void setSimpleType(String simpleType) {
        this.simpleType = simpleType;
    }
    /**
     * 获取：密钥类型
     */
    public String getSimpleType() {
        return simpleType;
    }
    /**
     * 设置：密钥值
     */
    public void setSimpleValue(String simpleValue) {
        this.simpleValue = simpleValue;
    }
    /**
     * 获取：密钥值
     */
    public String getSimpleValue() {
        return simpleValue;
    }
    /**
     * 设置：数据转换类型
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
    /**
     * 获取：数据转换类型
     */
    public String getDataFormat() {
        return dataFormat;
    }
    /**
     * 设置：排序字段
     */
    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }
    /**
     * 获取：排序字段
     */
    public String getOrderField() {
        return orderField;
    }
    /**
     * 设置：是否截取字符串
     */
    public void setIsCut(String isCut) {
        this.isCut = isCut;
    }
    /**
     * 获取：是否截取字符串
     */
    public String getIsCut() {
        return isCut;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
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
