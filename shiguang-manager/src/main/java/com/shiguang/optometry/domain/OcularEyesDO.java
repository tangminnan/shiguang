package com.shiguang.optometry.domain;

import java.io.Serializable;

public class OcularEyesDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //会员卡号
    private String memberNumber;
    //眼轴
    private Double axis;
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
    //角膜K1值(右眼)
    private Double cornealFirstK2Right;
    //角膜K1值@A(右眼)
    private Double cornealLastK2Right;
    //角膜K1值(左眼)
    private Double cornealFirstK2Left;
    //角膜K1值@A(左眼)
    private Double cornealLastK2Left;
    //散光(右眼)
    private Double astigmiaFirstRight;
    //散光@A(右眼)
    private Double astigmiaLastRight;
    //散光(左眼)
    private Double astigmiaFirstLeft;
    //散光@A(左眼)
    private Double astigmiaLastLeft;

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
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    /**
     * 获取：会员卡号
     */
    public String getMemberNumber() {
        return memberNumber;
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
     * 设置：中央角膜厚度(右眼)
     */
    public void setCentralThicknessRight(Double centralThicknessRight) {
        this.centralThicknessRight = centralThicknessRight;
    }
    /**
     * 获取：中央角膜厚度(右眼)
     */
    public Double getCentralThicknessRight() {
        return centralThicknessRight;
    }
    /**
     * 设置：中央角膜厚度(左眼)
     */
    public void setCentralThicknessLeft(Double centralThicknessLeft) {
        this.centralThicknessLeft = centralThicknessLeft;
    }
    /**
     * 获取：中央角膜厚度(左眼)
     */
    public Double getCentralThicknessLeft() {
        return centralThicknessLeft;
    }
    /**
     * 设置：房水深度(右眼)
     */
    public void setDepthHumorRight(Double depthHumorRight) {
        this.depthHumorRight = depthHumorRight;
    }
    /**
     * 获取：房水深度(右眼)
     */
    public Double getDepthHumorRight() {
        return depthHumorRight;
    }
    /**
     * 设置：房水深度(左眼)
     */
    public void setDepthHumorLeft(Double depthHumorLeft) {
        this.depthHumorLeft = depthHumorLeft;
    }
    /**
     * 获取：房水深度(左眼)
     */
    public Double getDepthHumorLeft() {
        return depthHumorLeft;
    }
    /**
     * 设置：前房深度(右眼)
     */
    public void setAnteriorChamberDepthRight(Double anteriorChamberDepthRight) {
        this.anteriorChamberDepthRight = anteriorChamberDepthRight;
    }
    /**
     * 获取：前房深度(右眼)
     */
    public Double getAnteriorChamberDepthRight() {
        return anteriorChamberDepthRight;
    }
    /**
     * 设置：前房深度(左眼)
     */
    public void setAnteriorChamberDepthLeft(Double anteriorChamberDepthLeft) {
        this.anteriorChamberDepthLeft = anteriorChamberDepthLeft;
    }
    /**
     * 获取：前房深度(左眼)
     */
    public Double getAnteriorChamberDepthLeft() {
        return anteriorChamberDepthLeft;
    }
    /**
     * 设置：晶状体厚度(右眼)
     */
    public void setLensThicknessRight(Double lensThicknessRight) {
        this.lensThicknessRight = lensThicknessRight;
    }
    /**
     * 获取：晶状体厚度(右眼)
     */
    public Double getLensThicknessRight() {
        return lensThicknessRight;
    }
    /**
     * 设置：晶状体厚度(左眼)
     */
    public void setLensThicknessLeft(Double lensThicknessLeft) {
        this.lensThicknessLeft = lensThicknessLeft;
    }
    /**
     * 获取：晶状体厚度(左眼)
     */
    public Double getLensThicknessLeft() {
        return lensThicknessLeft;
    }
    /**
     * 设置：瞳孔直径(右眼)
     */
    public void setPupilSizeRight(Double pupilSizeRight) {
        this.pupilSizeRight = pupilSizeRight;
    }
    /**
     * 获取：瞳孔直径(右眼)
     */
    public Double getPupilSizeRight() {
        return pupilSizeRight;
    }
    /**
     * 设置：瞳孔直径(左眼)
     */
    public void setPupilSizeLeft(Double pupilSizeLeft) {
        this.pupilSizeLeft = pupilSizeLeft;
    }
    /**
     * 获取：瞳孔直径(左眼)
     */
    public Double getPupilSizeLeft() {
        return pupilSizeLeft;
    }
    /**
     * 设置：白到白(右眼)
     */
    public void setWhiteRight(Double whiteRight) {
        this.whiteRight = whiteRight;
    }
    /**
     * 获取：白到白(右眼)
     */
    public Double getWhiteRight() {
        return whiteRight;
    }
    /**
     * 设置：白到白(左眼)
     */
    public void setWhiteLeft(Double whiteLeft) {
        this.whiteLeft = whiteLeft;
    }
    /**
     * 获取：白到白(左眼)
     */
    public Double getWhiteLeft() {
        return whiteLeft;
    }
    /**
     * 设置：玻璃体厚度(右眼)
     */
    public void setVitreousThicknessRight(Double vitreousThicknessRight) {
        this.vitreousThicknessRight = vitreousThicknessRight;
    }
    /**
     * 获取：玻璃体厚度(右眼)
     */
    public Double getVitreousThicknessRight() {
        return vitreousThicknessRight;
    }
    /**
     * 设置：玻璃体厚度(左眼)
     */
    public void setVitreousThicknessLeft(Double vitreousThicknessLeft) {
        this.vitreousThicknessLeft = vitreousThicknessLeft;
    }
    /**
     * 获取：玻璃体厚度(左眼)
     */
    public Double getVitreousThicknessLeft() {
        return vitreousThicknessLeft;
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
     * 设置：角膜K1值(右眼)
     */
    public void setCornealFirstK2Right(Double cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }
    /**
     * 获取：角膜K1值(右眼)
     */
    public Double getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }
    /**
     * 设置：角膜K1值@A(右眼)
     */
    public void setCornealLastK2Right(Double cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }
    /**
     * 获取：角膜K1值@A(右眼)
     */
    public Double getCornealLastK2Right() {
        return cornealLastK2Right;
    }
    /**
     * 设置：角膜K1值(左眼)
     */
    public void setCornealFirstK2Left(Double cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }
    /**
     * 获取：角膜K1值(左眼)
     */
    public Double getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }
    /**
     * 设置：角膜K1值@A(左眼)
     */
    public void setCornealLastK2Left(Double cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }
    /**
     * 获取：角膜K1值@A(左眼)
     */
    public Double getCornealLastK2Left() {
        return cornealLastK2Left;
    }
    /**
     * 设置：散光(右眼)
     */
    public void setAstigmiaFirstRight(Double astigmiaFirstRight) {
        this.astigmiaFirstRight = astigmiaFirstRight;
    }
    /**
     * 获取：散光(右眼)
     */
    public Double getAstigmiaFirstRight() {
        return astigmiaFirstRight;
    }
    /**
     * 设置：散光@A(右眼)
     */
    public void setAstigmiaLastRight(Double astigmiaLastRight) {
        this.astigmiaLastRight = astigmiaLastRight;
    }
    /**
     * 获取：散光@A(右眼)
     */
    public Double getAstigmiaLastRight() {
        return astigmiaLastRight;
    }
    /**
     * 设置：散光(左眼)
     */
    public void setAstigmiaFirstLeft(Double astigmiaFirstLeft) {
        this.astigmiaFirstLeft = astigmiaFirstLeft;
    }
    /**
     * 获取：散光(左眼)
     */
    public Double getAstigmiaFirstLeft() {
        return astigmiaFirstLeft;
    }
    /**
     * 设置：散光@A(左眼)
     */
    public void setAstigmiaLastLeft(Double astigmiaLastLeft) {
        this.astigmiaLastLeft = astigmiaLastLeft;
    }
    /**
     * 获取：散光@A(左眼)
     */
    public Double getAstigmiaLastLeft() {
        return astigmiaLastLeft;
    }
}
