package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 老花镜度数表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 16:19:35
 */
public class OlddegreesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//老花镜度数id
	private Long oldId;
	//老花镜度数
	private String degrees;

	/**
	 * 设置：老花镜度数id
	 */
	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}
	/**
	 * 获取：老花镜度数id
	 */
	public Long getOldId() {
		return oldId;
	}
	/**
	 * 设置：老花镜度数
	 */
	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}
	/**
	 * 获取：老花镜度数
	 */
	public String getDegrees() {
		return degrees;
	}
}
