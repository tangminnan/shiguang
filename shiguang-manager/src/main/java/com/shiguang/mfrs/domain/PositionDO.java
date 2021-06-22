package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 仓位维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */
public class PositionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//仓位id
	private Long positionId;
	//仓位代码
	private String positionNum;
	//部门编码
	private String departNumber;
	//仓位名称
	private String positionName;
	//排列序号
	private String positionOrder;
	//状态id
	private Integer stateId;
	//状态（1停用：2启用）
	private String status;
	//状态(0:删除1:未删除)
	private Long state;

	/**
	 * 设置：仓位id
	 */
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：仓位id
	 */
	public Long getPositionId() {
		return positionId;
	}
	/**
	 * 设置：仓位代码
	 */
	public void setPositionNum(String positionNum) {
		this.positionNum = positionNum;
	}
	/**
	 * 获取：仓位代码
	 */
	public String getPositionNum() {
		return positionNum;
	}
	/**
	 * 设置：部门编码
	 */
	public void setDepartNumber(String departNumber) {
		this.departNumber = departNumber;
	}
	/**
	 * 获取：部门编码
	 */
	public String getDepartNumber() {
		return departNumber;
	}
	/**
	 * 设置：仓位名称
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	/**
	 * 获取：仓位名称
	 */
	public String getPositionName() {
		return positionName;
	}
	/**
	 * 设置：排列序号
	 */
	public void setPositionOrder(String positionOrder) {
		this.positionOrder = positionOrder;
	}
	/**
	 * 获取：排列序号
	 */
	public String getPositionOrder() {
		return positionOrder;
	}
	/**
	 * 设置：状态id
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	/**
	 * 获取：状态id
	 */
	public Integer getStateId() {
		return stateId;
	}
	/**
	 * 设置：状态（1停用：2启用）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态（1停用：2启用）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：状态(0:删除1:未删除)
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：状态(0:删除1:未删除)
	 */
	public Long getState() {
		return state;
	}
}
