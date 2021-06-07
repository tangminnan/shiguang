package com.shiguang.baseinfomation.domain;

import java.io.Serializable;

public class CardTypeDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long id;
    //会员卡类型名称
    private String cardName;
    //积分范围
    private String integerFirst;
    //积分范围
    private Long integerLast;
    //升级后会员卡类型
    private String upgradeCard;
    //会员升级扣除积分数
    private Long integerNum;
    //按商品类型设置默认折扣
    private String discount;
    //设置为默认会员卡类型(0:默认1:否)
    private Long isDefault;
    //参与优惠活动(0:参与1:否)
    private Long isPartake;

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
     * 设置：会员卡类型名称
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    /**
     * 获取：会员卡类型名称
     */
    public String getCardName() {
        return cardName;
    }
    /**
     * 设置：积分范围
     */
    public void setIntegerFirst(String integerFirst) {
        this.integerFirst = integerFirst;
    }
    /**
     * 获取：积分范围
     */
    public String getIntegerFirst() {
        return integerFirst;
    }
    /**
     * 设置：积分范围
     */
    public void setIntegerLast(Long integerLast) {
        this.integerLast = integerLast;
    }
    /**
     * 获取：积分范围
     */
    public Long getIntegerLast() {
        return integerLast;
    }
    /**
     * 设置：升级后会员卡类型
     */
    public void setUpgradeCard(String upgradeCard) {
        this.upgradeCard = upgradeCard;
    }
    /**
     * 获取：升级后会员卡类型
     */
    public String getUpgradeCard() {
        return upgradeCard;
    }
    /**
     * 设置：会员升级扣除积分数
     */
    public void setIntegerNum(Long integerNum) {
        this.integerNum = integerNum;
    }
    /**
     * 获取：会员升级扣除积分数
     */
    public Long getIntegerNum() {
        return integerNum;
    }
    /**
     * 设置：按商品类型设置默认折扣
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    /**
     * 获取：按商品类型设置默认折扣
     */
    public String getDiscount() {
        return discount;
    }
    /**
     * 设置：设置为默认会员卡类型(0:默认1:否)
     */
    public void setIsDefault(Long isDefault) {
        this.isDefault = isDefault;
    }
    /**
     * 获取：设置为默认会员卡类型(0:默认1:否)
     */
    public Long getIsDefault() {
        return isDefault;
    }
    /**
     * 设置：参与优惠活动(0:参与1:否)
     */
    public void setIsPartake(Long isPartake) {
        this.isPartake = isPartake;
    }
    /**
     * 获取：参与优惠活动(0:参与1:否)
     */
    public Long getIsPartake() {
        return isPartake;
    }
}
