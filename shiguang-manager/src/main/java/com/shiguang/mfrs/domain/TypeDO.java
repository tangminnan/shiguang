package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 抛弃型分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public class TypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//抛弃型分类id
	private Integer typeId;
	//抛弃型分类
	private String typeName;

	/**
	 * 设置：抛弃型分类id
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：抛弃型分类id
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * 设置：抛弃型分类
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：抛弃型分类
	 */
	public String getTypeName() {
		return typeName;
	}
}
