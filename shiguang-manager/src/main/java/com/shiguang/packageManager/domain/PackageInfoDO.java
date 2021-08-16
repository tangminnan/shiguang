package com.shiguang.packageManager.domain;

import java.io.Serializable;

public class PackageInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //套餐id
    private String packageId;
    //商品类型
    private String goodsType;
    //商品代码
    private String goodsCode;
    //商品名称
    private String goodsName;
    //购买方式
    private Long buyWay;
    //商品原价区间开始
    private String originalStartPrice;
    //商品原价区间结束
    private String originalEndPrice;
    //套餐价格区间开始
    private String packageStartPrice;
    //套餐价格区间结束
    private String packageEndPrice;
    //销售数量
    private String saleNumber;
    //消费满(开始价格)
    private String fullStartPrice;
    //消费满(结束价格)
    private String fullEndPrice;
    //优惠方式
    private String preferentialWay;
    //套餐单价
    private String unitPrice;
    //特价金额
    private String specialPrice;
    //优惠金额
    private String preferentialPrice;
    //优惠折扣
    private String preferentialRebate;

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
     * 设置：套餐id
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    /**
     * 获取：套餐id
     */
    public String getPackageId() {
        return packageId;
    }
    /**
     * 设置：商品类型
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
    /**
     * 获取：商品类型
     */
    public String getGoodsType() {
        return goodsType;
    }
    /**
     * 设置：商品代码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    /**
     * 获取：商品代码
     */
    public String getGoodsCode() {
        return goodsCode;
    }
    /**
     * 设置：商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
     * 获取：商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }
    /**
     * 设置：购买方式
     */
    public void setBuyWay(Long buyWay) {
        this.buyWay = buyWay;
    }
    /**
     * 获取：购买方式
     */
    public Long getBuyWay() {
        return buyWay;
    }
    /**
     * 设置：商品原价区间开始
     */
    public void setOriginalStartPrice(String originalStartPrice) {
        this.originalStartPrice = originalStartPrice;
    }
    /**
     * 获取：商品原价区间开始
     */
    public String getOriginalStartPrice() {
        return originalStartPrice;
    }
    /**
     * 设置：商品原价区间结束
     */
    public void setOriginalEndPrice(String originalEndPrice) {
        this.originalEndPrice = originalEndPrice;
    }
    /**
     * 获取：商品原价区间结束
     */
    public String getOriginalEndPrice() {
        return originalEndPrice;
    }
    /**
     * 设置：套餐价格区间开始
     */
    public void setPackageStartPrice(String packageStartPrice) {
        this.packageStartPrice = packageStartPrice;
    }
    /**
     * 获取：套餐价格区间开始
     */
    public String getPackageStartPrice() {
        return packageStartPrice;
    }
    /**
     * 设置：套餐价格区间结束
     */
    public void setPackageEndPrice(String packageEndPrice) {
        this.packageEndPrice = packageEndPrice;
    }
    /**
     * 获取：套餐价格区间结束
     */
    public String getPackageEndPrice() {
        return packageEndPrice;
    }
    /**
     * 设置：销售数量
     */
    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }
    /**
     * 获取：销售数量
     */
    public String getSaleNumber() {
        return saleNumber;
    }
    /**
     * 设置：消费满(开始价格)
     */
    public void setFullStartPrice(String fullStartPrice) {
        this.fullStartPrice = fullStartPrice;
    }
    /**
     * 获取：消费满(开始价格)
     */
    public String getFullStartPrice() {
        return fullStartPrice;
    }
    /**
     * 设置：消费满(结束价格)
     */
    public void setFullEndPrice(String fullEndPrice) {
        this.fullEndPrice = fullEndPrice;
    }
    /**
     * 获取：消费满(结束价格)
     */
    public String getFullEndPrice() {
        return fullEndPrice;
    }
    /**
     * 设置：优惠方式
     */
    public void setPreferentialWay(String preferentialWay) {
        this.preferentialWay = preferentialWay;
    }
    /**
     * 获取：优惠方式
     */
    public String getPreferentialWay() {
        return preferentialWay;
    }
    /**
     * 设置：套餐单价
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
    /**
     * 获取：套餐单价
     */
    public String getUnitPrice() {
        return unitPrice;
    }
    /**
     * 设置：特价金额
     */
    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }
    /**
     * 获取：特价金额
     */
    public String getSpecialPrice() {
        return specialPrice;
    }
    /**
     * 设置：优惠金额
     */
    public void setPreferentialPrice(String preferentialPrice) {
        this.preferentialPrice = preferentialPrice;
    }
    /**
     * 获取：优惠金额
     */
    public String getPreferentialPrice() {
        return preferentialPrice;
    }
    /**
     * 设置：优惠折扣
     */
    public void setPreferentialRebate(String preferentialRebate) {
        this.preferentialRebate = preferentialRebate;
    }
    /**
     * 获取：优惠折扣
     */
    public String getPreferentialRebate() {
        return preferentialRebate;
    }
}
