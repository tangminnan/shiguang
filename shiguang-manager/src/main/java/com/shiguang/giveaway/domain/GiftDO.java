package com.shiguang.giveaway.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-05 15:49:05
 */
public class GiftDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//赠品代码
	private String giftNum;
	//赠品名称
	private String giftName;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：赠品代码
	 */
	public void setGiftNum(String giftNum) {
		this.giftNum = giftNum;
	}
	/**
	 * 获取：赠品代码
	 */
	public String getGiftNum() {
		return giftNum;
	}
	/**
	 * 设置：赠品名称
	 */
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	/**
	 * 获取：赠品名称
	 */
	public String getGiftName() {
		return giftName;
	}
}
