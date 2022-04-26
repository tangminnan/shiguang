package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
	//是否缴费
	private String saleType;
	private String username;
	private String store;
	private String createTime;
	private String usecount;
	private String ygcount;
	//会员卡号
	private String memberNumber;
	private String memberName;
	private String memberTel;
	private String address;
	//顾客性别(1:男2:女)
	private Long sex;
	private String sexx;
	//年龄
	private Long age;
	//联系电话1
	private String phone1;
	//销售人员
	private String saleName;
	//销售员工工号
	private String saleAccount;
	//用户名
	private String saleNum;
	//是否缴费
	private Long isSale;
	//实付金额
	private Double payMoney;
	//销售单号
	private String saleNumber;
	//商品代码
	private String goodsNum;
	//商品条码
	private String goodsCode;
	//眼镜类型
	private String eyeType;
	//结算金额
	private Double amountMoney;
	//原价金额
	private Double primeMoney;
	//取镜方式
	private String mirrorWay;
	//取镜日期
	private Date mirrorTime;
	private String mirrorDate;
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
	//品牌名称
	private String brandName;
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
	//收款日期
	private Date settleDate;
	private String settleTime;
	//验光师
	private String optometryName;
	//右眼瞳高
	private String righttg;
	//左眼瞳高
	private String lefttg;
	//	医生
	private String doctor;
//	公司id
	private String companyId;

	private String role_id;
	public void setRighttg(String righttg) {this.righttg = righttg;}

	public String getRighttg() {return righttg;}

	public void setLefttg(String lefttg) {this.lefttg = lefttg;}

	public String getLefttg() {return lefttg;}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUsecount() {
		return usecount;
	}

	public void setUsecount(String usecount) {
		this.usecount = usecount;
	}

	public String getYgcount() {
		return ygcount;
	}

	public void setYgcount(String ygcount) {
		this.ygcount = ygcount;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

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
	//远用球镜OD
	private String rightQJyy;
	//远用柱镜OD
	private String rightZJyy;
	//远用轴向OD
	private String rightzhouxiangyy;
	//远用三棱镜OD
	private String rightsanlingjingyy;
	//远用基地OD
	private String rightjidiyy;
	//远用远用瞳距OD
	private String rightyuanyongtjyy;
	//远用瞳高OD
	private String righttonggaoyy;
	//远用VA(OD)
	private String rightyuanyongVAyy;
	//远用球镜OS
	private String leftQJyy;
	//远用柱镜OS
	private String leftZJyy;
	//远用轴向OS
	private String leftzhouxiangyy;
	//远用三棱镜OS
	private String leftsanlingjingyy;
	//远用基地OS
	private String leftjidiyy;
	//远用瞳距OD
	private String leftyuanyongtjyy;
	//远用瞳高OS
	private String lefttonggaoyy;
	//远用VA(OS)
	private String leftyuanyongVAyy;
	//备注
	private String remark;
	//旧瞳距
	private String oldtongju;
	//片高
	private String piangao;
	//片宽
	private String piankuan;
	//中梁
	private String zhongliang;
	//镜片通道
	private String jingpiantongdao;
	//对角线
	private String duijiaoxian;
	//框型
	private String kuangxing;
	//直径
	private String zhijing;
	//RGP
	//屈光度(OD)
	private String rightRgpgd;
	//屈光度OS
	private String leftRgpgd;
	//BC(OD)
	private String rightBC;
	//BC(OS)
	private String leftBC;
	//DIA(OD)
	private String rightDIA;
	//DIA(OS)
	private String leftDIA;
	//散光OD
	private String rightsg;
	//散光OS
	private String leftsg;
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
	//物流状态
	private String logStatus;
	//发料人
	private String faliaoName;
	//发料日期
	private Date faliaoDate;
	private String faliaoTime;
	//邮寄地址
	private String mailAddress;
	//镜架名称
	private String jjGoodsName;
	//镜片名称
	private String jpGoodsName;
	private String jpGoodsNum;
	private String jpGoodsCode;
	//院区
	private String newOld;

	public String getNewOld() {
		return newOld;
	}

	public void setNewOld(String newOld) {
		this.newOld = newOld;
	}

	//	private List<SalesDO> lists = new ArrayList<>();
//
//	public List<SalesDO> getLists() {
//		return lists;
//	}
//
//	public void setLists(List<SalesDO> lists) {
//		this.lists = lists;
//	}

	public String getJpGoodsNum() {
		return jpGoodsNum;
	}

	public void setJpGoodsNum(String jpGoodsNum) {
		this.jpGoodsNum = jpGoodsNum;
	}

	public void setJpGoodsCode(String jpGoodsCode){this.jpGoodsCode = jpGoodsCode;}

	public String getJpGoodsCode(){return jpGoodsCode;}

	//右眼镜片
	private String rightjp;
	//左眼镜片
	private String leftjp;
	//是否订做(1:成品2:订做)
	private String classtype;
	//配镜发料用(是否订做)
	private String classTypeFL;
	//批号
	private String batch;
	//色号
	private String colorSize;
	public void setColorSize(String colorSize){this.colorSize = colorSize;}
	public String getColorSize(){return colorSize;}
	List<SaleGoodsDO> list = new ArrayList<>();

	private String changeMoney;
	private String modelMoney;

	public void setChangeMoney(String changeMoney){this.changeMoney = changeMoney;}
	public String getChangeMoney(){return changeMoney;}

	public void setModelMoney(String modelMoney){this.modelMoney = modelMoney;}
	public String getModelMoney(){return modelMoney;}

	private String mfrsid;

	public String getMfrsid() {
		return mfrsid;
	}

	public void setMfrsid(String mfrsid) {
		this.mfrsid = mfrsid;
	}

	//镜架代码
	private String jjGoodsNum;

	public String getJjGoodsNum() {
		return jjGoodsNum;
	}

	public void setJjGoodsNum(String jjGoodsNum) {
		this.jjGoodsNum = jjGoodsNum;
	}

	//近用球镜OD
	private String rightQJjy;
	//近用柱镜OD
	private String rightZJjy;
	//近用轴向OD
	private String rightzhouxiangjy;
	//近用三棱镜OD
	private String rightsanlingjingjy;
	//近用基地OD
	private String rightjidijy;
	//近用远用瞳距OD
	private String rightyuanyongtjjy;
	//近用瞳高OD
	private String righttonggaojy;
	//近用VA(OD)
	private String rightyuanyongVAjy;
	//近用球镜OS
	private String leftQJjy;
	//近用柱镜OS
	private String leftZJjy;
	//近用轴向OS
	private String leftzhouxiangjy;
	//近用三棱镜OS
	private String leftsanlingjingjy;
	//近用基地OS
	private String leftjidijy;
	//近用瞳距OD
	private String leftyuanyongtjjy;
	//近用瞳高OS
	private String lefttonggaojy;
	//近用VA(OS)
	private String leftyuanyongVAjy;

	//渐近/双光球镜OD
	private String rightQJsg;
	//渐近/双光柱镜OD
	private String rightZJsg;
	//渐近/双光轴向OD
	private String rightzhouxiangsg;
	//渐近/双光三棱镜OD
	private String rightsanlingjingsg;
	//渐近/双光ADD
	private String rightaddsg;
	//渐近/双光基地OD
	private String rightjidisg;
	//渐近/双光远用瞳距OD
	private String rightyuanyongtjsg;
	//渐近/双光近用瞳距OD
	private String rightjinyongtjsg;
	//渐近/双光瞳高OD
	private String righttonggaosg;
	//渐近/双光远用VA(OD)
	private String rightyuanyongVAsg;
	//渐近/双光近用VA(OD)
	private String rightjinyongVAsg;
	//渐近/双光球镜OS
	private String leftQJsg;
	//渐近/双光柱镜OS
	private String leftZJsg;
	//渐近/双光轴向OS
	private String leftzhouxiangsg;
	//渐近/双光三棱镜OS
	private String leftsanlingjingsg;
	//渐近/双光ADD
	private String leftaddsg;
	//渐近/双光基地OS
	private String leftjidisg;
	//渐近/双光远用瞳距OD
	private String leftyuanyongtjsg;
	//渐近/双光近用瞳距OD
	private String leftjinyongtjsg;
	//渐近/双光瞳高OS
	private String lefttonggaosg;
	//渐近/双光远用VA(OS)
	private String leftyuanyongVAsg;
	//渐近/双光近用VA(OS)
	private String leftjinyongVAsg;


	//中用球镜OD
	private String rightQJzy;
	//中用柱镜OD
	private String rightZJzy;
	//中用轴向OD
	private String rightzhouxiangzy;
	//中用三棱镜OD
	private String rightsanlingjingzy;
	//中用基地OD
	private String rightjidizy;
	//中用瞳距OD
	private String rightyuanyongtjzy;
	//中用瞳高OD
	private String righttonggaozy;
	//中用VA(OD)
	private String rightyuanyongVAzy;
	//中用球镜OS
	private String leftQJzy;
	//中用柱镜OS
	private String leftZJzy;
	//中用轴向OS
	private String leftzhouxiangzy;
	//中用三棱镜OS
	private String leftsanlingjingzy;
	//中用基地OS
	private String leftjidizy;
	//中用瞳距OD
	private String leftyuanyongtjzy;
	//中用瞳高OS
	private String lefttonggaozy;
	//中用VA(OS)
	private String leftyuanyongVAzy;


	//隐形球镜OD
	private String rightQJyx;
	//隐形柱镜OD
	private String rightZJyx;
	//隐形轴向OD
	private String rightzhouxiangyx;
	//隐形曲率
	private String rightqulvyx;
	//隐形直径
	private String rightzhijingyx;
	//隐形VA
	private String rightYingXingVAyx;
	//隐形使用镜片
	private String rightSYjingpianyx;
	//隐形片/盒数
	private String rightPianyx;
	//隐形球镜OD
	private String leftQJyx;
	//隐形柱镜OD
	private String leftZJyx;
	//隐形轴向OD
	private String leftzhouxiangyx;
	//隐形曲率
	private String leftqulvyx;
	//隐形直径
	private String leftzhijingyx;
	//隐形VA
	private String leftYingXingVAyx;
	//隐形使用镜片
	private String leftSYjingpianyx;
	//隐形片/盒数
	private String leftPianyx;

	//视觉训练球镜OD
	private String rightQJxl;
	//视觉训练柱镜OD
	private String rightZJxl;
	//视觉训练轴向OD
	private String rightzhouxiangxl;
	//视觉训练三棱镜OD
	private String rightsanlingjingxl;
	//视觉训练基地OD
	private String rightjidixl;
	//视觉训练远用瞳距
	private String rightSJXLyytj;
	//视觉训练近用瞳距
	private String rightSJXLjytj;
	//视觉训练远用va
	private String rightSJXLyyva;
	//视觉训练近用va
	private String rightSJXLjyva;
	//视觉训练球镜OS
	private String leftQJxl;
	//视觉训练柱镜OS
	private String leftZJxl;
	//视觉训练轴向OS
	private String leftzhouxiangxl;
	//视觉训练三棱镜OS
	private String leftsanlingjingxl;
	//视觉训练基地OS
	private String leftjidixl;
	//视觉训练远用瞳距
	private String leftSJXLyytj;
	//视觉训练近用瞳距
	private String leftSJXLjytj;
	//视觉训练远用va
	private String leftSJXLyyva;
	//视觉训练近用va
	private String leftSJXLjyva;

	//角膜塑形镜vst
	//球镜OD
	private String rightQJvst;
	//柱镜OD
	private String rightZJvst;
	//轴向OD
	private String rightzhouxiangvst;
	//试戴镜编号
	private String rightVstSdjbh;
	//FK
	private String rightVstFK;
	//曲率半径
	private String rightVstQlbj;
	//AC
	private String rightVstAC;
	//降幅
	private String rightVstJF;
	//DIA
	private String rightVstDIA;
	//BC
	private String rightVstBC;
	//CP/CLY
	private String rightVstCPCLY;
	//E值
	private String rightVstE;
	//VA
	private String rightVstVA;
	//品牌
	private String rightVstPinPai;
	//球镜OS
	private String leftQJvst;
	//柱镜OS
	private String leftZJvst;
	//轴向OS
	private String leftzhouxiangvst;
	//试戴镜编号
	private String leftVstSdjbh;
	//FK
	private String leftVstFK;
	//曲率半径
	private String leftVstQlbj;
	//AC
	private String leftVstAC;
	//降幅
	private String leftVstJF;
	//DIA
	private String leftVstDIA;
	//BC
	private String leftVstBC;
	//CP/CLY
	private String leftVstCPCLY;
	//E值
	private String leftVstE;
	//VA
	private String leftVstVA;
	//品牌
	private String leftVstPinPai;

	//角膜塑形镜CRT
	//球镜OD
	private String rightQjcrt;
	//柱镜OD
	private String rightZjcrt;
	//轴向OD
	private String rightZhouxiangcrt;
	//试戴镜编号
	private String rightSdjbhcrt;
	//BC
	private String rightBCcrt;
	//RZD
	private String rightRZDcrt;
	//LZA
	private String rightLZAcrt;
	//RZD2
	private String rightRZD2crt;
	//LZA2
	private String rightLZA2crt;
	//降幅
	private String rightJFcrt;
	//DIA
	private String rightDIAcrt;
	//VA
	private String rightVAcrt;
	//球镜OS
	private String leftQjcrt;
	//柱镜OS
	private String leftZjcrt;
	//轴向OS
	private String leftZhouxiangcrt;
	//试戴镜编号
	private String leftSdjbhcrt;
	//BC
	private String leftBCcrt;
	//RZD
	private String leftRZDcrt;
	//LZA
	private String leftLZAcrt;
	//RZD2
	private String leftRZD2crt;
	//LZA2
	private String leftLZA2crt;
	//降幅
	private String leftJFcrt;
	//DIA
	private String leftDIAcrt;
	//VA
	private String leftVAcrt;




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

	public void setSaleType(String saleType) {this.saleType = saleType;}

	public String getSaleType(){return saleType;}
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
	public void setAddress(String address) {this.address = address;}
	public String getAddress() {return address;}
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
	 * 销售员工工号
	 */
	public void setSaleAccount(String saleAccount) {this.saleAccount = saleAccount;}
	/**
	 * 销售员工工号
	 */
	public String getSaleAccount() {return saleAccount;}
	/**
	 * 用户名
	 */
	public void setSaleNum(String saleNum) {this.saleNum = saleNum;}
	/**
	 * 用户名
	 */
	public String getSaleNum() {return saleNum;}
	/**
	 * 是否缴费
	 */
	public void setIsSale(Long isSale){this.isSale = isSale;}

	/**
	 * 是否缴费
	 */
	public Long getIsSale() {return isSale;}

	/**
	 * 实付金额
	 */
	public void setPayMoney(Double payMoney){this.payMoney = payMoney;}
	/**
	 * 实付金额
	 */
	public Double getPayMoney() {return payMoney;}
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
	public void setGoodsNum(String goodsNum) {this.goodsNum = goodsNum;}
	public String getGoodsNum() {return goodsNum;}

	public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode;}

	public String getGoodsCode() {return goodsCode;}
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
	 * 原价金额
	 */
	public void setPrimeMoney(Double primeMoney) {this.primeMoney = primeMoney;}
	/**
	 * 原价金额
	 */
	public Double getPrimeMoney() {return primeMoney;}
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
	public void setMirrorDate(String mirrorDate){this.mirrorDate = mirrorDate;}
	public String getMirrorDate() {return mirrorDate;}
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

	public void setSettleDate(Date settleDate){this.settleDate = settleDate;}

	public Date getSettleDate(){return settleDate;}

	public void setSettleTime(String settleTime) {this.settleTime = settleTime;}

	public String getSettleTime(){return settleTime;}

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
	public void setRightQJyy(String rightQJyy) {this.rightQJyy = rightQJyy;}
	/**
	 * 球镜OD
	 */
	public String getRightQJyy(){return rightQJyy;}
	/**
	 * 柱镜OD
	 */
	public void setRightZJyy(String rightZJyy) {this.rightZJyy = rightZJyy;}
	/**
	 * 柱镜OD
	 */
	public String getRightZJyy() {return rightZJyy;}
	/**
	 * 轴向OD
	 */
	public void setRightzhouxiangyy(String rightzhouxiangyy) {this.rightzhouxiangyy = rightzhouxiangyy;}
	/**
	 * 轴向OD
	 */
	public String getRightzhouxiangyy(){return rightzhouxiangyy;}
	/**
	 * 三棱镜OD
	 */
	public void setRightsanlingjingyy(String rightsanlingjingyy) {this.rightsanlingjingyy = rightsanlingjingyy;}
	/**
	 * 三棱镜OD
	 */
	public String getRightsanlingjingyy() {return rightsanlingjingyy;}
	/**
	 * 基地OD
	 */
	public void setRightjidiyy(String rightjidiyy) {this.rightjidiyy = rightjidiyy;}
	/**
	 * 基地OD
	 */
	public String getRightjidiyy() {return rightjidiyy;}
	/**
	 * 远用瞳距OD
	 */
	public void setRightyuanyongtjyy(String rightyuanyongtjyy) {this.rightyuanyongtjyy = rightyuanyongtjyy;}
	/**
	 * 远用瞳距OD
	 */
	public String getRightyuanyongtjyy() {return rightyuanyongtjyy;}
	/**
	 * 瞳高OD
	 */
	public void setRighttonggaoyy(String righttonggaoyy) {this.righttonggaoyy = righttonggaoyy;}
	/**
	 * 瞳高OD
	 */
	public String getRighttonggaoyy() {return righttonggaoyy;}
	/**
	 * 远用VA(OD)
	 */
	public void setRightyuanyongVAyy(String rightyuanyongVAyy) {this.rightyuanyongVAyy = rightyuanyongVAyy;}
	/**
	 * 远用VA(OD)
	 */
	public String getRightyuanyongVAyy() {return rightyuanyongVAyy;}
	/**
	 * 球镜OS
	 */
	public void setLeftQJyy(String leftQJyy){this.leftQJyy = leftQJyy;}
	/**
	 * 球镜OS
	 */
	public String getLeftQJyy() {return leftQJyy;}
	/**
	 * 柱镜OS
	 */
	public void setLeftZJyy(String leftZJyy) {this.leftZJyy = leftZJyy;}
	/**
	 * 柱镜OS
	 */
	public String getLeftZJyy() {return leftZJyy;}
	/**
	 * 轴向OS
	 */
	public void setLeftzhouxiangyy(String leftzhouxiangyy) {this.leftzhouxiangyy = leftzhouxiangyy;}
	/**
	 * 轴向OS
	 */
	public String getLeftzhouxiangyy() {return leftzhouxiangyy;}
	/**
	 * 三棱镜OS
	 */
	public void setLeftsanlingjingyy(String leftsanlingjingyy) {this.leftsanlingjingyy = leftsanlingjingyy;}
	/**
	 * 三棱镜OS
	 */
	public String getLeftsanlingjingyy(){return leftsanlingjingyy;}
	/**
	 * 基地OS
	 */
	public void setLeftjidiyy(String leftjidiyy) {this.leftjidiyy = leftjidiyy;}
	/**
	 * 基地OS
	 */
	public String getLeftjidiyy() {return leftjidiyy;}
	/**
	 * 远用瞳距OS
	 */
	public void setLeftyuanyongtjyy(String leftyuanyongtjyy) {this.leftyuanyongtjyy = leftyuanyongtjyy;}
	/**
	 * 远用瞳距OS
	 */
	public String getLeftyuanyongtjyy(){return leftyuanyongtjyy;}
	/**
	 * 瞳高OS
	 */
	public void setLefttonggaoyy(String lefttonggaoyy){this.lefttonggaoyy = lefttonggaoyy;}
	/**
	 * 瞳高OS
	 */
	public String getLefttonggaoyy(){return lefttonggaoyy;}
	/**
	 * 远用VA(OS)
	 */
	public void setLeftyuanyongVAyy(String leftyuanyongVAyy) {this.leftyuanyongVAyy = leftyuanyongVAyy;}
	/**
	 * 远用VA(OS)
	 */
	public String getLeftyuanyongVAyy() {return leftyuanyongVAyy;}
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
	public void setOldtongju(String oldtongju) {this.oldtongju = oldtongju;}
	/**
	 * 旧瞳距
	 */
	public String getOldtongju(){return oldtongju;}
	/**
	 * 片高
	 */
	public void setPiangao(String piangao) {this.piangao = piangao;}
	/**
	 * 片高
	 */
	public String getPiangao() {return piangao;}
	/**
	 * 片宽
	 */
	public void setPiankuan(String piankuan) {this.piankuan = piankuan;}
	/**
	 * 片宽
	 */
	public String getPiankuan() {return piankuan;}
	/**
	 * 中梁
	 */
	public void setZhongliang(String zhongliang) {this.zhongliang = zhongliang;}
	/**
	 * 中梁
	 */
	public String getZhongliang() {return zhongliang;}
	/**
	 * 镜片通道
	 */
	public void setJingpiantongdao(String jingpiantongdao) {this.jingpiantongdao = jingpiantongdao;}
	/**
	 * 镜片通道
	 */
	public String getJingpiantongdao(){return jingpiantongdao;}
	/**
	 * 对角线
	 */
	public void setDuijiaoxian(String duijiaoxian) {this.duijiaoxian = duijiaoxian;}
	/**
	 * 对角线
	 */
	public String getDuijiaoxian() {return duijiaoxian;}
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
	public void setZhijing(String zhijing) {this.zhijing = zhijing;}
	/**
	 * 直径
	 */
	public String getZhijing(){return zhijing;}

	/**
	 * 屈光度OD
	 */
	public void setRightRgpgd(String rightRgpgd) {this.rightRgpgd = rightRgpgd;}
	/**
	 * 屈光度OD
	 */
	public String getRightRgpgd() {return rightRgpgd;}
	/**
	 * 屈光度OS
	 */
	public void setLeftRgpgd(String leftRgpgd) {this.leftRgpgd = leftRgpgd;}
	/**
	 * 屈光度OS
	 */
	public String getLeftRgpgd() {return leftRgpgd;}
	/**
	 * BC(OD)
	 */
	public void setRightBC(String rightBC) {this.rightBC = rightBC;}
	/**
	 * BC(OD)
	 */
	public String getRightBC(){return rightBC;}
	/**
	 * BC(OS)
	 */
	public void setLeftBC(String leftBC) {this.leftBC = leftBC;}
	/**
	 * BC(OS)
	 */
	public String getLeftBC() {return leftBC;}
	/**
	 * DIA(OD)
	 */
	public void setRightDIA(String rightDIA) {this.rightDIA = rightDIA;}
	/**
	 * DIA(OD)
	 */
	public String getRightDIA() {return rightDIA;}
	/**
	 * DIA(OS)
	 */
	public void setLeftDIA(String leftDIA) {this.leftDIA = leftDIA;}
	/**
	 * DIA(OS)
	 */
	public String getLeftDIA() {return leftDIA;}
	/**
	 * 散光(OD)
	 */
	public void setRightsg(String rightsg) {this.rightsg = rightsg;}
	/**
	 * 散光(OD)
	 */
	public String getRightsg() {return rightsg;}
	/**
	 * 散光(OS)
	 */
	public void setLeftsg(String leftsg) {this.leftsg = leftsg;}
	/**
	 * 散光(OS)
	 */
	public String getLeftsg() {return leftsg;}
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

	public void setLogStatus(String logStatus) {this.logStatus = logStatus;}

	public String getLogStatus() {return logStatus;}

	public void setFaliaoName(String faliaoName) {this.faliaoName = faliaoName;}

	public String getFaliaoName() {return faliaoName;}

	public void setFaliaoDate(Date faliaoDate) {this.faliaoDate = faliaoDate;}

	public Date getFaliaoDate() {return faliaoDate;}

	public void setFaliaoTime(String faliaoTime) {this.faliaoTime = faliaoTime;}

	public String getFaliaoTime() {return faliaoTime;}

	public void setMailAddress(String mailAddress) {this.mailAddress = mailAddress;}

	public String getMailAddress() {return mailAddress;}

	public void setJjGoodsName(String jjGoodsName) {this.jjGoodsName = jjGoodsName;}

	public String getJjGoodsName() {return jjGoodsName;}

	public void setJpGoodsName(String jpGoodsName) {this.jpGoodsName = jpGoodsName;}

	public String getJpGoodsName() {return jpGoodsName;}

	public void setRightjp(String rightjp) {this.rightjp = rightjp;}

	public String getRightjp() {return rightjp;}

	public void setLeftjp(String leftjp) {this.leftjp = leftjp;}

	public String getLeftjp() {return leftjp;}

	public void setClasstype(String classtype) {this.classtype = classtype;}

	public String getClasstype(){return classtype;}

	public void setClassTypeFL(String classTypeFL) {this.classTypeFL = classTypeFL;}

	public String getClassTypeFL() {return  classTypeFL;}

	public void setBatch(String batch){this.batch = batch;}

	public String getBatch(){return batch;}

	public void setList(List<SaleGoodsDO> list) {this.list = list;}

	public List<SaleGoodsDO> getList() {return list;}

	/**
	 * 球镜OD
	 */
	public void setRightQJjy(String rightQJjy) {this.rightQJjy = rightQJjy;}
	/**
	 * 球镜OD
	 */
	public String getRightQJjy(){return rightQJjy;}
	/**
	 * 柱镜OD
	 */
	public void setRightZJjy(String rightZJjy) {this.rightZJjy = rightZJjy;}
	/**
	 * 柱镜OD
	 */
	public String getRightZJjy() {return rightZJjy;}
	/**
	 * 轴向OD
	 */
	public void setRightzhouxiangjy(String rightzhouxiangjy) {this.rightzhouxiangjy = rightzhouxiangjy;}
	/**
	 * 轴向OD
	 */
	public String getRightzhouxiangjy(){return rightzhouxiangjy;}
	/**
	 * 三棱镜OD
	 */
	public void setRightsanlingjingjy(String rightsanlingjingjy) {this.rightsanlingjingjy = rightsanlingjingjy;}
	/**
	 * 三棱镜OD
	 */
	public String getRightsanlingjingjy() {return rightsanlingjingjy;}
	/**
	 * 基地OD
	 */
	public void setRightjidijy(String rightjidijy) {this.rightjidijy = rightjidijy;}
	/**
	 * 基地OD
	 */
	public String getRightjidijy() {return rightjidijy;}
	/**
	 * 近用瞳距OD
	 */
	public void setRightyuanyongtjjy(String rightyuanyongtjjy) {this.rightyuanyongtjjy = rightyuanyongtjjy;}
	/**
	 * 近用瞳距OD
	 */
	public String getRightyuanyongtjjy() {return rightyuanyongtjjy;}
	/**
	 * 瞳高OD
	 */
	public void setRighttonggaojy(String righttonggaojy) {this.righttonggaojy = righttonggaojy;}
	/**
	 * 瞳高OD
	 */
	public String getRighttonggaojy() {return righttonggaojy;}
	/**
	 * 近用VA(OD)
	 */
	public void setRightyuanyongVAjy(String rightyuanyongVAjy) {this.rightyuanyongVAjy = rightyuanyongVAjy;}
	/**
	 * 近用VA(OD)
	 */
	public String getRightyuanyongVAjy() {return rightyuanyongVAjy;}
	/**
	 * 球镜OS
	 */
	public void setLeftQJjy(String leftQJjy){this.leftQJjy = leftQJjy;}
	/**
	 * 球镜OS
	 */
	public String getLeftQJjy() {return leftQJjy;}
	/**
	 * 柱镜OS
	 */
	public void setLeftZJjy(String leftZJjy) {this.leftZJjy = leftZJjy;}
	/**
	 * 柱镜OS
	 */
	public String getLeftZJjy() {return leftZJjy;}
	/**
	 * 轴向OS
	 */
	public void setLeftzhouxiangjy(String leftzhouxiangjy) {this.leftzhouxiangjy = leftzhouxiangjy;}
	/**
	 * 轴向OS
	 */
	public String getLeftzhouxiangjy() {return leftzhouxiangjy;}
	/**
	 * 三棱镜OS
	 */
	public void setLeftsanlingjingjy(String leftsanlingjingjy) {this.leftsanlingjingjy = leftsanlingjingjy;}
	/**
	 * 三棱镜OS
	 */
	public String getLeftsanlingjingjy(){return leftsanlingjingjy;}
	/**
	 * 基地OS
	 */
	public void setLeftjidijy(String leftjidijy) {this.leftjidijy = leftjidijy;}
	/**
	 * 基地OS
	 */
	public String getLeftjidijy() {return leftjidijy;}
	/**
	 * 近用瞳距OS
	 */
	public void setLeftyuanyongtjjy(String leftyuanyongtjjy) {this.leftyuanyongtjjy = leftyuanyongtjjy;}
	/**
	 * 近用瞳距OS
	 */
	public String getLeftyuanyongtjjy(){return leftyuanyongtjjy;}
	/**
	 * 瞳高OS
	 */
	public void setLefttonggaojy(String lefttonggaojy){this.lefttonggaojy = lefttonggaojy;}
	/**
	 * 瞳高OS
	 */
	public String getLefttonggaojy(){return lefttonggaojy;}
	/**
	 * 近用VA(OS)
	 */
	public void setLeftyuanyongVAjy(String leftyuanyongVAjy) {this.leftyuanyongVAjy = leftyuanyongVAjy;}
	/**
	 * 近用VA(OS)
	 */
	public String getLeftyuanyongVAjy() {return leftyuanyongVAjy;}


	/**
	 * 球镜OD
	 */
	public void setRightQJsg(String rightQJsg) {this.rightQJsg = rightQJsg;}
	/**
	 * 球镜OD
	 */
	public String getRightQJsg(){return rightQJsg;}
	/**
	 * 柱镜OD
	 */
	public void setRightZJsg(String rightZJsg) {this.rightZJsg = rightZJsg;}
	/**
	 * 柱镜OD
	 */
	public String getRightZJsg() {return rightZJsg;}
	/**
	 * 轴向OD
	 */
	public void setRightzhouxiangsg(String rightzhouxiangsg) {this.rightzhouxiangsg = rightzhouxiangsg;}
	/**
	 * 轴向OD
	 */
	public String getRightzhouxiangsg(){return rightzhouxiangsg;}
	/**
	 * 三棱镜OD
	 */
	public void setRightsanlingjingsg(String rightsanlingjingsg) {this.rightsanlingjingsg = rightsanlingjingsg;}
	/**
	 * 三棱镜OD
	 */
	public String getRightsanlingjingsg() {return rightsanlingjingsg;}
	/**
	 * 基地OD
	 */
	public void setRightjidisg(String rightjidisg) {this.rightjidisg = rightjidisg;}
	/**
	 * 基地OD
	 */
	public String getRightjidisg() {return rightjidisg;}
	/**
	 * 渐近/双光瞳距OD
	 */
	public void setRightyuanyongtjsg(String rightyuanyongtjsg) {this.rightyuanyongtjsg = rightyuanyongtjsg;}
	/**
	 * 渐近/双光瞳距OD
	 */
	public String getRightyuanyongtjsg() {return rightyuanyongtjsg;}

	public void setRightjinyongtjsg(String rightjinyongtjsg){this.rightjinyongtjsg = this.rightjinyongtjsg;}

	public String getRightjinyongtjsg(){return rightjinyongtjsg;}

	public void setRightjinyongVAsg(String rightjinyongVAsg){this.rightjinyongVAsg = this.rightjinyongVAsg;}

	public String getRightjinyongVAsg(){return rightjinyongVAsg;}

	public void setLeftjinyongtjsg(String leftjinyongtjsg){this.leftjinyongtjsg = leftjinyongtjsg;}

	public String getLeftjinyongtjsg(){return leftjinyongtjsg;}

	public void setLeftjinyongVAsg(String leftjinyongVAsg){this.leftjinyongVAsg = leftjinyongVAsg;}

	public String getLeftjinyongVAsg(){return leftjinyongVAsg;}

	/**
	 * 瞳高OD
	 */
	public void setRighttonggaosg(String righttonggaosg) {this.righttonggaosg = righttonggaosg;}
	/**
	 * 瞳高OD
	 */
	public String getRighttonggaosg() {return righttonggaosg;}
	/**
	 * 渐近/双光VA(OD)
	 */
	public void setRightyuanyongVAsg(String rightyuanyongVAsg) {this.rightyuanyongVAsg = rightyuanyongVAsg;}
	/**
	 * 渐近/双光VA(OD)
	 */
	public String getRightyuanyongVAsg() {return rightyuanyongVAsg;}
	/**
	 * 球镜OS
	 */
	public void setLeftQJsg(String leftQJsg){this.leftQJsg = leftQJsg;}
	/**
	 * 球镜OS
	 */
	public String getLeftQJsg() {return leftQJsg;}
	/**
	 * 柱镜OS
	 */
	public void setLeftZJsg(String leftZJsg) {this.leftZJsg = leftZJsg;}
	/**
	 * 柱镜OS
	 */
	public String getLeftZJsg() {return leftZJsg;}
	/**
	 * 轴向OS
	 */
	public void setLeftzhouxiangsg(String leftzhouxiangsg) {this.leftzhouxiangsg = leftzhouxiangsg;}
	/**
	 * 轴向OS
	 */
	public String getLeftzhouxiangsg() {return leftzhouxiangsg;}
	/**
	 * 三棱镜OS
	 */
	public void setLeftsanlingjingsg(String leftsanlingjingsg) {this.leftsanlingjingsg = leftsanlingjingsg;}
	/**
	 * 三棱镜OS
	 */
	public String getLeftsanlingjingsg(){return leftsanlingjingsg;}
	/**
	 * 基地OS
	 */
	public void setLeftjidisg(String leftjidisg) {this.leftjidisg = leftjidisg;}
	/**
	 * 基地OS
	 */
	public String getLeftjidisg() {return leftjidisg;}
	/**
	 * 渐近/双光瞳距OS
	 */
	public void setLeftyuanyongtjsg(String leftyuanyongtjsg) {this.leftyuanyongtjsg = leftyuanyongtjsg;}
	/**
	 * 渐近/双光瞳距OS
	 */
	public String getLeftyuanyongtjsg(){return leftyuanyongtjsg;}
	/**
	 * 瞳高OS
	 */
	public void setLefttonggaosg(String lefttonggaosg){this.lefttonggaosg = lefttonggaosg;}
	/**
	 * 瞳高OS
	 */
	public String getLefttonggaosg(){return lefttonggaosg;}
	/**
	 * 渐近/双光VA(OS)
	 */
	public void setLeftyuanyongVAsg(String leftyuanyongVAsg) {this.leftyuanyongVAsg = leftyuanyongVAsg;}
	/**
	 * 渐近/双光VA(OS)
	 */
	public String getLeftyuanyongVAsg() {return leftyuanyongVAsg;}


	/**
	 * 球镜OD
	 */
	public void setRightQJzy(String rightQJzy) {this.rightQJzy= rightQJzy;}
	/**
	 * 球镜OD
	 */
	public String getRightQJzy(){return rightQJzy;}
	/**
	 * 柱镜OD
	 */
	public void setRightZJzy(String rightZJzy) {this.rightZJzy = rightZJzy;}
	/**
	 * 柱镜OD
	 */
	public String getRightZJzy() {return rightZJzy;}
	/**
	 * 轴向OD
	 */
	public void setRightzhouxiangzy(String rightzhouxiangzy) {this.rightzhouxiangzy = rightzhouxiangzy;}
	/**
	 * 轴向OD
	 */
	public String getRightzhouxiangzy(){return rightzhouxiangzy;}
	/**
	 * 三棱镜OD
	 */
	public void setRightsanlingjingzy(String rightsanlingjingzy) {this.rightsanlingjingzy = rightsanlingjingzy;}
	/**
	 * 三棱镜OD
	 */
	public String getRightsanlingjingzy() {return rightsanlingjingzy;}
	/**
	 * 基地OD
	 */
	public void setRightjidizy(String rightjidizy) {this.rightjidizy = rightjidizy;}
	/**
	 * 基地OD
	 */
	public String getRightjidizy() {return rightjidizy;}
	/**
	 * 中用瞳距OD
	 */
	public void setRightyuanyongtjzy(String rightyuanyongtjzy) {this.rightyuanyongtjzy = rightyuanyongtjzy;}
	/**
	 * 中用瞳距OD
	 */
	public String getRightyuanyongtjzy() {return rightyuanyongtjzy;}
	/**
	 * 瞳高OD
	 */
	public void setRighttonggaozy(String righttonggaozy) {this.righttonggaozy = righttonggaozy;}
	/**
	 * 瞳高OD
	 */
	public String getRighttonggaozy() {return righttonggaozy;}
	/**
	 * 中用VA(OD)
	 */
	public void setRightyuanyongVAzy(String rightyuanyongVAzy) {this.rightyuanyongVAzy = rightyuanyongVAzy;}
	/**
	 * 中用VA(OD)
	 */
	public String getRightyuanyongVAzy() {return rightyuanyongVAzy;}
	/**
	 * 球镜OS
	 */
	public void setLeftQJzy(String leftQJzy){this.leftQJzy = leftQJzy;}
	/**
	 * 球镜OS
	 */
	public String getLeftQJzy() {return leftQJzy;}
	/**
	 * 柱镜OS
	 */
	public void setLeftZJzy(String leftZJzy) {this.leftZJzy = leftZJzy;}
	/**
	 * 柱镜OS
	 */
	public String getLeftZJzy() {return leftZJzy;}
	/**
	 * 轴向OS
	 */
	public void setLeftzhouxiangzy(String leftzhouxiangzy) {this.leftzhouxiangzy = leftzhouxiangzy;}
	/**
	 * 轴向OS
	 */
	public String getLeftzhouxiangzy() {return leftzhouxiangzy;}
	/**
	 * 三棱镜OS
	 */
	public void setLeftsanlingjingzy(String leftsanlingjingzy) {this.leftsanlingjingzy = leftsanlingjingzy;}
	/**
	 * 三棱镜OS
	 */
	public String getLeftsanlingjingzy(){return leftsanlingjingzy;}
	/**
	 * 基地OS
	 */
	public void setLeftjidizy(String leftjidizy) {this.leftjidizy = leftjidizy;}
	/**
	 * 基地OS
	 */
	public String getLeftjidizy() {return leftjidizy;}
	/**
	 * 中用瞳距OS
	 */
	public void setLeftyuanyongtjzy(String leftyuanyongtjzy) {this.leftyuanyongtjzy = leftyuanyongtjzy;}
	/**
	 * 中用瞳距OS
	 */
	public String getLeftyuanyongtjzy(){return leftyuanyongtjzy;}
	/**
	 * 瞳高OS
	 */
	public void setLefttonggaozy(String lefttonggaozy){this.lefttonggaozy = lefttonggaozy;}
	/**
	 * 瞳高OS
	 */
	public String getLefttonggaozy(){return lefttonggaozy;}
	/**
	 * 中用VA(OS)
	 */
	public void setLeftyuanyongVAzy(String leftyuanyongVAzy) {this.leftyuanyongVAzy = leftyuanyongVAzy;}
	/**
	 * 中用VA(OS)
	 */
	public String getLeftyuanyongVAzy() {return leftyuanyongVAzy;}

	public String getRightQJyx() {
		return rightQJyx;
	}

	public void setRightQJyx(String rightQJyx) {
		this.rightQJyx = rightQJyx;
	}

	public String getRightZJyx() {
		return rightZJyx;
	}

	public void setRightZJyx(String rightZJyx) {
		this.rightZJyx = rightZJyx;
	}

	public String getRightzhouxiangyx() {
		return rightzhouxiangyx;
	}

	public void setRightzhouxiangyx(String rightzhouxiangyx) {
		this.rightzhouxiangyx = rightzhouxiangyx;
	}

	public String getRightqulvyx() {
		return rightqulvyx;
	}

	public void setRightqulvyx(String rightqulvyx) {
		this.rightqulvyx = rightqulvyx;
	}

	public String getRightzhijingyx() {
		return rightzhijingyx;
	}

	public void setRightzhijingyx(String rightzhijingyx) {
		this.rightzhijingyx = rightzhijingyx;
	}

	public String getRightYingXingVAyx() {
		return rightYingXingVAyx;
	}

	public void setRightYingXingVAyx(String rightYingXingVAyx) {
		this.rightYingXingVAyx = rightYingXingVAyx;
	}

	public String getRightSYjingpianyx() {
		return rightSYjingpianyx;
	}

	public void setRightSYjingpianyx(String rightSYjingpianyx) {
		this.rightSYjingpianyx = rightSYjingpianyx;
	}

	public String getRightPianyx() {
		return rightPianyx;
	}

	public void setRightPianyx(String rightPianyx) {
		this.rightPianyx = rightPianyx;
	}

	public String getLeftQJyx() {
		return leftQJyx;
	}

	public void setLeftQJyx(String leftQJyx) {
		this.leftQJyx = leftQJyx;
	}

	public String getLeftZJyx() {
		return leftZJyx;
	}

	public void setLeftZJyx(String leftZJyx) {
		this.leftZJyx = leftZJyx;
	}

	public String getLeftzhouxiangyx() {
		return leftzhouxiangyx;
	}

	public void setLeftzhouxiangyx(String leftzhouxiangyx) {
		this.leftzhouxiangyx = leftzhouxiangyx;
	}

	public String getLeftqulvyx() {
		return leftqulvyx;
	}

	public void setLeftqulvyx(String leftqulvyx) {
		this.leftqulvyx = leftqulvyx;
	}

	public String getLeftzhijingyx() {
		return leftzhijingyx;
	}

	public void setLeftzhijingyx(String leftzhijingyx) {
		this.leftzhijingyx = leftzhijingyx;
	}

	public String getLeftYingXingVAyx() {
		return leftYingXingVAyx;
	}

	public void setLeftYingXingVAyx(String leftYingXingVAyx) {
		this.leftYingXingVAyx = leftYingXingVAyx;
	}

	public String getLeftSYjingpianyx() {
		return leftSYjingpianyx;
	}

	public void setLeftSYjingpianyx(String leftSYjingpianyx) {
		this.leftSYjingpianyx = leftSYjingpianyx;
	}

	public String getLeftPianyx() {
		return leftPianyx;
	}

	public void setLeftPianyx(String leftPianyx) {
		this.leftPianyx = leftPianyx;
	}

	public String getRightQJxl() {
		return rightQJxl;
	}

	public void setRightQJxl(String rightQJxl) {
		this.rightQJxl = rightQJxl;
	}

	public String getRightZJxl() {
		return rightZJxl;
	}

	public void setRightZJxl(String rightZJxl) {
		this.rightZJxl = rightZJxl;
	}

	public String getRightzhouxiangxl() {
		return rightzhouxiangxl;
	}

	public void setRightzhouxiangxl(String rightzhouxiangxl) {
		this.rightzhouxiangxl = rightzhouxiangxl;
	}

	public String getRightsanlingjingxl() {
		return rightsanlingjingxl;
	}

	public void setRightsanlingjingxl(String rightsanlingjingxl) {
		this.rightsanlingjingxl = rightsanlingjingxl;
	}

	public String getRightjidixl() {
		return rightjidixl;
	}

	public void setRightjidixl(String rightjidixl) {
		this.rightjidixl = rightjidixl;
	}

	public String getRightSJXLyytj() {
		return rightSJXLyytj;
	}

	public void setRightSJXLyytj(String rightSJXLyytj) {
		this.rightSJXLyytj = rightSJXLyytj;
	}

	public String getRightSJXLjytj() {
		return rightSJXLjytj;
	}

	public void setRightSJXLjytj(String rightSJXLjytj) {
		this.rightSJXLjytj = rightSJXLjytj;
	}

	public String getRightSJXLyyva() {
		return rightSJXLyyva;
	}

	public void setRightSJXLyyva(String rightSJXLyyva) {
		this.rightSJXLyyva = rightSJXLyyva;
	}

	public String getRightSJXLjyva() {
		return rightSJXLjyva;
	}

	public void setRightSJXLjyva(String rightSJXLjyva) {
		this.rightSJXLjyva = rightSJXLjyva;
	}

	public String getLeftQJxl() {
		return leftQJxl;
	}

	public void setLeftQJxl(String leftQJxl) {
		this.leftQJxl = leftQJxl;
	}

	public String getLeftZJxl() {
		return leftZJxl;
	}

	public void setLeftZJxl(String leftZJxl) {
		this.leftZJxl = leftZJxl;
	}

	public String getLeftzhouxiangxl() {
		return leftzhouxiangxl;
	}

	public void setLeftzhouxiangxl(String leftzhouxiangxl) {
		this.leftzhouxiangxl = leftzhouxiangxl;
	}

	public String getLeftsanlingjingxl() {
		return leftsanlingjingxl;
	}

	public void setLeftsanlingjingxl(String leftsanlingjingxl) {
		this.leftsanlingjingxl = leftsanlingjingxl;
	}

	public String getLeftjidixl() {
		return leftjidixl;
	}

	public void setLeftjidixl(String leftjidixl) {
		this.leftjidixl = leftjidixl;
	}

	public String getLeftSJXLyytj() {
		return leftSJXLyytj;
	}

	public void setLeftSJXLyytj(String leftSJXLyytj) {
		this.leftSJXLyytj = leftSJXLyytj;
	}

	public String getLeftSJXLjytj() {
		return leftSJXLjytj;
	}

	public void setLeftSJXLjytj(String leftSJXLjytj) {
		this.leftSJXLjytj = leftSJXLjytj;
	}

	public String getLeftSJXLyyva() {
		return leftSJXLyyva;
	}

	public void setLeftSJXLyyva(String leftSJXLyyva) {
		this.leftSJXLyyva = leftSJXLyyva;
	}

	public String getLeftSJXLjyva() {
		return leftSJXLjyva;
	}

	public void setLeftSJXLjyva(String leftSJXLjyva) {
		this.leftSJXLjyva = leftSJXLjyva;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String rightsph;//OD球镜
	private String leftsph;//OS球镜
	private String rightcyl;//OD柱镜
	private String leftcyl;//OS柱镜
	private String rightzx;//OD轴向
	private String leftzx;//OS轴向
	private String rightAdd;//ODADD
	private String leftAdd;//OSADD
	private String rightSlja;//OD三棱镜
	private String leftSlja;//OS三棱镜
	private String rightJd;//OD基底
	private String leftJd;//OS基底
	private String rightFartj;//OD远瞳距
	private String leftFartj;//OS远瞳距
	private String rightNeartj;//OD近瞳距
	private String leftNeartj;//OS近瞳距
	private String rightqulv;//OD曲率
	private String leftqulv;//OS曲率
	private String rightzj;//OD直径
	private String leftzj;//OS直径
	private String leftRight;//左右

	public String getRightqulv() {
		return rightqulv;
	}

	public void setRightqulv(String rightqulv) {
		this.rightqulv = rightqulv;
	}

	public String getLeftqulv() {
		return leftqulv;
	}

	public void setLeftqulv(String leftqulv) {
		this.leftqulv = leftqulv;
	}

	public String getRightzj() {
		return rightzj;
	}

	public void setRightzj(String rightzj) {
		this.rightzj = rightzj;
	}

	public String getLeftzj() {
		return leftzj;
	}

	public void setLeftzj(String leftzj) {
		this.leftzj = leftzj;
	}

	public String getRightsph() {
		return rightsph;
	}

	public void setRightsph(String rightsph) {
		this.rightsph = rightsph;
	}

	public String getLeftsph() {
		return leftsph;
	}

	public void setLeftsph(String leftsph) {
		this.leftsph = leftsph;
	}

	public String getRightcyl() {
		return rightcyl;
	}

	public void setRightcyl(String rightcyl) {
		this.rightcyl = rightcyl;
	}

	public String getLeftcyl() {
		return leftcyl;
	}

	public void setLeftcyl(String leftcyl) {
		this.leftcyl = leftcyl;
	}

	public String getRightzx() {
		return rightzx;
	}

	public void setRightzx(String rightzx) {
		this.rightzx = rightzx;
	}

	public String getLeftzx() {
		return leftzx;
	}

	public void setLeftzx(String leftzx) {
		this.leftzx = leftzx;
	}

	public String getRightAdd() {
		return rightAdd;
	}

	public void setRightAdd(String rightAdd) {
		this.rightAdd = rightAdd;
	}

	public String getLeftAdd() {
		return leftAdd;
	}

	public void setLeftAdd(String leftAdd) {
		this.leftAdd = leftAdd;
	}

	public String getRightSlja() {
		return rightSlja;
	}

	public void setRightSlja(String rightSlja) {
		this.rightSlja = rightSlja;
	}

	public String getLeftSlja() {
		return leftSlja;
	}

	public void setLeftSlja(String leftSlja) {
		this.leftSlja = leftSlja;
	}

	public String getRightJd() {
		return rightJd;
	}

	public void setRightJd(String rightJd) {
		this.rightJd = rightJd;
	}

	public String getLeftJd() {
		return leftJd;
	}

	public void setLeftJd(String leftJd) {
		this.leftJd = leftJd;
	}

	public String getRightFartj() {
		return rightFartj;
	}

	public void setRightFartj(String rightFartj) {
		this.rightFartj = rightFartj;
	}

	public String getLeftFartj() {
		return leftFartj;
	}

	public void setLeftFartj(String leftFartj) {
		this.leftFartj = leftFartj;
	}

	public String getRightNeartj() {
		return rightNeartj;
	}

	public void setRightNeartj(String rightNeartj) {
		this.rightNeartj = rightNeartj;
	}

	public String getLeftNeartj() {
		return leftNeartj;
	}

	public void setLeftNeartj(String leftNeartj) {
		this.leftNeartj = leftNeartj;
	}


	public String getLeftRight() {
		return leftRight;
	}

	public void setLeftRight(String leftRight) {
		this.leftRight = leftRight;
	}


	public String getRightQJvst() {
		return rightQJvst;
	}

	public void setRightQJvst(String rightQJvst) {
		this.rightQJvst = rightQJvst;
	}

	public String getRightZJvst() {
		return rightZJvst;
	}

	public void setRightZJvst(String rightZJvst) {
		this.rightZJvst = rightZJvst;
	}

	public String getRightzhouxiangvst() {
		return rightzhouxiangvst;
	}

	public void setRightzhouxiangvst(String rightzhouxiangvst) {
		this.rightzhouxiangvst = rightzhouxiangvst;
	}

	public String getRightVstSdjbh() {
		return rightVstSdjbh;
	}

	public void setRightVstSdjbh(String rightVstSdjbh) {
		this.rightVstSdjbh = rightVstSdjbh;
	}

	public String getRightVstFK() {
		return rightVstFK;
	}

	public void setRightVstFK(String rightVstFK) {
		this.rightVstFK = rightVstFK;
	}

	public String getRightVstQlbj() {
		return rightVstQlbj;
	}

	public void setRightVstQlbj(String rightVstQlbj) {
		this.rightVstQlbj = rightVstQlbj;
	}

	public String getRightVstAC() {
		return rightVstAC;
	}

	public void setRightVstAC(String rightVstAC) {
		this.rightVstAC = rightVstAC;
	}

	public String getRightVstJF() {
		return rightVstJF;
	}

	public void setRightVstJF(String rightVstJF) {
		this.rightVstJF = rightVstJF;
	}

	public String getRightVstDIA() {
		return rightVstDIA;
	}

	public void setRightVstDIA(String rightVstDIA) {
		this.rightVstDIA = rightVstDIA;
	}

	public String getRightVstBC() {
		return rightVstBC;
	}

	public void setRightVstBC(String rightVstBC) {
		this.rightVstBC = rightVstBC;
	}

	public String getRightVstCPCLY() {
		return rightVstCPCLY;
	}

	public void setRightVstCPCLY(String rightVstCPCLY) {
		this.rightVstCPCLY = rightVstCPCLY;
	}

	public String getRightVstE() {
		return rightVstE;
	}

	public void setRightVstE(String rightVstE) {
		this.rightVstE = rightVstE;
	}

	public String getRightVstVA() {
		return rightVstVA;
	}

	public void setRightVstVA(String rightVstVA) {
		this.rightVstVA = rightVstVA;
	}

	public String getRightVstPinPai() {
		return rightVstPinPai;
	}

	public void setRightVstPinPai(String rightVstPinPai) {
		this.rightVstPinPai = rightVstPinPai;
	}

	public String getLeftQJvst() {
		return leftQJvst;
	}

	public void setLeftQJvst(String leftQJvst) {
		this.leftQJvst = leftQJvst;
	}

	public String getLeftZJvst() {
		return leftZJvst;
	}

	public void setLeftZJvst(String leftZJvst) {
		this.leftZJvst = leftZJvst;
	}

	public String getLeftzhouxiangvst() {
		return leftzhouxiangvst;
	}

	public void setLeftzhouxiangvst(String leftzhouxiangvst) {
		this.leftzhouxiangvst = leftzhouxiangvst;
	}

	public String getLeftVstSdjbh() {
		return leftVstSdjbh;
	}

	public void setLeftVstSdjbh(String leftVstSdjbh) {
		this.leftVstSdjbh = leftVstSdjbh;
	}

	public String getLeftVstFK() {
		return leftVstFK;
	}

	public void setLeftVstFK(String leftVstFK) {
		this.leftVstFK = leftVstFK;
	}

	public String getLeftVstQlbj() {
		return leftVstQlbj;
	}

	public void setLeftVstQlbj(String leftVstQlbj) {
		this.leftVstQlbj = leftVstQlbj;
	}

	public String getLeftVstAC() {
		return leftVstAC;
	}

	public void setLeftVstAC(String leftVstAC) {
		this.leftVstAC = leftVstAC;
	}

	public String getLeftVstJF() {
		return leftVstJF;
	}

	public void setLeftVstJF(String leftVstJF) {
		this.leftVstJF = leftVstJF;
	}

	public String getLeftVstDIA() {
		return leftVstDIA;
	}

	public void setLeftVstDIA(String leftVstDIA) {
		this.leftVstDIA = leftVstDIA;
	}

	public String getLeftVstBC() {
		return leftVstBC;
	}

	public void setLeftVstBC(String leftVstBC) {
		this.leftVstBC = leftVstBC;
	}

	public String getLeftVstCPCLY() {
		return leftVstCPCLY;
	}

	public void setLeftVstCPCLY(String leftVstCPCLY) {
		this.leftVstCPCLY = leftVstCPCLY;
	}

	public String getLeftVstE() {
		return leftVstE;
	}

	public void setLeftVstE(String leftVstE) {
		this.leftVstE = leftVstE;
	}

	public String getLeftVstVA() {
		return leftVstVA;
	}

	public void setLeftVstVA(String leftVstVA) {
		this.leftVstVA = leftVstVA;
	}

	public String getLeftVstPinPai() {
		return leftVstPinPai;
	}

	public void setLeftVstPinPai(String leftVstPinPai) {
		this.leftVstPinPai = leftVstPinPai;
	}

	public String getRightQjcrt() {
		return rightQjcrt;
	}

	public void setRightQjcrt(String rightQjcrt) {
		this.rightQjcrt = rightQjcrt;
	}

	public String getRightZjcrt() {
		return rightZjcrt;
	}

	public void setRightZjcrt(String rightZjcrt) {
		this.rightZjcrt = rightZjcrt;
	}

	public String getRightZhouxiangcrt() {
		return rightZhouxiangcrt;
	}

	public void setRightZhouxiangcrt(String rightZhouxiangcrt) {
		this.rightZhouxiangcrt = rightZhouxiangcrt;
	}

	public String getRightSdjbhcrt() {
		return rightSdjbhcrt;
	}

	public void setRightSdjbhcrt(String rightSdjbhcrt) {
		this.rightSdjbhcrt = rightSdjbhcrt;
	}

	public String getRightBCcrt() {
		return rightBCcrt;
	}

	public void setRightBCcrt(String rightBCcrt) {
		this.rightBCcrt = rightBCcrt;
	}

	public String getRightRZDcrt() {
		return rightRZDcrt;
	}

	public void setRightRZDcrt(String rightRZDcrt) {
		this.rightRZDcrt = rightRZDcrt;
	}

	public String getRightLZAcrt() {
		return rightLZAcrt;
	}

	public void setRightLZAcrt(String rightLZAcrt) {
		this.rightLZAcrt = rightLZAcrt;
	}

	public String getRightRZD2crt() {
		return rightRZD2crt;
	}

	public void setRightRZD2crt(String rightRZD2crt) {
		this.rightRZD2crt = rightRZD2crt;
	}

	public String getRightLZA2crt() {
		return rightLZA2crt;
	}

	public void setRightLZA2crt(String rightLZA2crt) {
		this.rightLZA2crt = rightLZA2crt;
	}

	public String getRightJFcrt() {
		return rightJFcrt;
	}

	public void setRightJFcrt(String rightJFcrt) {
		this.rightJFcrt = rightJFcrt;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getRightDIAcrt() {
		return rightDIAcrt;
	}

	public void setRightDIAcrt(String rightDIAcrt) {
		this.rightDIAcrt = rightDIAcrt;
	}

	public String getRightVAcrt() {
		return rightVAcrt;
	}

	public void setRightVAcrt(String rightVAcrt) {
		this.rightVAcrt = rightVAcrt;
	}

	public String getLeftQjcrt() {
		return leftQjcrt;
	}

	public void setLeftQjcrt(String leftQjcrt) {
		this.leftQjcrt = leftQjcrt;
	}

	public String getLeftZjcrt() {
		return leftZjcrt;
	}

	public void setLeftZjcrt(String leftZjcrt) {
		this.leftZjcrt = leftZjcrt;
	}

	public String getLeftZhouxiangcrt() {
		return leftZhouxiangcrt;
	}

	public void setLeftZhouxiangcrt(String leftZhouxiangcrt) {
		this.leftZhouxiangcrt = leftZhouxiangcrt;
	}

	public String getLeftSdjbhcrt() {
		return leftSdjbhcrt;
	}

	public void setLeftSdjbhcrt(String leftSdjbhcrt) {
		this.leftSdjbhcrt = leftSdjbhcrt;
	}

	public String getLeftBCcrt() {
		return leftBCcrt;
	}

	public void setLeftBCcrt(String leftBCcrt) {
		this.leftBCcrt = leftBCcrt;
	}

	public String getLeftRZDcrt() {
		return leftRZDcrt;
	}

	public void setLeftRZDcrt(String leftRZDcrt) {
		this.leftRZDcrt = leftRZDcrt;
	}

	public String getLeftLZAcrt() {
		return leftLZAcrt;
	}

	public void setLeftLZAcrt(String leftLZAcrt) {
		this.leftLZAcrt = leftLZAcrt;
	}

	public String getLeftRZD2crt() {
		return leftRZD2crt;
	}

	public void setLeftRZD2crt(String leftRZD2crt) {
		this.leftRZD2crt = leftRZD2crt;
	}

	public String getLeftLZA2crt() {
		return leftLZA2crt;
	}

	public void setLeftLZA2crt(String leftLZA2crt) {
		this.leftLZA2crt = leftLZA2crt;
	}

	public String getLeftJFcrt() {
		return leftJFcrt;
	}

	public void setLeftJFcrt(String leftJFcrt) {
		this.leftJFcrt = leftJFcrt;
	}

	public String getLeftDIAcrt() {
		return leftDIAcrt;
	}

	public void setLeftDIAcrt(String leftDIAcrt) {
		this.leftDIAcrt = leftDIAcrt;
	}

	public String getLeftVAcrt() {
		return leftVAcrt;
	}

	public void setLeftVAcrt(String leftVAcrt) {
		this.leftVAcrt = leftVAcrt;
	}

}
