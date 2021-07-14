package com.shiguang.packageManager.domain;

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
	//套餐名称
	private String packageName;
	//套餐日期
	private Date packageTime;
	//套餐形式
	private String packageForm;
	//生效日期
	private Date effectiveDate;
	//截至日期
	private Date expiryDate;
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
	//备注
	private String remark;
	//失效状态
	private Long lose;

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
}
