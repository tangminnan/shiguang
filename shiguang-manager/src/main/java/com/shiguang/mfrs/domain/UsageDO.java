package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 使用类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public class UsageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//使用类型id
	private Integer usageId;
	//使用类型
	private String usageName;

	/**
	 * 设置：使用类型id
	 */
	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}
	/**
	 * 获取：使用类型id
	 */
	public Integer getUsageId() {
		return usageId;
	}
	/**
	 * 设置：使用类型
	 */
	public void setUsageName(String usageName) {
		this.usageName = usageName;
	}
	/**
	 * 获取：使用类型
	 */
	public String getUsageName() {
		return usageName;
	}
}
