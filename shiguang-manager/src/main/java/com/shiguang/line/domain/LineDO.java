package com.shiguang.line.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 排队列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-15 14:09:10
 */
public class LineDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//会员卡号
	private String memberNumber;
	//性别
	private Long sex;
	private String sexx;
	//姓名
	private String memberName;
	//叫号
	private String callType;
	//是否叫号(0:未叫号1:已叫号2:已过号)
	private String callStatus;
	//诊室
	private String consultRoom;
	//楼层
	private String storey;
	//排队日期
	private Date lineTime;
	private String lineDate;

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
	 * 设置：性别
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Long getSex() {
		return sex;
	}

	public void setSexx(String sexx) {this.sexx = sexx;}

	public String getSexx() {return sexx;}

	/**
	 * 设置：姓名
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * 获取：姓名
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * 设置：叫号
	 */
	public void setCallType(String callType) {
		this.callType = callType;
	}
	/**
	 * 获取：叫号
	 */
	public String getCallType() {
		return callType;
	}
	/**
	 * 设置：是否叫号(0:未叫号1:已叫号2:已过号)
	 */
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}
	/**
	 * 获取：是否叫号(0:未叫号1:已叫号2:已过号)
	 */
	public String getCallStatus() {
		return callStatus;
	}
	/**
	 * 设置：诊室
	 */
	public void setConsultRoom(String consultRoom) {
		this.consultRoom = consultRoom;
	}
	/**
	 * 获取：诊室
	 */
	public String getConsultRoom() {
		return consultRoom;
	}
	/**
	 * 楼层
	 */
	public void setStorey(String storey){this.storey = storey;}
	/**
	 * 楼层
	 */
	public String getStorey(){return storey;}
	/**
	 * 设置：排队日期
	 */
	public void setLineTime(Date lineTime) {
		this.lineTime = lineTime;
	}
	/**
	 * 获取：排队日期
	 */
	public Date getLineTime() {
		return lineTime;
	}

	public void setLineDate(String lineDate){this.lineDate = lineDate;}

	public String getLineDate(){return lineDate;}
}
