package com.shiguang.retailprice.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 零售价价格调整表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
public class RetailpriceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//单据编号
	private String number;
	//制单日期
	private String day;
	//制单人
	private String people;
	//备注
	private String remarks;
	//商品代码
	private String num;
	//商品名称
	private String name;
	//制造商代码
	private String mfrsnum;
	//制造商名称
	private String mfrsname;
	//品种代码
	private String brandnum;
	//品种名称
	private String brandname;
	//型号
	private String factory;
	//原销售价格
	private String oldPrice;
	//调整价格
	private String newPrice;

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
	 * 设置：单据编号
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：单据编号
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：制单日期
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * 获取：制单日期
	 */
	public String getDay() {
		return day;
	}
	/**
	 * 设置：制单人
	 */
	public void setPeople(String people) {
		this.people = people;
	}
	/**
	 * 获取：制单人
	 */
	public String getPeople() {
		return people;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：商品代码
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 获取：商品代码
	 */
	public String getNum() {
		return num;
	}
	/**
	 * 设置：商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：制造商代码
	 */
	public void setMfrsnum(String mfrsnum) {
		this.mfrsnum = mfrsnum;
	}
	/**
	 * 获取：制造商代码
	 */
	public String getMfrsnum() {
		return mfrsnum;
	}
	/**
	 * 设置：制造商名称
	 */
	public void setMfrsname(String mfrsname) {
		this.mfrsname = mfrsname;
	}
	/**
	 * 获取：制造商名称
	 */
	public String getMfrsname() {
		return mfrsname;
	}
	/**
	 * 设置：品种代码
	 */
	public void setBrandnum(String brandnum) {
		this.brandnum = brandnum;
	}
	/**
	 * 获取：品种代码
	 */
	public String getBrandnum() {
		return brandnum;
	}
	/**
	 * 设置：品种名称
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	/**
	 * 获取：品种名称
	 */
	public String getBrandname() {
		return brandname;
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
	 * 设置：原销售价格
	 */
	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}
	/**
	 * 获取：原销售价格
	 */
	public String getOldPrice() {
		return oldPrice;
	}
	/**
	 * 设置：调整价格
	 */
	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}
	/**
	 * 获取：调整价格
	 */
	public String getNewPrice() {
		return newPrice;
	}
}
