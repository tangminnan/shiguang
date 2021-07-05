package com.shiguang.giveaway.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-05 11:09:07
 */
public class GiveawayDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//商品代码
	private String giveNumber;
	//
	private String giveName;
	//赠品简称
	private String giveJc;
	//活动门店
	private String stores;
	//赠品类型
	private Long giveType;
	private String giveTypeName;

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
	 * 设置：商品代码
	 */
	public void setGiveNumber(String giveNumber) {
		this.giveNumber = giveNumber;
	}
	/**
	 * 获取：商品代码
	 */
	public String getGiveNumber() {
		return giveNumber;
	}
	/**
	 * 设置：
	 */
	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}
	/**
	 * 获取：
	 */
	public String getGiveName() {
		return giveName;
	}
	/**
	 * 设置：赠品简称
	 */
	public void setGiveJc(String giveJc) {
		this.giveJc = giveJc;
	}
	/**
	 * 获取：赠品简称
	 */
	public String getGiveJc() {
		return giveJc;
	}
	/**
	 * 设置：活动门店
	 */
	public void setStores(String stores) {
		this.stores = stores;
	}
	/**
	 * 获取：活动门店
	 */
	public String getStores() {
		return stores;
	}
	/**
	 * 设置：赠品类型
	 */
	public void setGiveType(Long giveType) {
		this.giveType = giveType;
	}
	/**
	 * 获取：赠品类型
	 */
	public Long getGiveType() {
		return giveType;
	}

	public void setGiveTypeName(String giveTypeName) {this.giveTypeName = giveTypeName;}

	public String getGiveTypeName(){return giveTypeName;}
}
