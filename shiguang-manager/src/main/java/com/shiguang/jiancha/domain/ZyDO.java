package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 框架中用表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:50:32
 */
public class ZyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//中用id
	private Long zyId;
	//卡号
	private String cardNumber;
	//处方类型
	private String zyPrescriptionType;
	//医生
	private String zyDoctor;
	//验光师
	private String zyOptometryName;
	//球镜OD
	private Double zySphod;
	//球镜OS
	private Double zySphos;
	//柱镜OD
	private Double zyCylod;
	//柱镜OS
	private Double zyCylos;
	//轴向OD
	private Double zyAxialod;
	//轴向OS
	private Double zyAxialos;
	//三棱镜(OD)
	private Double zyPrismod;
	//三棱镜(OS)
	private Double zyPrismos;
	//基底(OD)
	private String zyJdod;
	//基底(OS)
	private String zyJdos;
	//中用瞳距(mm)(OD)
	private Double zyZytjod;
	//中用瞳距(mm)(OS)
	private Double zyZytjos;
	//瞳高(mm)(OD)
	private Double zyTgod;
	//瞳高(mm)(OS)
	private Double zyTgos;
	//中用va(OD)
	private Double zyVaod;
	//中用va(OS)
	private Double zyVaos;
	//建议镜片材质
	private String zyJpcz;
	//处理方式
	private String zyClfs;
	//建议镜框
	private String zyJyjk;
	//镜框类型
	private String zyJklx;
	//文本
	private String zyText;
	//备注
	private String zyBeizhu;

	/**
	 * 设置：中用id
	 */
	public void setZyId(Long zyId) {
		this.zyId = zyId;
	}
	/**
	 * 获取：中用id
	 */
	public Long getZyId() {
		return zyId;
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
	public void setZyPrescriptionType(String zyPrescriptionType) {
		this.zyPrescriptionType = zyPrescriptionType;
	}
	/**
	 * 获取：处方类型
	 */
	public String getZyPrescriptionType() {
		return zyPrescriptionType;
	}
	/**
	 * 设置：医生
	 */
	public void setZyDoctor(String zyDoctor) {
		this.zyDoctor = zyDoctor;
	}
	/**
	 * 获取：医生
	 */
	public String getZyDoctor() {
		return zyDoctor;
	}
	/**
	 * 设置：验光师
	 */
	public void setZyOptometryName(String zyOptometryName) {
		this.zyOptometryName = zyOptometryName;
	}
	/**
	 * 获取：验光师
	 */
	public String getZyOptometryName() {
		return zyOptometryName;
	}
	/**
	 * 设置：球镜OD
	 */
	public void setZySphod(Double zySphod) {
		this.zySphod = zySphod;
	}
	/**
	 * 获取：球镜OD
	 */
	public Double getZySphod() {
		return zySphod;
	}
	/**
	 * 设置：球镜OS
	 */
	public void setZySphos(Double zySphos) {
		this.zySphos = zySphos;
	}
	/**
	 * 获取：球镜OS
	 */
	public Double getZySphos() {
		return zySphos;
	}
	/**
	 * 设置：柱镜OD
	 */
	public void setZyCylod(Double zyCylod) {
		this.zyCylod = zyCylod;
	}
	/**
	 * 获取：柱镜OD
	 */
	public Double getZyCylod() {
		return zyCylod;
	}
	/**
	 * 设置：柱镜OS
	 */
	public void setZyCylos(Double zyCylos) {
		this.zyCylos = zyCylos;
	}
	/**
	 * 获取：柱镜OS
	 */
	public Double getZyCylos() {
		return zyCylos;
	}
	/**
	 * 设置：轴向OD
	 */
	public void setZyAxialod(Double zyAxialod) {
		this.zyAxialod = zyAxialod;
	}
	/**
	 * 获取：轴向OD
	 */
	public Double getZyAxialod() {
		return zyAxialod;
	}
	/**
	 * 设置：轴向OS
	 */
	public void setZyAxialos(Double zyAxialos) {
		this.zyAxialos = zyAxialos;
	}
	/**
	 * 获取：轴向OS
	 */
	public Double getZyAxialos() {
		return zyAxialos;
	}
	/**
	 * 设置：三棱镜(OD)
	 */
	public void setZyPrismod(Double zyPrismod) {
		this.zyPrismod = zyPrismod;
	}
	/**
	 * 获取：三棱镜(OD)
	 */
	public Double getZyPrismod() {
		return zyPrismod;
	}
	/**
	 * 设置：三棱镜(OS)
	 */
	public void setZyPrismos(Double zyPrismos) {
		this.zyPrismos = zyPrismos;
	}
	/**
	 * 获取：三棱镜(OS)
	 */
	public Double getZyPrismos() {
		return zyPrismos;
	}
	/**
	 * 设置：基底(OD)
	 */
	public void setZyJdod(String zyJdod) {
		this.zyJdod = zyJdod;
	}
	/**
	 * 获取：基底(OD)
	 */
	public String getZyJdod() {
		return zyJdod;
	}
	/**
	 * 设置：基底(OS)
	 */
	public void setZyJdos(String zyJdos) {
		this.zyJdos = zyJdos;
	}
	/**
	 * 获取：基底(OS)
	 */
	public String getZyJdos() {
		return zyJdos;
	}
	/**
	 * 设置：中用瞳距(mm)(OD)
	 */
	public void setZyZytjod(Double zyZytjod) {
		this.zyZytjod = zyZytjod;
	}
	/**
	 * 获取：中用瞳距(mm)(OD)
	 */
	public Double getZyZytjod() {
		return zyZytjod;
	}
	/**
	 * 设置：中用瞳距(mm)(OS)
	 */
	public void setZyZytjos(Double zyZytjos) {
		this.zyZytjos = zyZytjos;
	}
	/**
	 * 获取：中用瞳距(mm)(OS)
	 */
	public Double getZyZytjos() {
		return zyZytjos;
	}
	/**
	 * 设置：瞳高(mm)(OD)
	 */
	public void setZyTgod(Double zyTgod) {
		this.zyTgod = zyTgod;
	}
	/**
	 * 获取：瞳高(mm)(OD)
	 */
	public Double getZyTgod() {
		return zyTgod;
	}
	/**
	 * 设置：瞳高(mm)(OS)
	 */
	public void setZyTgos(Double zyTgos) {
		this.zyTgos = zyTgos;
	}
	/**
	 * 获取：瞳高(mm)(OS)
	 */
	public Double getZyTgos() {
		return zyTgos;
	}
	/**
	 * 设置：中用va(OD)
	 */
	public void setZyVaod(Double zyVaod) {
		this.zyVaod = zyVaod;
	}
	/**
	 * 获取：中用va(OD)
	 */
	public Double getZyVaod() {
		return zyVaod;
	}
	/**
	 * 设置：中用va(OS)
	 */
	public void setZyVaos(Double zyVaos) {
		this.zyVaos = zyVaos;
	}
	/**
	 * 获取：中用va(OS)
	 */
	public Double getZyVaos() {
		return zyVaos;
	}
	/**
	 * 设置：建议镜片材质
	 */
	public void setZyJpcz(String zyJpcz) {
		this.zyJpcz = zyJpcz;
	}
	/**
	 * 获取：建议镜片材质
	 */
	public String getZyJpcz() {
		return zyJpcz;
	}
	/**
	 * 设置：处理方式
	 */
	public void setZyClfs(String zyClfs) {
		this.zyClfs = zyClfs;
	}
	/**
	 * 获取：处理方式
	 */
	public String getZyClfs() {
		return zyClfs;
	}
	/**
	 * 设置：建议镜框
	 */
	public void setZyJyjk(String zyJyjk) {
		this.zyJyjk = zyJyjk;
	}
	/**
	 * 获取：建议镜框
	 */
	public String getZyJyjk() {
		return zyJyjk;
	}
	/**
	 * 设置：镜框类型
	 */
	public void setZyJklx(String zyJklx) {
		this.zyJklx = zyJklx;
	}
	/**
	 * 获取：镜框类型
	 */
	public String getZyJklx() {
		return zyJklx;
	}
	/**
	 * 设置：文本
	 */
	public void setZyText(String zyText) {
		this.zyText = zyText;
	}
	/**
	 * 获取：文本
	 */
	public String getZyText() {
		return zyText;
	}
	/**
	 * 设置：备注
	 */
	public void setZyBeizhu(String zyBeizhu) {
		this.zyBeizhu = zyBeizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getZyBeizhu() {
		return zyBeizhu;
	}
}
