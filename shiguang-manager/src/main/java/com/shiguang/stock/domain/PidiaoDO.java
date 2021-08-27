package com.shiguang.stock.domain;

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
	//批调单号
	private Integer pidiaoNumber;
	//关联单号
	private String guanlianNumber;
	//发出部门
	private String outDepartment;
	//发出仓位
	private String outPosition;
	//接收公司
	private String inCompany;
	//接收部门
	private String inDepartment;
	//接收仓位
	private String inPosition;
	//制单人
	private String zhidanPeople;
	//单据日期
	private Date danjuDay;
	//委外收货单
	private String outsourcingNumber;
	//备注
	private String beizhu;
	//商品代码
	private String goodsNum;
	//商品名称
	private String goodsName;
	//型号
	private String producFactory;
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
	private  String classtype;

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

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
	/**
	 * 设置：批调单号
	 */
	public void setPidiaoNumber(Integer pidiaoNumber) {
		this.pidiaoNumber = pidiaoNumber;
	}
	/**
	 * 获取：批调单号
	 */
	public Integer getPidiaoNumber() {
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
	public void setDanjuDay(Date danjuDay) {
		this.danjuDay = danjuDay;
	}
	/**
	 * 获取：单据日期
	 */
	public Date getDanjuDay() {
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
	 * 设置：型号
	 */
	public void setProducFactory(String producFactory) {
		this.producFactory = producFactory;
	}
	/**
	 * 获取：型号
	 */
	public String getProducFactory() {
		return producFactory;
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
}
