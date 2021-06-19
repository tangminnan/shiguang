package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 光度分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
public class LightDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//光度分类id
	private Integer id;
	//光度分类
	private String lightName;

	/**
	 * 设置：光度分类id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：光度分类id
	 */
	public Integer getId() {
		return id;
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
