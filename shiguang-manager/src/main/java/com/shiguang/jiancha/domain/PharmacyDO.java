package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:51:54
 */
public class PharmacyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//散瞳用药id
	private Long pharmacyId;
	//散瞳用药
	private String pharmacy;

	/**
	 * 设置：散瞳用药id
	 */
	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	/**
	 * 获取：散瞳用药id
	 */
	public Long getPharmacyId() {
		return pharmacyId;
	}
	/**
	 * 设置：散瞳用药
	 */
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	/**
	 * 获取：散瞳用药
	 */
	public String getPharmacy() {
		return pharmacy;
	}
}
