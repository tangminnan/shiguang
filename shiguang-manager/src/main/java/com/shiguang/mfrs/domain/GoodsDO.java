package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品类别表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品id
	private Integer goodsid;
	//商品类别
	private String goodsname;
	//商品代码
	private String goodsnum;

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
	 * 设置：商品类别
	 */
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	/**
	 * 获取：商品类别
	 */
	public String getGoodsname() {
		return goodsname;
	}
	/**
	 * 设置：商品代码
	 */
	public void setGoodsnum(String goodsnum) {
		this.goodsnum = goodsnum;
	}
	/**
	 * 获取：商品代码
	 */
	public String getGoodsnum() {
		return goodsnum;
	}
}
