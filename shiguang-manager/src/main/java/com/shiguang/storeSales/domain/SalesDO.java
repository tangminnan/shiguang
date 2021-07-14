package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 门店销售
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-06 15:09:24
 */
public class SalesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//会员卡号
	private String memberNumber;
	//销售人员
	private String saleName;
	//销售单号
	private String saleNumber;
	//眼镜类型
	private String eyeType;
	//结算金额
	private Double amountMoney;
	//取镜方式
	private String mirrorWay;
	//取镜日期
	private Date mirrorTime;
	//取镜地点
	private String mirorAddress;
	//加急状态
	private String urgentStatus;
	//商品打折
	private Double goodsRebate;
	//一口价
	private Double fixedPrice;
	//抹零金额
	private Double molingMoney;
	//附加费用
	private String additionalCost;
	//加工要求
	private String processAsk;
	//商品名称
	private String storeName;
	//商品描述
	private String storeDescribe;
	//单价
	private String storeUnit;
	//数量
	private String storeCount;
	//销售备注
	private String remark;
	//赠品
	private String giveName;
	//是否有镜片
	private String isJj;
	//是否有镜架
	private Long isJp;
	//配镜日期
	private Date peijingTime;
	//验光师
	private String optometryName;
	//外来处方类型
	private String outRecipel;
	//处方类型
	private Long recipelType;

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
	 * 设置：眼镜类型
	 */
	public void setEyeType(String eyeType) {
		this.eyeType = eyeType;
	}
	/**
	 * 获取：眼镜类型
	 */
	public String getEyeType() {
		return eyeType;
	}
	/**
	 * 设置：结算金额
	 */
	public void setAmountMoney(Double amountMoney) {
		this.amountMoney = amountMoney;
	}
	/**
	 * 获取：结算金额
	 */
	public Double getAmountMoney() {
		return amountMoney;
	}
	/**
	 * 设置：取镜方式
	 */
	public void setMirrorWay(String mirrorWay) {
		this.mirrorWay = mirrorWay;
	}
	/**
	 * 获取：取镜方式
	 */
	public String getMirrorWay() {
		return mirrorWay;
	}
	/**
	 * 设置：取镜日期
	 */
	public void setMirrorTime(Date mirrorTime) {
		this.mirrorTime = mirrorTime;
	}
	/**
	 * 获取：取镜日期
	 */
	public Date getMirrorTime() {
		return mirrorTime;
	}
	/**
	 * 设置：取镜地点
	 */
	public void setMirorAddress(String mirorAddress) {
		this.mirorAddress = mirorAddress;
	}
	/**
	 * 获取：取镜地点
	 */
	public String getMirorAddress() {
		return mirorAddress;
	}
	/**
	 * 设置：加急状态
	 */
	public void setUrgentStatus(String urgentStatus) {
		this.urgentStatus = urgentStatus;
	}
	/**
	 * 获取：加急状态
	 */
	public String getUrgentStatus() {
		return urgentStatus;
	}
	/**
	 * 设置：商品打折
	 */
	public void setGoodsRebate(Double goodsRebate) {
		this.goodsRebate = goodsRebate;
	}
	/**
	 * 获取：商品打折
	 */
	public Double getGoodsRebate() {
		return goodsRebate;
	}
	/**
	 * 设置：一口价
	 */
	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	/**
	 * 获取：一口价
	 */
	public Double getFixedPrice() {
		return fixedPrice;
	}
	/**
	 * 设置：抹零金额
	 */
	public void setMolingMoney(Double molingMoney) {
		this.molingMoney = molingMoney;
	}
	/**
	 * 获取：抹零金额
	 */
	public Double getMolingMoney() {
		return molingMoney;
	}
	/**
	 * 设置：附加费用
	 */
	public void setAdditionalCost(String additionalCost) {
		this.additionalCost = additionalCost;
	}
	/**
	 * 获取：附加费用
	 */
	public String getAdditionalCost() {
		return additionalCost;
	}
	/**
	 * 设置：加工要求
	 */
	public void setProcessAsk(String processAsk) {
		this.processAsk = processAsk;
	}
	/**
	 * 获取：加工要求
	 */
	public String getProcessAsk() {
		return processAsk;
	}
	/**
	 * 设置：商品名称
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * 设置：商品描述
	 */
	public void setStoreDescribe(String storeDescribe) {
		this.storeDescribe = storeDescribe;
	}
	/**
	 * 获取：商品描述
	 */
	public String getStoreDescribe() {
		return storeDescribe;
	}
	/**
	 * 设置：单价
	 */
	public void setStoreUnit(String storeUnit) {
		this.storeUnit = storeUnit;
	}
	/**
	 * 获取：单价
	 */
	public String getStoreUnit() {
		return storeUnit;
	}
	/**
	 * 设置：数量
	 */
	public void setStoreCount(String storeCount) {
		this.storeCount = storeCount;
	}
	/**
	 * 获取：数量
	 */
	public String getStoreCount() {
		return storeCount;
	}
	/**
	 * 设置：销售备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：销售备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：赠品
	 */
	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}
	/**
	 * 获取：赠品
	 */
	public String getGiveName() {
		return giveName;
	}

	public void setIsJj(String isJj){this.isJj = isJj;}

	public String getIsJj(){return isJj;}

	public void setIsJp(Long isJp){this.isJp=isJp;}

	public Long getIsJp(){return isJp;}

	/**
	 * 设置：配镜日期
	 */
	public void setPeijingTime(Date peijingTime) {
		this.peijingTime = peijingTime;
	}
	/**
	 * 获取：配镜日期
	 */
	public Date getPeijingTime() {
		return peijingTime;
	}

	/**
	 * 获取：验光师
	 */
	public String getOptometryName() {
		return optometryName;
	}
	/**
	 * 设置：验光师
	 */
	public void setOptometryName(String optometryName) {
		this.optometryName = optometryName;
	}

	/**
	 * 获取：外来处方
	 */
	public String getOutRecipel() {
		return outRecipel;
	}
	/**
	 * 设置：外来处方
	 */
	public void setOutRecipel(String outRecipel) {
		this.outRecipel = outRecipel;
	}

	/**
	 * 获取：处方类型
	 */
	public Long getRecipelType() {
		return recipelType;
	}
	/**
	 * 设置：外来类型
	 */
	public void setRecipelType(Long recipelType) {
		this.recipelType = recipelType;
	}
}
