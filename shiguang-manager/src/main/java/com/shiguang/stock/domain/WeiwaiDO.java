package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-14 16:17:31
 */
public class WeiwaiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//委外收货id
	private Long id;
	//配镜单号
	private String saleNumber;
	//收货单号
	private String shouhuoNumber;
	//收入仓位id
	private String positionId;
	//制造商id
	private Integer mfrsid;
	//顾客姓名
	private String name;
	//联系电话
	private String phone;
	//订做类型
	private String dzStype;
	//取镜日期
	private Date mirrorTime;
	//右眼加工要求
	private String eyeRight;
	//左眼加工要求
	private String eyeLeft;
	//部门编码
	private String departNumber;
	//球镜
	private String sph;
	//柱镜
	private String cyl;
	//商品名称
	private String goodsName;
	//R/L
	private String rl;
	//商品代码
	private String goodsNum;
	//厂家型号
	private String factory;
	//数量
	private Integer count;
	//商品条码
	private String goodsCode;

	/**
	 * 设置：委外收货id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：委外收货id
	 */
	public Long getId() {
		return id;
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
	 * 设置：收货单号
	 */
	public void setShouhuoNumber(String shouhuoNumber) {
		this.shouhuoNumber = shouhuoNumber;
	}
	/**
	 * 获取：收货单号
	 */
	public String getShouhuoNumber() {
		return shouhuoNumber;
	}
	/**
	 * 设置：收入仓位id
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：收入仓位id
	 */
	public String getPositionId() {
		return positionId;
	}
	/**
	 * 设置：制造商id
	 */
	public void setMfrsid(Integer mfrsid) {
		this.mfrsid = mfrsid;
	}
	/**
	 * 获取：制造商id
	 */
	public Integer getMfrsid() {
		return mfrsid;
	}
	/**
	 * 设置：顾客姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：顾客姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：订做类型
	 */
	public void setDzStype(String dzStype) {
		this.dzStype = dzStype;
	}
	/**
	 * 获取：订做类型
	 */
	public String getDzStype() {
		return dzStype;
	}
	/**
	 * 设置：取镜日期
	 */
	public void setMirrorTime(Date mirrorTime) {
		this.mirrorTime = mirrorTime;
	}
	/**
	 * 获取：取镜日期
	 */
	public Date getMirrorTime() {
		return mirrorTime;
	}
	/**
	 * 设置：右眼加工要求
	 */
	public void setEyeRight(String eyeRight) {
		this.eyeRight = eyeRight;
	}
	/**
	 * 获取：右眼加工要求
	 */
	public String getEyeRight() {
		return eyeRight;
	}
	/**
	 * 设置：左眼加工要求
	 */
	public void setEyeLeft(String eyeLeft) {
		this.eyeLeft = eyeLeft;
	}
	/**
	 * 获取：左眼加工要求
	 */
	public String getEyeLeft() {
		return eyeLeft;
	}
	/**
	 * 设置：部门编码
	 */
	public void setDepartNumber(String departNumber) {
		this.departNumber = departNumber;
	}
	/**
	 * 获取：部门编码
	 */
	public String getDepartNumber() {
		return departNumber;
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
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：R/L
	 */
	public void setRl(String rl) {
		this.rl = rl;
	}
	/**
	 * 获取：R/L
	 */
	public String getRl() {
		return rl;
	}
	/**
	 * 设置：商品代码
	 */
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	/**
	 * 获取：商品代码
	 */
	public String getGoodsNum() {
		return goodsNum;
	}
	/**
	 * 设置：厂家型号
	 */
	public void setFactory(String factory) {
		this.factory = factory;
	}
	/**
	 * 获取：厂家型号
	 */
	public String getFactory() {
		return factory;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：商品条码
	 */
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	/**
	 * 获取：商品条码
	 */
	public String getGoodsCode() {
		return goodsCode;
	}

	private String 	memberNumber;
	private String 	phone1;
	private String 	eyeType;
	private String 	peijingTime;

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getEyeType() {
		return eyeType;
	}

	public void setEyeType(String eyeType) {
		this.eyeType = eyeType;
	}

	public String getPeijingTime() {
		return peijingTime;
	}

	public void setPeijingTime(String peijingTime) {
		this.peijingTime = peijingTime;
	}
}
