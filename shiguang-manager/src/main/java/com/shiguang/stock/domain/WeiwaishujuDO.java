package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-18 19:36:15
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
	//商品代码OD
	private String rightNum;
	//商品代码OS
	private String leftNum;
	//商品名称OD
	private String rightName;
	//商品名称OS
	private String leftName;
	//镜片型OD
	private String rightR;
	//镜片型OS
	private String leftL;
	//数量OD
	private String countr;
	//数量OS
	private String countl;
	//要求OD
	private String yaoqiur;
	//要求OS
	private String yaoqiul;
	//商品代码ODyx
	private String rightNumyx;
	//商品代码OSyx
	private String leftNumyx;
	//商品名称ODyx
	private String rightNameyx;
	//商品名称OSyx
	private String leftNameyx;
	//镜片型ODyx
	private String rightRyx;
	//镜片型OSyx
	private String leftLyx;
	//数量ODyx
	private String countryx;
	//数量OS
	private String countlyx;
	//要求OD
	private String yaoqiuryx;
	//要求OS
	private String yaoqiulyx;
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
	public void setnumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：销售单号
	 */
	public String getnumber() {
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
	 * 设置：商品代码OD
	 */
	public void setRightNum(String rightNum) {
		this.rightNum = rightNum;
	}
	/**
	 * 获取：商品代码OD
	 */
	public String getRightNum() {
		return rightNum;
	}
	/**
	 * 设置：商品代码OS
	 */
	public void setLeftNum(String leftNum) {
		this.leftNum = leftNum;
	}
	/**
	 * 获取：商品代码OS
	 */
	public String getLeftNum() {
		return leftNum;
	}
	/**
	 * 设置：商品名称OD
	 */
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	/**
	 * 获取：商品名称OD
	 */
	public String getRightName() {
		return rightName;
	}
	/**
	 * 设置：商品名称OS
	 */
	public void setLeftName(String leftName) {
		this.leftName = leftName;
	}
	/**
	 * 获取：商品名称OS
	 */
	public String getLeftName() {
		return leftName;
	}
	/**
	 * 设置：镜片型OD
	 */
	public void setRightR(String rightR) {
		this.rightR = rightR;
	}
	/**
	 * 获取：镜片型OD
	 */
	public String getRightR() {
		return rightR;
	}
	/**
	 * 设置：镜片型OS
	 */
	public void setLeftL(String leftL) {
		this.leftL = leftL;
	}
	/**
	 * 获取：镜片型OS
	 */
	public String getLeftL() {
		return leftL;
	}
	/**
	 * 设置：数量OD
	 */
	public void setCountr(String countr) {
		this.countr = countr;
	}
	/**
	 * 获取：数量OD
	 */
	public String getCountr() {
		return countr;
	}
	/**
	 * 设置：数量OS
	 */
	public void setCountl(String countl) {
		this.countl = countl;
	}
	/**
	 * 获取：数量OS
	 */
	public String getCountl() {
		return countl;
	}
	/**
	 * 设置：要求OD
	 */
	public void setYaoqiur(String yaoqiur) {
		this.yaoqiur = yaoqiur;
	}
	/**
	 * 获取：要求OD
	 */
	public String getYaoqiur() {
		return yaoqiur;
	}
	/**
	 * 设置：要求OS
	 */
	public void setYaoqiul(String yaoqiul) {
		this.yaoqiul = yaoqiul;
	}
	/**
	 * 获取：要求OS
	 */
	public String getYaoqiul() {
		return yaoqiul;
	}
	/**
	 * 设置：商品代码ODyx
	 */
	public void setRightNumyx(String rightNumyx) {
		this.rightNumyx = rightNumyx;
	}
	/**
	 * 获取：商品代码ODyx
	 */
	public String getRightNumyx() {
		return rightNumyx;
	}
	/**
	 * 设置：商品代码OSyx
	 */
	public void setLeftNumyx(String leftNumyx) {
		this.leftNumyx = leftNumyx;
	}
	/**
	 * 获取：商品代码OSyx
	 */
	public String getLeftNumyx() {
		return leftNumyx;
	}
	/**
	 * 设置：商品名称ODyx
	 */
	public void setRightNameyx(String rightNameyx) {
		this.rightNameyx = rightNameyx;
	}
	/**
	 * 获取：商品名称ODyx
	 */
	public String getRightNameyx() {
		return rightNameyx;
	}
	/**
	 * 设置：商品名称OSyx
	 */
	public void setLeftNameyx(String leftNameyx) {
		this.leftNameyx = leftNameyx;
	}
	/**
	 * 获取：商品名称OSyx
	 */
	public String getLeftNameyx() {
		return leftNameyx;
	}
	/**
	 * 设置：镜片型ODyx
	 */
	public void setRightRyx(String rightRyx) {
		this.rightRyx = rightRyx;
	}
	/**
	 * 获取：镜片型ODyx
	 */
	public String getRightRyx() {
		return rightRyx;
	}
	/**
	 * 设置：镜片型OSyx
	 */
	public void setLeftLyx(String leftLyx) {
		this.leftLyx = leftLyx;
	}
	/**
	 * 获取：镜片型OSyx
	 */
	public String getLeftLyx() {
		return leftLyx;
	}
	/**
	 * 设置：数量ODyx
	 */
	public void setCountryx(String countryx) {
		this.countryx = countryx;
	}
	/**
	 * 获取：数量ODyx
	 */
	public String getCountryx() {
		return countryx;
	}
	/**
	 * 设置：数量OS
	 */
	public void setCountlyx(String countlyx) {
		this.countlyx = countlyx;
	}
	/**
	 * 获取：数量OS
	 */
	public String getCountlyx() {
		return countlyx;
	}
	/**
	 * 设置：要求OD
	 */
	public void setYaoqiuryx(String yaoqiuryx) {
		this.yaoqiuryx = yaoqiuryx;
	}
	/**
	 * 获取：要求OD
	 */
	public String getYaoqiuryx() {
		return yaoqiuryx;
	}
	/**
	 * 设置：要求OS
	 */
	public void setYaoqiulyx(String yaoqiulyx) {
		this.yaoqiulyx = yaoqiulyx;
	}
	/**
	 * 获取：要求OS
	 */
	public String getYaoqiulyx() {
		return yaoqiulyx;
	}

	public String getGkname() {
		return gkname;
	}

	public void setGkname(String gkname) {
		this.gkname = gkname;
	}

	public String getHyknum() {
		return hyknum;
	}

	public void setHyknum(String hyknum) {
		this.hyknum = hyknum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
