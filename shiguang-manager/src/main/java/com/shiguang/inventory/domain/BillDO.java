package com.shiguang.inventory.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 盘点商品单表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
public class BillDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//盘点id
	private Long inventoryId;
	//商品代码
	private String goodsNum;
	//商品条码
	private String goodsCode;
	//商品名称
	private String goodsName;
	//商品效期
	private String goodsTime;
	//商品批号
	private String goodsBatch;
	//型号
	private String factory;
	//单位
	private String unitname;
	//帐存数量
	private String bookNum;
	//实存数量
	private String actualNum;
	//盈余数量
	private String surplus;

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
	 * 盘点id
	 */
	public void setInventoryId(Long inventoryId){this.inventoryId = inventoryId;}
	/**
	 * 盘点id
	 */
	public Long getInventoryId() {return inventoryId;}
	/**
	 * 设置：商品代码
	 */
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	/**
	 * 获取：商品代码
	 */
	public String getGoodsNum() {
		return goodsNum;
	}
	/**
	 * 设置：商品条码
	 */
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	/**
	 * 获取：商品条码
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
	 * 设置：商品效期
	 */
	public void setGoodsTime(String goodsTime) {
		this.goodsTime = goodsTime;
	}
	/**
	 * 获取：商品效期
	 */
	public String getGoodsTime() {
		return goodsTime;
	}
	/**
	 * 设置：商品批号
	 */
	public void setGoodsBatch(String goodsBatch) {
		this.goodsBatch = goodsBatch;
	}
	/**
	 * 获取：商品批号
	 */
	public String getGoodsBatch() {
		return goodsBatch;
	}
	/**
	 * 设置：型号
	 */
	public void setFactory(String factory) {
		this.factory = factory;
	}
	/**
	 * 获取：型号
	 */
	public String getFactory() {
		return factory;
	}
	/**
	 * 设置：单位
	 */
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	/**
	 * 获取：单位
	 */
	public String getUnitname() {
		return unitname;
	}
	/**
	 * 设置：帐存数量
	 */
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	/**
	 * 获取：帐存数量
	 */
	public String getBookNum() {
		return bookNum;
	}
	/**
	 * 设置：实存数量
	 */
	public void setActualNum(String actualNum) {
		this.actualNum = actualNum;
	}
	/**
	 * 获取：实存数量
	 */
	public String getActualNum() {
		return actualNum;
	}
	/**
	 * 设置：盈余数量
	 */
	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}
	/**
	 * 获取：盈余数量
	 */
	public String getSurplus() {
		return surplus;
	}
}
