package com.shiguang.packageManager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 套餐表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-13 13:48:48
 */
public class PackageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//套餐id
	private Long packageId;
	//套餐名称
	private String packageName;
	//套餐日期
	private Date packageTime;
	private String packageDate;
	//套餐形式
	private String packageForm;
	//生效日期
	private Date effectiveDate;
	private String effectiveTime;
	//截至日期
	private Date expiryDate;
	private String expiryTime;
	//套餐分类
	private String packageType;
	//套餐价格区间开始
	private String startPrice;
	//套餐价格区间结束
	private String endPrice;
	//套餐金额
	private String packagePrice;
	//是否允许累计积分
	private Long isCumulativePoints;
	//是否允许累加
	private Long isAdd;
	//是否允许折上折
	private Long foldUp;
	//零售价格
	private String retailPrice;
	//活动门店
	private String store;
	//活动门店编码
	private String storeNum;
	//备注
	private String remark;
	//失效状态
	private Long lose;
	//整单满(开始)
	private String wholeStart;
	//整单满(结束)
	private String wholeEnd;
	//单一优惠方式
	private String danyiyh;
	//优惠价格（打折）
	private String dazhePrice;
	//优惠价格（返现）
	private String fanxianPrice;
	//优惠价格（特价）
	private String tejiaPrice;

	//商品类型
	private String goodsType;
	//商品代码
	private String goodsCode;
	//商品名称
	private String goodsName;
	//购买方式
	private Long buyWay;
	//商品原价区间
	private String originalPriceRange;
	//套餐价格区间开始
	private String packageStartPrice;
	//套餐价格区间结束
	private String packageEndPrice;
	//销售数量
	private Long saleNumber;
	//消费满(开始价格)
	private String fullStartPrice;
	//消费满(结束价格)
	private String fullEndPrice;
	//优惠方式
	private String preferentialWay;
	//套餐单价
	private String unitPrice;
	//特价金额
	private String specialPrice;
	//优惠金额
	private String preferentialPrice;
	//优惠折扣
	private String preferentialRebate;

	/**
	 * 设置：商品类型
	 */
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：商品类型
	 */
	public String getGoodsType() {
		return goodsType;
	}
	/**
	 * 设置：商品代码
	 */
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	/**
	 * 获取：商品代码
	 */
	public String getGoodsCode() {
		return goodsCode;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：购买方式
	 */
	public void setBuyWay(Long buyWay) {
		this.buyWay = buyWay;
	}
	/**
	 * 获取：购买方式
	 */
	public Long getBuyWay() {
		return buyWay;
	}
	/**
	 * 设置：商品原价区间
	 */
	public void setOriginalPriceRange(String originalPriceRange) {
		this.originalPriceRange = originalPriceRange;
	}
	/**
	 * 获取：商品原价区间
	 */
	public String getOriginalPriceRange() {
		return originalPriceRange;
	}
	/**
	 * 设置：套餐价格区间开始
	 */
	public void setPackageStartPrice(String packageStartPrice) {
		this.packageStartPrice = packageStartPrice;
	}
	/**
	 * 获取：套餐价格区间开始
	 */
	public String getPackageStartPrice() {
		return packageStartPrice;
	}
	/**
	 * 设置：套餐价格区间结束
	 */
	public void setPackageEndPrice(String packageEndPrice) {
		this.packageEndPrice = packageEndPrice;
	}
	/**
	 * 获取：套餐价格区间结束
	 */
	public String getPackageEndPrice() {
		return packageEndPrice;
	}
	/**
	 * 设置：销售数量
	 */
	public void setSaleNumber(Long saleNumber) {
		this.saleNumber = saleNumber;
	}
	/**
	 * 获取：销售数量
	 */
	public Long getSaleNumber() {
		return saleNumber;
	}
	/**
	 * 设置：消费满(开始价格)
	 */
	public void setFullStartPrice(String fullStartPrice) {
		this.fullStartPrice = fullStartPrice;
	}
	/**
	 * 获取：消费满(开始价格)
	 */
	public String getFullStartPrice() {
		return fullStartPrice;
	}
	/**
	 * 设置：消费满(结束价格)
	 */
	public void setFullEndPrice(String fullEndPrice) {
		this.fullEndPrice = fullEndPrice;
	}
	/**
	 * 获取：消费满(结束价格)
	 */
	public String getFullEndPrice() {
		return fullEndPrice;
	}
	/**
	 * 设置：优惠方式
	 */
	public void setPreferentialWay(String preferentialWay) {
		this.preferentialWay = preferentialWay;
	}
	/**
	 * 获取：优惠方式
	 */
	public String getPreferentialWay() {
		return preferentialWay;
	}
	/**
	 * 设置：套餐单价
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 获取：套餐单价
	 */
	public String getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 设置：特价金额
	 */
	public void setSpecialPrice(String specialPrice) {
		this.specialPrice = specialPrice;
	}
	/**
	 * 获取：特价金额
	 */
	public String getSpecialPrice() {
		return specialPrice;
	}
	/**
	 * 设置：优惠金额
	 */
	public void setPreferentialPrice(String preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}
	/**
	 * 获取：优惠金额
	 */
	public String getPreferentialPrice() {
		return preferentialPrice;
	}
	/**
	 * 设置：优惠折扣
	 */
	public void setPreferentialRebate(String preferentialRebate) {
		this.preferentialRebate = preferentialRebate;
	}
	/**
	 * 获取：优惠折扣
	 */
	public String getPreferentialRebate() {
		return preferentialRebate;
	}

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
	public void setPackageId(Long packageId) {this.packageId = packageId;}
	public Long getPackageId() {return packageId;}
	/**
	 * 设置：套餐名称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * 获取：套餐名称
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * 设置：套餐日期
	 */
	public void setPackageTime(Date packageTime) {
		this.packageTime = packageTime;
	}
	/**
	 * 获取：套餐日期
	 */
	public Date getPackageTime() {
		return packageTime;
	}
	public void setPackageDate(String packageDate) {this.packageDate = packageDate;}
	public String getPackageDate() {return packageDate;}
	/**
	 * 设置：套餐形式
	 */
	public void setPackageForm(String packageForm) {
		this.packageForm = packageForm;
	}
	/**
	 * 获取：套餐形式
	 */
	public String getPackageForm() {
		return packageForm;
	}
	/**
	 * 设置：生效日期
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * 获取：生效日期
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveTime(String effectiveTime) {this.effectiveTime = effectiveTime;}
	public String getEffectiveTime(){return effectiveTime;}
	/**
	 * 设置：截至日期
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * 获取：截至日期
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryTime(String expiryTime) {this.expiryTime = expiryTime;}
	public String getExpiryTime() {return expiryTime;}
	/**
	 * 设置：套餐分类
	 */
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	/**
	 * 获取：套餐分类
	 */
	public String getPackageType() {
		return packageType;
	}
	/**
	 * 设置：套餐价格区间开始
	 */
	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}
	/**
	 * 获取：套餐价格区间开始
	 */
	public String getStartPrice() {
		return startPrice;
	}
	/**
	 * 设置：套餐价格区间结束
	 */
	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}
	/**
	 * 获取：套餐价格区间结束
	 */
	public String getEndPrice() {
		return endPrice;
	}
	/**
	 * 设置：套餐金额
	 */
	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}
	/**
	 * 获取：套餐金额
	 */
	public String getPackagePrice() {
		return packagePrice;
	}
	/**
	 * 设置：是否允许累计积分
	 */
	public void setIsCumulativePoints(Long isCumulativePoints) {
		this.isCumulativePoints = isCumulativePoints;
	}
	/**
	 * 获取：是否允许累计积分
	 */
	public Long getIsCumulativePoints() {
		return isCumulativePoints;
	}
	/**
	 * 设置：是否允许累加
	 */
	public void setIsAdd(Long isAdd) {
		this.isAdd = isAdd;
	}
	/**
	 * 获取：是否允许累加
	 */
	public Long getIsAdd() {
		return isAdd;
	}
	/**
	 * 设置：是否允许折上折
	 */
	public void setFoldUp(Long foldUp) {
		this.foldUp = foldUp;
	}
	/**
	 * 获取：是否允许折上折
	 */
	public Long getFoldUp() {
		return foldUp;
	}
	/**
	 * 设置：零售价格
	 */
	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * 获取：零售价格
	 */
	public String getRetailPrice() {
		return retailPrice;
	}
	/**
	 * 设置：活动门店
	 */
	public void setStore(String store) {
		this.store = store;
	}
	/**
	 * 获取：活动门店
	 */
	public String getStore() {
		return store;
	}
	public void setStoreNum(String storeNum) {this.storeNum = storeNum;}
	public String getStoreNum(){return storeNum;}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：失效
	 */
	public void setLose(Long lose){this.lose = lose;}
	/**
	 * 获取：失效
	 */
	public Long getLose(){return lose;}

	public void setWholeStart(String wholeStart) {this.wholeStart = wholeStart;}
	public String getWholeStart() {return wholeStart;}
	public void setWholeEnd(String wholeEnd) {this.wholeEnd = wholeEnd;}
	public String getWholeEnd(){return wholeEnd;}
	public void setDanyiyh(String danyiyh) {this.danyiyh = danyiyh;}
	public String getDanyiyh() {return danyiyh;}
	public void setDazhePrice(String dazhePrice) {this.dazhePrice = dazhePrice;}
	public String getDazhePrice() {return dazhePrice;}
	public void setFanxianPrice(String fanxianPrice) {this.fanxianPrice = fanxianPrice;}
	public String getFanxianPrice() {return fanxianPrice;}
	public void setTejiaPrice(String tejiaPrice) {this.tejiaPrice = tejiaPrice;}
	public String getTejiaPrice() {return tejiaPrice;}
}
