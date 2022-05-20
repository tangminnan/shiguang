package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 在途信息
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-05-19 16:09:53
 */
public class InfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//销售单号
	private String saleNumber;
	//在途状态
	private String trainStatus;
	//操作时间
	private Date trainTime;
	//操作人员
	private String trainName;
	//更新时间
	private Date update;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
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
	 * 设置：在途状态
	 */
	public void setTrainStatus(String trainStatus) {
		this.trainStatus = trainStatus;
	}
	/**
	 * 获取：在途状态
	 */
	public String getTrainStatus() {
		return trainStatus;
	}
	/**
	 * 设置：操作时间
	 */
	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getTrainTime() {
		return trainTime;
	}
	/**
	 * 设置：操作人员
	 */
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	/**
	 * 获取：操作人员
	 */
	public String getTrainName() {
		return trainName;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdate(Date update) {
		this.update = update;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdate() {
		return update;
	}
}
