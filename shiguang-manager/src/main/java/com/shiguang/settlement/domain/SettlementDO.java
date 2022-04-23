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
	//收银员
	private String saleName;
	//员工工号
	private String saleAcount;
	//实际金额
	private Double actualMoney;
	//缴费金额
	private Double paymentMoney;
	//找零金额
	private Double changeMoney;
	//支付方式
	private String payModel;
	//更改付款方式
	private String payGgModel;
	//缴费金额
	private String modelGgMoney;
	//缴费金额(根据支付方式)
	private String modelMoney;
	//缴费金额
	private Double payMoney;
	//销售单号
	private String saleNumber;
	//付款方式
	private String payWay;
	//定金金额
	private Double frontMoney;
	//缴定金时间
	private Date frontTime;
	//会员姓名
	private String memberName;
	//性别
	private Long sex;
	//年龄
	private Long age;
	//欠费金额
	private Double arrearsMoney;
	//销售日期
	private Date settleDate;
	private String settleTime;
	//原价合计
	private Double originalPrice;
	//退款金额
	private String drawBackMoney;
	//退款方式
	private String drawBackWay;
	//部门名称
	private String departmentName;
	//储值卡
	private String chuzhiNumber;
	//储值卡密码
	private String chuzhiPasd;


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
	public void setSaleName(String saleName){this.saleName = saleName;}
	public String getSaleName() {return saleName;}
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
	public void setPayModel(String payModel) {
		this.payModel = payModel;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPayModel() {
		return payModel;
	}
	/**
	 * 缴费金额(根据支付方式)
	 */
	public void setModelMoney(String modelMoney) {this.modelMoney = modelMoney;}
	/**
	 * 缴费金额(根据缴费方式)
	 */
	public String getModelMoney(){return modelMoney;}
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

	public void setPayWay(String payWay) {this.payWay = payWay;}

	public String getPayWay() {return payWay;}

	public void setFrontMoney(Double frontMoney) {this.frontMoney = frontMoney;}

	public Double getFrontMoney() {return frontMoney;}

	public void setFrontTime(Date frontTime){this.frontTime = frontTime;}

	public Date getFrontTime(){return frontTime;}

	public void setMemberName(String memberName) {this.memberName =memberName;}

	public String getMemberName(){return memberName;}

	public void setArrearsMoney(Double arrearsMoney) {this.arrearsMoney = arrearsMoney;}

	public Double getArrearsMoney() {return arrearsMoney;}

	public void setSettleDate(Date settleDate) {this.settleDate = settleDate;}

	public Date getSettleDate() {return settleDate;}

	public void setSettleTime(String settleTime) {this.settleTime = settleTime;}

	public String getSettleTime() {return settleTime;}

	public void setOriginalPrice(Double originalPrice) {this.originalPrice = originalPrice;}

	public Double getOriginalPrice() {return originalPrice;}

	public void setSex(Long sex) {this.sex = sex;}

	public Long getSex() {return sex;}

	/**
	 * 设置：年龄
	 */
	public void setAge(Long age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Long getAge() {
		return age;
	}

	public void setDrawBackMoney(String drawBackMoney){this.drawBackMoney = drawBackMoney;}

	public String getDrawBackMoney(){return drawBackMoney;}

	public void setDrawBackWay(String drawBackWay){this.drawBackWay = drawBackWay;}

	public String getDrawBackWay(){return drawBackWay;}

	public void setSaleAcount(String saleAcount){this.saleAcount = saleAcount;}

	public String getSaleAcount(){return saleAcount;}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getChuzhiNumber() {
		return chuzhiNumber;
	}

	public void setChuzhiNumber(String chuzhiNumber) {
		this.chuzhiNumber = chuzhiNumber;
	}

	public String getChuzhiPasd() {
		return chuzhiPasd;
	}

	public void setChuzhiPasd(String chuzhiPasd) {
		this.chuzhiPasd = chuzhiPasd;
	}

	public String getPayGgModel() {
		return payGgModel;
	}

	public void setPayGgModel(String payGgModel) {
		this.payGgModel = payGgModel;
	}

	public String getModelGgMoney() {
		return modelGgMoney;
	}

	public void setModelGgMoney(String modelGgMoney) {
		this.modelGgMoney = modelGgMoney;
	}
}
