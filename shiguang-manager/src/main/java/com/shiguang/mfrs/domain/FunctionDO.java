package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 镜片功能表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
public class FunctionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//镜片功能id
	private Integer id;
	//镜片功能
	private String functionName;

	/**
	 * 设置：镜片功能id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：镜片功能id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：镜片功能
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	/**
	 * 获取：镜片功能
	 */
	public String getFunctionName() {
		return functionName;
	}
}
