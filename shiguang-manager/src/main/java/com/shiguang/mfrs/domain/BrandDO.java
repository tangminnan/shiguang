package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 品牌维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 18:07:13
 */
public class BrandDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//品牌id
	private Integer brandid;
	//品牌代码
	private String brandnum;
	//品牌名称
	private String brandname;
	//商品类别(1镜架、2配件、3镜片、4隐形)
	private String goodsid;
	//镜架材质名称
	private String materialname;
	//材料分类
	private String lensName;
	//光度分类
	private String lightName;
	//折射率值
	private String refractivityvalue;
	//镜片功能
	private String functionName;
	//渐进片分类
	private String gradualName;
	//制造商id
	private Integer mfrsid;
	//制造商简称
	private String mfrsname;
	//计量单位
	private String unitid;
	//产地
	private String address;
	//采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	private Integer payid;
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
	//状态(0:停用1:启用)
	private Long status;

	/**
	 * 设置：品牌id
	 */
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	/**
	 * 获取：品牌id
	 */
	public Integer getBrandid() {
		return brandid;
	}
	/**
	 * 设置：品牌代码
	 */
	public void setBrandnum(String brandnum) {
		this.brandnum = brandnum;
	}
	/**
	 * 获取：品牌代码
	 */
	public String getBrandnum() {
		return brandnum;
	}
	/**
	 * 设置：品牌名称
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandname() {
		return brandname;
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
	 * 设置：镜架材质名称
	 */
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	/**
	 * 获取：镜架材质名称
	 */
	public String getMaterialname() {
		return materialname;
	}
	/**
	 * 设置：材料分类
	 */
	public void setLensName(String lensName) {
		this.lensName = lensName;
	}
	/**
	 * 获取：材料分类
	 */
	public String getLensName() {
		return lensName;
	}
	/**
	 * 设置：光度分类
	 */
	public void setLightName(String lightName) {
		this.lightName = lightName;
	}
	/**
	 * 获取：光度分类
	 */
	public String getLightName() {
		return lightName;
	}
	/**
	 * 设置：折射率值
	 */
	public void setRefractivityvalue(String refractivityvalue) {
		this.refractivityvalue = refractivityvalue;
	}
	/**
	 * 获取：折射率值
	 */
	public String getRefractivityvalue() {
		return refractivityvalue;
	}
	/**
	 * 设置：镜片功能
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	/**
	 * 获取：镜片功能
	 */
	public String getFunctionName() {
		return functionName;
	}
	/**
	 * 设置：渐进片分类
	 */
	public void setGradualName(String gradualName) {
		this.gradualName = gradualName;
	}
	/**
	 * 获取：渐进片分类
	 */
	public String getGradualName() {
		return gradualName;
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
	 * 设置：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	 */
	public void setPayid(Integer payid) {
		this.payid = payid;
	}
	/**
	 * 获取：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
	 */
	public Integer getPayid() {
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
	/**
	 * 设置：状态(0:停用1:启用)
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:停用1:启用)
	 */
	public Long getStatus() {
		return status;
	}
}
