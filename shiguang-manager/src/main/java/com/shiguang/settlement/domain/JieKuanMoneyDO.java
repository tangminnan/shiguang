package com.shiguang.settlement.domain;

import java.io.Serializable;

public class JieKuanMoneyDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String companyId;
    private String cardNumber;
    private String isSale;
    private String saleNumber;
    private String peijingTime;
    private String amountMoney;
    private String sex;
    private String departNumber;
    private String age;
    private String phone1;
    private String saleForm;
    private String state;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getPeijingTime() {
        return peijingTime;
    }

    public void setPeijingTime(String peijingTime) {
        this.peijingTime = peijingTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartNumber() {
        return departNumber;
    }

    public void setDepartNumber(String departNumber) {
        this.departNumber = departNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getSaleForm() {
        return saleForm;
    }

    public void setSaleForm(String saleForm) {
        this.saleForm = saleForm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(String amountMoney) {
        this.amountMoney = amountMoney;
    }
}
