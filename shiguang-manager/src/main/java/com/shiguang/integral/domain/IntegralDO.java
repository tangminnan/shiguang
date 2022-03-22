package com.shiguang.integral.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 积分设置表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-06 15:20:18
 */
public class IntegralDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//商品类型
	private String goodsType;
	//部门编号
	private String storeNum;
	//部门名称
	private String storeName;
	//会员卡类型
	private String cardType;
	//1元兑换多少积分
	private String redeemPoints;
	//创建时间
	private Date createTime;
	//公司id
	private String companyId;

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
	 * 设置：部门编号
	 */
	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}
	/**
	 * 获取：部门编号
	 */
	public String getStoreNum() {
		return storeNum;
	}
	/**
	 * 设置：部门名称
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * 设置：会员卡类型
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：会员卡类型
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置：1元兑换多少积分
	 */
	public void setRedeemPoints(String redeemPoints) {
		this.redeemPoints = redeemPoints;
	}
	/**
	 * 获取：1元兑换多少积分
	 */
	public String getRedeemPoints() {
		return redeemPoints;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
