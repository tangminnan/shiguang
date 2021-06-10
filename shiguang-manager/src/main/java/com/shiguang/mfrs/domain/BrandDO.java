package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 12:01:40
 */
public class BrandDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//品种id
	private Integer brandid;
	//品种代码
	private String brandnum;
	//品种名称
	private String brandname;
	//制造商简称
	private String mfrsname;
	//商品类别(1镜架、2配件、3镜片、4隐形)
	private String goodsid;
	//产地
	private String address;
	//计量单位
	private String unitid;
	//采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	private String payid;
	//批号管理(1是、2否)
	private String batchid;
	//厂家型号
	private String factory;
	//促销金额
	private Double money;
	//速记码
	private String shorthandcode;
	//生产企业许可证号
	private String productionkey;

	/**
	 * 设置：品种id
	 */
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	/**
	 * 获取：品种id
	 */
	public Integer getBrandid() {
		return brandid;
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
	 * 设置：制造商简称
	 */
	public void setMfrsname(String mfrsname) {
		this.mfrsname = mfrsname;
	}
	/**
	 * 获取：制造商简称
	 */
	public String getMfrsname() {
		return mfrsname;
	}
	/**
	 * 设置：商品类别(1镜架、2配件、3镜片、4隐形)
	 */
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 获取：商品类别(1镜架、2配件、3镜片、4隐形)
	 */
	public String getGoodsid() {
		return goodsid;
	}
	/**
	 * 设置：产地
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：产地
	 */
	public String getAddress() {
		return address;
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
	 * 设置：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	 */
	public void setPayid(String payid) {
		this.payid = payid;
	}
	/**
	 * 获取：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	 */
	public String getPayid() {
		return payid;
	}
	/**
	 * 设置：批号管理(1是、2否)
	 */
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	/**
	 * 获取：批号管理(1是、2否)
	 */
	public String getBatchid() {
		return batchid;
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
	 * 设置：促销金额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：促销金额
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：速记码
	 */
	public void setShorthandcode(String shorthandcode) {
		this.shorthandcode = shorthandcode;
	}
	/**
	 * 获取：速记码
	 */
	public String getShorthandcode() {
		return shorthandcode;
	}
	/**
	 * 设置：生产企业许可证号
	 */
	public void setProductionkey(String productionkey) {
		this.productionkey = productionkey;
	}
	/**
	 * 获取：生产企业许可证号
	 */
	public String getProductionkey() {
		return productionkey;
	}
}
