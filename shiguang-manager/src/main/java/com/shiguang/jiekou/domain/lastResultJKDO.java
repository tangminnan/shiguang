package com.shiguang.jiekou.domain;

import java.io.Serializable;


/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
public class lastResultJKDO implements Serializable {
    private static final long serialVersionUID = 1L;
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
    //中央角膜厚度(右眼)
    private Double centralThicknessRight;
    //中央角膜厚度(左眼)
    private Double centralThicknessLeft;
    //房水深度(右眼)
    private Double depthHumorRight;
    //房水深度(左眼)
    private Double depthHumorLeft;
    //前房深度(右眼)
    private Double anteriorChamberDepthRight;
    //前房深度(左眼)
    private Double anteriorChamberDepthLeft;
    //晶状体厚度(右眼)
    private Double lensThicknessRight;
    //晶状体厚度(左眼)
    private Double lensThicknessLeft;
    //瞳孔直径(右眼)
    private Double pupilSizeRight;
    //瞳孔直径(左眼)
    private Double pupilSizeLeft;
    //白到白(右眼)
    private Double whiteRight;
    //白到白(左眼)
    private Double whiteLeft;
    //玻璃体厚度(右眼)
    private Double vitreousThicknessRight;
    //玻璃体厚度(左眼)
    private Double vitreousThicknessLeft;
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
    //散光(右眼)
    private Double astigmiaFirstRight;
    //散光@A(右眼)
    private Double astigmiaLastRight;
    //散光(左眼)
    private Double astigmiaFirstLeft;
    //散光@A(左眼)
    private Double astigmiaLastLeft;
    //眼压(OD)
    private String intraocularOd;
    //眼压(OS)
    private String intraocularOs;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
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
    //角膜散光(OD)
    private String cornealAstigmatismOd;
    //角膜散光(OS)
    private String cornealAstigmatismOs;
    //瞳距(OD)
    private String pdOd;
    //瞳距(OS)
    private String pdOs;

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

    public Double getCentralThicknessRight() {
        return centralThicknessRight;
    }

    public void setCentralThicknessRight(Double centralThicknessRight) {
        this.centralThicknessRight = centralThicknessRight;
    }

    public Double getCentralThicknessLeft() {
        return centralThicknessLeft;
    }

    public void setCentralThicknessLeft(Double centralThicknessLeft) {
        this.centralThicknessLeft = centralThicknessLeft;
    }

    public Double getDepthHumorRight() {
        return depthHumorRight;
    }

    public void setDepthHumorRight(Double depthHumorRight) {
        this.depthHumorRight = depthHumorRight;
    }

    public Double getDepthHumorLeft() {
        return depthHumorLeft;
    }

    public void setDepthHumorLeft(Double depthHumorLeft) {
        this.depthHumorLeft = depthHumorLeft;
    }

    public Double getAnteriorChamberDepthRight() {
        return anteriorChamberDepthRight;
    }

    public void setAnteriorChamberDepthRight(Double anteriorChamberDepthRight) {
        this.anteriorChamberDepthRight = anteriorChamberDepthRight;
    }

    public Double getAnteriorChamberDepthLeft() {
        return anteriorChamberDepthLeft;
    }

    public void setAnteriorChamberDepthLeft(Double anteriorChamberDepthLeft) {
        this.anteriorChamberDepthLeft = anteriorChamberDepthLeft;
    }

    public Double getLensThicknessRight() {
        return lensThicknessRight;
    }

    public void setLensThicknessRight(Double lensThicknessRight) {
        this.lensThicknessRight = lensThicknessRight;
    }

    public Double getLensThicknessLeft() {
        return lensThicknessLeft;
    }

    public void setLensThicknessLeft(Double lensThicknessLeft) {
        this.lensThicknessLeft = lensThicknessLeft;
    }

    public Double getPupilSizeRight() {
        return pupilSizeRight;
    }

    public void setPupilSizeRight(Double pupilSizeRight) {
        this.pupilSizeRight = pupilSizeRight;
    }

    public Double getPupilSizeLeft() {
        return pupilSizeLeft;
    }

    public void setPupilSizeLeft(Double pupilSizeLeft) {
        this.pupilSizeLeft = pupilSizeLeft;
    }

    public Double getWhiteRight() {
        return whiteRight;
    }

    public void setWhiteRight(Double whiteRight) {
        this.whiteRight = whiteRight;
    }

    public Double getWhiteLeft() {
        return whiteLeft;
    }

    public void setWhiteLeft(Double whiteLeft) {
        this.whiteLeft = whiteLeft;
    }

    public Double getVitreousThicknessRight() {
        return vitreousThicknessRight;
    }

    public void setVitreousThicknessRight(Double vitreousThicknessRight) {
        this.vitreousThicknessRight = vitreousThicknessRight;
    }

    public Double getVitreousThicknessLeft() {
        return vitreousThicknessLeft;
    }

    public void setVitreousThicknessLeft(Double vitreousThicknessLeft) {
        this.vitreousThicknessLeft = vitreousThicknessLeft;
    }

    public Double getCornealFirstK1Right() {
        return cornealFirstK1Right;
    }

    public void setCornealFirstK1Right(Double cornealFirstK1Right) {
        this.cornealFirstK1Right = cornealFirstK1Right;
    }

    public Double getCornealLastK1Right() {
        return cornealLastK1Right;
    }

    public void setCornealLastK1Right(Double cornealLastK1Right) {
        this.cornealLastK1Right = cornealLastK1Right;
    }

    public Double getCornealFirstK1Left() {
        return cornealFirstK1Left;
    }

    public void setCornealFirstK1Left(Double cornealFirstK1Left) {
        this.cornealFirstK1Left = cornealFirstK1Left;
    }

    public Double getCornealLastK1Left() {
        return cornealLastK1Left;
    }

    public void setCornealLastK1Left(Double cornealLastK1Left) {
        this.cornealLastK1Left = cornealLastK1Left;
    }

    public Double getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }

    public void setCornealFirstK2Right(Double cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }

    public Double getCornealLastK2Right() {
        return cornealLastK2Right;
    }

    public void setCornealLastK2Right(Double cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }

    public Double getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }

    public void setCornealFirstK2Left(Double cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }

    public Double getCornealLastK2Left() {
        return cornealLastK2Left;
    }

    public void setCornealLastK2Left(Double cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }

    public Double getAstigmiaFirstRight() {
        return astigmiaFirstRight;
    }

    public void setAstigmiaFirstRight(Double astigmiaFirstRight) {
        this.astigmiaFirstRight = astigmiaFirstRight;
    }

    public Double getAstigmiaLastRight() {
        return astigmiaLastRight;
    }

    public void setAstigmiaLastRight(Double astigmiaLastRight) {
        this.astigmiaLastRight = astigmiaLastRight;
    }

    public Double getAstigmiaFirstLeft() {
        return astigmiaFirstLeft;
    }

    public void setAstigmiaFirstLeft(Double astigmiaFirstLeft) {
        this.astigmiaFirstLeft = astigmiaFirstLeft;
    }

    public Double getAstigmiaLastLeft() {
        return astigmiaLastLeft;
    }

    public void setAstigmiaLastLeft(Double astigmiaLastLeft) {
        this.astigmiaLastLeft = astigmiaLastLeft;
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

    public String getPdOd() {
        return pdOd;
    }

    public void setPdOd(String pdOd) {
        this.pdOd = pdOd;
    }

    public String getPdOs() {
        return pdOs;
    }

    public void setPdOs(String pdOs) {
        this.pdOs = pdOs;
    }
}

