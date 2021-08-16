package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 10:22:52
 */
public class ShiliDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //视力id
    private Long id;
    //卡号
    private String cardNumber;
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

    /**
     * 设置：视力id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：视力id
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
}
