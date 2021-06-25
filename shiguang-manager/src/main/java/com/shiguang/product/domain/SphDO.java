package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 球镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
public class SphDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//球镜id
	private Long id;
	//球镜
	private String sph;

	/**
	 * 设置：球镜id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：球镜id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：球镜
	 */
	public void setSph(String sph) {
		this.sph = sph;
	}
	/**
	 * 获取：球镜
	 */
	public String getSph() {
		return sph;
	}
}
