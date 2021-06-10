package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 采购结算方式表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public class PayDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//采购结算方式id
	private Integer payid;
	//采购结算方式
	private String paymethod;

	/**
	 * 设置：采购结算方式id
	 */
	public void setPayid(Integer payid) {
		this.payid = payid;
	}
	/**
	 * 获取：采购结算方式id
	 */
	public Integer getPayid() {
		return payid;
	}
	/**
	 * 设置：采购结算方式
	 */
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	/**
	 * 获取：采购结算方式
	 */
	public String getPaymethod() {
		return paymethod;
	}
}
