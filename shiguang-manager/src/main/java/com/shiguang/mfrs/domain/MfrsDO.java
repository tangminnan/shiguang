package com.shiguang.mfrs.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 制造商维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 14:17:19
 */
public class MfrsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //制造商id
    private Integer mfrsid;
    //制造商代码
    private String mfrsnum;
    //制造商简称
    private String mfrsname;
    //制造商联系人
    private String mfrscontacts;
    //制造商全称
    private String mfrsrealname;
    //制造商电话
    private String mfrstelephone;
    //联系人电话
    private String mfrsphone;
    //商品类别(1镜架、2配件、3镜片、4隐形)
    private String goodsid;
    //制造商传真
    private String mfrsfax;
    //制造商地址
    private String mfrsaddress;
    //采购结算方式(1现金、2数期、3代销月结、4信用额周转)
    private Integer payid;
    //开票状态(1开票、2不开票)
    private Integer invoiceid;
    //统一社会信用代码
    private String creditcode;
    //统一社会信用代码效期
    private Date creditcodeday;
    private String creditcodedays;
    //医疗器械经营许可证号
    private String medicinecode;
    //医疗器械经营许可证有效期
    private Date medicinecodeday;
    private String medicinecodedays;
    //全国工业品生产许可证号
    private String productscode;
    //全国工业品生产许可证有效期
    private Date productscodeday;
    private String productscodedays;
    //备注
    private String remarks;
    //状态（0：启用1：停用）
    private Long status;
    //状态(0:删除1:未删除)
    private Long state;

    /**
     * 设置：制造商id
     */
    public void setMfrsid(Integer mfrsid) {
        this.mfrsid = mfrsid;
    }

    /**
     * 获取：制造商id
     */
    public Integer getMfrsid() {
        return mfrsid;
    }

    /**
     * 设置：制造商代码
     */
    public void setMfrsnum(String mfrsnum) {
        this.mfrsnum = mfrsnum;
    }

    /**
     * 获取：制造商代码
     */
    public String getMfrsnum() {
        return mfrsnum;
    }

    /**
     * 设置：制造商简称
     */
    public void setMfrsname(String mfrsname) {
        this.mfrsname = mfrsname;
    }

    /**
     * 获取：制造商简称
     */
    public String getMfrsname() {
        return mfrsname;
    }

    /**
     * 设置：制造商联系人
     */
    public void setMfrscontacts(String mfrscontacts) {
        this.mfrscontacts = mfrscontacts;
    }

    /**
     * 获取：制造商联系人
     */
    public String getMfrscontacts() {
        return mfrscontacts;
    }

    /**
     * 设置：制造商全称
     */
    public void setMfrsrealname(String mfrsrealname) {
        this.mfrsrealname = mfrsrealname;
    }

    /**
     * 获取：制造商全称
     */
    public String getMfrsrealname() {
        return mfrsrealname;
    }

    /**
     * 设置：制造商电话
     */
    public void setMfrstelephone(String mfrstelephone) {
        this.mfrstelephone = mfrstelephone;
    }

    /**
     * 获取：制造商电话
     */
    public String getMfrstelephone() {
        return mfrstelephone;
    }

    /**
     * 设置：联系人电话
     */
    public void setMfrsphone(String mfrsphone) {
        this.mfrsphone = mfrsphone;
    }

    /**
     * 获取：联系人电话
     */
    public String getMfrsphone() {
        return mfrsphone;
    }

    /**
     * 设置：商品类别(1镜架、2配件、3镜片、4隐形)
     */
    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * 获取：商品类别(1镜架、2配件、3镜片、4隐形)
     */
    public String getGoodsid() {
        return goodsid;
    }

    /**
     * 设置：制造商传真
     */
    public void setMfrsfax(String mfrsfax) {
        this.mfrsfax = mfrsfax;
    }

    /**
     * 获取：制造商传真
     */
    public String getMfrsfax() {
        return mfrsfax;
    }

    /**
     * 设置：制造商地址
     */
    public void setMfrsaddress(String mfrsaddress) {
        this.mfrsaddress = mfrsaddress;
    }

    /**
     * 获取：制造商地址
     */
    public String getMfrsaddress() {
        return mfrsaddress;
    }

    /**
     * 设置：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
     */
    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    /**
     * 获取：采购结算方式(1现金、2数期、3代销月结、4信用额周转)
     */
    public Integer getPayid() {
        return payid;
    }

    /**
     * 设置：开票状态(1开票、2不开票)
     */
    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    /**
     * 获取：开票状态(1开票、2不开票)
     */
    public Integer getInvoiceid() {
        return invoiceid;
    }

    /**
     * 设置：统一社会信用代码
     */
    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode;
    }

    /**
     * 获取：统一社会信用代码
     */
    public String getCreditcode() {
        return creditcode;
    }

    /**
     * 设置：统一社会信用代码效期
     */
    public void setCreditcodeday(Date creditcodeday) {
        this.creditcodeday = creditcodeday;
    }

    /**
     * 获取：统一社会信用代码效期
     */
    public Date getCreditcodeday() {
        return creditcodeday;
    }

    /**
     * 设置：医疗器械经营许可证号
     */
    public void setMedicinecode(String medicinecode) {
        this.medicinecode = medicinecode;
    }

    /**
     * 获取：医疗器械经营许可证号
     */
    public String getMedicinecode() {
        return medicinecode;
    }

    /**
     * 设置：医疗器械经营许可证有效期
     */
    public void setMedicinecodeday(Date medicinecodeday) {
        this.medicinecodeday = medicinecodeday;
    }

    /**
     * 获取：医疗器械经营许可证有效期
     */
    public Date getMedicinecodeday() {
        return medicinecodeday;
    }

    /**
     * 设置：全国工业品生产许可证号
     */
    public void setProductscode(String productscode) {
        this.productscode = productscode;
    }

    /**
     * 获取：全国工业品生产许可证号
     */
    public String getProductscode() {
        return productscode;
    }

    /**
     * 设置：全国工业品生产许可证有效期
     */
    public void setProductscodeday(Date productscodeday) {
        this.productscodeday = productscodeday;
    }

    /**
     * 获取：全国工业品生产许可证有效期
     */
    public Date getProductscodeday() {
        return productscodeday;
    }


    /**
     * 设置：备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 获取：备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 设置：状态(0：启用1：停用)
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取：状态(0：启用1：停用)
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置删除：//状态(0:删除1:未删除)
     */
    public void setState(Long state) {
        this.state = state;
    }

    /**
     * 获取删除：//状态(0:删除1:未删除)
     */
    public Long getState() {
        return state;
    }

    public String getCreditcodedays() {
        return creditcodedays;
    }

    public void setCreditcodedays(String creditcodedays) {
        this.creditcodedays = creditcodedays;
    }

    public String getMedicinecodedays() {
        return medicinecodedays;
    }

    public void setMedicinecodedays(String medicinecodedays) {
        this.medicinecodedays = medicinecodedays;
    }

    public String getProductscodedays() {
        return productscodedays;
    }

    public void setProductscodedays(String productscodedays) {
        this.productscodedays = productscodedays;
    }
}
