package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 球镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class SphDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//球镜id
	private Long sphId;
	//球镜
	private String sph;

	/**
	 * 设置：球镜id
	 */
	public void setSphId(Long sphId) {
		this.sphId = sphId;
	}
	/**
	 * 获取：球镜id
	 */
	public Long getSphId() {
		return sphId;
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
