package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 制造商与商品类别关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */
public class MfrsGoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//制造商——商品类别id
	private Integer id;
	//制造商代码
	private String mfrsnum;
	//商品类别代码
	private String goodsnum;

	/**
	 * 设置：制造商——商品类别id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：制造商——商品类别id
	 */
	public Integer getId() {
		return id;
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
	 * 设置：商品类别代码
	 */
	public void setGoodsnum(String goodsnum) {
		this.goodsnum = goodsnum;
	}
	/**
	 * 获取：商品类别代码
	 */
	public String getGoodsnum() {
		return goodsnum;
	}
}
