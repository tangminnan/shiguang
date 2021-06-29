package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 制造商品牌关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-28 13:49:46
 */
public class MbDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//制造商品牌id
	private Integer id;
	//制造商id
	private Integer mfrsid;
	//品牌id
	private Integer brandid;

	/**
	 * 设置：制造商品牌id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：制造商品牌id
	 */
	public Integer getId() {
		return id;
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
}
