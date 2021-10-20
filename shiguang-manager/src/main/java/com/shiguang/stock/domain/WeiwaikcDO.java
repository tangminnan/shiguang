package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-30 01:34:01
 */
public class WeiwaikcDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//委外入库id
	private Long id;
	//仓位id
	private String positionId;
	//顾客姓名
	private String gkname;
	//会员卡
	private String hyknum;
	//手机号
	private String phone;
	//单据编号（委外）
	private String danjuNumber;
	//配镜单号
	private String saleNumber;
	//取镜时间
	private String mirrorTime;
	//商品名称
	private String goodsName;
	//数量
	private String count;

	//1未收货，0已收货未配送，2配送
	private String status;
	//工号
	private String username;
	//收货时间
	private String shTime;
	//配送。退回
	private String shstatus;
	//配送人员或者退回
	private String psname;
	//配送或者退回时间
	private String pstime;

	public String getPstime() {
		return pstime;
	}

	public void setPstime(String pstime) {
		this.pstime = pstime;
	}

	public String getPsname() {
		return psname;
	}

	public void setPsname(String psname) {
		this.psname = psname;
	}
	//原配镜单
	private String salenumbery;

	public String getSalenumbery() {
		return salenumbery;
	}

	public void setSalenumbery(String salenumbery) {
		this.salenumbery = salenumbery;
	}

	/**
	 * 设置：委外入库id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：委外入库id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：仓位id
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：仓位id
	 */
	public String getPositionId() {
		return positionId;
	}
	/**
	 * 设置：顾客姓名
	 */
	public void setGkname(String gkname) {
		this.gkname = gkname;
	}
	/**
	 * 获取：顾客姓名
	 */
	public String getGkname() {
		return gkname;
	}
	/**
	 * 设置：会员卡
	 */
	public void setHyknum(String hyknum) {
		this.hyknum = hyknum;
	}
	/**
	 * 获取：会员卡
	 */
	public String getHyknum() {
		return hyknum;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：单据编号（委外）
	 */
	public void setDanjuNumber(String danjuNumber) {
		this.danjuNumber = danjuNumber;
	}
	/**
	 * 获取：单据编号（委外）
	 */
	public String getDanjuNumber() {
		return danjuNumber;
	}
	/**
	 * 设置：配镜单号
	 */
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	/**
	 * 获取：配镜单号
	 */
	public String getSaleNumber() {
		return saleNumber;
	}
	/**
	 * 设置：取镜时间
	 */
	public void setMirrorTime(String mirrorTime) {
		this.mirrorTime = mirrorTime;
	}
	/**
	 * 获取：取镜时间
	 */
	public String getMirrorTime() {
		return mirrorTime;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 * @param goodsName
	 */
	public String getGoodsName(String goodsName) {
		return this.goodsName;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 * @param count
	 */
	public String getCount(String count) {
		return this.count;
	}



	/**
	 * 设置：1未收货，0已收货未配送，2配送
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：1未收货，0已收货未配送，2配送
	 * @param status
	 */
	public String getStatus(String status) {
		return this.status;
	}


	public String getGoodsName() {
		return goodsName;
	}

	public String getCount() {
		return count;
	}


	public String getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShTime() {
		return shTime;
	}

	public void setShTime(String shTime) {
		this.shTime = shTime;
	}

	public String getShstatus() {
		return shstatus;
	}

	public void setShstatus(String shstatus) {
		this.shstatus = shstatus;
	}
}
