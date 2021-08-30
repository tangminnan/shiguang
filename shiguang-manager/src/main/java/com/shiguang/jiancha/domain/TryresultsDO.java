package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
public class TryresultsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //试戴镜结果id
    private Long id;
    //卡号
    private String cardNumber;
    //验光号
    private String ptometryNumber;
    //验光师
    private String optometryName;
    //创建时间
    private Date createTime;
    //转诊医生
    private String referralDoctor;
    //转诊
    private String referral;
    //主诉
    private String chiefComplaint;
    //球镜(右眼OD)
    private String sphereRighttry;
    //球镜(左眼OS)
    private String sphereLefttry;
    //柱镜(右眼OD)
    private String cylinderRighttry;
    //柱镜(左眼OS)
    private String cylinderLefttry;
    //轴向(右眼-OD)
    private String axialRighttry;
    //轴向(左眼OS)
    private String axialLefttry;
    //DVA(右眼OD)
    private String dvaRighttry;
    //DVA(左眼OS)
    private String dvaLefttry;
    //NVA(OD)
    private String nvaRighttry;
    //NVA(OS)
    private String nvaLefttry;
    //三棱镜(OD)
    private String prismRighttry;
    //三棱镜(OS)
    private String prismLefttry;
    //基底(OD)
    private String jdrTry;
    //基底(OS)
    private String jdlTry;
    //瞳高(mm)(OD)
    private String heightRighttry;
    //瞳高(mm)(OS)
    private String heightLefttry;
    //Add(OD)
    private String addRighttry;
    //Add(OS)
    private String addLefttry;
    //远用瞳孔距(mm)(OD)
    private String yuanRrty;
    //远用瞳孔距(mm)(OS)
    private String yuanLrty;
    //近用瞳孔距(mm)(OD)
    private String nearRighttry;
    //近用瞳孔距(mm)(OS)
    private String nearLefttry;
    //备注
    private String remarks;
    //裸眼视力远OU
    private String farLyou;
    //裸眼视力远OD
    private String farLyod;
    //裸眼视力远OS
    private String farLyos;
    //裸眼视力近OU
    private String nearLyou;
    //裸眼视力近OD
    private String nearLyod;
    //裸眼视力近OS
    private String nearLyos;
    //原镜视力远OU
    private String farYjou;
    //原镜视力远OD
    private String farYjod;
    //原镜视力远OS
    private String farYjos;
    //原镜视力近OU
    private String nearYjou;
    //原镜视力近OD
    private String nearYjod;
    //原镜视力近OS
    private String nearYjos;
    //小孔视力远OU
    private String farXkou;
    //小孔视力远OD
    private String farXkod;
    //小孔视力远OS
    private String farXkos;
    //小孔视力近OU
    private String nearXkou;
    //小孔视力近OD
    private String nearXkod;
    //小孔视力近OS
    private String nearXkos;
    //主导眼
    private String dominantEye;
    //眼轴
    private String axis;
    //眼轴(OS)
    private String axisLeft;
    //角膜K1值(右眼)
    private String cornealFirstK1Right;
    //角膜K1值@A(右眼)
    private String cornealLastK1Right;
    //角膜K1值(左眼)
    private String cornealFirstK1Left;
    //角膜K1值@A(左眼)
    private String cornealLastK1Left;
    //角膜K2值(右眼)
    private String cornealFirstK2Right;
    //角膜K2值@A(右眼)
    private String cornealLastK2Right;
    //角膜K2值(左眼)
    private String cornealFirstK2Left;
    //角膜K2值@A(左眼)
    private String cornealLastK2Left;
    //平Kos
    private String pkod;
    //平Kos
    private String pkos;
    //平K1od
    private String pk1od;
    //平K1os
    private String pk1os;
    //陡K1
    private String dkod;
    //陡K1
    private String dkos;
    //陡K1
    private String dk1os;
    //陡K1
    private String dk1od;
    //平均k2OD
    private String pjkOd;
    //平均k2OS
    private String pjkOs;
    //平均k2OD
    private String pjkOd2;
    //平均k2OS
    private String pjkOs2;
    //眼压(OD)
    private String intraocularOd;
    //眼压(OS)
    private String intraocularOs;
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


    //球镜(右眼OD)
    private String sphereRightz;
    //球镜(左眼OS)
    private String sphereLeftz;
    //柱镜(右眼OD)
    private String cylinderRightz;
    //柱镜(左眼OS)
    private String cylinderLeftz;
    //轴向(右眼-OD)
    private String axialRightz;
    //轴向(左眼OS)
    private String axialLeftz;
    //DVA(右眼OD)
    private String dvaRightz;
    //DVA(左眼OS)
    private String dvaLeftz;
    //NVA(OD)
    private String nvaRightz;
    //NVA(OS)
    private String nvaLeftz;
    //三棱镜(OD)
    private String prismRightz;
    //三棱镜(OS)
    private String prismLeftz;
    //基底(OD)
    private String jdrZ;
    //基底(OS)
    private String jdlZ;
    //Add(OD)
    private String addRightz;
    //Add(OS)
    private String addLeftz;
    //远用瞳孔距(mm)(OD)
    private String yuanRz;
    //远用瞳孔距(mm)(OS)
    private String yuanLz;
    //近用瞳孔距(mm)(OD)
    private String nearRightz;
    //近用瞳孔距(mm)(OS)
    private String nearLeftz;
    //球镜(右眼OD)后
    private String sphereRight2;
    //球镜(左眼OS)后
    private String sphereLeft2;
    //柱镜(右眼OD)后
    private String cylinderRight2;
    //柱镜(左眼OS)后
    private String cylinderLeft2;
    //轴向(右眼-OD)后
    private String axialRight2;
    //轴向(左眼OS)后
    private String axialLeft2;

    /**
     * 设置：试戴镜结果id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：试戴镜结果id
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
     * 设置：验光号
     */
    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }

    /**
     * 获取：验光号
     */
    public String getPtometryNumber() {
        return ptometryNumber;
    }

    /**
     * 设置：验光师
     */
    public void setOptometryName(String optometryName) {
        this.optometryName = optometryName;
    }

    /**
     * 获取：验光师
     */
    public String getOptometryName() {
        return optometryName;
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

    /**
     * 设置：转诊医生
     */
    public void setReferralDoctor(String referralDoctor) {
        this.referralDoctor = referralDoctor;
    }

    /**
     * 获取：转诊医生
     */
    public String getReferralDoctor() {
        return referralDoctor;
    }

    /**
     * 设置：转诊
     */
    public void setReferral(String referral) {
        this.referral = referral;
    }

    /**
     * 获取：转诊
     */
    public String getReferral() {
        return referral;
    }

    /**
     * 设置：主诉
     */
    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    /**
     * 获取：主诉
     */
    public String getChiefComplaint() {
        return chiefComplaint;
    }

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRighttry(String sphereRighttry) {
        this.sphereRighttry = sphereRighttry;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRighttry() {
        return sphereRighttry;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLefttry(String sphereLefttry) {
        this.sphereLefttry = sphereLefttry;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLefttry() {
        return sphereLefttry;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRighttry(String cylinderRighttry) {
        this.cylinderRighttry = cylinderRighttry;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRighttry() {
        return cylinderRighttry;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLefttry(String cylinderLefttry) {
        this.cylinderLefttry = cylinderLefttry;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLefttry() {
        return cylinderLefttry;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRighttry(String axialRighttry) {
        this.axialRighttry = axialRighttry;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRighttry() {
        return axialRighttry;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLefttry(String axialLefttry) {
        this.axialLefttry = axialLefttry;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLefttry() {
        return axialLefttry;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRighttry(String dvaRighttry) {
        this.dvaRighttry = dvaRighttry;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public String getDvaRighttry() {
        return dvaRighttry;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLefttry(String dvaLefttry) {
        this.dvaLefttry = dvaLefttry;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public String getDvaLefttry() {
        return dvaLefttry;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRighttry(String nvaRighttry) {
        this.nvaRighttry = nvaRighttry;
    }

    /**
     * 获取：NVA(OD)
     */
    public String getNvaRighttry() {
        return nvaRighttry;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLefttry(String nvaLefttry) {
        this.nvaLefttry = nvaLefttry;
    }

    /**
     * 获取：NVA(OS)
     */
    public String getNvaLefttry() {
        return nvaLefttry;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRighttry(String prismRighttry) {
        this.prismRighttry = prismRighttry;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getPrismRighttry() {
        return prismRighttry;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLefttry(String prismLefttry) {
        this.prismLefttry = prismLefttry;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getPrismLefttry() {
        return prismLefttry;
    }

    /**
     * 设置：基底(OD)
     */
    public void setJdrTry(String jdrTry) {
        this.jdrTry = jdrTry;
    }

    /**
     * 获取：基底(OD)
     */
    public String getJdrTry() {
        return jdrTry;
    }

    /**
     * 设置：基底(OS)
     */
    public void setJdlTry(String jdlTry) {
        this.jdlTry = jdlTry;
    }

    /**
     * 获取：基底(OS)
     */
    public String getJdlTry() {
        return jdlTry;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setHeightRighttry(String heightRighttry) {
        this.heightRighttry = heightRighttry;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getHeightRighttry() {
        return heightRighttry;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setHeightLefttry(String heightLefttry) {
        this.heightLefttry = heightLefttry;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getHeightLefttry() {
        return heightLefttry;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRighttry(String addRighttry) {
        this.addRighttry = addRighttry;
    }

    /**
     * 获取：Add(OD)
     */
    public String getAddRighttry() {
        return addRighttry;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLefttry(String addLefttry) {
        this.addLefttry = addLefttry;
    }

    /**
     * 获取：Add(OS)
     */
    public String getAddLefttry() {
        return addLefttry;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRrty(String yuanRrty) {
        this.yuanRrty = yuanRrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public String getYuanRrty() {
        return yuanRrty;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLrty(String yuanLrty) {
        this.yuanLrty = yuanLrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public String getYuanLrty() {
        return yuanLrty;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRighttry(String nearRighttry) {
        this.nearRighttry = nearRighttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public String getNearRighttry() {
        return nearRighttry;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLefttry(String nearLefttry) {
        this.nearLefttry = nearLefttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public String getNearLefttry() {
        return nearLefttry;
    }

    /**
     * 设置：备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置：裸眼视力远OU
     */
    public void setFarLyou(String farLyou) {
        this.farLyou = farLyou;
    }

    /**
     * 获取：裸眼视力远OU
     */
    public String getFarLyou() {
        return farLyou;
    }

    /**
     * 设置：裸眼视力远OD
     */
    public void setFarLyod(String farLyod) {
        this.farLyod = farLyod;
    }

    /**
     * 获取：裸眼视力远OD
     */
    public String getFarLyod() {
        return farLyod;
    }

    /**
     * 设置：裸眼视力远OS
     */
    public void setFarLyos(String farLyos) {
        this.farLyos = farLyos;
    }

    /**
     * 获取：裸眼视力远OS
     */
    public String getFarLyos() {
        return farLyos;
    }

    /**
     * 设置：裸眼视力近OU
     */
    public void setNearLyou(String nearLyou) {
        this.nearLyou = nearLyou;
    }

    /**
     * 获取：裸眼视力近OU
     */
    public String getNearLyou() {
        return nearLyou;
    }

    /**
     * 设置：裸眼视力近OD
     */
    public void setNearLyod(String nearLyod) {
        this.nearLyod = nearLyod;
    }

    /**
     * 获取：裸眼视力近OD
     */
    public String getNearLyod() {
        return nearLyod;
    }

    /**
     * 设置：裸眼视力近OS
     */
    public void setNearLyos(String nearLyos) {
        this.nearLyos = nearLyos;
    }

    /**
     * 获取：裸眼视力近OS
     */
    public String getNearLyos() {
        return nearLyos;
    }

    /**
     * 设置：原镜视力远OU
     */
    public void setFarYjou(String farYjou) {
        this.farYjou = farYjou;
    }

    /**
     * 获取：原镜视力远OU
     */
    public String getFarYjou() {
        return farYjou;
    }

    /**
     * 设置：原镜视力远OD
     */
    public void setFarYjod(String farYjod) {
        this.farYjod = farYjod;
    }

    /**
     * 获取：原镜视力远OD
     */
    public String getFarYjod() {
        return farYjod;
    }

    /**
     * 设置：原镜视力远OS
     */
    public void setFarYjos(String farYjos) {
        this.farYjos = farYjos;
    }

    /**
     * 获取：原镜视力远OS
     */
    public String getFarYjos() {
        return farYjos;
    }

    /**
     * 设置：原镜视力近OU
     */
    public void setNearYjou(String nearYjou) {
        this.nearYjou = nearYjou;
    }

    /**
     * 获取：原镜视力近OU
     */
    public String getNearYjou() {
        return nearYjou;
    }

    /**
     * 设置：原镜视力近OD
     */
    public void setNearYjod(String nearYjod) {
        this.nearYjod = nearYjod;
    }

    /**
     * 获取：原镜视力近OD
     */
    public String getNearYjod() {
        return nearYjod;
    }

    /**
     * 设置：原镜视力近OS
     */
    public void setNearYjos(String nearYjos) {
        this.nearYjos = nearYjos;
    }

    /**
     * 获取：原镜视力近OS
     */
    public String getNearYjos() {
        return nearYjos;
    }

    /**
     * 设置：小孔视力远OU
     */
    public void setFarXkou(String farXkou) {
        this.farXkou = farXkou;
    }

    /**
     * 获取：小孔视力远OU
     */
    public String getFarXkou() {
        return farXkou;
    }

    /**
     * 设置：小孔视力远OD
     */
    public void setFarXkod(String farXkod) {
        this.farXkod = farXkod;
    }

    /**
     * 获取：小孔视力远OD
     */
    public String getFarXkod() {
        return farXkod;
    }

    /**
     * 设置：小孔视力远OS
     */
    public void setFarXkos(String farXkos) {
        this.farXkos = farXkos;
    }

    /**
     * 获取：小孔视力远OS
     */
    public String getFarXkos() {
        return farXkos;
    }

    /**
     * 设置：小孔视力近OU
     */
    public void setNearXkou(String nearXkou) {
        this.nearXkou = nearXkou;
    }

    /**
     * 获取：小孔视力近OU
     */
    public String getNearXkou() {
        return nearXkou;
    }

    /**
     * 设置：小孔视力近OD
     */
    public void setNearXkod(String nearXkod) {
        this.nearXkod = nearXkod;
    }

    /**
     * 获取：小孔视力近OD
     */
    public String getNearXkod() {
        return nearXkod;
    }

    /**
     * 设置：小孔视力近OS
     */
    public void setNearXkos(String nearXkos) {
        this.nearXkos = nearXkos;
    }

    /**
     * 获取：小孔视力近OS
     */
    public String getNearXkos() {
        return nearXkos;
    }

    /**
     * 设置：主导眼
     */
    public void setDominantEye(String dominantEye) {
        this.dominantEye = dominantEye;
    }

    /**
     * 获取：主导眼
     */
    public String getDominantEye() {
        return dominantEye;
    }

    /**
     * 设置：眼轴
     */
    public void setAxis(String axis) {
        this.axis = axis;
    }

    /**
     * 获取：眼轴
     */
    public String getAxis() {
        return axis;
    }

    /**
     * 设置：眼轴(OS)
     */
    public void setAxisLeft(String axisLeft) {
        this.axisLeft = axisLeft;
    }

    /**
     * 获取：眼轴(OS)
     */
    public String getAxisLeft() {
        return axisLeft;
    }

    /**
     * 设置：角膜K1值(右眼)
     */
    public void setCornealFirstK1Right(String cornealFirstK1Right) {
        this.cornealFirstK1Right = cornealFirstK1Right;
    }

    /**
     * 获取：角膜K1值(右眼)
     */
    public String getCornealFirstK1Right() {
        return cornealFirstK1Right;
    }

    /**
     * 设置：角膜K1值@A(右眼)
     */
    public void setCornealLastK1Right(String cornealLastK1Right) {
        this.cornealLastK1Right = cornealLastK1Right;
    }

    /**
     * 获取：角膜K1值@A(右眼)
     */
    public String getCornealLastK1Right() {
        return cornealLastK1Right;
    }

    /**
     * 设置：角膜K1值(左眼)
     */
    public void setCornealFirstK1Left(String cornealFirstK1Left) {
        this.cornealFirstK1Left = cornealFirstK1Left;
    }

    /**
     * 获取：角膜K1值(左眼)
     */
    public String getCornealFirstK1Left() {
        return cornealFirstK1Left;
    }

    /**
     * 设置：角膜K1值@A(左眼)
     */
    public void setCornealLastK1Left(String cornealLastK1Left) {
        this.cornealLastK1Left = cornealLastK1Left;
    }

    /**
     * 获取：角膜K1值@A(左眼)
     */
    public String getCornealLastK1Left() {
        return cornealLastK1Left;
    }

    /**
     * 设置：角膜K2值(右眼)
     */
    public void setCornealFirstK2Right(String cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }

    /**
     * 获取：角膜K2值(右眼)
     */
    public String getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }

    /**
     * 设置：角膜K2值@A(右眼)
     */
    public void setCornealLastK2Right(String cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }

    /**
     * 获取：角膜K2值@A(右眼)
     */
    public String getCornealLastK2Right() {
        return cornealLastK2Right;
    }

    /**
     * 设置：角膜K2值(左眼)
     */
    public void setCornealFirstK2Left(String cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }

    /**
     * 获取：角膜K2值(左眼)
     */
    public String getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }

    /**
     * 设置：角膜K2值@A(左眼)
     */
    public void setCornealLastK2Left(String cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }

    /**
     * 获取：角膜K2值@A(左眼)
     */
    public String getCornealLastK2Left() {
        return cornealLastK2Left;
    }

    /**
     * 设置：平Kos
     */
    public void setPkod(String pkod) {
        this.pkod = pkod;
    }
    /**
     * 获取：平Kos
     */
    public String getPkod() {
        return pkod;
    }
    /**
     * 设置：平Kos
     */
    public void setPkos(String pkos) {
        this.pkos = pkos;
    }
    /**
     * 获取：平Kos
     */
    public String getPkos() {
        return pkos;
    }
    /**
     * 设置：平K1od
     */
    public void setPk1od(String pk1od) {
        this.pk1od = pk1od;
    }
    /**
     * 获取：平K1od
     */
    public String getPk1od() {
        return pk1od;
    }
    /**
     * 设置：平K1os
     */
    public void setPk1os(String pk1os) {
        this.pk1os = pk1os;
    }
    /**
     * 获取：平K1os
     */
    public String getPk1os() {
        return pk1os;
    }
    /**
     * 设置：陡K1
     */
    public void setDkod(String dkod) {
        this.dkod = dkod;
    }
    /**
     * 获取：陡K1
     */
    public String getDkod() {
        return dkod;
    }
    /**
     * 设置：陡K1
     */
    public void setDkos(String dkos) {
        this.dkos = dkos;
    }
    /**
     * 获取：陡K1
     */
    public String getDkos() {
        return dkos;
    }
    /**
     * 设置：陡K1
     */
    public void setDk1os(String dk1os) {
        this.dk1os = dk1os;
    }
    /**
     * 获取：陡K1
     */
    public String getDk1os() {
        return dk1os;
    }
    /**
     * 设置：陡K1
     */
    public void setDk1od(String dk1od) {
        this.dk1od = dk1od;
    }
    /**
     * 获取：陡K1
     */
    public String getDk1od() {
        return dk1od;
    }
    /**
     * 设置：平均k2OD
     */
    public void setPjkOd(String pjkOd) {
        this.pjkOd = pjkOd;
    }
    /**
     * 获取：平均k2OD
     */
    public String getPjkOd() {
        return pjkOd;
    }
    /**
     * 设置：平均k2OS
     */
    public void setPjkOs(String pjkOs) {
        this.pjkOs = pjkOs;
    }
    /**
     * 获取：平均k2OS
     */
    public String getPjkOs() {
        return pjkOs;
    }
    /**
     * 设置：平均k2OD
     */
    public void setPjkOd2(String pjkOd2) {
        this.pjkOd2 = pjkOd2;
    }
    /**
     * 获取：平均k2OD
     */
    public String getPjkOd2() {
        return pjkOd2;
    }
    /**
     * 设置：平均k2OS
     */
    public void setPjkOs2(String pjkOs2) {
        this.pjkOs2 = pjkOs2;
    }
    /**
     * 获取：平均k2OS
     */
    public String getPjkOs2() {
        return pjkOs2;
    }
    /**
     * 设置：眼压(OD)
     */
    public void setIntraocularOd(String intraocularOd) {
        this.intraocularOd = intraocularOd;
    }

    /**
     * 获取：眼压(OD)
     */
    public String getIntraocularOd() {
        return intraocularOd;
    }

    /**
     * 设置：眼压(OS)
     */
    public void setIntraocularOs(String intraocularOs) {
        this.intraocularOs = intraocularOs;
    }

    /**
     * 获取：眼压(OS)
     */
    public String getIntraocularOs() {
        return intraocularOs;
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
     * 设置：球镜(右眼OD)
     */
    public void setSphereRightz(String sphereRightz) {
        this.sphereRightz = sphereRightz;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRightz() {
        return sphereRightz;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeftz(String sphereLeftz) {
        this.sphereLeftz = sphereLeftz;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLeftz() {
        return sphereLeftz;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRightz(String cylinderRightz) {
        this.cylinderRightz = cylinderRightz;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRightz() {
        return cylinderRightz;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeftz(String cylinderLeftz) {
        this.cylinderLeftz = cylinderLeftz;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLeftz() {
        return cylinderLeftz;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRightz(String axialRightz) {
        this.axialRightz = axialRightz;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRightz() {
        return axialRightz;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeftz(String axialLeftz) {
        this.axialLeftz = axialLeftz;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLeftz() {
        return axialLeftz;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRightz(String dvaRightz) {
        this.dvaRightz = dvaRightz;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public String getDvaRightz() {
        return dvaRightz;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLeftz(String dvaLeftz) {
        this.dvaLeftz = dvaLeftz;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public String getDvaLeftz() {
        return dvaLeftz;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRightz(String nvaRightz) {
        this.nvaRightz = nvaRightz;
    }

    /**
     * 获取：NVA(OD)
     */
    public String getNvaRightz() {
        return nvaRightz;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLeftz(String nvaLeftz) {
        this.nvaLeftz = nvaLeftz;
    }

    /**
     * 获取：NVA(OS)
     */
    public String getNvaLeftz() {
        return nvaLeftz;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRightz(String prismRightz) {
        this.prismRightz = prismRightz;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getPrismRightz() {
        return prismRightz;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLeftz(String prismLeftz) {
        this.prismLeftz = prismLeftz;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getPrismLeftz() {
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
    public void setAddRightz(String addRightz) {
        this.addRightz = addRightz;
    }

    /**
     * 获取：Add(OD)
     */
    public String getAddRightz() {
        return addRightz;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLeftz(String addLeftz) {
        this.addLeftz = addLeftz;
    }

    /**
     * 获取：Add(OS)
     */
    public String getAddLeftz() {
        return addLeftz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRz(String yuanRz) {
        this.yuanRz = yuanRz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public String getYuanRz() {
        return yuanRz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLz(String yuanLz) {
        this.yuanLz = yuanLz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public String getYuanLz() {
        return yuanLz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRightz(String nearRightz) {
        this.nearRightz = nearRightz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public String getNearRightz() {
        return nearRightz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLeftz(String nearLeftz) {
        this.nearLeftz = nearLeftz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public String getNearLeftz() {
        return nearLeftz;
    }


    //双眼视功能检查（是否）
    private String sgnSf;
    //原因
    private String sgnReason;
    //CISS得分
    private String sgnCiss;
    //WORTH 4 DOT 远
    private String sgnFardot;
    //WORTH 4 DOT 近
    private String sgnNeardot;
    //眼位远：水平1
    private String sgnFarsp1;
    //眼位远：水平下拉框2
    private String sgnFarsp2;
    //眼位远：垂直1
    private String sgnFarcz1;
    //眼位远：垂直下拉2
    private String sgnFarcz2;
    //眼位近：水平1
    private String sgnNearsp1;
    //眼位近：水平下拉框2
    private String sgnNearsp2;
    //眼位近：垂直1
    private String sgnNearcz1;
    //眼位近：垂直下拉2
    private String sgnNearcz2;
    //远距水平隐斜视1
    private String sgnVgfarsp1;
    //远距水平隐斜视2
    private String sgnVgfarsp2;
    //近距水平隐斜视1
    private String sgnVgnearsp1;
    //近距水平隐斜视2
    private String sgnVgnearsp2;
    //远距垂直隐斜视1
    private String sgnVgfarcz1;
    //远距垂直隐斜视2
    private String sgnVgfarcz2;
    //近距垂直隐斜视1
    private String sgnVgnearcz1;
    //近距垂直隐斜视2
    private String sgnVgnearcz2;
    //综合验光仪瞳距1
    private String sgnAllygytj1;
    //综合验光仪瞳距2
    private String sgnAllygytj2;
    //AC/A
    private String sgnAc;
    //梯度法/计算法
    private String sgnAcway;
    //调节反应BBC/MEM
    private String sgnTjfy;
    //调节反应OU
    private String sgnTjfyou;
    //调节反应OD
    private String sgnTjfyod;
    //调节反应OS
    private String sgnTjfyos;
    //正/负相对调节PRA
    private String sgnPra;
    //正/负相对调节NRA
    private String sgnNra;
    //遮盖单眼是否变清晰是否
    private String sgnZfsf;

    /**
     * 设置：双眼视功能检查（是否）
     */
    public void setSgnSf(String sgnSf) {
        this.sgnSf = sgnSf;
    }
    /**
     * 获取：双眼视功能检查（是否）
     */
    public String getSgnSf() {
        return sgnSf;
    }
    /**
     * 设置：原因
     */
    public void setSgnReason(String sgnReason) {
        this.sgnReason = sgnReason;
    }
    /**
     * 获取：原因
     */
    public String getSgnReason() {
        return sgnReason;
    }
    /**
     * 设置：CISS得分
     */
    public void setSgnCiss(String sgnCiss) {
        this.sgnCiss = sgnCiss;
    }
    /**
     * 获取：CISS得分
     */
    public String getSgnCiss() {
        return sgnCiss;
    }
    /**
     * 设置：WORTH 4 DOT 远
     */
    public void setSgnFardot(String sgnFardot) {
        this.sgnFardot = sgnFardot;
    }
    /**
     * 获取：WORTH 4 DOT 远
     */
    public String getSgnFardot() {
        return sgnFardot;
    }
    /**
     * 设置：WORTH 4 DOT 近
     */
    public void setSgnNeardot(String sgnNeardot) {
        this.sgnNeardot = sgnNeardot;
    }
    /**
     * 获取：WORTH 4 DOT 近
     */
    public String getSgnNeardot() {
        return sgnNeardot;
    }
    /**
     * 设置：眼位远：水平1
     */
    public void setSgnFarsp1(String sgnFarsp1) {
        this.sgnFarsp1 = sgnFarsp1;
    }
    /**
     * 获取：眼位远：水平1
     */
    public String getSgnFarsp1() {
        return sgnFarsp1;
    }
    /**
     * 设置：眼位远：水平下拉框2
     */
    public void setSgnFarsp2(String sgnFarsp2) {
        this.sgnFarsp2 = sgnFarsp2;
    }
    /**
     * 获取：眼位远：水平下拉框2
     */
    public String getSgnFarsp2() {
        return sgnFarsp2;
    }
    /**
     * 设置：眼位远：垂直1
     */
    public void setSgnFarcz1(String sgnFarcz1) {
        this.sgnFarcz1 = sgnFarcz1;
    }
    /**
     * 获取：眼位远：垂直1
     */
    public String getSgnFarcz1() {
        return sgnFarcz1;
    }
    /**
     * 设置：眼位远：垂直下拉2
     */
    public void setSgnFarcz2(String sgnFarcz2) {
        this.sgnFarcz2 = sgnFarcz2;
    }
    /**
     * 获取：眼位远：垂直下拉2
     */
    public String getSgnFarcz2() {
        return sgnFarcz2;
    }
    /**
     * 设置：眼位近：水平1
     */
    public void setSgnNearsp1(String sgnNearsp1) {
        this.sgnNearsp1 = sgnNearsp1;
    }
    /**
     * 获取：眼位近：水平1
     */
    public String getSgnNearsp1() {
        return sgnNearsp1;
    }
    /**
     * 设置：眼位近：水平下拉框2
     */
    public void setSgnNearsp2(String sgnNearsp2) {
        this.sgnNearsp2 = sgnNearsp2;
    }
    /**
     * 获取：眼位近：水平下拉框2
     */
    public String getSgnNearsp2() {
        return sgnNearsp2;
    }
    /**
     * 设置：眼位近：垂直1
     */
    public void setSgnNearcz1(String sgnNearcz1) {
        this.sgnNearcz1 = sgnNearcz1;
    }
    /**
     * 获取：眼位近：垂直1
     */
    public String getSgnNearcz1() {
        return sgnNearcz1;
    }
    /**
     * 设置：眼位近：垂直下拉2
     */
    public void setSgnNearcz2(String sgnNearcz2) {
        this.sgnNearcz2 = sgnNearcz2;
    }
    /**
     * 获取：眼位近：垂直下拉2
     */
    public String getSgnNearcz2() {
        return sgnNearcz2;
    }
    /**
     * 设置：远距水平隐斜视1
     */
    public void setSgnVgfarsp1(String sgnVgfarsp1) {
        this.sgnVgfarsp1 = sgnVgfarsp1;
    }
    /**
     * 获取：远距水平隐斜视1
     */
    public String getSgnVgfarsp1() {
        return sgnVgfarsp1;
    }
    /**
     * 设置：远距水平隐斜视2
     */
    public void setSgnVgfarsp2(String sgnVgfarsp2) {
        this.sgnVgfarsp2 = sgnVgfarsp2;
    }
    /**
     * 获取：远距水平隐斜视2
     */
    public String getSgnVgfarsp2() {
        return sgnVgfarsp2;
    }
    /**
     * 设置：近距水平隐斜视1
     */
    public void setSgnVgnearsp1(String sgnVgnearsp1) {
        this.sgnVgnearsp1 = sgnVgnearsp1;
    }
    /**
     * 获取：近距水平隐斜视1
     */
    public String getSgnVgnearsp1() {
        return sgnVgnearsp1;
    }
    /**
     * 设置：近距水平隐斜视2
     */
    public void setSgnVgnearsp2(String sgnVgnearsp2) {
        this.sgnVgnearsp2 = sgnVgnearsp2;
    }
    /**
     * 获取：近距水平隐斜视2
     */
    public String getSgnVgnearsp2() {
        return sgnVgnearsp2;
    }
    /**
     * 设置：远距垂直隐斜视1
     */
    public void setSgnVgfarcz1(String sgnVgfarcz1) {
        this.sgnVgfarcz1 = sgnVgfarcz1;
    }
    /**
     * 获取：远距垂直隐斜视1
     */
    public String getSgnVgfarcz1() {
        return sgnVgfarcz1;
    }
    /**
     * 设置：远距垂直隐斜视2
     */
    public void setSgnVgfarcz2(String sgnVgfarcz2) {
        this.sgnVgfarcz2 = sgnVgfarcz2;
    }
    /**
     * 获取：远距垂直隐斜视2
     */
    public String getSgnVgfarcz2() {
        return sgnVgfarcz2;
    }
    /**
     * 设置：近距垂直隐斜视1
     */
    public void setSgnVgnearcz1(String sgnVgnearcz1) {
        this.sgnVgnearcz1 = sgnVgnearcz1;
    }
    /**
     * 获取：近距垂直隐斜视1
     */
    public String getSgnVgnearcz1() {
        return sgnVgnearcz1;
    }
    /**
     * 设置：近距垂直隐斜视2
     */
    public void setSgnVgnearcz2(String sgnVgnearcz2) {
        this.sgnVgnearcz2 = sgnVgnearcz2;
    }
    /**
     * 获取：近距垂直隐斜视2
     */
    public String getSgnVgnearcz2() {
        return sgnVgnearcz2;
    }
    /**
     * 设置：综合验光仪瞳距1
     */
    public void setSgnAllygytj1(String sgnAllygytj1) {
        this.sgnAllygytj1 = sgnAllygytj1;
    }
    /**
     * 获取：综合验光仪瞳距1
     */
    public String getSgnAllygytj1() {
        return sgnAllygytj1;
    }
    /**
     * 设置：综合验光仪瞳距2
     */
    public void setSgnAllygytj2(String sgnAllygytj2) {
        this.sgnAllygytj2 = sgnAllygytj2;
    }
    /**
     * 获取：综合验光仪瞳距2
     */
    public String getSgnAllygytj2() {
        return sgnAllygytj2;
    }
    /**
     * 设置：AC/A
     */
    public void setSgnAc(String sgnAc) {
        this.sgnAc = sgnAc;
    }
    /**
     * 获取：AC/A
     */
    public String getSgnAc() {
        return sgnAc;
    }
    /**
     * 设置：梯度法/计算法
     */
    public void setSgnAcway(String sgnAcway) {
        this.sgnAcway = sgnAcway;
    }
    /**
     * 获取：梯度法/计算法
     */
    public String getSgnAcway() {
        return sgnAcway;
    }
    /**
     * 设置：调节反应BBC/MEM
     */
    public void setSgnTjfy(String sgnTjfy) {
        this.sgnTjfy = sgnTjfy;
    }
    /**
     * 获取：调节反应BBC/MEM
     */
    public String getSgnTjfy() {
        return sgnTjfy;
    }
    /**
     * 设置：调节反应OU
     */
    public void setSgnTjfyou(String sgnTjfyou) {
        this.sgnTjfyou = sgnTjfyou;
    }
    /**
     * 获取：调节反应OU
     */
    public String getSgnTjfyou() {
        return sgnTjfyou;
    }
    /**
     * 设置：调节反应OD
     */
    public void setSgnTjfyod(String sgnTjfyod) {
        this.sgnTjfyod = sgnTjfyod;
    }
    /**
     * 获取：调节反应OD
     */
    public String getSgnTjfyod() {
        return sgnTjfyod;
    }
    /**
     * 设置：调节反应OS
     */
    public void setSgnTjfyos(String sgnTjfyos) {
        this.sgnTjfyos = sgnTjfyos;
    }
    /**
     * 获取：调节反应OS
     */
    public String getSgnTjfyos() {
        return sgnTjfyos;
    }
    /**
     * 设置：正/负相对调节PRA
     */
    public void setSgnPra(String sgnPra) {
        this.sgnPra = sgnPra;
    }
    /**
     * 获取：正/负相对调节PRA
     */
    public String getSgnPra() {
        return sgnPra;
    }
    /**
     * 设置：正/负相对调节NRA
     */
    public void setSgnNra(String sgnNra) {
        this.sgnNra = sgnNra;
    }
    /**
     * 获取：正/负相对调节NRA
     */
    public String getSgnNra() {
        return sgnNra;
    }
    /**
     * 设置：遮盖单眼是否变清晰是否
     */
    public void setSgnZfsf(String sgnZfsf) {
        this.sgnZfsf = sgnZfsf;
    }
    /**
     * 获取：遮盖单眼是否变清晰是否
     */
    public String getSgnZfsf() {
        return sgnZfsf;
    }
    /**
     * 设置：球镜(右眼OD)后
     */
    public void setSphereRight2(String sphereRight2) {
        this.sphereRight2 = sphereRight2;
    }
    /**
     * 获取：球镜(右眼OD)后
     */
    public String getSphereRight2() {
        return sphereRight2;
    }
    /**
     * 设置：球镜(左眼OS)后
     */
    public void setSphereLeft2(String sphereLeft2) {
        this.sphereLeft2 = sphereLeft2;
    }
    /**
     * 获取：球镜(左眼OS)后
     */
    public String getSphereLeft2() {
        return sphereLeft2;
    }
    /**
     * 设置：柱镜(右眼OD)后
     */
    public void setCylinderRight2(String cylinderRight2) {
        this.cylinderRight2 = cylinderRight2;
    }
    /**
     * 获取：柱镜(右眼OD)后
     */
    public String getCylinderRight2() {
        return cylinderRight2;
    }
    /**
     * 设置：柱镜(左眼OS)后
     */
    public void setCylinderLeft2(String cylinderLeft2) {
        this.cylinderLeft2 = cylinderLeft2;
    }
    /**
     * 获取：柱镜(左眼OS)后
     */
    public String getCylinderLeft2() {
        return cylinderLeft2;
    }
    /**
     * 设置：轴向(右眼-OD)后
     */
    public void setAxialRight2(String axialRight2) {
        this.axialRight2 = axialRight2;
    }
    /**
     * 获取：轴向(右眼-OD)后
     */
    public String getAxialRight2() {
        return axialRight2;
    }
    /**
     * 设置：轴向(左眼OS)后
     */
    public void setAxialLeft2(String axialLeft2) {
        this.axialLeft2 = axialLeft2;
    }
    /**
     * 获取：轴向(左眼OS)后
     */
    public String getAxialLeft2() {
        return axialLeft2;
    }

}

