package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 角膜接触镜VST
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 16:38:36
 */
public class VstDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//角膜接触镜VSTid
	private Long vstId;
	//卡号
	private String cardNumber;
	//处方类型
	private String vstPrescriptionType;
	//医生
	private String vstDoctor;
	//试戴片编号OD
	private String vstSdbhod;
	//试戴片编号OS
	private String vstSdbhos;
	//FK(OD)
	private Double vstFkod;
	//FK(OS)
	private Double vstFkos;
	//曲率半径(OD)
	private Double vstQlbjod;
	//曲率半径(OS)
	private Double vstQlbjos;
	//AC(OD)
	private Double vstAcod;
	//AC(OS)
	private Double vstAcos;
	//降幅OD
	private Double vstJfod;
	//降幅OS
	private Double vstJfos;
	//DIA(OD)
	private Double vstDiaod;
	//DIA(OS)
	private Double vstDiaos;
	//BC(OD)
	private Double vstBcod;
	//BC(OS)
	private Double vstBcos;
	//CP/CLY(OD)
	private Double vstCpclyod;
	//CP/CLY(OS)
	private Double vstCpclyos;
	//E值(OD)
	private Double vstEod;
	//E值(OS)
	private Double vstEos;
	//VA(OD)
	private Double vstVaod;
	//VA(OS)
	private Double vstVaos;
	//镜片颜色OD
	private String vstJpysod;
	//镜片颜色OS
	private String vstJpysos;
	//适用镜片OD
	private String vstSyjpod;
	//适用镜片OS
	private String vstSyjpos;
	//备注
	private String vstBeizhu;

	/**
	 * 设置：角膜接触镜VSTid
	 */
	public void setVstId(Long vstId) {
		this.vstId = vstId;
	}
	/**
	 * 获取：角膜接触镜VSTid
	 */
	public Long getVstId() {
		return vstId;
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
	public void setVstPrescriptionType(String vstPrescriptionType) {
		this.vstPrescriptionType = vstPrescriptionType;
	}
	/**
	 * 获取：处方类型
	 */
	public String getVstPrescriptionType() {
		return vstPrescriptionType;
	}
	/**
	 * 设置：医生
	 */
	public void setVstDoctor(String vstDoctor) {
		this.vstDoctor = vstDoctor;
	}
	/**
	 * 获取：医生
	 */
	public String getVstDoctor() {
		return vstDoctor;
	}
	/**
	 * 设置：试戴片编号OD
	 */
	public void setVstSdbhod(String vstSdbhod) {
		this.vstSdbhod = vstSdbhod;
	}
	/**
	 * 获取：试戴片编号OD
	 */
	public String getVstSdbhod() {
		return vstSdbhod;
	}
	/**
	 * 设置：试戴片编号OS
	 */
	public void setVstSdbhos(String vstSdbhos) {
		this.vstSdbhos = vstSdbhos;
	}
	/**
	 * 获取：试戴片编号OS
	 */
	public String getVstSdbhos() {
		return vstSdbhos;
	}
	/**
	 * 设置：FK(OD)
	 */
	public void setVstFkod(Double vstFkod) {
		this.vstFkod = vstFkod;
	}
	/**
	 * 获取：FK(OD)
	 */
	public Double getVstFkod() {
		return vstFkod;
	}
	/**
	 * 设置：FK(OS)
	 */
	public void setVstFkos(Double vstFkos) {
		this.vstFkos = vstFkos;
	}
	/**
	 * 获取：FK(OS)
	 */
	public Double getVstFkos() {
		return vstFkos;
	}
	/**
	 * 设置：曲率半径(OD)
	 */
	public void setVstQlbjod(Double vstQlbjod) {
		this.vstQlbjod = vstQlbjod;
	}
	/**
	 * 获取：曲率半径(OD)
	 */
	public Double getVstQlbjod() {
		return vstQlbjod;
	}
	/**
	 * 设置：曲率半径(OS)
	 */
	public void setVstQlbjos(Double vstQlbjos) {
		this.vstQlbjos = vstQlbjos;
	}
	/**
	 * 获取：曲率半径(OS)
	 */
	public Double getVstQlbjos() {
		return vstQlbjos;
	}
	/**
	 * 设置：AC(OD)
	 */
	public void setVstAcod(Double vstAcod) {
		this.vstAcod = vstAcod;
	}
	/**
	 * 获取：AC(OD)
	 */
	public Double getVstAcod() {
		return vstAcod;
	}
	/**
	 * 设置：AC(OS)
	 */
	public void setVstAcos(Double vstAcos) {
		this.vstAcos = vstAcos;
	}
	/**
	 * 获取：AC(OS)
	 */
	public Double getVstAcos() {
		return vstAcos;
	}
	/**
	 * 设置：降幅OD
	 */
	public void setVstJfod(Double vstJfod) {
		this.vstJfod = vstJfod;
	}
	/**
	 * 获取：降幅OD
	 */
	public Double getVstJfod() {
		return vstJfod;
	}
	/**
	 * 设置：降幅OS
	 */
	public void setVstJfos(Double vstJfos) {
		this.vstJfos = vstJfos;
	}
	/**
	 * 获取：降幅OS
	 */
	public Double getVstJfos() {
		return vstJfos;
	}
	/**
	 * 设置：DIA(OD)
	 */
	public void setVstDiaod(Double vstDiaod) {
		this.vstDiaod = vstDiaod;
	}
	/**
	 * 获取：DIA(OD)
	 */
	public Double getVstDiaod() {
		return vstDiaod;
	}
	/**
	 * 设置：DIA(OS)
	 */
	public void setVstDiaos(Double vstDiaos) {
		this.vstDiaos = vstDiaos;
	}
	/**
	 * 获取：DIA(OS)
	 */
	public Double getVstDiaos() {
		return vstDiaos;
	}
	/**
	 * 设置：BC(OD)
	 */
	public void setVstBcod(Double vstBcod) {
		this.vstBcod = vstBcod;
	}
	/**
	 * 获取：BC(OD)
	 */
	public Double getVstBcod() {
		return vstBcod;
	}
	/**
	 * 设置：BC(OS)
	 */
	public void setVstBcos(Double vstBcos) {
		this.vstBcos = vstBcos;
	}
	/**
	 * 获取：BC(OS)
	 */
	public Double getVstBcos() {
		return vstBcos;
	}
	/**
	 * 设置：CP/CLY(OD)
	 */
	public void setVstCpclyod(Double vstCpclyod) {
		this.vstCpclyod = vstCpclyod;
	}
	/**
	 * 获取：CP/CLY(OD)
	 */
	public Double getVstCpclyod() {
		return vstCpclyod;
	}
	/**
	 * 设置：CP/CLY(OS)
	 */
	public void setVstCpclyos(Double vstCpclyos) {
		this.vstCpclyos = vstCpclyos;
	}
	/**
	 * 获取：CP/CLY(OS)
	 */
	public Double getVstCpclyos() {
		return vstCpclyos;
	}
	/**
	 * 设置：E值(OD)
	 */
	public void setVstEod(Double vstEod) {
		this.vstEod = vstEod;
	}
	/**
	 * 获取：E值(OD)
	 */
	public Double getVstEod() {
		return vstEod;
	}
	/**
	 * 设置：E值(OS)
	 */
	public void setVstEos(Double vstEos) {
		this.vstEos = vstEos;
	}
	/**
	 * 获取：E值(OS)
	 */
	public Double getVstEos() {
		return vstEos;
	}
	/**
	 * 设置：VA(OD)
	 */
	public void setVstVaod(Double vstVaod) {
		this.vstVaod = vstVaod;
	}
	/**
	 * 获取：VA(OD)
	 */
	public Double getVstVaod() {
		return vstVaod;
	}
	/**
	 * 设置：VA(OS)
	 */
	public void setVstVaos(Double vstVaos) {
		this.vstVaos = vstVaos;
	}
	/**
	 * 获取：VA(OS)
	 */
	public Double getVstVaos() {
		return vstVaos;
	}
	/**
	 * 设置：镜片颜色OD
	 */
	public void setVstJpysod(String vstJpysod) {
		this.vstJpysod = vstJpysod;
	}
	/**
	 * 获取：镜片颜色OD
	 */
	public String getVstJpysod() {
		return vstJpysod;
	}
	/**
	 * 设置：镜片颜色OS
	 */
	public void setVstJpysos(String vstJpysos) {
		this.vstJpysos = vstJpysos;
	}
	/**
	 * 获取：镜片颜色OS
	 */
	public String getVstJpysos() {
		return vstJpysos;
	}
	/**
	 * 设置：适用镜片OD
	 */
	public void setVstSyjpod(String vstSyjpod) {
		this.vstSyjpod = vstSyjpod;
	}
	/**
	 * 获取：适用镜片OD
	 */
	public String getVstSyjpod() {
		return vstSyjpod;
	}
	/**
	 * 设置：适用镜片OS
	 */
	public void setVstSyjpos(String vstSyjpos) {
		this.vstSyjpos = vstSyjpos;
	}
	/**
	 * 获取：适用镜片OS
	 */
	public String getVstSyjpos() {
		return vstSyjpos;
	}
	/**
	 * 设置：备注
	 */
	public void setVstBeizhu(String vstBeizhu) {
		this.vstBeizhu = vstBeizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getVstBeizhu() {
		return vstBeizhu;
	}
}
