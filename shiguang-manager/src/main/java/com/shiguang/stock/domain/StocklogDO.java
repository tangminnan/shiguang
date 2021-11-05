package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-05 16:13:22
 */
public class StocklogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//库存logid
	private Long id;
	//商品代码
	private String num;
	//商品条码
	private String code;
	//商品名称
	private String name;
	//数量
	private String counts;
	//日期
	private String day;
	//方式
	private String way;
	//工号
	private String username;
	//仓位id
	private Long positionId;

	/**
	 * 设置：库存logid
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：库存logid
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：商品代码
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 获取：商品代码
	 */
	public String getNum() {
		return num;
	}
	/**
	 * 设置：商品条码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：商品条码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：数量
	 */
	public void setCounts(String counts) {
		this.counts = counts;
	}
	/**
	 * 获取：数量
	 */
	public String getCounts() {
		return counts;
	}
	/**
	 * 设置：日期
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * 获取：日期
	 */
	public String getDay() {
		return day;
	}
	/**
	 * 设置：方式
	 */
	public void setWay(String way) {
		this.way = way;
	}
	/**
	 * 获取：方式
	 */
	public String getWay() {
		return way;
	}
	/**
	 * 设置：工号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：工号
	 */
	public String getUsername() {
		return username;
	}
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
}
