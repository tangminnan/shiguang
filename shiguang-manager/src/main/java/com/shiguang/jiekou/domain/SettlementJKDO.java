package com.shiguang.jiekou.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 结款管理
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
public class SettlementJKDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//会员卡号
	private String memberNumber;
	//收银员
	private String saleName;
	//销售单号
	private String saleNumber;
	//实际金额
	private Double actualMoney;
	//找零金额
	private Double changeMoney;
	//支付方式
	private String payModel;
	//缴费金额(根据支付方式)
	private String modelMoney;
	//缴费金额
	private Double payMoney;
	//销售日期
	private Date settleDate;
	//商品名称
	private String storeName;

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}

	public Double getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(Double actualMoney) {
		this.actualMoney = actualMoney;
	}

	public Double getChangeMoney() {
		return changeMoney;
	}

	public void setChangeMoney(Double changeMoney) {
		this.changeMoney = changeMoney;
	}

	public String getPayModel() {
		return payModel;
	}

	public void setPayModel(String payModel) {
		this.payModel = payModel;
	}

	public String getModelMoney() {
		return modelMoney;
	}

	public void setModelMoney(String modelMoney) {
		this.modelMoney = modelMoney;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Date getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
