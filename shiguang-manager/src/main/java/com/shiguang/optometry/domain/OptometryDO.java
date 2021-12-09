package com.shiguang.optometry.domain;

import java.io.Serializable;
import java.util.Date;

public class OptometryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //会员卡号
    private String memberInumber;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
    //散瞳用药id
    private Long pharmacyId;
    //散瞳用药
    private String pharmacy;
    //球镜(右眼OD)
    private String sphereRight;
    //球镜(左眼OS)
    private String sphereLeft;
    //柱镜(右眼OD)
    private String cylinderRight;
    //柱镜(左眼OS)
    private String cylinderLeft;
    //轴向(右眼-OD)
    private String axialRight;
    //轴向(左眼OS)
    private String axialLeft;
    //角膜散光(OD)
    private String cornealAstigmatismOd;
    //角膜散光(OS)
    private String cornealAstigmatismOs;
    //瞳距(OD)
    private String pdOd;
    //瞳距(OS)
    private String pdOs;
    //检影球镜(OD)
    private String sphJyod;
    //检影球镜(OS)
    private String sphJyos;
    //检影柱镜(OD)
    private String cylJyod;
    //检影柱镜(OS)
    private String cylJyos;
    //检影轴向(OD)
    private String axialJyod;
    //检影轴向(OS)
    private String axialJyos;
    //检影VA(OD)
    private String vaJyod;
    //检影VA(OS)
    private String vaJyos;
    //检影瞳距(mm)(OD)
    private String pdJyod;
    //检影瞳距(mm)(OS)
    private String pdJyos;
    //插片球镜(OD)
    private String sphCpod;
    //插片球镜(OS)
    private String sphCpos;
    //插片柱镜(OD)
    private String cylCpod;
    //插片柱镜(OS)
    private String cylCpos;
    //插片轴向(OD)
    private String axialCpod;
    //插片轴向(OS)
    private String axialCpos;
    //插片DVA(OD)
    private String dvaCpod;
    //插片DVA(OS)
    private String dvaCpos;
    //插片NVA(OD)
    private String nvaCpod;
    //插片NVA(OS)
    private String nvaCpos;
    //插片add(OD)
    private String addCpod;
    //插片add(OS)
    private String addCpos;
    //插片测量距离(OD)
    private String distanceOd;
    //插片测量距离(OS)
    private String distanceOs;
    //创建时间
    private Date createTime;





    //会员卡号
    private String cardNumber;
    //是否缴费
    private Long isSale;
    //顾客性别(1:男2:女)
    private Long sex;
    private String sexx;
    private String name;
    //年龄
    private Long age;
    //销售单号
    private String saleNumber;
    //类型
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getIsSale() {
        return isSale;
    }

    public void setIsSale(Long isSale) {
        this.isSale = isSale;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getSexx() {
        return sexx;
    }

    public void setSexx(String sexx) {
        this.sexx = sexx;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：会员卡号
     */
    public void setMemberInumber(String memberInumber) {
        this.memberInumber = memberInumber;
    }

    /**
     * 获取：会员卡号
     */
    public String getMemberInumber() {
        return memberInumber;
    }

    /**
     * 设置：是否散瞳(0:散瞳前1:散瞳后)
     */
    public void setMydriasis(Long mydriasis) {
        this.mydriasis = mydriasis;
    }

    /**
     * 获取：是否散瞳(0:散瞳前1:散瞳后)
     */
    public Long getMydriasis() {
        return mydriasis;
    }

    /**
     * 设置：散瞳用药id
     */
    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    /**
     * 获取：散瞳用药id
     */
    public Long getPharmacyId() {
        return pharmacyId;
    }

    /**
     * 设置：散瞳用药
     */
    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    /**
     * 获取：散瞳用药
     */
    public String getPharmacy() {
        return pharmacy;
    }

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRight(String sphereRight) {
        this.sphereRight = sphereRight;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRight() {
        return sphereRight;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeft(String sphereLeft) {
        this.sphereLeft = sphereLeft;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLeft() {
        return sphereLeft;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRight(String cylinderRight) {
        this.cylinderRight = cylinderRight;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRight() {
        return cylinderRight;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeft(String cylinderLeft) {
        this.cylinderLeft = cylinderLeft;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLeft() {
        return cylinderLeft;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRight(String axialRight) {
        this.axialRight = axialRight;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRight() {
        return axialRight;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeft(String axialLeft) {
        this.axialLeft = axialLeft;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLeft() {
        return axialLeft;
    }

    /**
     * 设置：角膜散光(OS)
     */
    public void setCornealAstigmatismOs(String cornealAstigmatismOs) {
        this.cornealAstigmatismOs = cornealAstigmatismOs;
    }

    /**
     * 获取：角膜散光(OS)
     */
    public String getCornealAstigmatismOs() {
        return cornealAstigmatismOs;
    }

    /**
     * 设置：角膜散光(OD)
     */
    public void setCornealAstigmatismOd(String cornealAstigmatismOd) {
        this.cornealAstigmatismOd = cornealAstigmatismOd;
    }

    /**
     * 获取：角膜散光(OD)
     */
    public String getCornealAstigmatismOd() {
        return cornealAstigmatismOd;
    }

    /**
     * 设置：瞳距(OD)
     */
    public void setPdOd(String pdOd) {
        this.pdOd = pdOd;
    }

    /**
     * 获取：瞳距(OD)
     */
    public String getPdOd() {
        return pdOd;
    }

    /**
     * 设置：瞳距(OS)
     */
    public void setPdOs(String pdOs) {
        this.pdOs = pdOs;
    }

    /**
     * 获取：瞳距(OS)
     */
    public String getPdOs() {
        return pdOs;
    }

    /**
     * 设置：检影球镜(OD)
     */
    public void setSphJyod(String sphJyod) {
        this.sphJyod = sphJyod;
    }

    /**
     * 获取：检影球镜(OD)
     */
    public String getSphJyod() {
        return sphJyod;
    }

    /**
     * 设置：检影球镜(OS)
     */
    public void setSphJyos(String sphJyos) {
        this.sphJyos = sphJyos;
    }

    /**
     * 获取：检影球镜(OS)
     */
    public String getSphJyos() {
        return sphJyos;
    }

    /**
     * 设置：检影柱镜(OD)
     */
    public void setCylJyod(String cylJyod) {
        this.cylJyod = cylJyod;
    }

    /**
     * 获取：检影柱镜(OD)
     */
    public String getCylJyod() {
        return cylJyod;
    }

    /**
     * 设置：检影柱镜(OS)
     */
    public void setCylJyos(String cylJyos) {
        this.cylJyos = cylJyos;
    }

    /**
     * 获取：检影柱镜(OS)
     */
    public String getCylJyos() {
        return cylJyos;
    }

    /**
     * 设置：检影轴向(OD)
     */
    public void setAxialJyod(String axialJyod) {
        this.axialJyod = axialJyod;
    }

    /**
     * 获取：检影轴向(OD)
     */
    public String getAxialJyod() {
        return axialJyod;
    }

    /**
     * 设置：检影轴向(OS)
     */
    public void setAxialJyos(String axialJyos) {
        this.axialJyos = axialJyos;
    }

    /**
     * 获取：检影轴向(OS)
     */
    public String getAxialJyos() {
        return axialJyos;
    }

    /**
     * 设置：检影VA(OD)
     */
    public void setVaJyod(String vaJyod) {
        this.vaJyod = vaJyod;
    }

    /**
     * 获取：检影VA(OD)
     */
    public String getVaJyod() {
        return vaJyod;
    }

    /**
     * 设置：检影VA(OS)
     */
    public void setVaJyos(String vaJyos) {
        this.vaJyos = vaJyos;
    }

    /**
     * 获取：检影VA(OS)
     */
    public String getVaJyos() {
        return vaJyos;
    }

    /**
     * 设置：检影瞳距(mm)(OD)
     */
    public void setPdJyod(String pdJyod) {
        this.pdJyod = pdJyod;
    }

    /**
     * 获取：检影瞳距(mm)(OD)
     */
    public String getPdJyod() {
        return pdJyod;
    }

    /**
     * 设置：检影瞳距(mm)(OS)
     */
    public void setPdJyos(String pdJyos) {
        this.pdJyos = pdJyos;
    }

    /**
     * 获取：检影瞳距(mm)(OS)
     */
    public String getPdJyos() {
        return pdJyos;
    }

    /**
     * 设置：插片球镜(OD)
     */
    public void setSphCpod(String sphCpod) {
        this.sphCpod = sphCpod;
    }

    /**
     * 获取：插片球镜(OD)
     */
    public String getSphCpod() {
        return sphCpod;
    }

    /**
     * 设置：插片球镜(OS)
     */
    public void setSphCpos(String sphCpos) {
        this.sphCpos = sphCpos;
    }

    /**
     * 获取：插片球镜(OS)
     */
    public String getSphCpos() {
        return sphCpos;
    }

    /**
     * 设置：插片柱镜(OD)
     */
    public void setCylCpod(String cylCpod) {
        this.cylCpod = cylCpod;
    }

    /**
     * 获取：插片柱镜(OD)
     */
    public String getCylCpod() {
        return cylCpod;
    }

    /**
     * 设置：插片柱镜(OS)
     */
    public void setCylCpos(String cylCpos) {
        this.cylCpos = cylCpos;
    }

    /**
     * 获取：插片柱镜(OS)
     */
    public String getCylCpos() {
        return cylCpos;
    }

    /**
     * 设置：插片轴向(OD)
     */
    public void setAxialCpod(String axialCpod) {
        this.axialCpod = axialCpod;
    }

    /**
     * 获取：插片轴向(OD)
     */
    public String getAxialCpod() {
        return axialCpod;
    }

    /**
     * 设置：插片轴向(OS)
     */
    public void setAxialCpos(String axialCpos) {
        this.axialCpos = axialCpos;
    }

    /**
     * 获取：插片轴向(OS)
     */
    public String getAxialCpos() {
        return axialCpos;
    }

    /**
     * 设置：插片DVA(OD)
     */
    public void setDvaCpod(String dvaCpod) {
        this.dvaCpod = dvaCpod;
    }

    /**
     * 获取：插片DVA(OD)
     */
    public String getDvaCpod() {
        return dvaCpod;
    }

    /**
     * 设置：插片DVA(OS)
     */
    public void setDvaCpos(String dvaCpos) {
        this.dvaCpos = dvaCpos;
    }

    /**
     * 获取：插片DVA(OS)
     */
    public String getDvaCpos() {
        return dvaCpos;
    }

    /**
     * 设置：插片NVA(OD)
     */
    public void setNvaCpod(String nvaCpod) {
        this.nvaCpod = nvaCpod;
    }

    /**
     * 获取：插片NVA(OD)
     */
    public String getNvaCpod() {
        return nvaCpod;
    }

    /**
     * 设置：插片NVA(OS)
     */
    public void setNvaCpos(String nvaCpos) {
        this.nvaCpos = nvaCpos;
    }

    /**
     * 获取：插片NVA(OS)
     */
    public String getNvaCpos() {
        return nvaCpos;
    }

    /**
     * 设置：插片add(OD)
     */
    public void setAddCpod(String addCpod) {
        this.addCpod = addCpod;
    }

    /**
     * 获取：插片add(OD)
     */
    public String getAddCpod() {
        return addCpod;
    }

    /**
     * 设置：插片add(OS)
     */
    public void setAddCpos(String addCpos) {
        this.addCpos = addCpos;
    }

    /**
     * 获取：插片add(OS)
     */
    public String getAddCpos() {
        return addCpos;
    }

    /**
     * 设置：插片测量距离(OD)
     */
    public void setDistanceOd(String distanceOd) {
        this.distanceOd = distanceOd;
    }

    /**
     * 获取：插片测量距离(OD)
     */
    public String getDistanceOd() {
        return distanceOd;
    }

    /**
     * 设置：插片测量距离(OS)
     */
    public void setDistanceOs(String distanceOs) {
        this.distanceOs = distanceOs;
    }

    /**
     * 获取：插片测量距离(OS)
     */
    public String getDistanceOs() {
        return distanceOs;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
}
