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
public class ZipianDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//商品代码
	private String producNum;
	//商品名称
	private String producName;
	//零售价格
	private Double retailPrice;
	//球镜
	private String sph;
	//柱镜
	private String cyl;
	//下加光
	private String lightbelow;
	//折射率
	private String refractivity;
	//光度分类
	private String light;
	//材料分类
	private String lens;

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
	public void setProducNum(String producNum) {
		this.producNum = producNum;
	}
	/**
	 * 获取：商品代码
	 */
	public String getProducNum() {
		return producNum;
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
	 * 设置：球镜
	 */
	public void setSph(String sph) {
		this.sph = sph;
	}
	/**
	 * 获取：球镜
	 */
	public String getSph() {
		return sph;
	}
	/**
	 * 设置：柱镜
	 */
	public void setCyl(String cyl) {
		this.cyl = cyl;
	}
	/**
	 * 获取：柱镜
	 */
	public String getCyl() {
		return cyl;
	}
	/**
	 * 设置：下加光
	 */
	public void setLightbelow(String lightbelow) {
		this.lightbelow = lightbelow;
	}
	/**
	 * 获取：下加光
	 */
	public String getLightbelow() {
		return lightbelow;
	}
	/**
	 * 设置：折射率
	 */
	public void setRefractivity(String refractivity) {
		this.refractivity = refractivity;
	}
	/**
	 * 获取：折射率
	 */
	public String getRefractivity() {
		return refractivity;
	}
	/**
	 * 设置：光度分类
	 */
	public void setLight(String light) {
		this.light = light;
	}
	/**
	 * 获取：光度分类
	 */
	public String getLight() {
		return light;
	}
	/**
	 * 设置：材料分类
	 */
	public void setLens(String lens) {
		this.lens = lens;
	}
	/**
	 * 获取：材料分类
	 */
	public String getLens() {
		return lens;
	}
}
