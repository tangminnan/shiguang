package com.shiguang.unqualiffed.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 不合格表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
public class UnqualiffedDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//销售单号
	private String saleNumber;
	//制单人
	private String preparedName;
	//责任人
	private String responsibleName;
	//单据编号
	private String billNumber;
	//不合格原因
	private String cause;
	//所属现象
	private String phenomenon;
	//处理
	private String handle;
	//单据日期
	private Date billDate;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：销售单号
	 */
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	/**
	 * 获取：销售单号
	 */
	public String getSaleNumber() {
		return saleNumber;
	}
	/**
	 * 设置：制单人
	 */
	public void setPreparedName(String preparedName) {
		this.preparedName = preparedName;
	}
	/**
	 * 获取：制单人
	 */
	public String getPreparedName() {
		return preparedName;
	}
	/**
	 * 设置：责任人
	 */
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	/**
	 * 获取：责任人
	 */
	public String getResponsibleName() {
		return responsibleName;
	}
	/**
	 * 设置：单据编号
	 */
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	/**
	 * 获取：单据编号
	 */
	public String getBillNumber() {
		return billNumber;
	}
	/**
	 * 设置：不合格原因
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}
	/**
	 * 获取：不合格原因
	 */
	public String getCause() {
		return cause;
	}
	/**
	 * 设置：所属现象
	 */
	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
	}
	/**
	 * 获取：所属现象
	 */
	public String getPhenomenon() {
		return phenomenon;
	}
	/**
	 * 设置：处理
	 */
	public void setHandle(String handle) {
		this.handle = handle;
	}
	/**
	 * 获取：处理
	 */
	public String getHandle() {
		return handle;
	}
	/**
	 * 设置：单据日期
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	/**
	 * 获取：单据日期
	 */
	public Date getBillDate() {
		return billDate;
	}
}
