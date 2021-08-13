package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 工艺类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-10 14:23:53
 */
public class TechnologyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//工艺类型id
	private Long technologyId;
	//编码
	private String technologyNum;
	//工艺类型
	private String technologyType;
	//状态(0:删除1:未删除)
	private Long state;

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
