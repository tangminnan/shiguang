package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 框架近用表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:18:47
 */
public class RxjmjcjDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//软性角膜接触镜id
	private Long rxId;
	//卡号
	private String cardNumber;
	//处方类型
	private String rxPrescriptionType;
	//医生
	private String rxDoctor;
	//验光师
	private String rxOptometryName;
	//BC(OD)
	private Double rxBcod;
	//BC(OS)
	private Double rxBcos;
	//球镜OD
	private Double rxSphod;
	//球镜OS
	private Double rxSphos;
	//柱镜OD
	private Double rxCylod;
	//柱镜OS
	private Double rxCylos;
	//轴向OD
	private Double rxAxialod;
	//轴向OS
	private Double rxAxialos;
	//直径(OD)
	private Double rxZjod;
	//直径(OS)
	private Double rxZjos;
	//va(OD)
	private Double rxVaod;
	//va(OS)
	private Double rxVaos;
	//适用镜片OD
	private String rxSyjpod;
	//适用镜片OS
	private String rxSyjpos;
	//片/盒OD
	private String rxUnitod;
	//片/盒OS
	private String rxUnitos;
	//软性角膜接触镜处理方式
	private String rxClfs;
	//护理液品种
	private String rxHlypz;
	//备注
	private String rxBeizhu;

	/**
	 * 设置：软性角膜接触镜id
	 */
	public void setRxId(Long rxId) {
		this.rxId = rxId;
	}
	/**
	 * 获取：软性角膜接触镜id
	 */
	public Long getRxId() {
		return rxId;
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
	public void setRxPrescriptionType(String rxPrescriptionType) {
		this.rxPrescriptionType = rxPrescriptionType;
	}
	/**
	 * 获取：处方类型
	 */
	public String getRxPrescriptionType() {
		return rxPrescriptionType;
	}
	/**
	 * 设置：医生
	 */
	public void setRxDoctor(String rxDoctor) {
		this.rxDoctor = rxDoctor;
	}
	/**
	 * 获取：医生
	 */
	public String getRxDoctor() {
		return rxDoctor;
	}
	/**
	 * 设置：验光师
	 */
	public void setRxOptometryName(String rxOptometryName) {
		this.rxOptometryName = rxOptometryName;
	}
	/**
	 * 获取：验光师
	 */
	public String getRxOptometryName() {
		return rxOptometryName;
	}
	/**
	 * 设置：BC(OD)
	 */
	public void setRxBcod(Double rxBcod) {
		this.rxBcod = rxBcod;
	}
	/**
	 * 获取：BC(OD)
	 */
	public Double getRxBcod() {
		return rxBcod;
	}
	/**
	 * 设置：BC(OS)
	 */
	public void setRxBcos(Double rxBcos) {
		this.rxBcos = rxBcos;
	}
	/**
	 * 获取：BC(OS)
	 */
	public Double getRxBcos() {
		return rxBcos;
	}
	/**
	 * 设置：球镜OD
	 */
	public void setRxSphod(Double rxSphod) {
		this.rxSphod = rxSphod;
	}
	/**
	 * 获取：球镜OD
	 */
	public Double getRxSphod() {
		return rxSphod;
	}
	/**
	 * 设置：球镜OS
	 */
	public void setRxSphos(Double rxSphos) {
		this.rxSphos = rxSphos;
	}
	/**
	 * 获取：球镜OS
	 */
	public Double getRxSphos() {
		return rxSphos;
	}
	/**
	 * 设置：柱镜OD
	 */
	public void setRxCylod(Double rxCylod) {
		this.rxCylod = rxCylod;
	}
	/**
	 * 获取：柱镜OD
	 */
	public Double getRxCylod() {
		return rxCylod;
	}
	/**
	 * 设置：柱镜OS
	 */
	public void setRxCylos(Double rxCylos) {
		this.rxCylos = rxCylos;
	}
	/**
	 * 获取：柱镜OS
	 */
	public Double getRxCylos() {
		return rxCylos;
	}
	/**
	 * 设置：轴向OD
	 */
	public void setRxAxialod(Double rxAxialod) {
		this.rxAxialod = rxAxialod;
	}
	/**
	 * 获取：轴向OD
	 */
	public Double getRxAxialod() {
		return rxAxialod;
	}
	/**
	 * 设置：轴向OS
	 */
	public void setRxAxialos(Double rxAxialos) {
		this.rxAxialos = rxAxialos;
	}
	/**
	 * 获取：轴向OS
	 */
	public Double getRxAxialos() {
		return rxAxialos;
	}
	/**
	 * 设置：直径(OD)
	 */
	public void setRxZjod(Double rxZjod) {
		this.rxZjod = rxZjod;
	}
	/**
	 * 获取：直径(OD)
	 */
	public Double getRxZjod() {
		return rxZjod;
	}
	/**
	 * 设置：直径(OS)
	 */
	public void setRxZjos(Double rxZjos) {
		this.rxZjos = rxZjos;
	}
	/**
	 * 获取：直径(OS)
	 */
	public Double getRxZjos() {
		return rxZjos;
	}
	/**
	 * 设置：va(OD)
	 */
	public void setRxVaod(Double rxVaod) {
		this.rxVaod = rxVaod;
	}
	/**
	 * 获取：va(OD)
	 */
	public Double getRxVaod() {
		return rxVaod;
	}
	/**
	 * 设置：va(OS)
	 */
	public void setRxVaos(Double rxVaos) {
		this.rxVaos = rxVaos;
	}
	/**
	 * 获取：va(OS)
	 */
	public Double getRxVaos() {
		return rxVaos;
	}
	/**
	 * 设置：适用镜片OD
	 */
	public void setRxSyjpod(String rxSyjpod) {
		this.rxSyjpod = rxSyjpod;
	}
	/**
	 * 获取：适用镜片OD
	 */
	public String getRxSyjpod() {
		return rxSyjpod;
	}
	/**
	 * 设置：适用镜片OS
	 */
	public void setRxSyjpos(String rxSyjpos) {
		this.rxSyjpos = rxSyjpos;
	}
	/**
	 * 获取：适用镜片OS
	 */
	public String getRxSyjpos() {
		return rxSyjpos;
	}
	/**
	 * 设置：片/盒OD
	 */
	public void setRxUnitod(String rxUnitod) {
		this.rxUnitod = rxUnitod;
	}
	/**
	 * 获取：片/盒OD
	 */
	public String getRxUnitod() {
		return rxUnitod;
	}
	/**
	 * 设置：片/盒OS
	 */
	public void setRxUnitos(String rxUnitos) {
		this.rxUnitos = rxUnitos;
	}
	/**
	 * 获取：片/盒OS
	 */
	public String getRxUnitos() {
		return rxUnitos;
	}
	/**
	 * 设置：软性角膜接触镜处理方式
	 */
	public void setRxClfs(String rxClfs) {
		this.rxClfs = rxClfs;
	}
	/**
	 * 获取：软性角膜接触镜处理方式
	 */
	public String getRxClfs() {
		return rxClfs;
	}
	/**
	 * 设置：护理液品种
	 */
	public void setRxHlypz(String rxHlypz) {
		this.rxHlypz = rxHlypz;
	}
	/**
	 * 获取：护理液品种
	 */
	public String getRxHlypz() {
		return rxHlypz;
	}
	/**
	 * 设置：备注
	 */
	public void setRxBeizhu(String rxBeizhu) {
		this.rxBeizhu = rxBeizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getRxBeizhu() {
		return rxBeizhu;
	}
}