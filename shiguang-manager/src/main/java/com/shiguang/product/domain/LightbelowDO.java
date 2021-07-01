package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 下加光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class LightbelowDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//下加光id
	private Long lightbelowId;
	//下加光
	private String lightbelow;

	/**
	 * 设置：下加光id
	 */
	public void setLightbelowId(Long lightbelowId) {
		this.lightbelowId = lightbelowId;
	}
	/**
	 * 获取：下加光id
	 */
	public Long getLightbelowId() {
		return lightbelowId;
	}
	/**
	 * 设置：下加光
	 */
	public void setLightbelow(String lightbelow) {
		this.lightbelow = lightbelow;
	}
	/**
	 * 获取：下加光
	 */
	public String getLightbelow() {
		return lightbelow;
	}
}
