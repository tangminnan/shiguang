package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 下加光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:26:17
 */
public class LightbelowDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//下加光id
	private Long id;
	//下加光
	private String lightBelow;

	/**
	 * 设置：下加光id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：下加光id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：下加光
	 */
	public void setLightBelow(String lightBelow) {
		this.lightBelow = lightBelow;
	}
	/**
	 * 获取：下加光
	 */
	public String getLightBelow() {
		return lightBelow;
	}
}
