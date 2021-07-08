package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-08 09:43:54
 */
public class ZijiaDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//商品信息代码
	private String producNum;
	//商品条码
	private String producCode;
	//商品名称
	private String producName;
	//型号
	private String producFactory;
	//零售价格
	private Double retailPrice;
	//色号
	private String producColor;

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
	 * 设置：零售价格
	 */
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * 获取：零售价格
	 */
	public Double getRetailPrice() {
		return retailPrice;
	}
	/**
	 * 设置：色号
	 */
	public void setProducColor(String producColor) {
		this.producColor = producColor;
	}
	/**
	 * 获取：色号
	 */
	public String getProducColor() {
		return producColor;
	}
}
