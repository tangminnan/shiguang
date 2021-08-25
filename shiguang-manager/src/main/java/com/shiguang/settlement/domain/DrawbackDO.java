package com.shiguang.settlement.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 16:40:11
 */
public class DrawbackDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//退款单号
	private String drawbackNumber;
	//顾客姓名
	private String drawbackName;
	//退款金额
	private String drawbackMoney;
	//创建人
	private String createrName;
	//退款时间
	private Date createTime;

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
	 * 设置：退款单号
	 */
	public void setDrawbackNumber(String drawbackNumber) {
		this.drawbackNumber = drawbackNumber;
	}
	/**
	 * 获取：退款单号
	 */
	public String getDrawbackNumber() {
		return drawbackNumber;
	}
	/**
	 * 设置：顾客姓名
	 */
	public void setDrawbackName(String drawbackName) {
		this.drawbackName = drawbackName;
	}
	/**
	 * 获取：顾客姓名
	 */
	public String getDrawbackName() {
		return drawbackName;
	}
	/**
	 * 设置：退款金额
	 */
	public void setDrawbackMoney(String drawbackMoney) {
		this.drawbackMoney = drawbackMoney;
	}
	/**
	 * 获取：退款金额
	 */
	public String getDrawbackMoney() {
		return drawbackMoney;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreaterName() {
		return createrName;
	}
	/**
	 * 设置：退款时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：退款时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
