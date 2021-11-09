package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合格仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
public class StockqualifyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//合格仓id
	private Long positionId;
	//商品条码
	private String goodsCode;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：合格仓id
	 */
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：合格仓id
	 */
	public Long getPositionId() {
		return positionId;
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
