package com.shiguang.member.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-23 10:11:11
 */
public class LineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//会员卡号
	private String memberNumber;
	//会员姓名
	private String memberName;
	//性别
	private Long sex;
	//诊室
	private String distribute;
	//创建时间
	private String createTime;
	//创建人
	private String createName;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
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
	/**
	 * 设置：会员姓名
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * 获取：会员姓名
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * 设置：诊室
	 */
	public void setDistribute(String distribute) {
		this.distribute = distribute;
	}
	/**
	 * 获取：诊室
	 */
	public String getDistribute() {
		return distribute;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}
}
