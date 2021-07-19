package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 角膜接触镜CRT
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:00:46
 */
public class CrtDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//角膜接触镜CRTid
	private Long crtId;
	//卡号
	private String cardNumber;
	//处方类型
	private String crtPrescriptionType;
	//医生
	private String crtDoctor;
	//验光师
	private String crtOptometryName;
	//试戴片编号OD
	private String crtSdbhod;
	//试戴片编号OS
	private String crtSdbhos;
	//BC(OD)
	private Double ctrBcod;
	//BC(OS)
	private Double crtBcos;
	//RZD(OD)
	private Double crtRzdod;
	//RZD(OS)
	private Double crtRzdos;
	//LZA(OD)
	private Double crtLzaod;
	//LZA(OS)
	private Double crtLzaos;
	//RZD2OD
	private Double crtRzd2od;
	//RZD2OS
	private Double crtRzd2os;
	//LZA2(OD)
	private Double crtLza2od;
	//LZA2(OS)
	private Double crtLza2os;
	//降幅(OD)
	private Double crtJfod;
	//降幅(OS)
	private Double crtJfos;
	//DIA(OD)
	private Double crtDiaod;
	//DIA(OS)
	private Double crtDiaos;
	//VA(OD)
	private Double crtVaod;
	//VA(OS)
	private Double crtVaos;
	//镜片颜色OD
	private String crtJpysod;
	//镜片颜色OS
	private String crtJpysos;
	//适用镜片OD
	private String crtSyjpod;
	//适用镜片OS
	private String crtSyjpos;
	//备注
	private String crtBeizhu;

	/**
	 * 设置：角膜接触镜CRTid
	 */
	public void setCrtId(Long crtId) {
		this.crtId = crtId;
	}
	/**
	 * 获取：角膜接触镜CRTid
	 */
	public Long getCrtId() {
		return crtId;
	}
	/**
	 * 设置：卡号
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * 获取：卡号
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * 设置：处方类型
	 */
	public void setCrtPrescriptionType(String crtPrescriptionType) {
		this.crtPrescriptionType = crtPrescriptionType;
	}
	/**
	 * 获取：处方类型
	 */
	public String getCrtPrescriptionType() {
		return crtPrescriptionType;
	}
	/**
	 * 设置：医生
	 */
	public void setCrtDoctor(String crtDoctor) {
		this.crtDoctor = crtDoctor;
	}
	/**
	 * 获取：医生
	 */
	public String getCrtDoctor() {
		return crtDoctor;
	}
	/**
	 * 设置：验光师
	 */
	public void setCrtOptometryName(String crtOptometryName) {
		this.crtOptometryName = crtOptometryName;
	}
	/**
	 * 获取：验光师
	 */
	public String getCrtOptometryName() {
		return crtOptometryName;
	}
	/**
	 * 设置：试戴片编号OD
	 */
	public void setCrtSdbhod(String crtSdbhod) {
		this.crtSdbhod = crtSdbhod;
	}
	/**
	 * 获取：试戴片编号OD
	 */
	public String getCrtSdbhod() {
		return crtSdbhod;
	}
	/**
	 * 设置：试戴片编号OS
	 */
	public void setCrtSdbhos(String crtSdbhos) {
		this.crtSdbhos = crtSdbhos;
	}
	/**
	 * 获取：试戴片编号OS
	 */
	public String getCrtSdbhos() {
		return crtSdbhos;
	}
	/**
	 * 设置：BC(OD)
	 */
	public void setCtrBcod(Double ctrBcod) {
		this.ctrBcod = ctrBcod;
	}
	/**
	 * 获取：BC(OD)
	 */
	public Double getCtrBcod() {
		return ctrBcod;
	}
	/**
	 * 设置：BC(OS)
	 */
	public void setCrtBcos(Double crtBcos) {
		this.crtBcos = crtBcos;
	}
	/**
	 * 获取：BC(OS)
	 */
	public Double getCrtBcos() {
		return crtBcos;
	}
	/**
	 * 设置：RZD(OD)
	 */
	public void setCrtRzdod(Double crtRzdod) {
		this.crtRzdod = crtRzdod;
	}
	/**
	 * 获取：RZD(OD)
	 */
	public Double getCrtRzdod() {
		return crtRzdod;
	}
	/**
	 * 设置：RZD(OS)
	 */
	public void setCrtRzdos(Double crtRzdos) {
		this.crtRzdos = crtRzdos;
	}
	/**
	 * 获取：RZD(OS)
	 */
	public Double getCrtRzdos() {
		return crtRzdos;
	}
	/**
	 * 设置：LZA(OD)
	 */
	public void setCrtLzaod(Double crtLzaod) {
		this.crtLzaod = crtLzaod;
	}
	/**
	 * 获取：LZA(OD)
	 */
	public Double getCrtLzaod() {
		return crtLzaod;
	}
	/**
	 * 设置：LZA(OS)
	 */
	public void setCrtLzaos(Double crtLzaos) {
		this.crtLzaos = crtLzaos;
	}
	/**
	 * 获取：LZA(OS)
	 */
	public Double getCrtLzaos() {
		return crtLzaos;
	}
	/**
	 * 设置：RZD2OD
	 */
	public void setCrtRzd2od(Double crtRzd2od) {
		this.crtRzd2od = crtRzd2od;
	}
	/**
	 * 获取：RZD2OD
	 */
	public Double getCrtRzd2od() {
		return crtRzd2od;
	}
	/**
	 * 设置：RZD2OS
	 */
	public void setCrtRzd2os(Double crtRzd2os) {
		this.crtRzd2os = crtRzd2os;
	}
	/**
	 * 获取：RZD2OS
	 */
	public Double getCrtRzd2os() {
		return crtRzd2os;
	}
	/**
	 * 设置：LZA2(OD)
	 */
	public void setCrtLza2od(Double crtLza2od) {
		this.crtLza2od = crtLza2od;
	}
	/**
	 * 获取：LZA2(OD)
	 */
	public Double getCrtLza2od() {
		return crtLza2od;
	}
	/**
	 * 设置：LZA2(OS)
	 */
	public void setCrtLza2os(Double crtLza2os) {
		this.crtLza2os = crtLza2os;
	}
	/**
	 * 获取：LZA2(OS)
	 */
	public Double getCrtLza2os() {
		return crtLza2os;
	}
	/**
	 * 设置：降幅(OD)
	 */
	public void setCrtJfod(Double crtJfod) {
		this.crtJfod = crtJfod;
	}
	/**
	 * 获取：降幅(OD)
	 */
	public Double getCrtJfod() {
		return crtJfod;
	}
	/**
	 * 设置：降幅(OS)
	 */
	public void setCrtJfos(Double crtJfos) {
		this.crtJfos = crtJfos;
	}
	/**
	 * 获取：降幅(OS)
	 */
	public Double getCrtJfos() {
		return crtJfos;
	}
	/**
	 * 设置：DIA(OD)
	 */
	public void setCrtDiaod(Double crtDiaod) {
		this.crtDiaod = crtDiaod;
	}
	/**
	 * 获取：DIA(OD)
	 */
	public Double getCrtDiaod() {
		return crtDiaod;
	}
	/**
	 * 设置：DIA(OS)
	 */
	public void setCrtDiaos(Double crtDiaos) {
		this.crtDiaos = crtDiaos;
	}
	/**
	 * 获取：DIA(OS)
	 */
	public Double getCrtDiaos() {
		return crtDiaos;
	}
	/**
	 * 设置：VA(OD)
	 */
	public void setCrtVaod(Double crtVaod) {
		this.crtVaod = crtVaod;
	}
	/**
	 * 获取：VA(OD)
	 */
	public Double getCrtVaod() {
		return crtVaod;
	}
	/**
	 * 设置：VA(OS)
	 */
	public void setCrtVaos(Double crtVaos) {
		this.crtVaos = crtVaos;
	}
	/**
	 * 获取：VA(OS)
	 */
	public Double getCrtVaos() {
		return crtVaos;
	}
	/**
	 * 设置：镜片颜色OD
	 */
	public void setCrtJpysod(String crtJpysod) {
		this.crtJpysod = crtJpysod;
	}
	/**
	 * 获取：镜片颜色OD
	 */
	public String getCrtJpysod() {
		return crtJpysod;
	}
	/**
	 * 设置：镜片颜色OS
	 */
	public void setCrtJpysos(String crtJpysos) {
		this.crtJpysos = crtJpysos;
	}
	/**
	 * 获取：镜片颜色OS
	 */
	public String getCrtJpysos() {
		return crtJpysos;
	}
	/**
	 * 设置：适用镜片OD
	 */
	public void setCrtSyjpod(String crtSyjpod) {
		this.crtSyjpod = crtSyjpod;
	}
	/**
	 * 获取：适用镜片OD
	 */
	public String getCrtSyjpod() {
		return crtSyjpod;
	}
	/**
	 * 设置：适用镜片OS
	 */
	public void setCrtSyjpos(String crtSyjpos) {
		this.crtSyjpos = crtSyjpos;
	}
	/**
	 * 获取：适用镜片OS
	 */
	public String getCrtSyjpos() {
		return crtSyjpos;
	}
	/**
	 * 设置：备注
	 */
	public void setCrtBeizhu(String crtBeizhu) {
		this.crtBeizhu = crtBeizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getCrtBeizhu() {
		return crtBeizhu;
	}
}
