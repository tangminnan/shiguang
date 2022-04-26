package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2022-01-22 15:26:34
 */
public class WeiwaishujuDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//委外数据id
	private Long id;
	//销售单号
	private String number;
	//单据日期
	private String danjuDay;
	//所属部门
	private String departname;
	//制单人
	private String zhidanPeople;
	//镜片类型
	private String jcStyle;
	//取镜时间
	private String timetime;
	//单据类型
	private String danjuStyle;
	//原配镜单
	private String saleNumber;
	//委外类型
	private String weiwaiStyle;
	//备注
	private String beizhu;
	//球镜
	private String sph;
	//柱镜
	private String cyl;
	//轴向
	private String zx;
	//Add(下加)
	private String add;
	//三棱镜
	private String slj;
	//基底
	private String jd;
	//远瞳距
	private String fartj;
	//近瞳距
	private String neartj;
	//瞳高
	private String tg;
	//曲率
	private String qulv;
	//直径
	private String zj;
	//球镜yx
	private String sphyx;
	//柱镜yx
	private String cylyx;
	//轴向yx
	private String zxyx;
	//基地隐形
	private String jdyx;
	//商品代码
	private String num;
	//商品条码
	private String code;
	//商品名称
	private String name;
	//镜片型左右
	private String leftRight;
	//数量
	private String count;
	//要求
	private String yaoqiu;
	//商品代码yx
	private String numyx;
	//商品条码yx
	private String codeyx;
	//商品名称yx
	private String nameyx;
	//镜片型左右yx
	private String leftRightYx;
	//数量yx
	private String countyx;
	//要求隐形
	private String yaoqiuyx;
	//顾客姓名
	private String gkname;
	//会员卡
	private String hyknum;
	//手机号
	private String phone;

	/**
	 * 设置：委外数据id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：委外数据id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：销售单号
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：销售单号
	 */
	public String getNumber() {
		return number;
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
	 * 设置：所属部门
	 */
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	/**
	 * 获取：所属部门
	 */
	public String getDepartname() {
		return departname;
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
	 * 设置：镜片类型
	 */
	public void setJcStyle(String jcStyle) {
		this.jcStyle = jcStyle;
	}
	/**
	 * 获取：镜片类型
	 */
	public String getJcStyle() {
		return jcStyle;
	}
	/**
	 * 设置：取镜时间
	 */
	public void setTimetime(String timetime) {
		this.timetime = timetime;
	}
	/**
	 * 获取：取镜时间
	 */
	public String getTimetime() {
		return timetime;
	}
	/**
	 * 设置：单据类型
	 */
	public void setDanjuStyle(String danjuStyle) {
		this.danjuStyle = danjuStyle;
	}
	/**
	 * 获取：单据类型
	 */
	public String getDanjuStyle() {
		return danjuStyle;
	}
	/**
	 * 设置：原配镜单
	 */
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	/**
	 * 获取：原配镜单
	 */
	public String getSaleNumber() {
		return saleNumber;
	}
	/**
	 * 设置：委外类型
	 */
	public void setWeiwaiStyle(String weiwaiStyle) {
		this.weiwaiStyle = weiwaiStyle;
	}
	/**
	 * 获取：委外类型
	 */
	public String getWeiwaiStyle() {
		return weiwaiStyle;
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
	public void setZx(String zx) {
		this.zx = zx;
	}
	/**
	 * 获取：轴向
	 */
	public String getZx() {
		return zx;
	}
	/**
	 * 设置：Add(下加)
	 */
	public void setAdd(String add) {
		this.add = add;
	}
	/**
	 * 获取：Add(下加)
	 */
	public String getAdd() {
		return add;
	}
	/**
	 * 设置：三棱镜
	 */
	public void setSlj(String slj) {
		this.slj = slj;
	}
	/**
	 * 获取：三棱镜
	 */
	public String getSlj() {
		return slj;
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
	 * 设置：远瞳距
	 */
	public void setFartj(String fartj) {
		this.fartj = fartj;
	}
	/**
	 * 获取：远瞳距
	 */
	public String getFartj() {
		return fartj;
	}
	/**
	 * 设置：近瞳距
	 */
	public void setNeartj(String neartj) {
		this.neartj = neartj;
	}
	/**
	 * 获取：近瞳距
	 */
	public String getNeartj() {
		return neartj;
	}
	/**
	 * 设置：瞳高
	 */
	public void setTg(String tg) {
		this.tg = tg;
	}
	/**
	 * 获取：瞳高
	 */
	public String getTg() {
		return tg;
	}
	/**
	 * 设置：曲率
	 */
	public void setQulv(String qulv) {
		this.qulv = qulv;
	}
	/**
	 * 获取：曲率
	 */
	public String getQulv() {
		return qulv;
	}
	/**
	 * 设置：直径
	 */
	public void setZj(String zj) {
		this.zj = zj;
	}
	/**
	 * 获取：直径
	 */
	public String getZj() {
		return zj;
	}
	/**
	 * 设置：球镜yx
	 */
	public void setSphyx(String sphyx) {
		this.sphyx = sphyx;
	}
	/**
	 * 获取：球镜yx
	 */
	public String getSphyx() {
		return sphyx;
	}
	/**
	 * 设置：柱镜yx
	 */
	public void setCylyx(String cylyx) {
		this.cylyx = cylyx;
	}
	/**
	 * 获取：柱镜yx
	 */
	public String getCylyx() {
		return cylyx;
	}
	/**
	 * 设置：轴向yx
	 */
	public void setZxyx(String zxyx) {
		this.zxyx = zxyx;
	}

	/**
	 * 获取：轴向yx
	 */
	public String getZxyx() {
		return zxyx;
	}
	/**
	 * 获取：基底yx
	 */
	public String getJdyx() {
		return jdyx;
	}
	/**
	 * 设置：基底yx
	 */
	public void setJdyx(String jdyx) {
		this.jdyx = jdyx;
	}
	/**
	 * 设置：商品代码
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 获取：商品代码
	 */
	public String getNum() {
		return num;
	}
	/**
	 * 设置：商品条码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：商品条码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：商品名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：镜片型左右
	 */
	public void setLeftRight(String leftRight) {
		this.leftRight = leftRight;
	}
	/**
	 * 获取：镜片型左右
	 */
	public String getLeftRight() {
		return leftRight;
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
	 * 设置：要求
	 */
	public void setYaoqiu(String yaoqiu) {
		this.yaoqiu = yaoqiu;
	}
	/**
	 * 获取：要求
	 */
	public String getYaoqiu() {
		return yaoqiu;
	}
	/**
	 * 设置：商品代码yx
	 */
	public void setNumyx(String numyx) {
		this.numyx = numyx;
	}
	/**
	 * 获取：商品代码yx
	 */
	public String getNumyx() {
		return numyx;
	}
	/**
	 * 设置：商品条码yx
	 */
	public void setCodeyx(String codeyx) {
		this.codeyx = codeyx;
	}
	/**
	 * 获取：商品条码yx
	 */
	public String getCodeyx() {
		return codeyx;
	}
	/**
	 * 设置：商品名称yx
	 */
	public void setNameyx(String nameyx) {
		this.nameyx = nameyx;
	}
	/**
	 * 获取：商品名称yx
	 */
	public String getNameyx() {
		return nameyx;
	}
	/**
	 * 设置：镜片型左右yx
	 */
	public void setLeftRightYx(String leftRightYx) {
		this.leftRightYx = leftRightYx;
	}
	/**
	 * 获取：镜片型左右yx
	 */
	public String getLeftRightYx() {
		return leftRightYx;
	}
	/**
	 * 设置：数量yx
	 */
	public void setCountyx(String countyx) {
		this.countyx = countyx;
	}
	/**
	 * 获取：数量yx
	 */
	public String getCountyx() {
		return countyx;
	}
	/**
	 * 设置：要求隐形
	 */
	public void setYaoqiuyx(String yaoqiuyx) {
		this.yaoqiuyx = yaoqiuyx;
	}
	/**
	 * 获取：要求隐形
	 */
	public String getYaoqiuyx() {
		return yaoqiuyx;
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
}
