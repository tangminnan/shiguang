package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 隐形护理液表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:08:33
 */
public class HlyDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //隐形护理液id
    private Long id;
    //商品信息代码
    private String producNum;
    //商品条码
    private String producCode;
    //商品名称
    private String producName;
    //制造商id
    private Integer mfrsid;
    //商品品种
    private Integer brandid;
    //厂家型号
    private String factory;
    //商品编号
    private String proid;
    //计量单位
    private String unitid;
    //产品类型
    private String productType;
    //主容量
    private String mainCapacity;
    //次容量
    private String secondCapacity;
    //型号
    private String producFactory;
    //效期提醒上限（有效期前【】天提醒进入滞销状态）
    private Integer upday;
    //效期提醒下限（有效期前【】天提醒进入即将失效状态）
    private Integer downday;
    //税率(%)
    private String tax;
    //含税单价
    private String taxPrice;
    //批发价格
    private String tradePrice;
    //调货成本
    private String transferPrice;
    //标准零售价
    private String retailPrice;

    /**
     * 设置：隐形护理液id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：隐形护理液id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：商品信息代码
     */
    public void setProducNum(String producNum) {
        this.producNum = producNum;
    }

    /**
     * 获取：商品信息代码
     */
    public String getProducNum() {
        return producNum;
    }

    /**
     * 设置：商品条码
     */
    public void setProducCode(String producCode) {
        this.producCode = producCode;
    }

    /**
     * 获取：商品条码
     */
    public String getProducCode() {
        return producCode;
    }

    /**
     * 设置：商品名称
     */
    public void setProducName(String producName) {
        this.producName = producName;
    }

    /**
     * 获取：商品名称
     */
    public String getProducName() {
        return producName;
    }

    /**
     * 设置：制造商id
     */
    public void setMfrsid(Integer mfrsid) {
        this.mfrsid = mfrsid;
    }

    /**
     * 获取：制造商id
     */
    public Integer getMfrsid() {
        return mfrsid;
    }

    /**
     * 设置：商品品种
     */
    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    /**
     * 获取：商品品种
     */
    public Integer getBrandid() {
        return brandid;
    }

    /**
     * 设置：厂家型号
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }

    /**
     * 获取：厂家型号
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 设置：商品编号
     */
    public void setProid(String proid) {
        this.proid = proid;
    }

    /**
     * 获取：商品编号
     */
    public String getProid() {
        return proid;
    }

    /**
     * 设置：计量单位
     */
    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    /**
     * 获取：计量单位
     */
    public String getUnitid() {
        return unitid;
    }

    /**
     * 设置：产品类型
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 获取：产品类型
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置：主容量
     */
    public void setMainCapacity(String mainCapacity) {
        this.mainCapacity = mainCapacity;
    }

    /**
     * 获取：主容量
     */
    public String getMainCapacity() {
        return mainCapacity;
    }

    /**
     * 设置：次容量
     */
    public void setSecondCapacity(String secondCapacity) {
        this.secondCapacity = secondCapacity;
    }

    /**
     * 获取：次容量
     */
    public String getSecondCapacity() {
        return secondCapacity;
    }

    /**
     * 设置：型号
     */
    public void setProducFactory(String producFactory) {
        this.producFactory = producFactory;
    }

    /**
     * 获取：型号
     */
    public String getProducFactory() {
        return producFactory;
    }

    /**
     * 设置：效期提醒上限（有效期前【】天提醒进入滞销状态）
     */
    public void setUpday(Integer upday) {
        this.upday = upday;
    }

    /**
     * 获取：效期提醒上限（有效期前【】天提醒进入滞销状态）
     */
    public Integer getUpday() {
        return upday;
    }

    /**
     * 设置：效期提醒下限（有效期前【】天提醒进入即将失效状态）
     */
    public void setDownday(Integer downday) {
        this.downday = downday;
    }

    /**
     * 获取：效期提醒下限（有效期前【】天提醒进入即将失效状态）
     */
    public Integer getDownday() {
        return downday;
    }

    /**
     * 设置：税率(%)
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * 获取：税率(%)
     */
    public String getTax() {
        return tax;
    }

    /**
     * 设置：含税单价
     */
    public void setTaxPrice(String taxPrice) {
        this.taxPrice = taxPrice;
    }

    /**
     * 获取：含税单价
     */
    public String getTaxPrice() {
        return taxPrice;
    }

    /**
     * 设置：批发价格
     */
    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    /**
     * 获取：批发价格
     */
    public String getTradePrice() {
        return tradePrice;
    }

    /**
     * 设置：调货成本
     */
    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice;
    }

    /**
     * 获取：调货成本
     */
    public String getTransferPrice() {
        return transferPrice;
    }

    /**
     * 设置：标准零售价
     */
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取：标准零售价
     */
    public String getRetailPrice() {
        return retailPrice;
    }
}
