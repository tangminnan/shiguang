package com.shiguang.settlement.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 结款管理
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
public class SettlementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//检查费用id
	private Long costId;
	//会员卡号
	private String memberNumber;
	//实际金额
	private Double actualMoney;
	//缴费金额
	private Double paymentMoney;
	//找零金额
	private Double changeMoney;
	//支付方式
	private Long payModel;
	//缴费金额
	private Double payMoney;
	//销售单号
	private String saleNumber;

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

	public void setCostId(Long costId) {this.costId = costId;}

	public Long getCostId() {return costId;}

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
	 * 设置：实际金额
	 */
	public void setActualMoney(Double actualMoney) {
		this.actualMoney = actualMoney;
	}
	/**
	 * 获取：实际金额
	 */
	public Double getActualMoney() {
		return actualMoney;
	}
	/**
	 * 设置：缴费金额
	 */
	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	/**
	 * 获取：缴费金额
	 */
	public Double getPaymentMoney() {
		return paymentMoney;
	}
	/**
	 * 设置：找零金额
	 */
	public void setChangeMoney(Double changeMoney) {
		this.changeMoney = changeMoney;
	}
	/**
	 * 获取：找零金额
	 */
	public Double getChangeMoney() {
		return changeMoney;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayModel(Long payModel) {
		this.payModel = payModel;
	}
	/**
	 * 获取：支付方式
	 */
	public Long getPayModel() {
		return payModel;
	}
	/**
	 * 设置：缴费金额
	 */
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：缴费金额
	 */
	public Double getPayMoney() {
		return payMoney;
	}

	public void setSaleNumber(String saleNumber){this.saleNumber = saleNumber;}

	public String getSaleNumber() {return saleNumber;}
}
