package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 *
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2022-01-24 10:57:24
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
	//制造商代码
	private String mfrsid;
	//制造商名称
	private String mfrsname;
	//品牌代码
	private String brandnum;
	//品牌名称
	private String brandname;
	//仓位id
	private Long positionId;
	//仓位名称
	private String positionName;
	//收货联系人
	private String shouhuoPeople;
	//收货联系电话
	private String shouhuoPhone;
	//收货地址
	private String shouhuoAddress;
	//厂家订单号
	private String changjiaNumber;
	//备注
	private String beizhu;
	//委外配镜单号
	private String weiwaisaleNumber;
	//取镜时间
	private String mirrorTime;
	//代码
	private String num;
	//条码
	private String code;
	//商品名称
	private String name;
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
	private String zx;
	//下加
	private String add;
	//棱镜
	private String slj;
	//直径
	private String zj;
	//加工要求
	private String yaoqiu;
	//基底
	private String jd;
	//曲率
	private String qulv;
	//远瞳
	private String fartj;
	//近瞳
	private String neartj;
	//瞳高
	private String tg;
	//顾客姓名
	private String gkname;
	//会员卡
	private String hyknum;
	//手机号
	private String phone;
	//1未收货，0已收货未配送
	private String status;
	//工号
	private String username;
	//收货时间
	private String shTime;
	//0配送,1退回
	private String shstatus;
	//配送人员
	private String psname;
	//原配镜单
	private String saleNumber;
	//配送或退回时间
	private String pstime;
	//库存对应单据号
	private String stockorder;
	//公司名称
	private String companyName;
	//部门名称
	private String departname;
	//条码
	private String QRCode;


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
	 * 设置：制造商代码
	 */
	public void setMfrsid(String mfrsid) {
		this.mfrsid = mfrsid;
	}
	/**
	 * 获取：制造商代码
	 */
	public String getMfrsid() {
		return mfrsid;
	}
	/**
	 * 设置：制造商名称
	 */
	public void setMfrsname(String mfrsname) {
		this.mfrsname = mfrsname;
	}
	/**
	 * 获取：制造商名称
	 */
	public String getMfrsname() {
		return mfrsname;
	}
	/**
	 * 设置：品牌代码
	 */
	public void setBrandnum(String brandnum) {
		this.brandnum = brandnum;
	}
	/**
	 * 获取：品牌代码
	 */
	public String getBrandnum() {
		return brandnum;
	}
	/**
	 * 设置：品牌名称
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandname() {
		return brandname;
	}
	/**
	 * 设置：仓位id
	 */
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	/**
	 * 获取：仓位id
	 */
	public Long getPositionId() {
		return positionId;
	}
	/**
	 * 设置：仓位名称
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	/**
	 * 获取：仓位名称
	 */
	public String getPositionName() {
		return positionName;
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
	 * 设置：委外配镜单号
	 */
	public void setWeiwaisaleNumber(String weiwaisaleNumber) {
		this.weiwaisaleNumber = weiwaisaleNumber;
	}
	/**
	 * 获取：委外配镜单号
	 */
	public String getWeiwaisaleNumber() {
		return weiwaisaleNumber;
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
	 * 设置：代码
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 获取：代码
	 */
	public String getNum() {
		return num;
	}
	/**
	 * 设置：条码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：条码
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
	 * 设置：下加
	 */
	public void setAdd(String add) {
		this.add = add;
	}
	/**
	 * 获取：下加
	 */
	public String getAdd() {
		return add;
	}
	/**
	 * 设置：棱镜
	 */
	public void setSlj(String slj) {
		this.slj = slj;
	}
	/**
	 * 获取：棱镜
	 */
	public String getSlj() {
		return slj;
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
	public void setQulv(String qulv) {
		this.qulv = qulv;
	}
	/**
	 * 获取：曲率
	 */
	public String getQulv() {
		return qulv;
	}

	public String getFartj() {
		return fartj;
	}

	public void setFartj(String fartj) {
		this.fartj = fartj;
	}

	public String getNeartj() {
		return neartj;
	}

	public void setNeartj(String neartj) {
		this.neartj = neartj;
	}

	public String getTg() {
		return tg;
	}

	public void setTg(String tg) {
		this.tg = tg;
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
	 * 设置：1未收货，0已收货未配送
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：1未收货，0已收货未配送
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：工号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：工号
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：收货时间
	 */
	public void setShTime(String shTime) {
		this.shTime = shTime;
	}
	/**
	 * 获取：收货时间
	 */
	public String getShTime() {
		return shTime;
	}
	/**
	 * 设置：0配送,1退回
	 */
	public void setShstatus(String shstatus) {
		this.shstatus = shstatus;
	}
	/**
	 * 获取：0配送,1退回
	 */
	public String getShstatus() {
		return shstatus;
	}
	/**
	 * 设置：配送人员
	 */
	public void setPsname(String psname) {
		this.psname = psname;
	}
	/**
	 * 获取：配送人员
	 */
	public String getPsname() {
		return psname;
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
	 * 设置：配送或退回时间
	 */
	public void setPstime(String pstime) {
		this.pstime = pstime;
	}
	/**
	 * 获取：配送或退回时间
	 */
	public String getPstime() {
		return pstime;
	}
	/**
	 * 设置：库存对应单据号
	 */
	public void setStockorder(String stockorder) {
		this.stockorder = stockorder;
	}
	/**
	 * 获取：库存对应单据号
	 */
	public String getStockorder() {
		return stockorder;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getQRCode() {
		return QRCode;
	}

	public void setQRCode(String QRCode) {
		this.QRCode = QRCode;
	}
}
