package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 制造商商品类别表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 17:52:47
 */
public class MgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//制造商商品类别id
	private Integer id;
	//商品id
	private Integer goodsid;
	//制造商id
	private Integer mfrsid;

	/**
	 * 设置：制造商商品类别id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：制造商商品类别id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：商品id
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getGoodsid() {
		return goodsid;
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
}
