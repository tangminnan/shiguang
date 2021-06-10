package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 计量单位表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 15:13:48
 */
public class UnitDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//计量单位id
	private Integer unitid;
	//计量单位代码
	private String unitnum;
	//计量单位
	private String unitname;

	/**
	 * 设置：计量单位id
	 */
	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	/**
	 * 获取：计量单位id
	 */
	public Integer getUnitid() {
		return unitid;
	}
	/**
	 * 设置：计量单位代码
	 */
	public void setUnitnum(String unitnum) {
		this.unitnum = unitnum;
	}
	/**
	 * 获取：计量单位代码
	 */
	public String getUnitnum() {
		return unitnum;
	}
	/**
	 * 设置：计量单位
	 */
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	/**
	 * 获取：计量单位
	 */
	public String getUnitname() {
		return unitname;
	}
}
