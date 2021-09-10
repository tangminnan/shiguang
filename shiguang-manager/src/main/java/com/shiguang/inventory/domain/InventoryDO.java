package com.shiguang.inventory.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 盘点表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
public class InventoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//盘点单id(关联盘点商品信息表)
	private Long inventoryId;
	//盘盈单
	private String gain;
	//盘亏单
	private String loss;
	//盘点单编号
	private String inventoryNumber;
	//盘点单名称
	private String inventoryName;
	//盘点类型
	private String inventoryType;
	//盘点日期
	private Date inventoryDate;
	//盘点仓位
	private String inventoryPosition;
	//仓位名称
	private String positionName;
	//盘点人
	private String inventoryUser;
	//部门
	private String departmentName;
	//部门编号
	private String departmentNumber;
	//商品条码
	private String goodsCode;
	//单据编号
	private String documentNo;
	//单据日期
	private Date documentDate;
	private String documentTime;
	//文件

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
	 * 盘点id
	 */
	public void setInventoryId(Long inventoryId){this.inventoryId = inventoryId;}
	/**
	 * 盘点id
	 */
	public Long getInventoryId() {return inventoryId;}
	/**
	 * 设置：盘盈单
	 */
	public void setGain(String gain) {
		this.gain = gain;
	}
	/**
	 * 获取：盘盈单
	 */
	public String getGain() {
		return gain;
	}
	/**
	 * 设置：盘亏单
	 */
	public void setLoss(String loss) {
		this.loss = loss;
	}
	/**
	 * 获取：盘亏单
	 */
	public String getLoss() {
		return loss;
	}
	/**
	 * 设置：盘点单编号
	 */
	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	/**
	 * 获取：盘点单编号
	 */
	public String getInventoryNumber() {
		return inventoryNumber;
	}
	/**
	 * 设置：盘点单名称
	 */
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	/**
	 * 获取：盘点单名称
	 */
	public String getInventoryName() {
		return inventoryName;
	}
	/**
	 * 设置：盘点类型
	 */
	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}
	/**
	 * 获取：盘点类型
	 */
	public String getInventoryType() {
		return inventoryType;
	}
	/**
	 * 设置：盘点日期
	 */
	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
	/**
	 * 获取：盘点日期
	 */
	public Date getInventoryDate() {
		return inventoryDate;
	}
	/**
	 * 设置：盘点仓位
	 */
	public void setInventoryPosition(String inventoryPosition) {
		this.inventoryPosition = inventoryPosition;
	}
	/**
	 * 获取：盘点仓位
	 */
	public String getInventoryPosition() {
		return inventoryPosition;
	}
	public void setPositionName(String positionName) {this.positionName = positionName;}
	public String getPositionName(){return positionName;}
	/**
	 * 设置：盘点人
	 */
	public void setInventoryUser(String inventoryUser) {
		this.inventoryUser = inventoryUser;
	}
	/**
	 * 获取：盘点人
	 */
	public String getInventoryUser() {
		return inventoryUser;
	}
	/**
	 * 设置：部门
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * 获取：部门
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * 设置：部门编号
	 */
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	/**
	 * 获取：部门编号
	 */
	public String getDepartmentNumber() {
		return departmentNumber;
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
	 * 单据编号
	 */
	public void setDocumentNo(String documentNo) {this.documentNo = documentNo;}
	/**
	 * 单据编号
	 */
	public String getDocumentNo() {return documentNo;}
	/**
	 * 单据日期
	 */
	public void setDocumentDate(Date documentDate){this.documentDate = documentDate;}
	/**
	 * 单据日期
	 */
	public Date getDocumentDate() {return documentDate;}
	public void setDocumentTime(String documentTime){this.documentTime = documentTime;}
	public String getDocumentTime() {return documentTime;}
}
