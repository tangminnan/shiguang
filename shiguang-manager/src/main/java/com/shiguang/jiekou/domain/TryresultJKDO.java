package com.shiguang.jiekou.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
public class TryresultJKDO implements Serializable {
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
    //转诊
    private String referral;
    //主诉
    private String chiefComplaint;
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
    //双眼视功能检查（1是,2否）
    private String sgnSf;
    //原因
    private String sgnReason;
    //CISS得分
    private String sgnCiss;
    //WORTH 4 DOT 远
    private String sgnFardot;
    //WORTH 4 DOT 近
    private String sgnNeardot;
    //立体式
    private String litishi;
    //AC/A
    private String sgnAc;
    //1梯度法/2计算法
    private String sgnAcway;
    //正/负相对调节PRA
    private String sgnPra;
    //正/负相对调节NRA
    private String sgnNra;
    //调节反应1BBC/2MEM
    private String sgnTjfy;
    //调节反应OU
    private String sgnTjfyou;
    //调节反应OD
    private String sgnTjfyod;
    //调节反应OS
    private String sgnTjfyos;
    //遮盖单眼是否变清晰1是2否
    private String sgnZfsf;
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
    //眼压(OD)
    private String intraocularOd;
    //眼压(OS)
    private String intraocularOs;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
    //散瞳用药id
    private Long pharmacyId;
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
    //平Kod
    private String pkod;
    //平Kos
    private String pkos;
    //平K1od
    private String pk1od;
    //平K1os
    private String pk1os;
    //陡K1od
    private String dkod;
    //陡K1os
    private String dkos;
    //陡K1os
    private String dk1os;
    //陡K1od
    private String dk1od;
    //平均k2OD
    private String pjkOd;
    //平均k2OS
    private String pjkOs;
    //平均k2OD
    private String pjkOd2;
    //平均k2OS
    private String pjkOs2;
    //角膜散光(OD)
    private String cornealAstigmatismOd;
    //角膜散光(OS)
    private String cornealAstigmatismOs;
    //    测量瞳距od
    private String  tjod;
    //    测量瞳距os
    private String  tjos;
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
    //删除状态
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPtometryNumber() {
        return ptometryNumber;
    }

    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }

    public String getOptometryName() {
        return optometryName;
    }

    public void setOptometryName(String optometryName) {
        this.optometryName = optometryName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getFarLyou() {
        return farLyou;
    }

    public void setFarLyou(String farLyou) {
        this.farLyou = farLyou;
    }

    public String getFarLyod() {
        return farLyod;
    }

    public void setFarLyod(String farLyod) {
        this.farLyod = farLyod;
    }

    public String getFarLyos() {
        return farLyos;
    }

    public void setFarLyos(String farLyos) {
        this.farLyos = farLyos;
    }

    public String getNearLyou() {
        return nearLyou;
    }

    public void setNearLyou(String nearLyou) {
        this.nearLyou = nearLyou;
    }

    public String getNearLyod() {
        return nearLyod;
    }

    public void setNearLyod(String nearLyod) {
        this.nearLyod = nearLyod;
    }

    public String getNearLyos() {
        return nearLyos;
    }

    public void setNearLyos(String nearLyos) {
        this.nearLyos = nearLyos;
    }

    public String getFarYjou() {
        return farYjou;
    }

    public void setFarYjou(String farYjou) {
        this.farYjou = farYjou;
    }

    public String getFarYjod() {
        return farYjod;
    }

    public void setFarYjod(String farYjod) {
        this.farYjod = farYjod;
    }

    public String getFarYjos() {
        return farYjos;
    }

    public void setFarYjos(String farYjos) {
        this.farYjos = farYjos;
    }

    public String getNearYjou() {
        return nearYjou;
    }

    public void setNearYjou(String nearYjou) {
        this.nearYjou = nearYjou;
    }

    public String getNearYjod() {
        return nearYjod;
    }

    public void setNearYjod(String nearYjod) {
        this.nearYjod = nearYjod;
    }

    public String getNearYjos() {
        return nearYjos;
    }

    public void setNearYjos(String nearYjos) {
        this.nearYjos = nearYjos;
    }

    public String getFarXkou() {
        return farXkou;
    }

    public void setFarXkou(String farXkou) {
        this.farXkou = farXkou;
    }

    public String getFarXkod() {
        return farXkod;
    }

    public void setFarXkod(String farXkod) {
        this.farXkod = farXkod;
    }

    public String getFarXkos() {
        return farXkos;
    }

    public void setFarXkos(String farXkos) {
        this.farXkos = farXkos;
    }

    public String getNearXkou() {
        return nearXkou;
    }

    public void setNearXkou(String nearXkou) {
        this.nearXkou = nearXkou;
    }

    public String getNearXkod() {
        return nearXkod;
    }

    public void setNearXkod(String nearXkod) {
        this.nearXkod = nearXkod;
    }

    public String getNearXkos() {
        return nearXkos;
    }

    public void setNearXkos(String nearXkos) {
        this.nearXkos = nearXkos;
    }

    public String getDominantEye() {
        return dominantEye;
    }

    public void setDominantEye(String dominantEye) {
        this.dominantEye = dominantEye;
    }

    public String getSgnSf() {
        return sgnSf;
    }

    public void setSgnSf(String sgnSf) {
        this.sgnSf = sgnSf;
    }

    public String getSgnReason() {
        return sgnReason;
    }

    public void setSgnReason(String sgnReason) {
        this.sgnReason = sgnReason;
    }

    public String getSgnCiss() {
        return sgnCiss;
    }

    public void setSgnCiss(String sgnCiss) {
        this.sgnCiss = sgnCiss;
    }

    public String getSgnFardot() {
        return sgnFardot;
    }

    public void setSgnFardot(String sgnFardot) {
        this.sgnFardot = sgnFardot;
    }

    public String getSgnNeardot() {
        return sgnNeardot;
    }

    public void setSgnNeardot(String sgnNeardot) {
        this.sgnNeardot = sgnNeardot;
    }

    public String getLitishi() {
        return litishi;
    }

    public void setLitishi(String litishi) {
        this.litishi = litishi;
    }

    public String getSgnAc() {
        return sgnAc;
    }

    public void setSgnAc(String sgnAc) {
        this.sgnAc = sgnAc;
    }

    public String getSgnAcway() {
        return sgnAcway;
    }

    public void setSgnAcway(String sgnAcway) {
        this.sgnAcway = sgnAcway;
    }

    public String getSgnPra() {
        return sgnPra;
    }

    public void setSgnPra(String sgnPra) {
        this.sgnPra = sgnPra;
    }

    public String getSgnNra() {
        return sgnNra;
    }

    public void setSgnNra(String sgnNra) {
        this.sgnNra = sgnNra;
    }

    public String getSgnTjfy() {
        return sgnTjfy;
    }

    public void setSgnTjfy(String sgnTjfy) {
        this.sgnTjfy = sgnTjfy;
    }

    public String getSgnTjfyou() {
        return sgnTjfyou;
    }

    public void setSgnTjfyou(String sgnTjfyou) {
        this.sgnTjfyou = sgnTjfyou;
    }

    public String getSgnTjfyod() {
        return sgnTjfyod;
    }

    public void setSgnTjfyod(String sgnTjfyod) {
        this.sgnTjfyod = sgnTjfyod;
    }

    public String getSgnTjfyos() {
        return sgnTjfyos;
    }

    public void setSgnTjfyos(String sgnTjfyos) {
        this.sgnTjfyos = sgnTjfyos;
    }

    public String getSgnZfsf() {
        return sgnZfsf;
    }

    public void setSgnZfsf(String sgnZfsf) {
        this.sgnZfsf = sgnZfsf;
    }

    public String getSgnFarsp1() {
        return sgnFarsp1;
    }

    public void setSgnFarsp1(String sgnFarsp1) {
        this.sgnFarsp1 = sgnFarsp1;
    }

    public String getSgnFarsp2() {
        return sgnFarsp2;
    }

    public void setSgnFarsp2(String sgnFarsp2) {
        this.sgnFarsp2 = sgnFarsp2;
    }

    public String getSgnFarcz1() {
        return sgnFarcz1;
    }

    public void setSgnFarcz1(String sgnFarcz1) {
        this.sgnFarcz1 = sgnFarcz1;
    }

    public String getSgnFarcz2() {
        return sgnFarcz2;
    }

    public void setSgnFarcz2(String sgnFarcz2) {
        this.sgnFarcz2 = sgnFarcz2;
    }

    public String getSgnNearsp1() {
        return sgnNearsp1;
    }

    public void setSgnNearsp1(String sgnNearsp1) {
        this.sgnNearsp1 = sgnNearsp1;
    }

    public String getSgnNearsp2() {
        return sgnNearsp2;
    }

    public void setSgnNearsp2(String sgnNearsp2) {
        this.sgnNearsp2 = sgnNearsp2;
    }

    public String getSgnNearcz1() {
        return sgnNearcz1;
    }

    public void setSgnNearcz1(String sgnNearcz1) {
        this.sgnNearcz1 = sgnNearcz1;
    }

    public String getSgnNearcz2() {
        return sgnNearcz2;
    }

    public void setSgnNearcz2(String sgnNearcz2) {
        this.sgnNearcz2 = sgnNearcz2;
    }

    public String getSgnVgfarsp1() {
        return sgnVgfarsp1;
    }

    public void setSgnVgfarsp1(String sgnVgfarsp1) {
        this.sgnVgfarsp1 = sgnVgfarsp1;
    }

    public String getSgnVgfarsp2() {
        return sgnVgfarsp2;
    }

    public void setSgnVgfarsp2(String sgnVgfarsp2) {
        this.sgnVgfarsp2 = sgnVgfarsp2;
    }

    public String getSgnVgnearsp1() {
        return sgnVgnearsp1;
    }

    public void setSgnVgnearsp1(String sgnVgnearsp1) {
        this.sgnVgnearsp1 = sgnVgnearsp1;
    }

    public String getSgnVgnearsp2() {
        return sgnVgnearsp2;
    }

    public void setSgnVgnearsp2(String sgnVgnearsp2) {
        this.sgnVgnearsp2 = sgnVgnearsp2;
    }

    public String getSgnVgfarcz1() {
        return sgnVgfarcz1;
    }

    public void setSgnVgfarcz1(String sgnVgfarcz1) {
        this.sgnVgfarcz1 = sgnVgfarcz1;
    }

    public String getSgnVgfarcz2() {
        return sgnVgfarcz2;
    }

    public void setSgnVgfarcz2(String sgnVgfarcz2) {
        this.sgnVgfarcz2 = sgnVgfarcz2;
    }

    public String getSgnVgnearcz1() {
        return sgnVgnearcz1;
    }

    public void setSgnVgnearcz1(String sgnVgnearcz1) {
        this.sgnVgnearcz1 = sgnVgnearcz1;
    }

    public String getSgnVgnearcz2() {
        return sgnVgnearcz2;
    }

    public void setSgnVgnearcz2(String sgnVgnearcz2) {
        this.sgnVgnearcz2 = sgnVgnearcz2;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public String getAxisLeft() {
        return axisLeft;
    }

    public void setAxisLeft(String axisLeft) {
        this.axisLeft = axisLeft;
    }

    public String getCornealFirstK1Right() {
        return cornealFirstK1Right;
    }

    public void setCornealFirstK1Right(String cornealFirstK1Right) {
        this.cornealFirstK1Right = cornealFirstK1Right;
    }

    public String getCornealLastK1Right() {
        return cornealLastK1Right;
    }

    public void setCornealLastK1Right(String cornealLastK1Right) {
        this.cornealLastK1Right = cornealLastK1Right;
    }

    public String getCornealFirstK1Left() {
        return cornealFirstK1Left;
    }

    public void setCornealFirstK1Left(String cornealFirstK1Left) {
        this.cornealFirstK1Left = cornealFirstK1Left;
    }

    public String getCornealLastK1Left() {
        return cornealLastK1Left;
    }

    public void setCornealLastK1Left(String cornealLastK1Left) {
        this.cornealLastK1Left = cornealLastK1Left;
    }

    public String getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }

    public void setCornealFirstK2Right(String cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }

    public String getCornealLastK2Right() {
        return cornealLastK2Right;
    }

    public void setCornealLastK2Right(String cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }

    public String getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }

    public void setCornealFirstK2Left(String cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }

    public String getCornealLastK2Left() {
        return cornealLastK2Left;
    }

    public void setCornealLastK2Left(String cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }

    public String getIntraocularOd() {
        return intraocularOd;
    }

    public void setIntraocularOd(String intraocularOd) {
        this.intraocularOd = intraocularOd;
    }

    public String getIntraocularOs() {
        return intraocularOs;
    }

    public void setIntraocularOs(String intraocularOs) {
        this.intraocularOs = intraocularOs;
    }

    public Long getMydriasis() {
        return mydriasis;
    }

    public void setMydriasis(Long mydriasis) {
        this.mydriasis = mydriasis;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getSphereRight() {
        return sphereRight;
    }

    public void setSphereRight(String sphereRight) {
        this.sphereRight = sphereRight;
    }

    public String getSphereLeft() {
        return sphereLeft;
    }

    public void setSphereLeft(String sphereLeft) {
        this.sphereLeft = sphereLeft;
    }

    public String getCylinderRight() {
        return cylinderRight;
    }

    public void setCylinderRight(String cylinderRight) {
        this.cylinderRight = cylinderRight;
    }

    public String getCylinderLeft() {
        return cylinderLeft;
    }

    public void setCylinderLeft(String cylinderLeft) {
        this.cylinderLeft = cylinderLeft;
    }

    public String getAxialRight() {
        return axialRight;
    }

    public void setAxialRight(String axialRight) {
        this.axialRight = axialRight;
    }

    public String getAxialLeft() {
        return axialLeft;
    }

    public void setAxialLeft(String axialLeft) {
        this.axialLeft = axialLeft;
    }

    public String getSphereRight2() {
        return sphereRight2;
    }

    public void setSphereRight2(String sphereRight2) {
        this.sphereRight2 = sphereRight2;
    }

    public String getSphereLeft2() {
        return sphereLeft2;
    }

    public void setSphereLeft2(String sphereLeft2) {
        this.sphereLeft2 = sphereLeft2;
    }

    public String getCylinderRight2() {
        return cylinderRight2;
    }

    public void setCylinderRight2(String cylinderRight2) {
        this.cylinderRight2 = cylinderRight2;
    }

    public String getCylinderLeft2() {
        return cylinderLeft2;
    }

    public void setCylinderLeft2(String cylinderLeft2) {
        this.cylinderLeft2 = cylinderLeft2;
    }

    public String getAxialRight2() {
        return axialRight2;
    }

    public void setAxialRight2(String axialRight2) {
        this.axialRight2 = axialRight2;
    }

    public String getAxialLeft2() {
        return axialLeft2;
    }

    public void setAxialLeft2(String axialLeft2) {
        this.axialLeft2 = axialLeft2;
    }

    public String getPkod() {
        return pkod;
    }

    public void setPkod(String pkod) {
        this.pkod = pkod;
    }

    public String getPkos() {
        return pkos;
    }

    public void setPkos(String pkos) {
        this.pkos = pkos;
    }

    public String getPk1od() {
        return pk1od;
    }

    public void setPk1od(String pk1od) {
        this.pk1od = pk1od;
    }

    public String getPk1os() {
        return pk1os;
    }

    public void setPk1os(String pk1os) {
        this.pk1os = pk1os;
    }

    public String getDkod() {
        return dkod;
    }

    public void setDkod(String dkod) {
        this.dkod = dkod;
    }

    public String getDkos() {
        return dkos;
    }

    public void setDkos(String dkos) {
        this.dkos = dkos;
    }

    public String getDk1os() {
        return dk1os;
    }

    public void setDk1os(String dk1os) {
        this.dk1os = dk1os;
    }

    public String getDk1od() {
        return dk1od;
    }

    public void setDk1od(String dk1od) {
        this.dk1od = dk1od;
    }

    public String getPjkOd() {
        return pjkOd;
    }

    public void setPjkOd(String pjkOd) {
        this.pjkOd = pjkOd;
    }

    public String getPjkOs() {
        return pjkOs;
    }

    public void setPjkOs(String pjkOs) {
        this.pjkOs = pjkOs;
    }

    public String getPjkOd2() {
        return pjkOd2;
    }

    public void setPjkOd2(String pjkOd2) {
        this.pjkOd2 = pjkOd2;
    }

    public String getPjkOs2() {
        return pjkOs2;
    }

    public void setPjkOs2(String pjkOs2) {
        this.pjkOs2 = pjkOs2;
    }

    public String getCornealAstigmatismOd() {
        return cornealAstigmatismOd;
    }

    public void setCornealAstigmatismOd(String cornealAstigmatismOd) {
        this.cornealAstigmatismOd = cornealAstigmatismOd;
    }

    public String getCornealAstigmatismOs() {
        return cornealAstigmatismOs;
    }

    public void setCornealAstigmatismOs(String cornealAstigmatismOs) {
        this.cornealAstigmatismOs = cornealAstigmatismOs;
    }

    public String getTjod() {
        return tjod;
    }

    public void setTjod(String tjod) {
        this.tjod = tjod;
    }

    public String getTjos() {
        return tjos;
    }

    public void setTjos(String tjos) {
        this.tjos = tjos;
    }

    public String getSphereRightz() {
        return sphereRightz;
    }

    public void setSphereRightz(String sphereRightz) {
        this.sphereRightz = sphereRightz;
    }

    public String getSphereLeftz() {
        return sphereLeftz;
    }

    public void setSphereLeftz(String sphereLeftz) {
        this.sphereLeftz = sphereLeftz;
    }

    public String getCylinderRightz() {
        return cylinderRightz;
    }

    public void setCylinderRightz(String cylinderRightz) {
        this.cylinderRightz = cylinderRightz;
    }

    public String getCylinderLeftz() {
        return cylinderLeftz;
    }

    public void setCylinderLeftz(String cylinderLeftz) {
        this.cylinderLeftz = cylinderLeftz;
    }

    public String getAxialRightz() {
        return axialRightz;
    }

    public void setAxialRightz(String axialRightz) {
        this.axialRightz = axialRightz;
    }

    public String getAxialLeftz() {
        return axialLeftz;
    }

    public void setAxialLeftz(String axialLeftz) {
        this.axialLeftz = axialLeftz;
    }

    public String getDvaRightz() {
        return dvaRightz;
    }

    public void setDvaRightz(String dvaRightz) {
        this.dvaRightz = dvaRightz;
    }

    public String getDvaLeftz() {
        return dvaLeftz;
    }

    public void setDvaLeftz(String dvaLeftz) {
        this.dvaLeftz = dvaLeftz;
    }

    public String getNvaRightz() {
        return nvaRightz;
    }

    public void setNvaRightz(String nvaRightz) {
        this.nvaRightz = nvaRightz;
    }

    public String getNvaLeftz() {
        return nvaLeftz;
    }

    public void setNvaLeftz(String nvaLeftz) {
        this.nvaLeftz = nvaLeftz;
    }

    public String getPrismRightz() {
        return prismRightz;
    }

    public void setPrismRightz(String prismRightz) {
        this.prismRightz = prismRightz;
    }

    public String getPrismLeftz() {
        return prismLeftz;
    }

    public void setPrismLeftz(String prismLeftz) {
        this.prismLeftz = prismLeftz;
    }

    public String getJdrZ() {
        return jdrZ;
    }

    public void setJdrZ(String jdrZ) {
        this.jdrZ = jdrZ;
    }

    public String getJdlZ() {
        return jdlZ;
    }

    public void setJdlZ(String jdlZ) {
        this.jdlZ = jdlZ;
    }

    public String getAddRightz() {
        return addRightz;
    }

    public void setAddRightz(String addRightz) {
        this.addRightz = addRightz;
    }

    public String getAddLeftz() {
        return addLeftz;
    }

    public void setAddLeftz(String addLeftz) {
        this.addLeftz = addLeftz;
    }

    public String getYuanRz() {
        return yuanRz;
    }

    public void setYuanRz(String yuanRz) {
        this.yuanRz = yuanRz;
    }

    public String getYuanLz() {
        return yuanLz;
    }

    public void setYuanLz(String yuanLz) {
        this.yuanLz = yuanLz;
    }

    public String getNearRightz() {
        return nearRightz;
    }

    public void setNearRightz(String nearRightz) {
        this.nearRightz = nearRightz;
    }

    public String getNearLeftz() {
        return nearLeftz;
    }

    public void setNearLeftz(String nearLeftz) {
        this.nearLeftz = nearLeftz;
    }

    public String getSphereRighttry() {
        return sphereRighttry;
    }

    public void setSphereRighttry(String sphereRighttry) {
        this.sphereRighttry = sphereRighttry;
    }

    public String getSphereLefttry() {
        return sphereLefttry;
    }

    public void setSphereLefttry(String sphereLefttry) {
        this.sphereLefttry = sphereLefttry;
    }

    public String getCylinderRighttry() {
        return cylinderRighttry;
    }

    public void setCylinderRighttry(String cylinderRighttry) {
        this.cylinderRighttry = cylinderRighttry;
    }

    public String getCylinderLefttry() {
        return cylinderLefttry;
    }

    public void setCylinderLefttry(String cylinderLefttry) {
        this.cylinderLefttry = cylinderLefttry;
    }

    public String getAxialRighttry() {
        return axialRighttry;
    }

    public void setAxialRighttry(String axialRighttry) {
        this.axialRighttry = axialRighttry;
    }

    public String getAxialLefttry() {
        return axialLefttry;
    }

    public void setAxialLefttry(String axialLefttry) {
        this.axialLefttry = axialLefttry;
    }

    public String getDvaRighttry() {
        return dvaRighttry;
    }

    public void setDvaRighttry(String dvaRighttry) {
        this.dvaRighttry = dvaRighttry;
    }

    public String getDvaLefttry() {
        return dvaLefttry;
    }

    public void setDvaLefttry(String dvaLefttry) {
        this.dvaLefttry = dvaLefttry;
    }

    public String getNvaRighttry() {
        return nvaRighttry;
    }

    public void setNvaRighttry(String nvaRighttry) {
        this.nvaRighttry = nvaRighttry;
    }

    public String getNvaLefttry() {
        return nvaLefttry;
    }

    public void setNvaLefttry(String nvaLefttry) {
        this.nvaLefttry = nvaLefttry;
    }

    public String getPrismRighttry() {
        return prismRighttry;
    }

    public void setPrismRighttry(String prismRighttry) {
        this.prismRighttry = prismRighttry;
    }

    public String getPrismLefttry() {
        return prismLefttry;
    }

    public void setPrismLefttry(String prismLefttry) {
        this.prismLefttry = prismLefttry;
    }

    public String getJdrTry() {
        return jdrTry;
    }

    public void setJdrTry(String jdrTry) {
        this.jdrTry = jdrTry;
    }

    public String getJdlTry() {
        return jdlTry;
    }

    public void setJdlTry(String jdlTry) {
        this.jdlTry = jdlTry;
    }

    public String getHeightRighttry() {
        return heightRighttry;
    }

    public void setHeightRighttry(String heightRighttry) {
        this.heightRighttry = heightRighttry;
    }

    public String getHeightLefttry() {
        return heightLefttry;
    }

    public void setHeightLefttry(String heightLefttry) {
        this.heightLefttry = heightLefttry;
    }

    public String getAddRighttry() {
        return addRighttry;
    }

    public void setAddRighttry(String addRighttry) {
        this.addRighttry = addRighttry;
    }

    public String getAddLefttry() {
        return addLefttry;
    }

    public void setAddLefttry(String addLefttry) {
        this.addLefttry = addLefttry;
    }

    public String getYuanRrty() {
        return yuanRrty;
    }

    public void setYuanRrty(String yuanRrty) {
        this.yuanRrty = yuanRrty;
    }

    public String getYuanLrty() {
        return yuanLrty;
    }

    public void setYuanLrty(String yuanLrty) {
        this.yuanLrty = yuanLrty;
    }

    public String getNearRighttry() {
        return nearRighttry;
    }

    public void setNearRighttry(String nearRighttry) {
        this.nearRighttry = nearRighttry;
    }

    public String getNearLefttry() {
        return nearLefttry;
    }

    public void setNearLefttry(String nearLefttry) {
        this.nearLefttry = nearLefttry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

