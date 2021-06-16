package com.shiguang.optometry.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 验光数据表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-06-05 17:06:09
 */
public class ResultOptometryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer tOptometryId;
	//user ID
	private Integer userId;
	//第一次验光VD
	private Double firstCheckVd;
	//第一次检查右眼ps
	private Double firstCheckRps;
	//第一次检查左眼ps
	private Double firstCheckLps;
	//第一次检查右眼cs
	private Double firstCheckRcs;
	//第一次检查左眼cs
	private Double firstCheckLcs;
	//第一次定脑验光日期
	private Date checkDate;
	//第二次验光VD
	private Double secondCheckVd;
	//第一次检查右眼ps
	private Double secondCheckRps;
	//第一次检查左眼ps
	private Double secondCheckLps;
	//第一次检查右眼cs
	private Double secondCheckRcs;
	//第一次检查左眼cs
	private Double secondCheckLcs;
	//状态0：正常1：禁止
	private Integer deleteFlag;
	//第一次验光PD
	private Double firstCheckPd;
	//第二次验光PD
	private Double secondCheckPd;
	//身份证号
	private String identityCard;
	//本次的检查记录id
	private Integer checkId;
	//医生建议
	private String suggest;
	//医生姓名
	private String name;

	/**
	 * 设置：id
	 */
	public void setTOptometryId(Integer tOptometryId) {
		this.tOptometryId = tOptometryId;
	}
	/**
	 * 获取：id
	 */
	public Integer getTOptometryId() {
		return tOptometryId;
	}
	/**
	 * 设置：user ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：user ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：第一次验光VD
	 */
	public void setFirstCheckVd(Double firstCheckVd) {
		this.firstCheckVd = firstCheckVd;
	}
	/**
	 * 获取：第一次验光VD
	 */
	public Double getFirstCheckVd() {
		return firstCheckVd;
	}
	/**
	 * 设置：第一次检查右眼ps
	 */
	public void setFirstCheckRps(Double firstCheckRps) {
		this.firstCheckRps = firstCheckRps;
	}
	/**
	 * 获取：第一次检查右眼ps
	 */
	public Double getFirstCheckRps() {
		return firstCheckRps;
	}
	/**
	 * 设置：第一次检查左眼ps
	 */
	public void setFirstCheckLps(Double firstCheckLps) {
		this.firstCheckLps = firstCheckLps;
	}
	/**
	 * 获取：第一次检查左眼ps
	 */
	public Double getFirstCheckLps() {
		return firstCheckLps;
	}
	/**
	 * 设置：第一次检查右眼cs
	 */
	public void setFirstCheckRcs(Double firstCheckRcs) {
		this.firstCheckRcs = firstCheckRcs;
	}
	/**
	 * 获取：第一次检查右眼cs
	 */
	public Double getFirstCheckRcs() {
		return firstCheckRcs;
	}
	/**
	 * 设置：第一次检查左眼cs
	 */
	public void setFirstCheckLcs(Double firstCheckLcs) {
		this.firstCheckLcs = firstCheckLcs;
	}
	/**
	 * 获取：第一次检查左眼cs
	 */
	public Double getFirstCheckLcs() {
		return firstCheckLcs;
	}
	/**
	 * 设置：第一次定脑验光日期
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	/**
	 * 获取：第一次定脑验光日期
	 */
	public Date getCheckDate() {
		return checkDate;
	}
	/**
	 * 设置：第二次验光VD
	 */
	public void setSecondCheckVd(Double secondCheckVd) {
		this.secondCheckVd = secondCheckVd;
	}
	/**
	 * 获取：第二次验光VD
	 */
	public Double getSecondCheckVd() {
		return secondCheckVd;
	}
	/**
	 * 设置：第一次检查右眼ps
	 */
	public void setSecondCheckRps(Double secondCheckRps) {
		this.secondCheckRps = secondCheckRps;
	}
	/**
	 * 获取：第一次检查右眼ps
	 */
	public Double getSecondCheckRps() {
		return secondCheckRps;
	}
	/**
	 * 设置：第一次检查左眼ps
	 */
	public void setSecondCheckLps(Double secondCheckLps) {
		this.secondCheckLps = secondCheckLps;
	}
	/**
	 * 获取：第一次检查左眼ps
	 */
	public Double getSecondCheckLps() {
		return secondCheckLps;
	}
	/**
	 * 设置：第一次检查右眼cs
	 */
	public void setSecondCheckRcs(Double secondCheckRcs) {
		this.secondCheckRcs = secondCheckRcs;
	}
	/**
	 * 获取：第一次检查右眼cs
	 */
	public Double getSecondCheckRcs() {
		return secondCheckRcs;
	}
	/**
	 * 设置：第一次检查左眼cs
	 */
	public void setSecondCheckLcs(Double secondCheckLcs) {
		this.secondCheckLcs = secondCheckLcs;
	}
	/**
	 * 获取：第一次检查左眼cs
	 */
	public Double getSecondCheckLcs() {
		return secondCheckLcs;
	}
	/**
	 * 设置：状态0：正常1：禁止
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：状态0：正常1：禁止
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 设置：第一次验光PD
	 */
	public void setFirstCheckPd(Double firstCheckPd) {
		this.firstCheckPd = firstCheckPd;
	}
	/**
	 * 获取：第一次验光PD
	 */
	public Double getFirstCheckPd() {
		return firstCheckPd;
	}
	/**
	 * 设置：第二次验光PD
	 */
	public void setSecondCheckPd(Double secondCheckPd) {
		this.secondCheckPd = secondCheckPd;
	}
	/**
	 * 获取：第二次验光PD
	 */
	public Double getSecondCheckPd() {
		return secondCheckPd;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdentityCard() {
		return identityCard;
	}
	/**
	 * 设置：本次的检查记录id
	 */
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	/**
	 * 获取：本次的检查记录id
	 */
	public Integer getCheckId() {
		return checkId;
	}
	/**
	 * 设置：医生建议
	 */
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	/**
	 * 获取：医生建议
	 */
	public String getSuggest() {
		return suggest;
	}
	/**
	 * 设置：医生姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：医生姓名
	 */
	public String getName() {
		return name;
	}
}
