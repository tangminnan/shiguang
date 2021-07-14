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
    private Double sphereRighttry;
    //球镜(左眼OS)
    private Double sphereLefttry;
    //柱镜(右眼OD)
    private Double cylinderRighttry;
    //柱镜(左眼OS)
    private Double cylinderLefttry;
    //轴向(右眼-OD)
    private Double axialRighttry;
    //轴向(左眼OS)
    private Double axialLefttry;
    //DVA(右眼OD)
    private Double dvaRighttry;
    //DVA(左眼OS)
    private Double dvaLefttry;
    //NVA(OD)
    private Double nvaRighttry;
    //NVA(OS)
    private Double nvaLefttry;
    //三棱镜(OD)
    private Double prismRighttry;
    //三棱镜(OS)
    private Double prismLefttry;
    //基底(OD)
    private String jdrTry;
    //基底(OS)
    private String jdlTry;
    //瞳高(mm)(OD)
    private Double heightRighttry;
    //瞳高(mm)(OS)
    private Double heightLefttry;
    //Add(OD)
    private Double addRighttry;
    //Add(OS)
    private Double addLefttry;
    //远用瞳孔距(mm)(OD)
    private Double yuanRrty;
    //远用瞳孔距(mm)(OS)
    private Double yuanLrty;
    //近用瞳孔距(mm)(OD)
    private Double nearRighttry;
    //近用瞳孔距(mm)(OS)
    private Double nearLefttry;
    //备注
    private String remarks;
    //裸眼视力远OU
    private Double farLyou;
    //裸眼视力远OD
    private Double farLyod;
    //裸眼视力远OS
    private Double farLyos;
    //裸眼视力近OU
    private Double nearLyou;
    //裸眼视力近OD
    private Double nearLyod;
    //裸眼视力近OS
    private Double nearLyos;
    //原镜视力远OU
    private Double farYjou;
    //原镜视力远OD
    private Double farYjod;
    //原镜视力远OS
    private Double farYjos;
    //原镜视力近OU
    private Double nearYjou;
    //原镜视力近OD
    private Double nearYjod;
    //原镜视力近OS
    private Double nearYjos;
    //小孔视力远OU
    private Double farXkou;
    //小孔视力远OD
    private Double farXkod;
    //小孔视力远OS
    private Double farXkos;
    //小孔视力近OU
    private Double nearXkou;
    //小孔视力近OD
    private Double nearXkod;
    //小孔视力近OS
    private Double nearXkos;
    //主导眼
    private String dominantEye;
    //眼轴
    private Double axis;
    //眼轴(OS)
    private Double axisLeft;
    //角膜K1值(右眼)
    private Double cornealFirstK1Right;
    //角膜K1值@A(右眼)
    private Double cornealLastK1Right;
    //角膜K1值(左眼)
    private Double cornealFirstK1Left;
    //角膜K1值@A(左眼)
    private Double cornealLastK1Left;
    //角膜K2值(右眼)
    private Double cornealFirstK2Right;
    //角膜K2值@A(右眼)
    private Double cornealLastK2Right;
    //角膜K2值(左眼)
    private Double cornealFirstK2Left;
    //角膜K2值@A(左眼)
    private Double cornealLastK2Left;
    //平均k2OD
    private Double pjkOd2;
    //平均k2OS
    private Double pjkOs2;
    //眼压(OD)
    private Double intraocularOd;
    //眼压(OS)
    private Double intraocularOs;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
    //散瞳用药id
    private Long pharmacyId;
    //散瞳用药
    private String pharmacy;
    //球镜(右眼OD)
    private Double sphereRight;
    //球镜(左眼OS)
    private Double sphereLeft;
    //柱镜(右眼OD)
    private Double cylinderRight;
    //柱镜(左眼OS)
    private Double cylinderLeft;
    //轴向(右眼-OD)
    private Double axialRight;
    //轴向(左眼OS)
    private Double axialLeft;
    //角膜散光(OD)
    private String cornealAstigmatismOd;
    //角膜散光(OS)
    private String cornealAstigmatismOs;
    //检影球镜(OD)
    private Double sphJyod;
    //检影球镜(OS)
    private Double sphJyos;
    //检影柱镜(OD)
    private Double cylJyod;
    //检影柱镜(OS)
    private Double cylJyos;
    //检影轴向(OD)
    private Double axialJyod;
    //检影轴向(OS)
    private Double axialJyos;
    //检影VA(OD)
    private Double vaJyod;
    //检影VA(OS)
    private Double vaJyos;
    //检影瞳距(mm)(OD)
    private Double pdJyod;
    //检影瞳距(mm)(OS)
    private Double pdJyos;
    //插片球镜(OD)
    private Double sphCpod;
    //插片球镜(OS)
    private Double sphCpos;
    //插片柱镜(OD)
    private Double cylCpod;
    //插片柱镜(OS)
    private Double cylCpos;
    //插片轴向(OD)
    private Double axialCpod;
    //插片轴向(OS)
    private Double axialCpos;
    //插片DVA(OD)
    private Double dvaCpod;
    //插片DVA(OS)
    private Double dvaCpos;
    //插片NVA(OD)
    private Double nvaCpod;
    //插片NVA(OS)
    private Double nvaCpos;
    //插片add(OD)
    private Double addCpod;
    //插片add(OS)
    private Double addCpos;
    //插片测量距离(OD)
    private Double distanceOd;
    //插片测量距离(OS)
    private Double distanceOs;
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
    public void setSphereRighttry(Double sphereRighttry) {
        this.sphereRighttry = sphereRighttry;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public Double getSphereRighttry() {
        return sphereRighttry;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLefttry(Double sphereLefttry) {
        this.sphereLefttry = sphereLefttry;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public Double getSphereLefttry() {
        return sphereLefttry;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRighttry(Double cylinderRighttry) {
        this.cylinderRighttry = cylinderRighttry;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public Double getCylinderRighttry() {
        return cylinderRighttry;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLefttry(Double cylinderLefttry) {
        this.cylinderLefttry = cylinderLefttry;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public Double getCylinderLefttry() {
        return cylinderLefttry;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRighttry(Double axialRighttry) {
        this.axialRighttry = axialRighttry;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public Double getAxialRighttry() {
        return axialRighttry;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLefttry(Double axialLefttry) {
        this.axialLefttry = axialLefttry;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public Double getAxialLefttry() {
        return axialLefttry;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRighttry(Double dvaRighttry) {
        this.dvaRighttry = dvaRighttry;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public Double getDvaRighttry() {
        return dvaRighttry;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLefttry(Double dvaLefttry) {
        this.dvaLefttry = dvaLefttry;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public Double getDvaLefttry() {
        return dvaLefttry;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRighttry(Double nvaRighttry) {
        this.nvaRighttry = nvaRighttry;
    }

    /**
     * 获取：NVA(OD)
     */
    public Double getNvaRighttry() {
        return nvaRighttry;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLefttry(Double nvaLefttry) {
        this.nvaLefttry = nvaLefttry;
    }

    /**
     * 获取：NVA(OS)
     */
    public Double getNvaLefttry() {
        return nvaLefttry;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRighttry(Double prismRighttry) {
        this.prismRighttry = prismRighttry;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getPrismRighttry() {
        return prismRighttry;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLefttry(Double prismLefttry) {
        this.prismLefttry = prismLefttry;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getPrismLefttry() {
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
    public void setHeightRighttry(Double heightRighttry) {
        this.heightRighttry = heightRighttry;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getHeightRighttry() {
        return heightRighttry;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setHeightLefttry(Double heightLefttry) {
        this.heightLefttry = heightLefttry;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getHeightLefttry() {
        return heightLefttry;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRighttry(Double addRighttry) {
        this.addRighttry = addRighttry;
    }

    /**
     * 获取：Add(OD)
     */
    public Double getAddRighttry() {
        return addRighttry;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLefttry(Double addLefttry) {
        this.addLefttry = addLefttry;
    }

    /**
     * 获取：Add(OS)
     */
    public Double getAddLefttry() {
        return addLefttry;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRrty(Double yuanRrty) {
        this.yuanRrty = yuanRrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public Double getYuanRrty() {
        return yuanRrty;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLrty(Double yuanLrty) {
        this.yuanLrty = yuanLrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public Double getYuanLrty() {
        return yuanLrty;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRighttry(Double nearRighttry) {
        this.nearRighttry = nearRighttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public Double getNearRighttry() {
        return nearRighttry;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLefttry(Double nearLefttry) {
        this.nearLefttry = nearLefttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public Double getNearLefttry() {
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
    public void setFarLyou(Double farLyou) {
        this.farLyou = farLyou;
    }

    /**
     * 获取：裸眼视力远OU
     */
    public Double getFarLyou() {
        return farLyou;
    }

    /**
     * 设置：裸眼视力远OD
     */
    public void setFarLyod(Double farLyod) {
        this.farLyod = farLyod;
    }

    /**
     * 获取：裸眼视力远OD
     */
    public Double getFarLyod() {
        return farLyod;
    }

    /**
     * 设置：裸眼视力远OS
     */
    public void setFarLyos(Double farLyos) {
        this.farLyos = farLyos;
    }

    /**
     * 获取：裸眼视力远OS
     */
    public Double getFarLyos() {
        return farLyos;
    }

    /**
     * 设置：裸眼视力近OU
     */
    public void setNearLyou(Double nearLyou) {
        this.nearLyou = nearLyou;
    }

    /**
     * 获取：裸眼视力近OU
     */
    public Double getNearLyou() {
        return nearLyou;
    }

    /**
     * 设置：裸眼视力近OD
     */
    public void setNearLyod(Double nearLyod) {
        this.nearLyod = nearLyod;
    }

    /**
     * 获取：裸眼视力近OD
     */
    public Double getNearLyod() {
        return nearLyod;
    }

    /**
     * 设置：裸眼视力近OS
     */
    public void setNearLyos(Double nearLyos) {
        this.nearLyos = nearLyos;
    }

    /**
     * 获取：裸眼视力近OS
     */
    public Double getNearLyos() {
        return nearLyos;
    }

    /**
     * 设置：原镜视力远OU
     */
    public void setFarYjou(Double farYjou) {
        this.farYjou = farYjou;
    }

    /**
     * 获取：原镜视力远OU
     */
    public Double getFarYjou() {
        return farYjou;
    }

    /**
     * 设置：原镜视力远OD
     */
    public void setFarYjod(Double farYjod) {
        this.farYjod = farYjod;
    }

    /**
     * 获取：原镜视力远OD
     */
    public Double getFarYjod() {
        return farYjod;
    }

    /**
     * 设置：原镜视力远OS
     */
    public void setFarYjos(Double farYjos) {
        this.farYjos = farYjos;
    }

    /**
     * 获取：原镜视力远OS
     */
    public Double getFarYjos() {
        return farYjos;
    }

    /**
     * 设置：原镜视力近OU
     */
    public void setNearYjou(Double nearYjou) {
        this.nearYjou = nearYjou;
    }

    /**
     * 获取：原镜视力近OU
     */
    public Double getNearYjou() {
        return nearYjou;
    }

    /**
     * 设置：原镜视力近OD
     */
    public void setNearYjod(Double nearYjod) {
        this.nearYjod = nearYjod;
    }

    /**
     * 获取：原镜视力近OD
     */
    public Double getNearYjod() {
        return nearYjod;
    }

    /**
     * 设置：原镜视力近OS
     */
    public void setNearYjos(Double nearYjos) {
        this.nearYjos = nearYjos;
    }

    /**
     * 获取：原镜视力近OS
     */
    public Double getNearYjos() {
        return nearYjos;
    }

    /**
     * 设置：小孔视力远OU
     */
    public void setFarXkou(Double farXkou) {
        this.farXkou = farXkou;
    }

    /**
     * 获取：小孔视力远OU
     */
    public Double getFarXkou() {
        return farXkou;
    }

    /**
     * 设置：小孔视力远OD
     */
    public void setFarXkod(Double farXkod) {
        this.farXkod = farXkod;
    }

    /**
     * 获取：小孔视力远OD
     */
    public Double getFarXkod() {
        return farXkod;
    }

    /**
     * 设置：小孔视力远OS
     */
    public void setFarXkos(Double farXkos) {
        this.farXkos = farXkos;
    }

    /**
     * 获取：小孔视力远OS
     */
    public Double getFarXkos() {
        return farXkos;
    }

    /**
     * 设置：小孔视力近OU
     */
    public void setNearXkou(Double nearXkou) {
        this.nearXkou = nearXkou;
    }

    /**
     * 获取：小孔视力近OU
     */
    public Double getNearXkou() {
        return nearXkou;
    }

    /**
     * 设置：小孔视力近OD
     */
    public void setNearXkod(Double nearXkod) {
        this.nearXkod = nearXkod;
    }

    /**
     * 获取：小孔视力近OD
     */
    public Double getNearXkod() {
        return nearXkod;
    }

    /**
     * 设置：小孔视力近OS
     */
    public void setNearXkos(Double nearXkos) {
        this.nearXkos = nearXkos;
    }

    /**
     * 获取：小孔视力近OS
     */
    public Double getNearXkos() {
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
    public void setAxis(Double axis) {
        this.axis = axis;
    }

    /**
     * 获取：眼轴
     */
    public Double getAxis() {
        return axis;
    }

    /**
     * 设置：眼轴(OS)
     */
    public void setAxisLeft(Double axisLeft) {
        this.axisLeft = axisLeft;
    }

    /**
     * 获取：眼轴(OS)
     */
    public Double getAxisLeft() {
        return axisLeft;
    }

    /**
     * 设置：角膜K1值(右眼)
     */
    public void setCornealFirstK1Right(Double cornealFirstK1Right) {
        this.cornealFirstK1Right = cornealFirstK1Right;
    }

    /**
     * 获取：角膜K1值(右眼)
     */
    public Double getCornealFirstK1Right() {
        return cornealFirstK1Right;
    }

    /**
     * 设置：角膜K1值@A(右眼)
     */
    public void setCornealLastK1Right(Double cornealLastK1Right) {
        this.cornealLastK1Right = cornealLastK1Right;
    }

    /**
     * 获取：角膜K1值@A(右眼)
     */
    public Double getCornealLastK1Right() {
        return cornealLastK1Right;
    }

    /**
     * 设置：角膜K1值(左眼)
     */
    public void setCornealFirstK1Left(Double cornealFirstK1Left) {
        this.cornealFirstK1Left = cornealFirstK1Left;
    }

    /**
     * 获取：角膜K1值(左眼)
     */
    public Double getCornealFirstK1Left() {
        return cornealFirstK1Left;
    }

    /**
     * 设置：角膜K1值@A(左眼)
     */
    public void setCornealLastK1Left(Double cornealLastK1Left) {
        this.cornealLastK1Left = cornealLastK1Left;
    }

    /**
     * 获取：角膜K1值@A(左眼)
     */
    public Double getCornealLastK1Left() {
        return cornealLastK1Left;
    }

    /**
     * 设置：角膜K2值(右眼)
     */
    public void setCornealFirstK2Right(Double cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }

    /**
     * 获取：角膜K2值(右眼)
     */
    public Double getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }

    /**
     * 设置：角膜K2值@A(右眼)
     */
    public void setCornealLastK2Right(Double cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }

    /**
     * 获取：角膜K2值@A(右眼)
     */
    public Double getCornealLastK2Right() {
        return cornealLastK2Right;
    }

    /**
     * 设置：角膜K2值(左眼)
     */
    public void setCornealFirstK2Left(Double cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }

    /**
     * 获取：角膜K2值(左眼)
     */
    public Double getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }

    /**
     * 设置：角膜K2值@A(左眼)
     */
    public void setCornealLastK2Left(Double cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }

    /**
     * 获取：角膜K2值@A(左眼)
     */
    public Double getCornealLastK2Left() {
        return cornealLastK2Left;
    }

    /**
     * 设置：平均k2OD
     */
    public void setPjkOd2(Double pjkOd2) {
        this.pjkOd2 = pjkOd2;
    }

    /**
     * 获取：平均k2OD
     */
    public Double getPjkOd2() {
        return pjkOd2;
    }

    /**
     * 设置：平均k2OS
     */
    public void setPjkOs2(Double pjkOs2) {
        this.pjkOs2 = pjkOs2;
    }

    /**
     * 获取：平均k2OS
     */
    public Double getPjkOs2() {
        return pjkOs2;
    }

    /**
     * 设置：眼压(OD)
     */
    public void setIntraocularOd(Double intraocularOd) {
        this.intraocularOd = intraocularOd;
    }

    /**
     * 获取：眼压(OD)
     */
    public Double getIntraocularOd() {
        return intraocularOd;
    }

    /**
     * 设置：眼压(OS)
     */
    public void setIntraocularOs(Double intraocularOs) {
        this.intraocularOs = intraocularOs;
    }

    /**
     * 获取：眼压(OS)
     */
    public Double getIntraocularOs() {
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
    public void setSphereRight(Double sphereRight) {
        this.sphereRight = sphereRight;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public Double getSphereRight() {
        return sphereRight;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeft(Double sphereLeft) {
        this.sphereLeft = sphereLeft;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public Double getSphereLeft() {
        return sphereLeft;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRight(Double cylinderRight) {
        this.cylinderRight = cylinderRight;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public Double getCylinderRight() {
        return cylinderRight;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeft(Double cylinderLeft) {
        this.cylinderLeft = cylinderLeft;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public Double getCylinderLeft() {
        return cylinderLeft;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRight(Double axialRight) {
        this.axialRight = axialRight;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public Double getAxialRight() {
        return axialRight;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeft(Double axialLeft) {
        this.axialLeft = axialLeft;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public Double getAxialLeft() {
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
    public void setSphJyod(Double sphJyod) {
        this.sphJyod = sphJyod;
    }

    /**
     * 获取：检影球镜(OD)
     */
    public Double getSphJyod() {
        return sphJyod;
    }

    /**
     * 设置：检影球镜(OS)
     */
    public void setSphJyos(Double sphJyos) {
        this.sphJyos = sphJyos;
    }

    /**
     * 获取：检影球镜(OS)
     */
    public Double getSphJyos() {
        return sphJyos;
    }

    /**
     * 设置：检影柱镜(OD)
     */
    public void setCylJyod(Double cylJyod) {
        this.cylJyod = cylJyod;
    }

    /**
     * 获取：检影柱镜(OD)
     */
    public Double getCylJyod() {
        return cylJyod;
    }

    /**
     * 设置：检影柱镜(OS)
     */
    public void setCylJyos(Double cylJyos) {
        this.cylJyos = cylJyos;
    }

    /**
     * 获取：检影柱镜(OS)
     */
    public Double getCylJyos() {
        return cylJyos;
    }

    /**
     * 设置：检影轴向(OD)
     */
    public void setAxialJyod(Double axialJyod) {
        this.axialJyod = axialJyod;
    }

    /**
     * 获取：检影轴向(OD)
     */
    public Double getAxialJyod() {
        return axialJyod;
    }

    /**
     * 设置：检影轴向(OS)
     */
    public void setAxialJyos(Double axialJyos) {
        this.axialJyos = axialJyos;
    }

    /**
     * 获取：检影轴向(OS)
     */
    public Double getAxialJyos() {
        return axialJyos;
    }

    /**
     * 设置：检影VA(OD)
     */
    public void setVaJyod(Double vaJyod) {
        this.vaJyod = vaJyod;
    }

    /**
     * 获取：检影VA(OD)
     */
    public Double getVaJyod() {
        return vaJyod;
    }

    /**
     * 设置：检影VA(OS)
     */
    public void setVaJyos(Double vaJyos) {
        this.vaJyos = vaJyos;
    }

    /**
     * 获取：检影VA(OS)
     */
    public Double getVaJyos() {
        return vaJyos;
    }

    /**
     * 设置：检影瞳距(mm)(OD)
     */
    public void setPdJyod(Double pdJyod) {
        this.pdJyod = pdJyod;
    }

    /**
     * 获取：检影瞳距(mm)(OD)
     */
    public Double getPdJyod() {
        return pdJyod;
    }

    /**
     * 设置：检影瞳距(mm)(OS)
     */
    public void setPdJyos(Double pdJyos) {
        this.pdJyos = pdJyos;
    }

    /**
     * 获取：检影瞳距(mm)(OS)
     */
    public Double getPdJyos() {
        return pdJyos;
    }

    /**
     * 设置：插片球镜(OD)
     */
    public void setSphCpod(Double sphCpod) {
        this.sphCpod = sphCpod;
    }

    /**
     * 获取：插片球镜(OD)
     */
    public Double getSphCpod() {
        return sphCpod;
    }

    /**
     * 设置：插片球镜(OS)
     */
    public void setSphCpos(Double sphCpos) {
        this.sphCpos = sphCpos;
    }

    /**
     * 获取：插片球镜(OS)
     */
    public Double getSphCpos() {
        return sphCpos;
    }

    /**
     * 设置：插片柱镜(OD)
     */
    public void setCylCpod(Double cylCpod) {
        this.cylCpod = cylCpod;
    }

    /**
     * 获取：插片柱镜(OD)
     */
    public Double getCylCpod() {
        return cylCpod;
    }

    /**
     * 设置：插片柱镜(OS)
     */
    public void setCylCpos(Double cylCpos) {
        this.cylCpos = cylCpos;
    }

    /**
     * 获取：插片柱镜(OS)
     */
    public Double getCylCpos() {
        return cylCpos;
    }

    /**
     * 设置：插片轴向(OD)
     */
    public void setAxialCpod(Double axialCpod) {
        this.axialCpod = axialCpod;
    }

    /**
     * 获取：插片轴向(OD)
     */
    public Double getAxialCpod() {
        return axialCpod;
    }

    /**
     * 设置：插片轴向(OS)
     */
    public void setAxialCpos(Double axialCpos) {
        this.axialCpos = axialCpos;
    }

    /**
     * 获取：插片轴向(OS)
     */
    public Double getAxialCpos() {
        return axialCpos;
    }

    /**
     * 设置：插片DVA(OD)
     */
    public void setDvaCpod(Double dvaCpod) {
        this.dvaCpod = dvaCpod;
    }

    /**
     * 获取：插片DVA(OD)
     */
    public Double getDvaCpod() {
        return dvaCpod;
    }

    /**
     * 设置：插片DVA(OS)
     */
    public void setDvaCpos(Double dvaCpos) {
        this.dvaCpos = dvaCpos;
    }

    /**
     * 获取：插片DVA(OS)
     */
    public Double getDvaCpos() {
        return dvaCpos;
    }

    /**
     * 设置：插片NVA(OD)
     */
    public void setNvaCpod(Double nvaCpod) {
        this.nvaCpod = nvaCpod;
    }

    /**
     * 获取：插片NVA(OD)
     */
    public Double getNvaCpod() {
        return nvaCpod;
    }

    /**
     * 设置：插片NVA(OS)
     */
    public void setNvaCpos(Double nvaCpos) {
        this.nvaCpos = nvaCpos;
    }

    /**
     * 获取：插片NVA(OS)
     */
    public Double getNvaCpos() {
        return nvaCpos;
    }

    /**
     * 设置：插片add(OD)
     */
    public void setAddCpod(Double addCpod) {
        this.addCpod = addCpod;
    }

    /**
     * 获取：插片add(OD)
     */
    public Double getAddCpod() {
        return addCpod;
    }

    /**
     * 设置：插片add(OS)
     */
    public void setAddCpos(Double addCpos) {
        this.addCpos = addCpos;
    }

    /**
     * 获取：插片add(OS)
     */
    public Double getAddCpos() {
        return addCpos;
    }

    /**
     * 设置：插片测量距离(OD)
     */
    public void setDistanceOd(Double distanceOd) {
        this.distanceOd = distanceOd;
    }

    /**
     * 获取：插片测量距离(OD)
     */
    public Double getDistanceOd() {
        return distanceOd;
    }

    /**
     * 设置：插片测量距离(OS)
     */
    public void setDistanceOs(Double distanceOs) {
        this.distanceOs = distanceOs;
    }

    /**
     * 获取：插片测量距离(OS)
     */
    public Double getDistanceOs() {
        return distanceOs;
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
