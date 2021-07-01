package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 隐形类别表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class InvisibleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//隐形类别id
	private Long invisibleId;
	//隐形类别
	private String invisible;

	/**
	 * 设置：隐形类别id
	 */
	public void setInvisibleId(Long invisibleId) {
		this.invisibleId = invisibleId;
	}
	/**
	 * 获取：隐形类别id
	 */
	public Long getInvisibleId() {
		return invisibleId;
	}
	/**
	 * 设置：隐形类别
	 */
	public void setInvisible(String invisible) {
		this.invisible = invisible;
	}
	/**
	 * 获取：隐形类别
	 */
	public String getInvisible() {
		return invisible;
	}
}
