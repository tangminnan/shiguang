package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 工艺类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class TechnologyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//工艺类型id
	private Long technologyId;
	//编码
	private String technologyNum;
	//工艺类型
	private String technologyType;

	/**
	 * 设置：工艺类型id
	 */
	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}
	/**
	 * 获取：工艺类型id
	 */
	public Long getTechnologyId() {
		return technologyId;
	}
	/**
	 * 设置：编码
	 */
	public void setTechnologyNum(String technologyNum) {
		this.technologyNum = technologyNum;
	}
	/**
	 * 获取：编码
	 */
	public String getTechnologyNum() {
		return technologyNum;
	}
	/**
	 * 设置：工艺类型
	 */
	public void setTechnologyType(String technologyType) {
		this.technologyType = technologyType;
	}
	/**
	 * 获取：工艺类型
	 */
	public String getTechnologyType() {
		return technologyType;
	}
}
