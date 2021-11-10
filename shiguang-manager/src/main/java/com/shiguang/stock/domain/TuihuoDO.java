package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 退货表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
public class TuihuoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//退货id
	private Long id;
	//单据编号（退货号）
	private String tuihuoNum;
	//制单人
	private String zhidanPeople;
	//单据日期
	private String danjuDay;
	//制造商id
	private String mfrsid;
	//制造商（供应商）
	private String mfrsname;
	//发出仓位id
	private Long positionId;
	private String positionName;
	//备注
	private String beizhu;
	//商品信息id
	private Long goodsxinxiid;
	//商品品牌名称
	private String goodsbrandname;
	//商品代码
	private String goodsNum;
	//商品名称
	private String goodsName;
	private Integer goodsid;
	//型号
	private String factory;
	//单位
	private String unit;
	//可用库存
	private String goodsCount;
	//数量
	private String count;
	//商品条码
	private String goodsCode;
	//三种方式
	private String style;
	private String retailPrice;
	//库存对应单据号
	private String stockorder;

	public String getStockorder() {
		return stockorder;
	}

	public void setStockorder(String stockorder) {
		this.stockorder = stockorder;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * 设置：退货id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：退货id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：单据编号（退货号）
	 */
	public void setTuihuoNum(String tuihuoNum) {
		this.tuihuoNum = tuihuoNum;
	}
	/**
	 * 获取：单据编号（退货号）
	 */
	public String getTuihuoNum() {
		return tuihuoNum;
	}
	/**
	 * 设置：制单人
	 */
	public void setZhidanPeople(String zhidanPeople) {
		this.zhidanPeople = zhidanPeople;
	}
	/**
	 * 获取：制单人
	 */
	public String getZhidanPeople() {
		return zhidanPeople;
	}
	/**
	 * 设置：单据日期
	 */
	public void setDanjuDay(String danjuDay) {
		this.danjuDay = danjuDay;
	}
	/**
	 * 获取：单据日期
	 */
	public String getDanjuDay() {
		return danjuDay;
	}
	/**
	 * 设置：制造商id
	 */
	public void setMfrsid(String mfrsid) {
		this.mfrsid = mfrsid;
	}
	/**
	 * 获取：制造商id
	 */
	public String getMfrsid() {
		return mfrsid;
	}
	/**
	 * 设置：制造商（供应商）
	 */
	public void setMfrsname(String mfrsname) {
		this.mfrsname = mfrsname;
	}
	/**
	 * 获取：制造商（供应商）
	 */
	public String getMfrsname() {
		return mfrsname;
	}
	/**
	 * 设置：发出仓位id
	 */
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：发出仓位id
	 */
	public Long getPositionId() {
		return positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：商品信息id
	 */
	public void setGoodsxinxiid(Long goodsxinxiid) {
		this.goodsxinxiid = goodsxinxiid;
	}
	/**
	 * 获取：商品信息id
	 */
	public Long getGoodsxinxiid() {
		return goodsxinxiid;
	}
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

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsbrandname() {
		return goodsbrandname;
	}

	public void setGoodsbrandname(String goodsbrandname) {
		this.goodsbrandname = goodsbrandname;
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
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：可用库存
	 */
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	/**
	 * 获取：可用库存
	 */
	public String getGoodsCount() {
		return goodsCount;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public String getCount() {
		return count;
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
}
