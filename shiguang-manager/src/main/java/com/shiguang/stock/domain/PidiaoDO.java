package com.shiguang.stock.domain;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;



/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */
public class PidiaoDO implements Serializable {
	private static final long serialVersionUID = 1L;


	//批调id
	private Long id;
	private String goodsxinxiid;
	private String stockorder;
	private String stockorders;
	private String danzi;


	private String status;
	//工号
	private String  username;
	//批调单号
	private String pidiaoNumber;
	//关联单号
	private String guanlianNumber;
	private String companyId;
	//发出部门
	private String outDepartmentid;
	private String outDepartment;
	//发出仓位
	private String outPositionid;
	private String outPosition;
	//接收公司
	private String inCompanyid;
	private String inCompany;
	//接收部门
	private String inDepartmentid;
	private String inDepartment;
	//接收仓位
	private String inPositionid;
	private String inPosition;
	//制单人
	private String zhidanPeople;
	//单据日期
	private String danjuDay;
	//委外收货单
	private String outsourcingNumber;
	//备注
	private String beizhu;
	//商品代码
	private String goodsNum;
	//商品名称
	private String goodsName;
	//需求数量
	private String needCount;
	//可调用数量
	private String goodsCount;
	//批调数量
	private String useCount;
	//商品条码
	private String goodsCode;
	//批号
	private String batch;
	//注册证号
	private String zhuceNumber;
	//生产日期
	private String produceDay;
	//效期
	private String useday;
	//合计
	private String allCount;
	//镜片类型
	private  String classtype;
	//商品类型
	private String goods;

	private String outbm;
	private String outcw;
	private String ings;
	private String inbm;
	private String incw;
	//标准零售价
	private String money;
	//收货时间
	private String shTime;
	private  String flags;
	
	private String returnzt;


	/**
	 * 设置：批调id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：批调id
	 */
	public Long getId() {
		return id;
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

	/**
	 * 设置：批调单号
	 */
	public void setPidiaoNumber(String pidiaoNumber) {
		this.pidiaoNumber = pidiaoNumber;
	}
	/**
	 * 获取：批调单号
	 */
	public String getPidiaoNumber() {
		return pidiaoNumber;
	}
	/**
	 * 设置：关联单号
	 */
	public void setGuanlianNumber(String guanlianNumber) {
		this.guanlianNumber = guanlianNumber;
	}
	/**
	 * 获取：关联单号
	 */
	public String getGuanlianNumber() {
		return guanlianNumber;
	}
	/**
	 * 设置：发出部门
	 */
	public void setOutDepartment(String outDepartment) {
		this.outDepartment = outDepartment;
	}
	/**
	 * 获取：发出部门
	 */
	public String getOutDepartment() {
		return outDepartment;
	}
	/**
	 * 设置：发出仓位
	 */
	public void setOutPosition(String outPosition) {
		this.outPosition = outPosition;
	}
	/**
	 * 获取：发出仓位
	 */
	public String getOutPosition() {
		return outPosition;
	}
	/**
	 * 设置：接收仓位
	 */
	public void setInPosition(String inPosition) {
		this.inPosition = inPosition;
	}
	/**
	 * 获取：接收仓位
	 */
	public String getInPosition() {
		return inPosition;
	}
	/**
	 * 设置：接收公司
	 */
	public void setInCompany(String inCompany) {
		this.inCompany = inCompany;
	}
	/**
	 * 获取：接收公司
	 */
	public String getInCompany() {
		return inCompany;
	}
	/**
	 * 设置：接收部门
	 */
	public void setInDepartment(String inDepartment) {
		this.inDepartment = inDepartment;
	}
	/**
	 * 获取：接收部门
	 */
	public String getInDepartment() {
		return inDepartment;
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
	 * 设置：委外收货单
	 */
	public void setOutsourcingNumber(String outsourcingNumber) {
		this.outsourcingNumber = outsourcingNumber;
	}
	/**
	 * 获取：委外收货单
	 */
	public String getOutsourcingNumber() {
		return outsourcingNumber;
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
	 * 设置：需求数量
	 */
	public void setNeedCount(String needCount) {
		this.needCount = needCount;
	}
	/**
	 * 获取：需求数量
	 */
	public String getNeedCount() {
		return needCount;
	}
	/**
	 * 设置：可调用数量
	 */
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	/**
	 * 获取：可调用数量
	 */
	public String getGoodsCount() {
		return goodsCount;
	}
	/**
	 * 设置：批调数量
	 */
	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}
	/**
	 * 获取：批调数量
	 */
	public String getUseCount() {
		return useCount;
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
	/**
	 * 设置：批号
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * 获取：批号
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * 设置：注册证号
	 */
	public void setZhuceNumber(String zhuceNumber) {
		this.zhuceNumber = zhuceNumber;
	}
	/**
	 * 获取：注册证号
	 */
	public String getZhuceNumber() {
		return zhuceNumber;
	}
	/**
	 * 设置：生产日期
	 */
	public void setProduceDay(String produceDay) {
		this.produceDay = produceDay;
	}
	/**
	 * 获取：生产日期
	 */
	public String getProduceDay() {
		return produceDay;
	}
	/**
	 * 设置：效期
	 */
	public void setUseday(String useday) {
		this.useday = useday;
	}
	/**
	 * 获取：效期
	 */
	public String getUseday() {
		return useday;
	}
	/**
	 * 设置：合计
	 */
	public void setAllCount(String allCount) {
		this.allCount = allCount;
	}
	/**
	 * 获取：合计
	 */
	public String getAllCount() {
		return allCount;
	}
	//仓位id
	private Long positionId;
	//仓位代码
	private String positionNum;
	//部门编码
	private String departNumber;
	//部门名称
	private String departName;
	//仓位名称
	private String positionName;

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getPositionNum() {
		return positionNum;
	}

	public void setPositionNum(String positionNum) {
		this.positionNum = positionNum;
	}

	public String getDepartNumber() {
		return departNumber;
	}

	public void setDepartNumber(String departNumber) {
		this.departNumber = departNumber;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	private String factory;

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getOutDepartmentid() {
		return outDepartmentid;
	}

	public void setOutDepartmentid(String outDepartmentid) {
		this.outDepartmentid = outDepartmentid;
	}

	public String getOutPositionid() {
		return outPositionid;
	}

	public void setOutPositionid(String outPositionid) {
		this.outPositionid = outPositionid;
	}

	public String getInCompanyid() {
		return inCompanyid;
	}

	public void setInCompanyid(String inCompanyid) {
		this.inCompanyid = inCompanyid;
	}

	public String getInDepartmentid() {
		return inDepartmentid;
	}

	public void setInDepartmentid(String inDepartmentid) {
		this.inDepartmentid = inDepartmentid;
	}

	public String getInPositionid() {
		return inPositionid;
	}

	public void setInPositionid(String inPositionid) {
		this.inPositionid = inPositionid;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}



	//商品类别
	private String goodsType;
	private String gdname;
	//制造商id
	private String mfrsid;
	private String mfrsname;
	private String brandname;
	private String brandnum;

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandnum() {
		return brandnum;
	}

	public void setBrandnum(String brandnum) {
		this.brandnum = brandnum;
	}

	//标准零售价格
	private String retailPrice;
	//原价合计
	private String priceSum;
	//成本价格
	private String costPrice;
	//成本合计
	private String costSum;
	//批发价格
	private String wholePrice;
	//批发合计
	private String wholeSum;

	//入库时间
	private String createTime;
	//单据编号
	private String danjuNumber;
	//订单编号
	private String orderNumber;
	//运单号
	private String yundanNumber;

	//退货单号
	private String tuihuoNumber;
	//厂家订单号
	private String factoryNumber;

	//单位
	private String unit;
	//调货成本
	private String transferPrice;
	//调货成本合计
	private String transferPricecount;


	//尺寸
	private String size;
	//型号
	private String producFactory;
	//球镜
	private String sph;
	//柱镜
	private String cyl;
	//下加光
	private String lightbelow;
	//折射率
	private String refractivityvalue;
	//光度分类
	private String lightName;
	//材料分类
	private String lensName;

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGdname() {
		return gdname;
	}

	public void setGdname(String gdname) {
		this.gdname = gdname;
	}

	public String getMfrsid() {
		return mfrsid;
	}

	public void setMfrsid(String mfrsid) {
		this.mfrsid = mfrsid;
	}

	public String getMfrsname() {
		return mfrsname;
	}

	public void setMfrsname(String mfrsname) {
		this.mfrsname = mfrsname;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(String priceSum) {
		this.priceSum = priceSum;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getCostSum() {
		return costSum;
	}

	public void setCostSum(String costSum) {
		this.costSum = costSum;
	}

	public String getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(String wholePrice) {
		this.wholePrice = wholePrice;
	}

	public String getWholeSum() {
		return wholeSum;
	}

	public void setWholeSum(String wholeSum) {
		this.wholeSum = wholeSum;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDanjuNumber() {
		return danjuNumber;
	}

	public void setDanjuNumber(String danjuNumber) {
		this.danjuNumber = danjuNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getYundanNumber() {
		return yundanNumber;
	}

	public void setYundanNumber(String yundanNumber) {
		this.yundanNumber = yundanNumber;
	}

	public String getTuihuoNumber() {
		return tuihuoNumber;
	}

	public void setTuihuoNumber(String tuihuoNumber) {
		this.tuihuoNumber = tuihuoNumber;
	}

	public String getFactoryNumber() {
		return factoryNumber;
	}

	public void setFactoryNumber(String factoryNumber) {
		this.factoryNumber = factoryNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTransferPrice() {
		return transferPrice;
	}

	public void setTransferPrice(String transferPrice) {
		this.transferPrice = transferPrice;
	}

	public String getTransferPricecount() {
		return transferPricecount;
	}

	public void setTransferPricecount(String transferPricecount) {
		this.transferPricecount = transferPricecount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getProducFactory() {
		return producFactory;
	}

	public void setProducFactory(String producFactory) {
		this.producFactory = producFactory;
	}

	public String getSph() {
		return sph;
	}

	public void setSph(String sph) {
		this.sph = sph;
	}

	public String getCyl() {
		return cyl;
	}

	public void setCyl(String cyl) {
		this.cyl = cyl;
	}

	public String getLightbelow() {
		return lightbelow;
	}

	public void setLightbelow(String lightbelow) {
		this.lightbelow = lightbelow;
	}

	public String getRefractivityvalue() {
		return refractivityvalue;
	}

	public void setRefractivityvalue(String refractivityvalue) {
		this.refractivityvalue = refractivityvalue;
	}

	public String getLightName() {
		return lightName;
	}

	public void setLightName(String lightName) {
		this.lightName = lightName;
	}

	public String getLensName() {
		return lensName;
	}

	public void setLensName(String lensName) {
		this.lensName = lensName;
	}
	//条码
	private String QRCode;
	//名称
	private String viewGoodName;
	//色号
	private String producFactorycolor;

	public String getViewGoodName() {
		return viewGoodName;
	}

	public void setViewGoodName(String viewGoodName) {
		this.viewGoodName = viewGoodName;
	}

	public String getQRCode() {
		return QRCode;
	}

	public void setQRCode(String QRCode) {
		this.QRCode = QRCode;
	}

	public String getProducFactorycolor() {
		return producFactorycolor;
	}

	public void setProducFactorycolor(String producFactorycolor) {
		this.producFactorycolor = producFactorycolor;
	}

	public String getGoodsxinxiid() {
		return goodsxinxiid;
	}

	public void setGoodsxinxiid(String goodsxinxiid) {
		this.goodsxinxiid = goodsxinxiid;
	}

	public String getStockorder() {
		return stockorder;
	}

	public void setStockorder(String stockorder) {
		this.stockorder = stockorder;
	}

	public String getStockorders() {
		return stockorders;
	}

	public void setStockorders(String stockorders) {
		this.stockorders = stockorders;
	}

	public String getDanzi() {
		return danzi;
	}

	public void setDanzi(String danzi) {
		this.danzi = danzi;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOutbm() {
		return outbm;
	}

	public void setOutbm(String outbm) {
		this.outbm = outbm;
	}

	public String getOutcw() {
		return outcw;
	}

	public void setOutcw(String outcw) {
		this.outcw = outcw;
	}

	public String getIngs() {
		return ings;
	}

	public void setIngs(String ings) {
		this.ings = ings;
	}

	public String getInbm() {
		return inbm;
	}

	public void setInbm(String inbm) {
		this.inbm = inbm;
	}

	public String getIncw() {
		return incw;
	}

	public void setIncw(String incw) {
		this.incw = incw;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getShTime() {
		return shTime;
	}

	public void setShTime(String shTime) {
		this.shTime = shTime;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getReturnzt() {
		return returnzt;
	}

	public void setReturnzt(String returnzt) {
		this.returnzt = returnzt;
	}
}
