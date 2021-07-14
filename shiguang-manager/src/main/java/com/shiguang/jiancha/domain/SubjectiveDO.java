package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 主观验光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 10:22:52
 */
public class SubjectiveDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主观验光id
	private Long id;
	//卡号
	private String cardNumber;
	//球镜(右眼OD)
	private Double sphereRightz;
	//球镜(左眼OS)
	private Double sphereLeftz;
	//柱镜(右眼OD)
	private Double cylinderRightz;
	//柱镜(左眼OS)
	private Double cylinderLeftz;
	//轴向(右眼-OD)
	private Double axialRightz;
	//轴向(左眼OS)
	private Double axialLeftz;
	//DVA(右眼OD)
	private Double dvaRightz;
	//DVA(左眼OS)
	private Double dvaLeftz;
	//NVA(OD)
	private Double nvaRightz;
	//NVA(OS)
	private Double nvaLeftz;
	//三棱镜(OD)
	private Double prismRightz;
	//三棱镜(OS)
	private Double prismLeftz;
	//基底(OD)
	private String jdrZ;
	//基底(OS)
	private String jdlZ;
	//Add(OD)
	private Double addRightz;
	//Add(OS)
	private Double addLeftz;
	//远用瞳孔距(mm)(OD)
	private Double yuanRz;
	//远用瞳孔距(mm)(OS)
	private Double yuanLz;
	//近用瞳孔距(mm)(OD)
	private Double nearRightz;
	//近用瞳孔距(mm)(OS)
	private Double nearLeftz;

	/**
	 * 设置：主观验光id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主观验光id
	 */
	public Long getId() {
		return id;
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
	 * 设置：球镜(右眼OD)
	 */
	public void setSphereRightz(Double sphereRightz) {
		this.sphereRightz = sphereRightz;
	}
	/**
	 * 获取：球镜(右眼OD)
	 */
	public Double getSphereRightz() {
		return sphereRightz;
	}
	/**
	 * 设置：球镜(左眼OS)
	 */
	public void setSphereLeftz(Double sphereLeftz) {
		this.sphereLeftz = sphereLeftz;
	}
	/**
	 * 获取：球镜(左眼OS)
	 */
	public Double getSphereLeftz() {
		return sphereLeftz;
	}
	/**
	 * 设置：柱镜(右眼OD)
	 */
	public void setCylinderRightz(Double cylinderRightz) {
		this.cylinderRightz = cylinderRightz;
	}
	/**
	 * 获取：柱镜(右眼OD)
	 */
	public Double getCylinderRightz() {
		return cylinderRightz;
	}
	/**
	 * 设置：柱镜(左眼OS)
	 */
	public void setCylinderLeftz(Double cylinderLeftz) {
		this.cylinderLeftz = cylinderLeftz;
	}
	/**
	 * 获取：柱镜(左眼OS)
	 */
	public Double getCylinderLeftz() {
		return cylinderLeftz;
	}
	/**
	 * 设置：轴向(右眼-OD)
	 */
	public void setAxialRightz(Double axialRightz) {
		this.axialRightz = axialRightz;
	}
	/**
	 * 获取：轴向(右眼-OD)
	 */
	public Double getAxialRightz() {
		return axialRightz;
	}
	/**
	 * 设置：轴向(左眼OS)
	 */
	public void setAxialLeftz(Double axialLeftz) {
		this.axialLeftz = axialLeftz;
	}
	/**
	 * 获取：轴向(左眼OS)
	 */
	public Double getAxialLeftz() {
		return axialLeftz;
	}
	/**
	 * 设置：DVA(右眼OD)
	 */
	public void setDvaRightz(Double dvaRightz) {
		this.dvaRightz = dvaRightz;
	}
	/**
	 * 获取：DVA(右眼OD)
	 */
	public Double getDvaRightz() {
		return dvaRightz;
	}
	/**
	 * 设置：DVA(左眼OS)
	 */
	public void setDvaLeftz(Double dvaLeftz) {
		this.dvaLeftz = dvaLeftz;
	}
	/**
	 * 获取：DVA(左眼OS)
	 */
	public Double getDvaLeftz() {
		return dvaLeftz;
	}
	/**
	 * 设置：NVA(OD)
	 */
	public void setNvaRightz(Double nvaRightz) {
		this.nvaRightz = nvaRightz;
	}
	/**
	 * 获取：NVA(OD)
	 */
	public Double getNvaRightz() {
		return nvaRightz;
	}
	/**
	 * 设置：NVA(OS)
	 */
	public void setNvaLeftz(Double nvaLeftz) {
		this.nvaLeftz = nvaLeftz;
	}
	/**
	 * 获取：NVA(OS)
	 */
	public Double getNvaLeftz() {
		return nvaLeftz;
	}
	/**
	 * 设置：三棱镜(OD)
	 */
	public void setPrismRightz(Double prismRightz) {
		this.prismRightz = prismRightz;
	}
	/**
	 * 获取：三棱镜(OD)
	 */
	public Double getPrismRightz() {
		return prismRightz;
	}
	/**
	 * 设置：三棱镜(OS)
	 */
	public void setPrismLeftz(Double prismLeftz) {
		this.prismLeftz = prismLeftz;
	}
	/**
	 * 获取：三棱镜(OS)
	 */
	public Double getPrismLeftz() {
		return prismLeftz;
	}
	/**
	 * 设置：基底(OD)
	 */
	public void setJdrZ(String jdrZ) {
		this.jdrZ = jdrZ;
	}
	/**
	 * 获取：基底(OD)
	 */
	public String getJdrZ() {
		return jdrZ;
	}
	/**
	 * 设置：基底(OS)
	 */
	public void setJdlZ(String jdlZ) {
		this.jdlZ = jdlZ;
	}
	/**
	 * 获取：基底(OS)
	 */
	public String getJdlZ() {
		return jdlZ;
	}
	/**
	 * 设置：Add(OD)
	 */
	public void setAddRightz(Double addRightz) {
		this.addRightz = addRightz;
	}
	/**
	 * 获取：Add(OD)
	 */
	public Double getAddRightz() {
		return addRightz;
	}
	/**
	 * 设置：Add(OS)
	 */
	public void setAddLeftz(Double addLeftz) {
		this.addLeftz = addLeftz;
	}
	/**
	 * 获取：Add(OS)
	 */
	public Double getAddLeftz() {
		return addLeftz;
	}
	/**
	 * 设置：远用瞳孔距(mm)(OD)
	 */
	public void setYuanRz(Double yuanRz) {
		this.yuanRz = yuanRz;
	}
	/**
	 * 获取：远用瞳孔距(mm)(OD)
	 */
	public Double getYuanRz() {
		return yuanRz;
	}
	/**
	 * 设置：远用瞳孔距(mm)(OS)
	 */
	public void setYuanLz(Double yuanLz) {
		this.yuanLz = yuanLz;
	}
	/**
	 * 获取：远用瞳孔距(mm)(OS)
	 */
	public Double getYuanLz() {
		return yuanLz;
	}
	/**
	 * 设置：近用瞳孔距(mm)(OD)
	 */
	public void setNearRightz(Double nearRightz) {
		this.nearRightz = nearRightz;
	}
	/**
	 * 获取：近用瞳孔距(mm)(OD)
	 */
	public Double getNearRightz() {
		return nearRightz;
	}
	/**
	 * 设置：近用瞳孔距(mm)(OS)
	 */
	public void setNearLeftz(Double nearLeftz) {
		this.nearLeftz = nearLeftz;
	}
	/**
	 * 获取：近用瞳孔距(mm)(OS)
	 */
	public Double getNearLeftz() {
		return nearLeftz;
	}
}
