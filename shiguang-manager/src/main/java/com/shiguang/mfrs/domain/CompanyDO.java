package com.shiguang.mfrs.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;



/**
 * 公司维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-16 09:59:28
 */
public class CompanyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//公司id
	private Integer id;
	//公司名称
	private String name;
	//所属区域
	private String province;
	//公司电话
	private String telephone;
	//法人
	private String legalperson;
	//手机号
	private String phone;
	//默认采购收货地址
	private String purchaseaddress;
	//默认采购收货人
	private String purchasepeople;
	//默认采购收货电话
	private String purchasephone;
	//默认采购收货传真
	private String purchasefax;
	//报表表头显示名称
	private String headername;
	//批调金额(1向本公司批调时，默认填写成本价、向本公司批调时，需要手工填写批发价)
	private String approvedamount;
	//批发价比例
	private String proportion;
	//系统logo
	private String logo;
	//背景图
	private String backgroundimage;
	//部门选择背景图
	private String departmentimage;
	private MultipartFile imgFile;
	private MultipartFile imgFile1;
	private MultipartFile imgFile2;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public MultipartFile getImgFile1() {
		return imgFile1;
	}

	public void setImgFile1(MultipartFile imgFile1) {
		this.imgFile1 = imgFile1;
	}

	public MultipartFile getImgFile2() {
		return imgFile2;
	}

	public void setImgFile2(MultipartFile imgFile2) {
		this.imgFile2 = imgFile2;
	}

	/**
	 * 设置：公司id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：公司id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：公司名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：公司名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：所属区域
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：所属区域
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：公司电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 获取：公司电话
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 设置：法人
	 */
	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}
	/**
	 * 获取：法人
	 */
	public String getLegalperson() {
		return legalperson;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：默认采购收货地址
	 */
	public void setPurchaseaddress(String purchaseaddress) {
		this.purchaseaddress = purchaseaddress;
	}
	/**
	 * 获取：默认采购收货地址
	 */
	public String getPurchaseaddress() {
		return purchaseaddress;
	}
	/**
	 * 设置：默认采购收货人
	 */
	public void setPurchasepeople(String purchasepeople) {
		this.purchasepeople = purchasepeople;
	}
	/**
	 * 获取：默认采购收货人
	 */
	public String getPurchasepeople() {
		return purchasepeople;
	}
	/**
	 * 设置：默认采购收货电话
	 */
	public void setPurchasephone(String purchasephone) {
		this.purchasephone = purchasephone;
	}
	/**
	 * 获取：默认采购收货电话
	 */
	public String getPurchasephone() {
		return purchasephone;
	}
	/**
	 * 设置：默认采购收货传真
	 */
	public void setPurchasefax(String purchasefax) {
		this.purchasefax = purchasefax;
	}
	/**
	 * 获取：默认采购收货传真
	 */
	public String getPurchasefax() {
		return purchasefax;
	}
	/**
	 * 设置：报表表头显示名称
	 */
	public void setHeadername(String headername) {
		this.headername = headername;
	}
	/**
	 * 获取：报表表头显示名称
	 */
	public String getHeadername() {
		return headername;
	}
	/**
	 * 设置：批调金额(1向本公司批调时，默认填写成本价、向本公司批调时，需要手工填写批发价)
	 */
	public void setApprovedamount(String approvedamount) {
		this.approvedamount = approvedamount;
	}
	/**
	 * 获取：批调金额(1向本公司批调时，默认填写成本价、向本公司批调时，需要手工填写批发价)
	 */
	public String getApprovedamount() {
		return approvedamount;
	}
	/**
	 * 设置：批发价比例
	 */
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	/**
	 * 获取：批发价比例
	 */
	public String getProportion() {
		return proportion;
	}
	/**
	 * 设置：系统logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：系统logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：背景图
	 */
	public void setBackgroundimage(String backgroundimage) {
		this.backgroundimage = backgroundimage;
	}
	/**
	 * 获取：背景图
	 */
	public String getBackgroundimage() {
		return backgroundimage;
	}
	/**
	 * 设置：部门选择背景图
	 */
	public void setDepartmentimage(String departmentimage) {
		this.departmentimage = departmentimage;
	}
	/**
	 * 获取：部门选择背景图
	 */
	public String getDepartmentimage() {
		return departmentimage;
	}
}
