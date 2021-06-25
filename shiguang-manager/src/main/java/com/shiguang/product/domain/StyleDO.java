package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 款式表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
public class StyleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//款式id
	private Long styleId;
	//款式
	private String style;

	/**
	 * 设置：款式id
	 */
	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}
	/**
	 * 获取：款式id
	 */
	public Long getStyleId() {
		return styleId;
	}
	/**
	 * 设置：款式
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * 获取：款式
	 */
	public String getStyle() {
		return style;
	}
}
