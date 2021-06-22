package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 材料分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public class LensDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//材料分类id
	private Integer lensId;
	//材料分类
	private String lensName;

	/**
	 * 设置：材料分类id
	 */
	public void setLensId(Integer lensId) {
		this.lensId = lensId;
	}
	/**
	 * 获取：材料分类id
	 */
	public Integer getLensId() {
		return lensId;
	}
	/**
	 * 设置：材料分类
	 */
	public void setLensName(String lensName) {
		this.lensName = lensName;
	}
	/**
	 * 获取：材料分类
	 */
	public String getLensName() {
		return lensName;
	}
}
