package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 批号管理表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public class BatchDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//批号管理id
	private Integer batchid;
	//批号管理
	private String batchstate;

	/**
	 * 设置：批号管理id
	 */
	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}
	/**
	 * 获取：批号管理id
	 */
	public Integer getBatchid() {
		return batchid;
	}
	/**
	 * 设置：批号管理
	 */
	public void setBatchstate(String batchstate) {
		this.batchstate = batchstate;
	}
	/**
	 * 获取：批号管理
	 */
	public String getBatchstate() {
		return batchstate;
	}
}
