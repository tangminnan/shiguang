package com.shiguang.storeCard.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-20 16:22:19
 */
public class CardDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//储值卡号
	private String cardNumber;
	//储值金额
	private String cardMoney;
	//
	private String cardNumMoney;
	//会员卡号
	private String memberNumber;
	//会员姓名
	private String memberName;
	//密码
	private String password;
	//创建人
	private String createName;
	//创建时间
	private String createTime;
	//
	private String remark;
	//状态(停用/启用)
	private String status;
	//状态0:删除1:未删除
	private String state;

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
	 * 设置：储值卡号
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * 获取：储值卡号
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardNumMoney() {
		return cardNumMoney;
	}

	public void setCardNumMoney(String cardNumMoney) {
		this.cardNumMoney = cardNumMoney;
	}

	/**
	 * 设置：储值金额
	 */
	public void setCardMoney(String cardMoney) {
		this.cardMoney = cardMoney;
	}
	/**
	 * 获取：储值金额
	 */
	public String getCardMoney() {
		return cardMoney;
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
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateName() {
		return createName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：状态(停用/启用)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态(停用/启用)
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：状态0:删除1:未删除
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态0:删除1:未删除
	 */
	public String getState() {
		return state;
	}
}
