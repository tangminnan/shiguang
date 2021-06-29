package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 柱镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:26:17
 */
public class CylDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//柱镜id
	private Integer id;
	//柱镜
	private String cyl;

	/**
	 * 设置：柱镜id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：柱镜id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：柱镜
	 */
	public void setCyl(String cyl) {
		this.cyl = cyl;
	}
	/**
	 * 获取：柱镜
	 */
	public String getCyl() {
		return cyl;
	}
}
