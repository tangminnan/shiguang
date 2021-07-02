package com.shiguang.baseinfomation.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-30 16:55:50
 */
public class AdditionalDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//附加费用编码
	private String additionNum;
	//附加费用名称
	private String additionName;
	//价格
	private Double price;

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
	 * 设置：附加费用编码
	 */
	public void setAdditionNum(String additionNum) {
		this.additionNum = additionNum;
	}
	/**
	 * 获取：附加费用编码
	 */
	public String getAdditionNum() {
		return additionNum;
	}
	/**
	 * 设置：附加费用名称
	 */
	public void setAdditionName(String additionName) {
		this.additionName = additionName;
	}
	/**
	 * 获取：附加费用名称
	 */
	public String getAdditionName() {
		return additionName;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
}
