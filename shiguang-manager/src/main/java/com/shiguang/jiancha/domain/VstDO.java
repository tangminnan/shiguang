package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 角膜接触镜VST
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 16:38:36
 */
public class VstDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //角膜接触镜VSTid
    private Long vstId;
    //卡号
    private String cardNumber;
    //处方类型
    private String vstPrescriptionType;
    //医生
    private String vstDoctor;
    //验光师
    private String vstOptometryName;
    //试戴片编号OD
    private String vstSdbhod;
    //试戴片编号OS
    private String vstSdbhos;
    //FK(OD)
    private String vstFkod;
    //FK(OS)
    private String vstFkos;
    //曲率半径(OD)
    private String vstQlbjod;
    //曲率半径(OS)
    private String vstQlbjos;
    //AC(OD)
    private String vstAcod;
    //AC(OS)
    private String vstAcos;
    //降幅OD
    private String vstJfod;
    //降幅OS
    private String vstJfos;
    //DIA(OD)
    private String vstDiaod;
    //DIA(OS)
    private String vstDiaos;
    //BC(OD)
    private String vstBcod;
    //BC(OS)
    private String vstBcos;
    //CP/CLY(OD)
    private String vstCpclyod;
    //CP/CLY(OS)
    private String vstCpclyos;
    //E值(OD)
    private String vstEod;
    //E值(OS)
    private String vstEos;
    //VA(OD)
    private String vstVaod;
    //VA(OS)
    private String vstVaos;
    //镜片颜色OD
    private String vstJpysod;
    //镜片颜色OS
    private String vstJpysos;
    //适用镜片OD
    private String vstSyjpod;
    //适用镜片OS
    private String vstSyjpos;
    //备注
    private String vstBeizhu;
    //删除状态
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 设置：角膜接触镜VSTid
     */
    public void setVstId(Long vstId) {
        this.vstId = vstId;
    }

    /**
     * 获取：角膜接触镜VSTid
     */
    public Long getVstId() {
        return vstId;
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
    public void setVstPrescriptionType(String vstPrescriptionType) {
        this.vstPrescriptionType = vstPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getVstPrescriptionType() {
        return vstPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setVstDoctor(String vstDoctor) {
        this.vstDoctor = vstDoctor;
    }

    /**
     * 获取：医生
     */
    public String getVstDoctor() {
        return vstDoctor;
    }

    public String getVstOptometryName() {
        return vstOptometryName;
    }

    public void setVstOptometryName(String vstOptometryName) {
        this.vstOptometryName = vstOptometryName;
    }

    /**
     * 设置：试戴片编号OD
     */
    public void setVstSdbhod(String vstSdbhod) {
        this.vstSdbhod = vstSdbhod;
    }

    /**
     * 获取：试戴片编号OD
     */
    public String getVstSdbhod() {
        return vstSdbhod;
    }

    /**
     * 设置：试戴片编号OS
     */
    public void setVstSdbhos(String vstSdbhos) {
        this.vstSdbhos = vstSdbhos;
    }

    /**
     * 获取：试戴片编号OS
     */
    public String getVstSdbhos() {
        return vstSdbhos;
    }

    /**
     * 设置：FK(OD)
     */
    public void setVstFkod(String vstFkod) {
        this.vstFkod = vstFkod;
    }

    /**
     * 获取：FK(OD)
     */
    public String getVstFkod() {
        return vstFkod;
    }

    /**
     * 设置：FK(OS)
     */
    public void setVstFkos(String vstFkos) {
        this.vstFkos = vstFkos;
    }

    /**
     * 获取：FK(OS)
     */
    public String getVstFkos() {
        return vstFkos;
    }

    /**
     * 设置：曲率半径(OD)
     */
    public void setVstQlbjod(String vstQlbjod) {
        this.vstQlbjod = vstQlbjod;
    }

    /**
     * 获取：曲率半径(OD)
     */
    public String getVstQlbjod() {
        return vstQlbjod;
    }

    /**
     * 设置：曲率半径(OS)
     */
    public void setVstQlbjos(String vstQlbjos) {
        this.vstQlbjos = vstQlbjos;
    }

    /**
     * 获取：曲率半径(OS)
     */
    public String getVstQlbjos() {
        return vstQlbjos;
    }

    /**
     * 设置：AC(OD)
     */
    public void setVstAcod(String vstAcod) {
        this.vstAcod = vstAcod;
    }

    /**
     * 获取：AC(OD)
     */
    public String getVstAcod() {
        return vstAcod;
    }

    /**
     * 设置：AC(OS)
     */
    public void setVstAcos(String vstAcos) {
        this.vstAcos = vstAcos;
    }

    /**
     * 获取：AC(OS)
     */
    public String getVstAcos() {
        return vstAcos;
    }

    /**
     * 设置：降幅OD
     */
    public void setVstJfod(String vstJfod) {
        this.vstJfod = vstJfod;
    }

    /**
     * 获取：降幅OD
     */
    public String getVstJfod() {
        return vstJfod;
    }

    /**
     * 设置：降幅OS
     */
    public void setVstJfos(String vstJfos) {
        this.vstJfos = vstJfos;
    }

    /**
     * 获取：降幅OS
     */
    public String getVstJfos() {
        return vstJfos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setVstDiaod(String vstDiaod) {
        this.vstDiaod = vstDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public String getVstDiaod() {
        return vstDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setVstDiaos(String vstDiaos) {
        this.vstDiaos = vstDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public String getVstDiaos() {
        return vstDiaos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setVstBcod(String vstBcod) {
        this.vstBcod = vstBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public String getVstBcod() {
        return vstBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setVstBcos(String vstBcos) {
        this.vstBcos = vstBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public String getVstBcos() {
        return vstBcos;
    }

    /**
     * 设置：CP/CLY(OD)
     */
    public void setVstCpclyod(String vstCpclyod) {
        this.vstCpclyod = vstCpclyod;
    }

    /**
     * 获取：CP/CLY(OD)
     */
    public String getVstCpclyod() {
        return vstCpclyod;
    }

    /**
     * 设置：CP/CLY(OS)
     */
    public void setVstCpclyos(String vstCpclyos) {
        this.vstCpclyos = vstCpclyos;
    }

    /**
     * 获取：CP/CLY(OS)
     */
    public String getVstCpclyos() {
        return vstCpclyos;
    }

    /**
     * 设置：E值(OD)
     */
    public void setVstEod(String vstEod) {
        this.vstEod = vstEod;
    }

    /**
     * 获取：E值(OD)
     */
    public String getVstEod() {
        return vstEod;
    }

    /**
     * 设置：E值(OS)
     */
    public void setVstEos(String vstEos) {
        this.vstEos = vstEos;
    }

    /**
     * 获取：E值(OS)
     */
    public String getVstEos() {
        return vstEos;
    }

    /**
     * 设置：VA(OD)
     */
    public void setVstVaod(String vstVaod) {
        this.vstVaod = vstVaod;
    }

    /**
     * 获取：VA(OD)
     */
    public String getVstVaod() {
        return vstVaod;
    }

    /**
     * 设置：VA(OS)
     */
    public void setVstVaos(String vstVaos) {
        this.vstVaos = vstVaos;
    }

    /**
     * 获取：VA(OS)
     */
    public String getVstVaos() {
        return vstVaos;
    }

    /**
     * 设置：镜片颜色OD
     */
    public void setVstJpysod(String vstJpysod) {
        this.vstJpysod = vstJpysod;
    }

    /**
     * 获取：镜片颜色OD
     */
    public String getVstJpysod() {
        return vstJpysod;
    }

    /**
     * 设置：镜片颜色OS
     */
    public void setVstJpysos(String vstJpysos) {
        this.vstJpysos = vstJpysos;
    }

    /**
     * 获取：镜片颜色OS
     */
    public String getVstJpysos() {
        return vstJpysos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setVstSyjpod(String vstSyjpod) {
        this.vstSyjpod = vstSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getVstSyjpod() {
        return vstSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setVstSyjpos(String vstSyjpos) {
        this.vstSyjpos = vstSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getVstSyjpos() {
        return vstSyjpos;
    }

    /**
     * 设置：备注
     */
    public void setVstBeizhu(String vstBeizhu) {
        this.vstBeizhu = vstBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getVstBeizhu() {
        return vstBeizhu;
    }
    //验光号
    private String ptometryNumber;

    public String getPtometryNumber() {
        return ptometryNumber;
    }

    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }
}
