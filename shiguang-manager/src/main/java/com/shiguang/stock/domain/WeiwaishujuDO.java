package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-10-20 14:14:36
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
	//球镜OD
	private String rightsph;
	//球镜OS
	private String leftsph;
	//柱镜OD
	private String rightcyl;
	//柱镜OS
	private String leftcyl;
	//轴向OD
	private String rightzx;
	//轴向OS
	private String leftzx;
	//AddOD
	private String rightAdd;
	//AddOS
	private String leftAdd;
	//三棱镜OD
	private String rightSlj;
	//三棱镜OS
	private String leftSlj;
	//基底OD
	private String rightJd;
	//基底OS
	private String leftJd;
	//远瞳距OD
	private String rightFartj;
	//远瞳距OS
	private String leftFartj;
	//近瞳距OD
	private String rightNeartj;
	//近瞳距OS
	private String leftNeartj;
	//曲率OD
	private String rightqulv;
	//曲率OS
	private String leftqulv;
	//直径OD
	private String rightzj;
	//直径OS
	private String leftzj;
	//球镜ODyx
	private String rightsphyx;
	//球镜OSyx
	private String leftsphyx;
	//柱镜ODyx
	private String rightcylyx;
	//柱镜OSyx
	private String leftcylyx;
	//轴向ODyx
	private String rightzxyx;
	//轴向OSyx
	private String leftzxyx;


	//商品代码
	private String num;
	//条码
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeyx() {
		return codeyx;
	}

	public void setCodeyx(String codeyx) {
		this.codeyx = codeyx;
	}

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
	 * 设置：球镜OD
	 */
	public void setRightsph(String rightsph) {
		this.rightsph = rightsph;
	}
	/**
	 * 获取：球镜OD
	 */
	public String getRightsph() {
		return rightsph;
	}
	/**
	 * 设置：球镜OS
	 */
	public void setLeftsph(String leftsph) {
		this.leftsph = leftsph;
	}
	/**
	 * 获取：球镜OS
	 */
	public String getLeftsph() {
		return leftsph;
	}
	/**
	 * 设置：柱镜OD
	 */
	public void setRightcyl(String rightcyl) {
		this.rightcyl = rightcyl;
	}
	/**
	 * 获取：柱镜OD
	 */
	public String getRightcyl() {
		return rightcyl;
	}
	/**
	 * 设置：柱镜OS
	 */
	public void setLeftcyl(String leftcyl) {
		this.leftcyl = leftcyl;
	}
	/**
	 * 获取：柱镜OS
	 */
	public String getLeftcyl() {
		return leftcyl;
	}
	/**
	 * 设置：轴向OD
	 */
	public void setRightzx(String rightzx) {
		this.rightzx = rightzx;
	}
	/**
	 * 获取：轴向OD
	 */
	public String getRightzx() {
		return rightzx;
	}
	/**
	 * 设置：轴向OS
	 */
	public void setLeftzx(String leftzx) {
		this.leftzx = leftzx;
	}
	/**
	 * 获取：轴向OS
	 */
	public String getLeftzx() {
		return leftzx;
	}
	/**
	 * 设置：AddOD
	 */
	public void setRightAdd(String rightAdd) {
		this.rightAdd = rightAdd;
	}
	/**
	 * 获取：AddOD
	 */
	public String getRightAdd() {
		return rightAdd;
	}
	/**
	 * 设置：AddOS
	 */
	public void setLeftAdd(String leftAdd) {
		this.leftAdd = leftAdd;
	}
	/**
	 * 获取：AddOS
	 */
	public String getLeftAdd() {
		return leftAdd;
	}
	/**
	 * 设置：三棱镜OD
	 */
	public void setRightSlj(String rightSlj) {
		this.rightSlj = rightSlj;
	}
	/**
	 * 获取：三棱镜OD
	 */
	public String getRightSlj() {
		return rightSlj;
	}
	/**
	 * 设置：三棱镜OS
	 */
	public void setLeftSlj(String leftSlj) {
		this.leftSlj = leftSlj;
	}
	/**
	 * 获取：三棱镜OS
	 */
	public String getLeftSlj() {
		return leftSlj;
	}
	/**
	 * 设置：基底OD
	 */
	public void setRightJd(String rightJd) {
		this.rightJd = rightJd;
	}
	/**
	 * 获取：基底OD
	 */
	public String getRightJd() {
		return rightJd;
	}
	/**
	 * 设置：基底OS
	 */
	public void setLeftJd(String leftJd) {
		this.leftJd = leftJd;
	}
	/**
	 * 获取：基底OS
	 */
	public String getLeftJd() {
		return leftJd;
	}
	/**
	 * 设置：远瞳距OD
	 */
	public void setRightFartj(String rightFartj) {
		this.rightFartj = rightFartj;
	}
	/**
	 * 获取：远瞳距OD
	 */
	public String getRightFartj() {
		return rightFartj;
	}
	/**
	 * 设置：远瞳距OS
	 */
	public void setLeftFartj(String leftFartj) {
		this.leftFartj = leftFartj;
	}
	/**
	 * 获取：远瞳距OS
	 */
	public String getLeftFartj() {
		return leftFartj;
	}
	/**
	 * 设置：近瞳距OD
	 */
	public void setRightNeartj(String rightNeartj) {
		this.rightNeartj = rightNeartj;
	}
	/**
	 * 获取：近瞳距OD
	 */
	public String getRightNeartj() {
		return rightNeartj;
	}
	/**
	 * 设置：近瞳距OS
	 */
	public void setLeftNeartj(String leftNeartj) {
		this.leftNeartj = leftNeartj;
	}
	/**
	 * 获取：近瞳距OS
	 */
	public String getLeftNeartj() {
		return leftNeartj;
	}
	/**
	 * 设置：曲率OD
	 */
	public void setRightqulv(String rightqulv) {
		this.rightqulv = rightqulv;
	}
	/**
	 * 获取：曲率OD
	 */
	public String getRightqulv() {
		return rightqulv;
	}
	/**
	 * 设置：曲率OS
	 */
	public void setLeftqulv(String leftqulv) {
		this.leftqulv = leftqulv;
	}
	/**
	 * 获取：曲率OS
	 */
	public String getLeftqulv() {
		return leftqulv;
	}
	/**
	 * 设置：直径OD
	 */
	public void setRightzj(String rightzj) {
		this.rightzj = rightzj;
	}
	/**
	 * 获取：直径OD
	 */
	public String getRightzj() {
		return rightzj;
	}
	/**
	 * 设置：直径OS
	 */
	public void setLeftzj(String leftzj) {
		this.leftzj = leftzj;
	}
	/**
	 * 获取：直径OS
	 */
	public String getLeftzj() {
		return leftzj;
	}
	/**
	 * 设置：球镜ODyx
	 */
	public void setRightsphyx(String rightsphyx) {
		this.rightsphyx = rightsphyx;
	}
	/**
	 * 获取：球镜ODyx
	 */
	public String getRightsphyx() {
		return rightsphyx;
	}
	/**
	 * 设置：球镜OSyx
	 */
	public void setLeftsphyx(String leftsphyx) {
		this.leftsphyx = leftsphyx;
	}
	/**
	 * 获取：球镜OSyx
	 */
	public String getLeftsphyx() {
		return leftsphyx;
	}
	/**
	 * 设置：柱镜ODyx
	 */
	public void setRightcylyx(String rightcylyx) {
		this.rightcylyx = rightcylyx;
	}
	/**
	 * 获取：柱镜ODyx
	 */
	public String getRightcylyx() {
		return rightcylyx;
	}
	/**
	 * 设置：柱镜OSyx
	 */
	public void setLeftcylyx(String leftcylyx) {
		this.leftcylyx = leftcylyx;
	}
	/**
	 * 获取：柱镜OSyx
	 */
	public String getLeftcylyx() {
		return leftcylyx;
	}
	/**
	 * 设置：轴向ODyx
	 */
	public void setRightzxyx(String rightzxyx) {
		this.rightzxyx = rightzxyx;
	}
	/**
	 * 获取：轴向ODyx
	 */
	public String getRightzxyx() {
		return rightzxyx;
	}
	/**
	 * 设置：轴向OSyx
	 */
	public void setLeftzxyx(String leftzxyx) {
		this.leftzxyx = leftzxyx;
	}
	/**
	 * 获取：轴向OSyx
	 */
	public String getLeftzxyx() {
		return leftzxyx;
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
