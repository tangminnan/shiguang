package com.shiguang.inventory.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-07 15:27:42
 */
public class GainLossDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//单据编号
	private String documentNo;
	//盘点单号
	private String inventoryNumber;
	//盘点类型
	private String inventoryType;
	//单据类型
	private String documentType;
	//单据日期
	private Date documentDate;
	private String documentTime;
	//收入/发出仓位
	private String recenuePosition;
	//仓位id
	private Long positionId;
	//制单人
	private String singleName;
	//数量
	private String inventoryCount;
	//备注
	private String remark;
	//商品id
	private String goodsId;
	//所属门店
	private String departmentName;
	//所属门店编码
	private String departmentNumber;
	//商品条码
	private String producCode;

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
	 * 设置：单据编号
	 */
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	/**
	 * 获取：单据编号
	 */
	public String getDocumentNo() {
		return documentNo;
	}
	/**
	 * 设置：盘点单号
	 */
	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	/**
	 * 获取：盘点单号
	 */
	public String getInventoryNumber() {
		return inventoryNumber;
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
	 * 设置：单据类型
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	/**
	 * 获取：单据类型
	 */
	public String getDocumentType() {
		return documentType;
	}
	/**
	 * 设置：单据日期
	 */
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	/**
	 * 获取：单据日期
	 */
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentTime(String documentTime) {this.documentTime = documentTime;}
	public String getDocumentTime() {return documentTime;}
	/**
	 * 设置：收入/发出仓位
	 */
	public void setRecenuePosition(String recenuePosition) {
		this.recenuePosition = recenuePosition;
	}
	/**
	 * 获取：收入/发出仓位
	 */
	public String getRecenuePosition() {
		return recenuePosition;
	}
	/**
	 * 仓位id
	 */
	public void setPositionId(Long positionId) {this.positionId = positionId;}
	/**
	 * 仓位id
	 */
	public Long getPositionId() {return positionId;}
	/**
	 * 设置：制单人
	 */
	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}
	/**
	 * 获取：制单人
	 */
	public String getSingleName() {
		return singleName;
	}
	/**
	 * 数量
	 */
	public void setInventoryCount(String inventoryCount){this.inventoryCount = inventoryCount;}
	/**
	 * 数量
	 */
	public String getInventoryCount() {return inventoryCount;}
	/**
	 * 备注
	 */
	public void setRemark(String remark) {this.remark = remark;}
	/**
	 * 备注
	 */
	public String getRemark() {return remark;}
	/**
	 * 商品id
	 */
	public void setGoodsId(String goodsId) {this.goodsId = goodsId;}
	/**
	 * 商品id
	 */
	public String getGoodsId() {return goodsId;}
	/**
	 * 所属门店
	 */
	public void setDepartmentName(String departmentName){this.departmentName = departmentName;}
	/**
	 * 所属门店
	 */
	public String getDepartmentName() {return departmentName;}
	/**
	 * 所属门店编码
	 */
	public void setDepartmentNumber(String departmentNumber){this.departmentNumber = departmentNumber;}
	/**
	 * 所属门店编码
	 */
	public String getDepartmentNumber() {return departmentNumber;}
	/**
	 * 商品条码
	 */
	public void setProducCode(String producCode){this.producCode = producCode;}
	/**
	 * 商品条码
	 */
	public String getProducCode() {return producCode;}
}
