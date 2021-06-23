package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 渐进片分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public class GradualDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//渐进片分类id
	private Integer gradualId;
	//渐进片分类
	private String gradualName;

	/**
	 * 设置：渐进片分类id
	 */
	public void setGradualId(Integer gradualId) {
		this.gradualId = gradualId;
	}
	/**
	 * 获取：渐进片分类id
	 */
	public Integer getGradualId() {
		return gradualId;
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
