package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 框架双光/渐进表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 10:03:39
 */
public class SgjjDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//双光渐进id
	private Long sgjjId;
	//卡号
	private String cardNumber;
	//处方类型
	private String sgjjPrescriptionType;
	//医生
	private String sgjjDoctor;
	//验光师
	private String sgjjOptometryName;
	//球镜OD
	private Double sgjjSphod;
	//球镜OS
	private Double sgjjSphos;
	//柱镜OD
	private Double sgjjCylod;
	//柱镜OS
	private Double sgjjCylos;
	//轴向OD
	private Double sgjjAxialod;
	//轴向OS
	private Double sgjjAxialos;
	//Add(OD)
	private Double sgjjAddod;
	//Add(OS)
	private Double sgjjAddos;
	//远用瞳距(mm)(OD)
	private Double sgjjYytjod;
	//远用瞳距(mm)(OS)
	private Double sgjjYytjos;
	//近用瞳距(mm)(OD)
	private Double sgjjJytjod;
	//近用瞳距(mm)(OS)
	private Double sgjjJytjos;
	//瞳高(mm)(OD)
	private Double sgjjTgod;
	//瞳高(mm)(OS)
	private Double sgjjTgos;
	//远用va(OD)
	private Double sgjjYyvaod;
	//远用va(OS)
	private Double sgjjYyvaos;
	//近用va(OD)
	private Double sgjjJyvaod;
	//近用va(OS)
	private Double sgjjJyvaos;
	//建议镜片材质
	private String sgjjJpcz;
	//处理方式
	private String sgjjClfs;
	//建议框架
	private String sgjjJykj;
	//框架类型
	private String sgjjKjlx;
	//文本
	private String sgjjText;
	//备注
	private String sgjjBeizhu;

	/**
	 * 设置：双光渐进id
	 */
	public void setSgjjId(Long sgjjId) {
		this.sgjjId = sgjjId;
	}
	/**
	 * 获取：双光渐进id
	 */
	public Long getSgjjId() {
		return sgjjId;
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
	public void setSgjjPrescriptionType(String sgjjPrescriptionType) {
		this.sgjjPrescriptionType = sgjjPrescriptionType;
	}
	/**
	 * 获取：处方类型
	 */
	public String getSgjjPrescriptionType() {
		return sgjjPrescriptionType;
	}
	/**
	 * 设置：医生
	 */
	public void setSgjjDoctor(String sgjjDoctor) {
		this.sgjjDoctor = sgjjDoctor;
	}
	/**
	 * 获取：医生
	 */
	public String getSgjjDoctor() {
		return sgjjDoctor;
	}
	/**
	 * 设置：验光师
	 */
	public void setSgjjOptometryName(String sgjjOptometryName) {
		this.sgjjOptometryName = sgjjOptometryName;
	}
	/**
	 * 获取：验光师
	 */
	public String getSgjjOptometryName() {
		return sgjjOptometryName;
	}
	/**
	 * 设置：球镜OD
	 */
	public void setSgjjSphod(Double sgjjSphod) {
		this.sgjjSphod = sgjjSphod;
	}
	/**
	 * 获取：球镜OD
	 */
	public Double getSgjjSphod() {
		return sgjjSphod;
	}
	/**
	 * 设置：球镜OS
	 */
	public void setSgjjSphos(Double sgjjSphos) {
		this.sgjjSphos = sgjjSphos;
	}
	/**
	 * 获取：球镜OS
	 */
	public Double getSgjjSphos() {
		return sgjjSphos;
	}
	/**
	 * 设置：柱镜OD
	 */
	public void setSgjjCylod(Double sgjjCylod) {
		this.sgjjCylod = sgjjCylod;
	}
	/**
	 * 获取：柱镜OD
	 */
	public Double getSgjjCylod() {
		return sgjjCylod;
	}
	/**
	 * 设置：柱镜OS
	 */
	public void setSgjjCylos(Double sgjjCylos) {
		this.sgjjCylos = sgjjCylos;
	}
	/**
	 * 获取：柱镜OS
	 */
	public Double getSgjjCylos() {
		return sgjjCylos;
	}
	/**
	 * 设置：轴向OD
	 */
	public void setSgjjAxialod(Double sgjjAxialod) {
		this.sgjjAxialod = sgjjAxialod;
	}
	/**
	 * 获取：轴向OD
	 */
	public Double getSgjjAxialod() {
		return sgjjAxialod;
	}
	/**
	 * 设置：轴向OS
	 */
	public void setSgjjAxialos(Double sgjjAxialos) {
		this.sgjjAxialos = sgjjAxialos;
	}
	/**
	 * 获取：轴向OS
	 */
	public Double getSgjjAxialos() {
		return sgjjAxialos;
	}
	/**
	 * 设置：Add(OD)
	 */
	public void setSgjjAddod(Double sgjjAddod) {
		this.sgjjAddod = sgjjAddod;
	}
	/**
	 * 获取：Add(OD)
	 */
	public Double getSgjjAddod() {
		return sgjjAddod;
	}
	/**
	 * 设置：Add(OS)
	 */
	public void setSgjjAddos(Double sgjjAddos) {
		this.sgjjAddos = sgjjAddos;
	}
	/**
	 * 获取：Add(OS)
	 */
	public Double getSgjjAddos() {
		return sgjjAddos;
	}
	/**
	 * 设置：远用瞳距(mm)(OD)
	 */
	public void setSgjjYytjod(Double sgjjYytjod) {
		this.sgjjYytjod = sgjjYytjod;
	}
	/**
	 * 获取：远用瞳距(mm)(OD)
	 */
	public Double getSgjjYytjod() {
		return sgjjYytjod;
	}
	/**
	 * 设置：远用瞳距(mm)(OS)
	 */
	public void setSgjjYytjos(Double sgjjYytjos) {
		this.sgjjYytjos = sgjjYytjos;
	}
	/**
	 * 获取：远用瞳距(mm)(OS)
	 */
	public Double getSgjjYytjos() {
		return sgjjYytjos;
	}
	/**
	 * 设置：近用瞳距(mm)(OD)
	 */
	public void setSgjjJytjod(Double sgjjJytjod) {
		this.sgjjJytjod = sgjjJytjod;
	}
	/**
	 * 获取：近用瞳距(mm)(OD)
	 */
	public Double getSgjjJytjod() {
		return sgjjJytjod;
	}
	/**
	 * 设置：近用瞳距(mm)(OS)
	 */
	public void setSgjjJytjos(Double sgjjJytjos) {
		this.sgjjJytjos = sgjjJytjos;
	}
	/**
	 * 获取：近用瞳距(mm)(OS)
	 */
	public Double getSgjjJytjos() {
		return sgjjJytjos;
	}
	/**
	 * 设置：瞳高(mm)(OD)
	 */
	public void setSgjjTgod(Double sgjjTgod) {
		this.sgjjTgod = sgjjTgod;
	}
	/**
	 * 获取：瞳高(mm)(OD)
	 */
	public Double getSgjjTgod() {
		return sgjjTgod;
	}
	/**
	 * 设置：瞳高(mm)(OS)
	 */
	public void setSgjjTgos(Double sgjjTgos) {
		this.sgjjTgos = sgjjTgos;
	}
	/**
	 * 获取：瞳高(mm)(OS)
	 */
	public Double getSgjjTgos() {
		return sgjjTgos;
	}
	/**
	 * 设置：远用va(OD)
	 */
	public void setSgjjYyvaod(Double sgjjYyvaod) {
		this.sgjjYyvaod = sgjjYyvaod;
	}
	/**
	 * 获取：远用va(OD)
	 */
	public Double getSgjjYyvaod() {
		return sgjjYyvaod;
	}
	/**
	 * 设置：远用va(OS)
	 */
	public void setSgjjYyvaos(Double sgjjYyvaos) {
		this.sgjjYyvaos = sgjjYyvaos;
	}
	/**
	 * 获取：远用va(OS)
	 */
	public Double getSgjjYyvaos() {
		return sgjjYyvaos;
	}
	/**
	 * 设置：近用va(OD)
	 */
	public void setSgjjJyvaod(Double sgjjJyvaod) {
		this.sgjjJyvaod = sgjjJyvaod;
	}
	/**
	 * 获取：近用va(OD)
	 */
	public Double getSgjjJyvaod() {
		return sgjjJyvaod;
	}
	/**
	 * 设置：近用va(OS)
	 */
	public void setSgjjJyvaos(Double sgjjJyvaos) {
		this.sgjjJyvaos = sgjjJyvaos;
	}
	/**
	 * 获取：近用va(OS)
	 */
	public Double getSgjjJyvaos() {
		return sgjjJyvaos;
	}
	/**
	 * 设置：建议镜片材质
	 */
	public void setSgjjJpcz(String sgjjJpcz) {
		this.sgjjJpcz = sgjjJpcz;
	}
	/**
	 * 获取：建议镜片材质
	 */
	public String getSgjjJpcz() {
		return sgjjJpcz;
	}
	/**
	 * 设置：处理方式
	 */
	public void setSgjjClfs(String sgjjClfs) {
		this.sgjjClfs = sgjjClfs;
	}
	/**
	 * 获取：处理方式
	 */
	public String getSgjjClfs() {
		return sgjjClfs;
	}
	/**
	 * 设置：建议框架
	 */
	public void setSgjjJykj(String sgjjJykj) {
		this.sgjjJykj = sgjjJykj;
	}
	/**
	 * 获取：建议框架
	 */
	public String getSgjjJykj() {
		return sgjjJykj;
	}
	/**
	 * 设置：框架类型
	 */
	public void setSgjjKjlx(String sgjjKjlx) {
		this.sgjjKjlx = sgjjKjlx;
	}
	/**
	 * 获取：框架类型
	 */
	public String getSgjjKjlx() {
		return sgjjKjlx;
	}
	/**
	 * 设置：文本
	 */
	public void setSgjjText(String sgjjText) {
		this.sgjjText = sgjjText;
	}
	/**
	 * 获取：文本
	 */
	public String getSgjjText() {
		return sgjjText;
	}
	/**
	 * 设置：备注
	 */
	public void setSgjjBeizhu(String sgjjBeizhu) {
		this.sgjjBeizhu = sgjjBeizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getSgjjBeizhu() {
		return sgjjBeizhu;
	}
}
