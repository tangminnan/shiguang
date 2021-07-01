package com.shiguang.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 柱镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public class CylDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//柱镜id
	private Long cylId;
	//柱镜
	private String cyl;

	/**
	 * 设置：柱镜id
	 */
	public void setCylId(Long cylId) {
		this.cylId = cylId;
	}
	/**
	 * 获取：柱镜id
	 */
	public Long getCylId() {
		return cylId;
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
