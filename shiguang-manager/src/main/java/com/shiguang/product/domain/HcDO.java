package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 视光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 17:14:05
 */
public class HcDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//耗材id
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
	//型号
	private String producFactory;
	//商品编号
	private String proid;
	//其他商品大类
	private String big;
	//其他商品小类
	private String small;
	//计量单位
	private Integer unitid;
	//批号管理(1是、2否)
	private Integer batchid;
	//税率(%)
	private String tax;
	//含税单价
	private Double taxPrice;
	//批发价格
	private Double tradePrice;
	//调货成本
	private Double transferPrice;
	//标准零售价格
	private Double retailPrice;

	/**
	 * 设置：耗材id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：耗材id
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
	 * 设置：其他商品大类
	 */
	public void setBig(String big) {
		this.big = big;
	}
	/**
	 * 获取：其他商品大类
	 */
	public String getBig() {
		return big;
	}
	/**
	 * 设置：其他商品小类
	 */
	public void setSmall(String small) {
		this.small = small;
	}
	/**
	 * 获取：其他商品小类
	 */
	public String getSmall() {
		return small;
	}
	/**
	 * 设置：计量单位
	 */
	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	/**
	 * 获取：计量单位
	 */
	public Integer getUnitid() {
		return unitid;
	}
	/**
	 * 设置：批号管理(1是、2否)
	 */
	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}
	/**
	 * 获取：批号管理(1是、2否)
	 */
	public Integer getBatchid() {
		return batchid;
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
	public void setTaxPrice(Double taxPrice) {
		this.taxPrice = taxPrice;
	}
	/**
	 * 获取：含税单价
	 */
	public Double getTaxPrice() {
		return taxPrice;
	}
	/**
	 * 设置：批发价格
	 */
	public void setTradePrice(Double tradePrice) {
		this.tradePrice = tradePrice;
	}
	/**
	 * 获取：批发价格
	 */
	public Double getTradePrice() {
		return tradePrice;
	}
	/**
	 * 设置：调货成本
	 */
	public void setTransferPrice(Double transferPrice) {
		this.transferPrice = transferPrice;
	}
	/**
	 * 获取：调货成本
	 */
	public Double getTransferPrice() {
		return transferPrice;
	}
	/**
	 * 设置：标准零售价格
	 */
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * 获取：标准零售价格
	 */
	public Double getRetailPrice() {
		return retailPrice;
	}
}