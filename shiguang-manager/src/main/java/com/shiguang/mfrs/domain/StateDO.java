package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 状态表

 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 14:19:37
 */
public class StateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//状态id
	private Integer stateId;
	//状态（1:启用2:停用）
	private String status;

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
	 * 设置：状态（1:启用2:停用）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态（1:启用2:停用）
	 */
	public String getStatus() {
		return status;
	}
}
