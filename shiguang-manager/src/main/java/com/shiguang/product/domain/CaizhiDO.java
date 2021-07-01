package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 材质表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class CaizhiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//材质id
	private Long caizhiId;
	//材质
	private String caizhi;

	/**
	 * 设置：材质id
	 */
	public void setCaizhiId(Long caizhiId) {
		this.caizhiId = caizhiId;
	}
	/**
	 * 获取：材质id
	 */
	public Long getCaizhiId() {
		return caizhiId;
	}
	/**
	 * 设置：材质
	 */
	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}
	/**
	 * 获取：材质
	 */
	public String getCaizhi() {
		return caizhi;
	}
}
