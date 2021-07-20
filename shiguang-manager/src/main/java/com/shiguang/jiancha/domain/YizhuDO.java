package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 18:47:47
 */
public class YizhuDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//医嘱id
	private Long yizhuId;
	//类型
	private String yizhuType;
	//医嘱
	private String yizhu;

	/**
	 * 设置：医嘱id
	 */
	public void setYizhuId(Long yizhuId) {
		this.yizhuId = yizhuId;
	}
	/**
	 * 获取：医嘱id
	 */
	public Long getYizhuId() {
		return yizhuId;
	}
	/**
	 * 设置：类型
	 */
	public void setYizhuType(String yizhuType) {
		this.yizhuType = yizhuType;
	}
	/**
	 * 获取：类型
	 */
	public String getYizhuType() {
		return yizhuType;
	}
	/**
	 * 设置：医嘱
	 */
	public void setYizhu(String yizhu) {
		this.yizhu = yizhu;
	}
	/**
	 * 获取：医嘱
	 */
	public String getYizhu() {
		return yizhu;
	}
}