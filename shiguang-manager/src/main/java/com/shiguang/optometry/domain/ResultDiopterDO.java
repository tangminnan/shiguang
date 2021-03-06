package com.shiguang.optometry.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 曲光度详情
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-06-05 17:06:09
 */
public class ResultDiopterDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer tDiopterId;
	//
	private Integer tOptometryId;
	//右眼球镜（近、远视度数）
	private Double diopterS;
	//右眼柱镜（散光度数）
	private Double diopterC;
	//右眼轴位（散光轴位）
	private Double diopterA;
	//可信度
	private Integer believe;
	//SCA多次普通顺序 1 2  3...
	private Integer num;
	//保存的数据类型PU_TONG=多次批量检查SCAAVG =SCA的平均值L_DATA=夜间视力检查
	private String type;
	//L=左眼、R=右眼
	private String ifrl;
	//两周内的第几次检查  FIRST_CHECK=第一次检查   SECOND_CHECK=第二次检查
	private String firstSecond;
	//
	private Double dengxiaoqiujing;
	//本次检查日期
	private Date addTime;

	/**
	 * 设置：id
	 */
	public void setTDiopterId(Integer tDiopterId) {
		this.tDiopterId = tDiopterId;
	}
	/**
	 * 获取：id
	 */
	public Integer getTDiopterId() {
		return tDiopterId;
	}
	/**
	 * 设置：
	 */
	public void setTOptometryId(Integer tOptometryId) {
		this.tOptometryId = tOptometryId;
	}
	/**
	 * 获取：
	 */
	public Integer getTOptometryId() {
		return tOptometryId;
	}
	/**
	 * 设置：右眼球镜（近、远视度数）
	 */
	public void setDiopterS(Double diopterS) {
		this.diopterS = diopterS;
	}
	/**
	 * 获取：右眼球镜（近、远视度数）
	 */
	public Double getDiopterS() {
		return diopterS;
	}
	/**
	 * 设置：右眼柱镜（散光度数）
	 */
	public void setDiopterC(Double diopterC) {
		this.diopterC = diopterC;
	}
	/**
	 * 获取：右眼柱镜（散光度数）
	 */
	public Double getDiopterC() {
		return diopterC;
	}
	/**
	 * 设置：右眼轴位（散光轴位）
	 */
	public void setDiopterA(Double diopterA) {
		this.diopterA = diopterA;
	}
	/**
	 * 获取：右眼轴位（散光轴位）
	 */
	public Double getDiopterA() {
		return diopterA;
	}
	/**
	 * 设置：可信度
	 */
	public void setBelieve(Integer believe) {
		this.believe = believe;
	}
	/**
	 * 获取：可信度
	 */
	public Integer getBelieve() {
		return believe;
	}
	/**
	 * 设置：SCA多次普通顺序 1 2  3...
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：SCA多次普通顺序 1 2  3...
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：保存的数据类型 
PU_TONG=多次批量检查SCA
AVG =SCA的平均值
L_DATA=夜间视力检查
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：保存的数据类型 
PU_TONG=多次批量检查SCA
AVG =SCA的平均值
L_DATA=夜间视力检查
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：L=左眼、R=右眼
	 */
	public void setIfrl(String ifrl) {
		this.ifrl = ifrl;
	}
	/**
	 * 获取：L=左眼、R=右眼
	 */
	public String getIfrl() {
		return ifrl;
	}
	/**
	 * 设置：两周内的第几次检查  FIRST_CHECK=第一次检查   SECOND_CHECK=第二次检查
	 */
	public void setFirstSecond(String firstSecond) {
		this.firstSecond = firstSecond;
	}
	/**
	 * 获取：两周内的第几次检查  FIRST_CHECK=第一次检查   SECOND_CHECK=第二次检查
	 */
	public String getFirstSecond() {
		return firstSecond;
	}
	/**
	 * 设置：
	 */
	public void setDengxiaoqiujing(Double dengxiaoqiujing) {
		this.dengxiaoqiujing = dengxiaoqiujing;
	}
	/**
	 * 获取：
	 */
	public Double getDengxiaoqiujing() {
		return dengxiaoqiujing;
	}
	/**
	 * 设置：本次检查日期
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：本次检查日期
	 */
	public Date getAddTime() {
		return addTime;
	}
}
