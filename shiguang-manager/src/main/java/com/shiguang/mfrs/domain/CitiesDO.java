package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 行政区域地州市信息表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-20 17:25:32
 */
public class CitiesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String cityid;
	//
	private String city;
	//
	private String provinceid;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	/**
	 * 获取：
	 */
	public String getCityid() {
		return cityid;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：
	 */
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	/**
	 * 获取：
	 */
	public String getProvinceid() {
		return provinceid;
	}
}
