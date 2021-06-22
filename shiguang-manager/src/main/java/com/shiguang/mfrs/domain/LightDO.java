package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 光度分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public class LightDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//光度分类id
	private Integer lightId;
	//光度分类
	private String lightName;

	/**
	 * 设置：光度分类id
	 */
	public void setLightId(Integer lightId) {
		this.lightId = lightId;
	}
	/**
	 * 获取：光度分类id
	 */
	public Integer getLightId() {
		return lightId;
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
}
