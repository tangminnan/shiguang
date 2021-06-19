package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 渐进片分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
public class GradualDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//渐进片分类id
	private Integer id;
	//渐进片分类
	private String gradualName;

	/**
	 * 设置：渐进片分类id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：渐进片分类id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：渐进片分类
	 */
	public void setGradualName(String gradualName) {
		this.gradualName = gradualName;
	}
	/**
	 * 获取：渐进片分类
	 */
	public String getGradualName() {
		return gradualName;
	}
}
