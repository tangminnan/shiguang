package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
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
}
