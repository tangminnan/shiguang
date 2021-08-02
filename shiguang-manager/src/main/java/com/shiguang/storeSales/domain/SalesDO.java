package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 门店销售
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-06 15:09:24
 */
public class SalesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//验光号
	private String ptometryNumber;
	//会员卡号
	private String memberNumber;
	private String memberName;
	private String memberTel;
	//顾客性别(1:男2:女)
	private Long sex;
	private String sexx;
	//年龄
	private Long age;
	//联系电话1
	private String phone1;
	//销售人员
	private String saleName;
	//销售单号
	private String saleNumber;
	//眼镜类型
	private String eyeType;
	//结算金额
	private Double amountMoney;
	//取镜方式
	private String mirrorWay;
	//取镜日期
	private Date mirrorTime;
	//取镜地点
	private String mirorAddress;
	//取镜地点编码
	private String storeNum;
	//加急状态
	private String urgentStatus;
	//商品打折
	private Double goodsRebate;
	//一口价
	private Double fixedPrice;
	//抹零金额
	private Double molingMoney;
	//附加费用
	private String additionalCost;
	//附加费用单价
	private String additionalPrice;
	//附加费用数量
	private String additionalCount;
	//加工要求
	private String processAsk;
	//商品名称
	private String storeName;
	//商品描述
	private String storeDescribe;
	//单价
	private String storeUnit;
	//数量
	private String storeCount;
	//单位
	private String unit;
	//销售备注
	private String saleremark;
	private String taocanName;
	//赠品
	private String giveName;
	//是否有镜片
	private String isJj;
	//是否有镜架
	private Long isJp;
	//配镜日期
	private Date peijingTime;
	private String peijingDate;
	//验光师
	private String optometryName;
	//外来处方类型
	private String outRecipel;
	//处方类型
	private String recipelType;
	//外来验光师
	private String optometrywlName;
	//处方类型(外来)
	private Long recipelwlType;
	//外来处方
	private String chufang;
	//手填处方的度数
	//球镜OD
	private Double rightQJ;
	//柱镜OD
	private Double rightZJ;
	//轴向OD
	private Double rightzhouxiang;
	//三棱镜OD
	private Double rightsanlingjing;
	//基地OD
	private String rightjidi;
	//远用瞳距OD
	private Double rightyuanyongtj;
	//瞳高OD
	private Double righttonggao;
	//远用VA(OD)
	private Double rightyuanyongVA;
	//球镜OS
	private Double leftQJ;
	//柱镜OS
	private Double leftZJ;
	//轴向OS
	private Double leftzhouxiang;
	//三棱镜OS
	private Double leftsanlingjing;
	//基地OS
	private String leftjidi;
	//远用瞳距OD
	private Double leftyuanyongtj;
	//瞳高OS
	private Double lefttonggao;
	//远用VA(OS)
	private Double leftyuanyongVA;
	//备注
	private String remark;
	//旧瞳距
	private Double oldtongju;
	//片高
	private Double piangao;
	//片宽
	private Double piankuan;
	//中梁
	private Double zhongliang;
	//镜片通道
	private Double jingpiantongdao;
	//对角线
	private Double duijiaoxian;
	//框型
	private String kuangxing;
	//直径
	private Double zhijing;
	//RGP
	//屈光度(OD)
	private Double rightRgpgd;
	//屈光度OS
	private Double leftRgpgd;
	//BC(OD)
	private Double rightBC;
	//BC(OS)
	private Double leftBC;
	//DIA(OD)
	private Double rightDIA;
	//DIA(OS)
	private Double leftDIA;
	//散光OD
	private Double rightsg;
	//散光OS
	private Double leftsg;
	//镜片颜色OD
	private String rightJPColor;
	//镜片颜色OS
	private String leftJPColor;
	//特殊设计OD
	private String rightTssj;
	//特殊设计OS
	private String leftTssj;
	//品牌OD
	private String rightPinpai;
	//品牌OS
	private String leftPinpai;
	//药品
	//内容
	private String content;
	//药名
	private String ypName;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：验光号
	 */
	public void setPtometryNumber(String ptometryNumber) {
		this.ptometryNumber = ptometryNumber;
	}
	/**
	 * 获取：验光号
	 */
	public String getPtometryNumber() {
		return ptometryNumber;
	}
	/**
	 * 设置：会员卡号
	 */
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	/**
	 * 获取：会员卡号
	 */
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberName(String memberName) {this.memberName = memberName;}
	public String getMemberName() {return memberName;}
	public void setMemberTel(String memberTel) {this.memberTel = memberTel;}
	public String getMemberTel(){return memberTel;}
	/**
	 * 设置：顾客性别(0:男1:女)
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：顾客性别(0:男1:女)
	 */
	public Long getSex() {
		return sex;
	}

	/**
	 * 设置：顾客性别
	 */
	public void setSexx(String sexx) {
		this.sexx = sexx;
	}
	/**
	 * 获取：顾客性别
	 */
	public String getSexx() {
		return sexx;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Long age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Long getAge() {
		return age;
	}
	/**
	 * 设置：联系电话1
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * 获取：联系电话1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * 设置：销售人员
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	/**
	 * 获取：销售人员
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * 设置：销售单号
	 */
	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}
	/**
	 * 获取：销售单号
	 */
	public String getSaleNumber() {
		return saleNumber;
	}
	/**
	 * 设置：眼镜类型
	 */
	public void setEyeType(String eyeType) {
		this.eyeType = eyeType;
	}
	/**
	 * 获取：眼镜类型
	 */
	public String getEyeType() {
		return eyeType;
	}
	/**
	 * 设置：结算金额
	 */
	public void setAmountMoney(Double amountMoney) {
		this.amountMoney = amountMoney;
	}
	/**
	 * 获取：结算金额
	 */
	public Double getAmountMoney() {
		return amountMoney;
	}
	/**
	 * 设置：取镜方式
	 */
	public void setMirrorWay(String mirrorWay) {
		this.mirrorWay = mirrorWay;
	}
	/**
	 * 获取：取镜方式
	 */
	public String getMirrorWay() {
		return mirrorWay;
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
	 * 设置：取镜地点
	 */
	public void setMirorAddress(String mirorAddress) {
		this.mirorAddress = mirorAddress;
	}
	/**
	 * 获取：取镜地点
	 */
	public String getMirorAddress() {
		return mirorAddress;
	}

	public void setStoreNum(String storeNum) {this.storeNum = storeNum;}

	public String getStoreNum() {return storeNum;}

	/**
	 * 设置：加急状态
	 */
	public void setUrgentStatus(String urgentStatus) {
		this.urgentStatus = urgentStatus;
	}
	/**
	 * 获取：加急状态
	 */
	public String getUrgentStatus() {
		return urgentStatus;
	}
	/**
	 * 设置：商品打折
	 */
	public void setGoodsRebate(Double goodsRebate) {
		this.goodsRebate = goodsRebate;
	}
	/**
	 * 获取：商品打折
	 */
	public Double getGoodsRebate() {
		return goodsRebate;
	}
	/**
	 * 设置：一口价
	 */
	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	/**
	 * 获取：一口价
	 */
	public Double getFixedPrice() {
		return fixedPrice;
	}
	/**
	 * 设置：抹零金额
	 */
	public void setMolingMoney(Double molingMoney) {
		this.molingMoney = molingMoney;
	}
	/**
	 * 获取：抹零金额
	 */
	public Double getMolingMoney() {
		return molingMoney;
	}
	/**
	 * 设置：附加费用
	 */
	public void setAdditionalCost(String additionalCost) {
		this.additionalCost = additionalCost;
	}
	/**
	 * 获取：附加费用
	 */
	public String getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalPrice(String additionalPrice) {this.additionalPrice = additionalPrice;}

	public String getAdditionalPrice() {return additionalPrice;}

	public void setAdditionalCount(String additionalCount) {this.additionalCount = additionalCount;}

	public String getAdditionalCount() {return additionalCount;}

	/**
	 * 设置：加工要求
	 */
	public void setProcessAsk(String processAsk) {
		this.processAsk = processAsk;
	}
	/**
	 * 获取：加工要求
	 */
	public String getProcessAsk() {
		return processAsk;
	}
	/**
	 * 设置：商品名称
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * 设置：商品描述
	 */
	public void setStoreDescribe(String storeDescribe) {
		this.storeDescribe = storeDescribe;
	}
	/**
	 * 获取：商品描述
	 */
	public String getStoreDescribe() {
		return storeDescribe;
	}
	/**
	 * 设置：单价
	 */
	public void setStoreUnit(String storeUnit) {
		this.storeUnit = storeUnit;
	}
	/**
	 * 获取：单价
	 */
	public String getStoreUnit() {
		return storeUnit;
	}
	/**
	 * 设置：数量
	 */
	public void setStoreCount(String storeCount) {
		this.storeCount = storeCount;
	}
	/**
	 * 获取：数量
	 */
	public String getStoreCount() {
		return storeCount;
	}

	public void setUnit(String unit) {this.unit = unit;}

	public String getUnit() {return unit;}

	/**
	 * 设置：销售备注
	 */
	public void setSaleremark(String saleremark) {this.saleremark = saleremark;}
	/**
	 * 获取：销售备注
	 */
	public String getSaleremark() {return saleremark;}

	public void setTaocanName(String taocanName) {this.taocanName = taocanName;}

	public String getTaocanName() {return taocanName;}

	/**
	 * 设置：赠品
	 */
	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}
	/**
	 * 获取：赠品
	 */
	public String getGiveName() {
		return giveName;
	}

	public void setIsJj(String isJj){this.isJj = isJj;}

	public String getIsJj(){return isJj;}

	public void setIsJp(Long isJp){this.isJp=isJp;}

	public Long getIsJp(){return isJp;}

	/**
	 * 设置：配镜日期
	 */
	public void setPeijingTime(Date peijingTime) {
		this.peijingTime = peijingTime;
	}
	/**
	 * 获取：配镜日期
	 */
	public Date getPeijingTime() {
		return peijingTime;
	}

	/**
	 * 设置：配镜日期
	 */
	public void setPeijingDate(String peijingDate) {
		this.peijingDate = peijingDate;
	}
	/**
	 * 获取：配镜日期
	 */
	public String getPeijingDate() {
		return peijingDate;
	}

	/**
	 * 获取：验光师
	 */
	public String getOptometryName() {
		return optometryName;
	}
	/**
	 * 设置：验光师
	 */
	public void setOptometryName(String optometryName) {
		this.optometryName = optometryName;
	}

	/**
	 * 获取：外来处方
	 */
	public String getOutRecipel() {
		return outRecipel;
	}
	/**
	 * 设置：外来处方
	 */
	public void setOutRecipel(String outRecipel) {
		this.outRecipel = outRecipel;
	}

	/**
	 * 获取：处方类型
	 */
	public String getRecipelType() {
		return recipelType;
	}
	/**
	 * 设置：外来类型
	 */
	public void setRecipelType(String recipelType) {
		this.recipelType = recipelType;
	}
	public void setOptometrywlName(String optometrywlName) {this.optometrywlName = optometrywlName;}
	public String getOptometrywlName() {return optometrywlName;}
	public void setRecipelwlType(Long recipelwlType) {this.recipelwlType = recipelwlType;}
	public Long getRecipelwlType() {return recipelwlType;}
	/**
	 * 外来处方
	 */
	public void setChufang(String chufang){this.chufang = chufang;}
	/**
	 * 外来处方
	 */
	public String getChufang() {return chufang;}
	/**
	 * 球镜OD
	 */
	public void setRightQJ(Double rightQJ) {this.rightQJ = rightQJ;}
	/**
	 * 球镜OD
	 */
	public Double getRightQJ(){return rightQJ;}
	/**
	 * 柱镜OD
	 */
	public void setRightZJ(Double rightZJ) {this.rightZJ = rightZJ;}
	/**
	 * 柱镜OD
	 */
	public Double getRightZJ() {return rightZJ;}
	/**
	 * 轴向OD
	 */
	public void setRightzhouxiang(Double rightzhouxiang) {this.rightzhouxiang = rightzhouxiang;}
	/**
	 * 轴向OD
	 */
	public Double getRightzhouxiang(){return rightzhouxiang;}
	/**
	 * 三棱镜OD
	 */
	public void setRightsanlingjing(Double rightsanlingjing) {this.rightsanlingjing = rightsanlingjing;}
	/**
	 * 三棱镜OD
	 */
	public Double getRightsanlingjing() {return rightsanlingjing;}
	/**
	 * 基地OD
	 */
	public void setRightjidi(String rightjidi) {this.rightjidi = rightjidi;}
	/**
	 * 基地OD
	 */
	public String getRightjidi() {return rightjidi;}
	/**
	 * 远用瞳距OD
	 */
	public void setRightyuanyongtj(Double rightyuanyongtj) {this.rightyuanyongtj = rightyuanyongtj;}
	/**
	 * 远用瞳距OD
	 */
	public Double getRightyuanyongtj() {return rightyuanyongtj;}
	/**
	 * 瞳高OD
	 */
	public void setRighttonggao(Double righttonggao) {this.righttonggao = righttonggao;}
	/**
	 * 瞳高OD
	 */
	public Double getRighttonggao() {return righttonggao;}
	/**
	 * 远用VA(OD)
	 */
	public void setRightyuanyongVA(Double rightyuanyongVA) {this.rightyuanyongVA = rightyuanyongVA;}
	/**
	 * 远用VA(OD)
	 */
	public Double getRightyuanyongVA() {return rightyuanyongVA;}
	/**
	 * 球镜OS
	 */
	public void setLeftQJ(Double leftQJ){this.leftQJ = leftQJ;}
	/**
	 * 球镜OS
	 */
	public Double getLeftQJ() {return leftQJ;}
	/**
	 * 柱镜OS
	 */
	public void setLeftZJ(Double leftZJ) {this.leftZJ = leftZJ;}
	/**
	 * 柱镜OS
	 */
	public Double getLeftZJ() {return leftZJ;}
	/**
	 * 轴向OS
	 */
	public void setLeftzhouxiang(Double leftzhouxiang) {this.leftzhouxiang = leftzhouxiang;}
	/**
	 * 轴向OS
	 */
	public Double getLeftzhouxiang() {return leftzhouxiang;}
	/**
	 * 三棱镜OS
	 */
	public void setLeftsanlingjing(Double leftsanlingjing) {this.leftsanlingjing = leftsanlingjing;}
	/**
	 * 三棱镜OS
	 */
	public Double getLeftsanlingjing(){return leftsanlingjing;}
	/**
	 * 基地OS
	 */
	public void setLeftjidi(String leftjidi) {this.leftjidi = leftjidi;}
	/**
	 * 基地OS
	 */
	public String getLeftjidi() {return leftjidi;}
	/**
	 * 远用瞳距OS
	 */
	public void setLeftyuanyongtj(Double leftyuanyongtj) {this.leftyuanyongtj = leftyuanyongtj;}
	/**
	 * 远用瞳距OS
	 */
	public Double getLeftyuanyongtj(){return leftyuanyongtj;}
	/**
	 * 瞳高OS
	 */
	public void setLefttonggao(Double lefttonggao){this.lefttonggao = lefttonggao;}
	/**
	 * 瞳高OS
	 */
	public Double getLefttonggao(){return lefttonggao;}
	/**
	 * 远用VA(OS)
	 */
	public void setLeftyuanyongVA(Double leftyuanyongVA) {this.leftyuanyongVA = leftyuanyongVA;}
	/**
	 * 远用VA(OS)
	 */
	public Double getLeftyuanyongVA() {return leftyuanyongVA;}
	/**
	 * 获取：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 设置：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 旧瞳距
	 */
	public void setOldtongju(Double oldtongju) {this.oldtongju = oldtongju;}
	/**
	 * 旧瞳距
	 */
	public Double getOldtongju(){return oldtongju;}
	/**
	 * 片高
	 */
	public void setPiangao(Double piangao) {this.piangao = piangao;}
	/**
	 * 片高
	 */
	public Double getPiangao() {return piangao;}
	/**
	 * 片宽
	 */
	public void setPiankuan(Double piankuan) {this.piankuan = piankuan;}
	/**
	 * 片宽
	 */
	public Double getPiankuan() {return piankuan;}
	/**
	 * 中梁
	 */
	public void setZhongliang(Double zhongliang) {this.zhongliang = zhongliang;}
	/**
	 * 中梁
	 */
	public Double getZhongliang() {return zhongliang;}
	/**
	 * 镜片通道
	 */
	public void setJingpiantongdao(Double jingpiantongdao) {this.jingpiantongdao = jingpiantongdao;}
	/**
	 * 镜片通道
	 */
	public Double getJingpiantongdao(){return jingpiantongdao;}
	/**
	 * 对角线
	 */
	public void setDuijiaoxian(Double duijiaoxian) {this.duijiaoxian = duijiaoxian;}
	/**
	 * 对角线
	 */
	public Double getDuijiaoxian() {return duijiaoxian;}
	/**
	 * 框型
	 */
	public void setKuangxing(String kuangxing) {this.kuangxing = kuangxing;}
	/**
	 * 框型
	 */
	public String getKuangxing() {return kuangxing;}
	/**
	 * 直径
	 */
	public void setZhijing(Double zhijing) {this.zhijing = zhijing;}
	/**
	 * 直径
	 */
	public Double getZhijing(){return zhijing;}

	/**
	 * 屈光度OD
	 */
	public void setRightRgpgd(Double rightRgpgd) {this.rightRgpgd = rightRgpgd;}
	/**
	 * 屈光度OD
	 */
	public Double getRightRgpgd() {return rightRgpgd;}
	/**
	 * 屈光度OS
	 */
	public void setLeftRgpgd(Double leftRgpgd) {this.leftRgpgd = leftRgpgd;}
	/**
	 * 屈光度OS
	 */
	public Double getLeftRgpgd() {return leftRgpgd;}
	/**
	 * BC(OD)
	 */
	public void setRightBC(Double rightBC) {this.rightBC = rightBC;}
	/**
	 * BC(OD)
	 */
	public Double getRightBC(){return rightBC;}
	/**
	 * BC(OS)
	 */
	public void setLeftBC(Double leftBC) {this.leftBC = leftBC;}
	/**
	 * BC(OS)
	 */
	public Double getLeftBC() {return leftBC;}
	/**
	 * DIA(OD)
	 */
	public void setRightDIA(Double rightDIA) {this.rightDIA = rightDIA;}
	/**
	 * DIA(OD)
	 */
	public Double getRightDIA() {return rightDIA;}
	/**
	 * DIA(OS)
	 */
	public void setLeftDIA(Double leftDIA) {this.leftDIA = leftDIA;}
	/**
	 * DIA(OS)
	 */
	public Double getLeftDIA() {return leftDIA;}
	/**
	 * 散光(OD)
	 */
	public void setRightsg(Double rightsg) {this.rightsg = rightsg;}
	/**
	 * 散光(OD)
	 */
	public Double getRightsg() {return rightsg;}
	/**
	 * 散光(OS)
	 */
	public void setLeftsg(Double leftsg) {this.leftsg = leftsg;}
	/**
	 * 散光(OS)
	 */
	public Double getLeftsg() {return leftsg;}
	/**
	 * 镜片颜色OD
	 */
	public void setRightJPColor(String rightJPColor) {this.rightJPColor = rightJPColor;}
	/**
	 * 镜片颜色OD
	 */
	public String getRightJPColor() {return rightJPColor;}
	/**
	 * 镜片颜色OS
	 */
	public void setLeftJPColor(String leftJPColor) {this.leftJPColor = leftJPColor;}
	/**
	 * 镜片颜色OS
	 */
	public String getLeftJPColor() {return leftJPColor;}
	/**
	 * 特殊设计OD
	 */
	public void setRightTssj(String rightTssj) {this.rightTssj = rightTssj;}
	/**
	 * 特殊设计OD
	 */
	public String getRightTssj() {return rightTssj;}
	/**
	 * 特殊设计OS
	 */
	public void setLeftTssj(String leftTssj) {this.leftTssj = leftTssj;}
	/**
	 * 特殊设计OS
	 */
	public String getLeftTssj(){return leftTssj;}
	/**
	 * 品牌OD
	 */
	public void setRightPinpai(String rightPinpai) {this.rightPinpai = rightPinpai;}
	/**
	 * 品牌OD
	 */
	public String getRightPinpai(){return rightPinpai;}
	/**
	 * 品牌OS
	 */
	public void setLeftPinpai(String leftPinpai) {this.leftPinpai = leftPinpai;}
	/**
	 * 品牌OS
	 */
	public String getLeftPinpai(){return leftPinpai;}

	/**
	 * 内容
	 */
	public String getContent() {return content;}
	/**
	 * 内容
	 */
	public void setContent(String content) {this.content= content;}
	/**
	 * 药名
	 */
	public void setYpName(String ypName) {this.ypName = ypName;}
	/**
	 * 药名
	 */
	public String getYpName() {return ypName;}

}
