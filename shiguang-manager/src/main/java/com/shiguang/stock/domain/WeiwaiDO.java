package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */
public class WeiwaiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//单据编号
	private String danjuNumber;
	//单据日期
	private String danjuDay;
	//订单类型
	private String eyeStyle;
	//制单人
	private String zhidanPeople;
	//制造商id
	private Integer mfrsid;
	//厂家订单号
	private String changjiaNumber;
	//收货联系人
	private String shouhuoPeople;
	//收货联系电话
	private String shouhuoPhone;
	//收货地址
	private String shouhuoAddress;
	//备注
	private String beizhu;
	//配镜单号
	private String saleNumber;
	//取镜时间
	private Date mirrorTime;
	//商品名称
	private String goodsName;
	//委外方式
	private String style;
	//镜片类型r/l
	private String rl;
	//数量
	private String count;
	//球镜
	private String sph;
	//柱镜
	private String cyl;
	//轴向
	private String axial;
	//下加
	private String lightbelow;
	//棱镜
	private String lengjing;
	//直径
	private String diameter;
	//加工要求
	private String yaoqiu;
	//基底
	private String jd;
	//曲率
	private String curvature;
	//收货状态
	private String status;
	//工号
	private String username;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：单据编号
	 */
	public void setDanjuNumber(String danjuNumber) {
		this.danjuNumber = danjuNumber;
	}
	/**
	 * 获取：单据编号
	 */
	public String getDanjuNumber() {
		return danjuNumber;
	}
	/**
	 * 设置：单据日期
	 */
	public void setDanjuDay(String danjuDay) {
		this.danjuDay = danjuDay;
	}
	/**
	 * 获取：单据日期
	 */
	public String getDanjuDay() {
		return danjuDay;
	}
	/**
	 * 设置：订单类型
	 */
	public void setEyeStyle(String eyeStyle) {
		this.eyeStyle = eyeStyle;
	}
	/**
	 * 获取：订单类型
	 */
	public String getEyeStyle() {
		return eyeStyle;
	}
	/**
	 * 设置：制单人
	 */
	public void setZhidanPeople(String zhidanPeople) {
		this.zhidanPeople = zhidanPeople;
	}
	/**
	 * 获取：制单人
	 */
	public String getZhidanPeople() {
		return zhidanPeople;
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
	 * 设置：厂家订单号
	 */
	public void setChangjiaNumber(String changjiaNumber) {
		this.changjiaNumber = changjiaNumber;
	}
	/**
	 * 获取：厂家订单号
	 */
	public String getChangjiaNumber() {
		return changjiaNumber;
	}
	/**
	 * 设置：收货联系人
	 */
	public void setShouhuoPeople(String shouhuoPeople) {
		this.shouhuoPeople = shouhuoPeople;
	}
	/**
	 * 获取：收货联系人
	 */
	public String getShouhuoPeople() {
		return shouhuoPeople;
	}
	/**
	 * 设置：收货联系电话
	 */
	public void setShouhuoPhone(String shouhuoPhone) {
		this.shouhuoPhone = shouhuoPhone;
	}
	/**
	 * 获取：收货联系电话
	 */
	public String getShouhuoPhone() {
		return shouhuoPhone;
	}
	/**
	 * 设置：收货地址
	 */
	public void setShouhuoAddress(String shouhuoAddress) {
		this.shouhuoAddress = shouhuoAddress;
	}
	/**
	 * 获取：收货地址
	 */
	public String getShouhuoAddress() {
		return shouhuoAddress;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
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
	public void setMirrorTime(Date mirrorTime) {
		this.mirrorTime = mirrorTime;
	}
	/**
	 * 获取：取镜时间
	 */
	public Date getMirrorTime() {
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
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：委外方式
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * 获取：委外方式
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * 设置：镜片类型r/l
	 */
	public void setRl(String rl) {
		this.rl = rl;
	}
	/**
	 * 获取：镜片类型r/l
	 */
	public String getRl() {
		return rl;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public String getCount() {
		return count;
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
	 * 设置：轴向
	 */
	public void setAxial(String axial) {
		this.axial = axial;
	}
	/**
	 * 获取：轴向
	 */
	public String getAxial() {
		return axial;
	}
	/**
	 * 设置：下加
	 */
	public void setLightbelow(String lightbelow) {
		this.lightbelow = lightbelow;
	}
	/**
	 * 获取：下加
	 */
	public String getLightbelow() {
		return lightbelow;
	}
	/**
	 * 设置：棱镜
	 */
	public void setLengjing(String lengjing) {
		this.lengjing = lengjing;
	}
	/**
	 * 获取：棱镜
	 */
	public String getLengjing() {
		return lengjing;
	}
	/**
	 * 设置：直径
	 */
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	/**
	 * 获取：直径
	 */
	public String getDiameter() {
		return diameter;
	}
	/**
	 * 设置：加工要求
	 */
	public void setYaoqiu(String yaoqiu) {
		this.yaoqiu = yaoqiu;
	}
	/**
	 * 获取：加工要求
	 */
	public String getYaoqiu() {
		return yaoqiu;
	}
	/**
	 * 设置：基底
	 */
	public void setJd(String jd) {
		this.jd = jd;
	}
	/**
	 * 获取：基底
	 */
	public String getJd() {
		return jd;
	}
	/**
	 * 设置：曲率
	 */
	public void setCurvature(String curvature) {
		this.curvature = curvature;
	}
	/**
	 * 获取：曲率
	 */
	public String getCurvature() {
		return curvature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String memberNumber;
	private String name;
	private String phone1;
	private String eyeType;
	private String settleDate;
	private String saleName;
	private String amountMoney;

	public String getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(String amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

}
