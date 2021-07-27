package com.shiguang.checkout.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 费用提交
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-16 10:48:13
 */
public class CostDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//会员卡号
	private String memberNumber;
	//销售单号
	private String saleNumber;
	//应收金额
	private Double sumMoney;
	//缴费类型(0:缴费1:退费)
	private Long costType;
	//速记码
	private String shorthandCode;
	//费用名称
	private String costName;
	//费用金额
	private Double costMoney;
	//欠费金额
	private Double arrearMoney;
	//销售人员
	private String saleName;
	//是否缴费(0:未缴费1:已缴费)
	private Long isSale;
	//创建时间
	private Date createTime;
	//类型
	private String type;

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
	 * 设置：会员卡号
	 */
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	/**
	 * 获取：会员卡号
	 */
	public String getMemberNumber() {
		return memberNumber;
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
	 * 设置：应收金额
	 */
	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}
	/**
	 * 获取：应收金额
	 */
	public Double getSumMoney() {
		return sumMoney;
	}
	/**
	 * 设置：缴费类型(0:缴费1:退费)
	 */
	public void setCostType(Long costType) {
		this.costType = costType;
	}
	/**
	 * 获取：缴费类型(0:缴费1:退费)
	 */
	public Long getCostType() {
		return costType;
	}
	/**
	 * 设置：速记码
	 */
	public void setShorthandCode(String shorthandCode) {
		this.shorthandCode = shorthandCode;
	}
	/**
	 * 获取：速记码
	 */
	public String getShorthandCode() {
		return shorthandCode;
	}
	/**
	 * 设置：费用名称
	 */
	public void setCostName(String costName) {
		this.costName = costName;
	}
	/**
	 * 获取：费用名称
	 */
	public String getCostName() {
		return costName;
	}
	/**
	 * 设置：费用金额
	 */
	public void setCostMoney(Double costMoney) {
		this.costMoney = costMoney;
	}
	/**
	 * 获取：费用金额
	 */
	public Double getCostMoney() {
		return costMoney;
	}
	/**
	 * 设置：欠费金额
	 */
	public void setArrearMoney(Double arrearMoney) {
		this.arrearMoney = arrearMoney;
	}
	/**
	 * 获取：欠费金额
	 */
	public Double getArrearMoney() {
		return arrearMoney;
	}
	/**
	 * 设置：销售人员
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	/**
	 * 获取：销售人员
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * 设置：是否缴费(0:未缴费1:已缴费)
	 */
	public void setIsSale(Long isSale) {
		this.isSale = isSale;
	}
	/**
	 * 获取：是否缴费(0:未缴费1:已缴费)
	 */
	public Long getIsSale() {
		return isSale;
	}

	public void setCreateTime(Date createTime) {this.createTime = createTime;}

	public Date getCreateTime() {return createTime;}

	public void setType(String type) {this.type = type;}

	public String getType() {return type;}
}
