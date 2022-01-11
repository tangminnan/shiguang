package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 17:14:05
 */
public class HcDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //耗材id
    private Long id;
    //商品信息id
    private Long goodsxinxiid;

    public Long getGoodsxinxiid() {
        return goodsxinxiid;
    }

    public void setGoodsxinxiid(Long goodsxinxiid) {
        this.goodsxinxiid = goodsxinxiid;
    }
    //商品信息代码
    private String producNum;
    //商品条码
    private String producCode;
    //商品名称
    private String producName;
    private String viewGoodName;
    //制造商id
    private String mfrsid;
    //制造商代码
    private String mfrsname;
    //品牌id
    private Integer brandid;
    //品牌代码
    private String brandname;
    private String brandnum;
    private String goodsid;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getBrandnum() {
        return brandnum;
    }

    public void setBrandnum(String brandnum) {
        this.brandnum = brandnum;
    }

    //厂家型号
    private String factory;
    //型号
    private String producFactory;
    //商品编号
    private String proid;
    //其他商品大类
    private String big;
    //其他商品小类
    private String small;
    private String smallstr;

    public String getSmallstr() {
        return smallstr;
    }

    public void setSmallstr(String smallstr) {
        this.smallstr = smallstr;
    }

    //计量单位id
    private Integer unitid;
    //单位
    private String unitname;
    //批号管理(1是、2否)
    private Integer batchid;
    //税率(%)
    private String tax;
    //含税单价
    private String taxPrice;
    //批发价格
    private String tradePrice;
    //调货成本
    private String transferPrice;
    //标准零售价格
    private String retailPrice;
    //状态（0：启用1：停用）
    private Long xsstate;
    //状态(0:删除1:未删除)
    private Long state;
    //盘盈盘亏的商品数量
    private String inventoryCount;
    public void setInventoryCount(String inventoryCount){this.inventoryCount = inventoryCount;}
    public String getInventoryCount() {return inventoryCount;}
    //镜片类型
    private String classtype;

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    /**
     * 设置：耗材id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：耗材id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：商品信息代码
     */
    public void setProducNum(String producNum) {
        this.producNum = producNum;
    }

    /**
     * 获取：商品信息代码
     */
    public String getProducNum() {
        return producNum;
    }

    /**
     * 设置：商品条码
     */
    public void setProducCode(String producCode) {
        this.producCode = producCode;
    }

    /**
     * 获取：商品条码
     */
    public String getProducCode() {
        return producCode;
    }

    /**
     * 设置：商品名称
     */
    public void setProducName(String producName) {
        this.producName = producName;
    }

    /**
     * 获取：商品名称
     */
    public String getProducName() {
        return producName;
    }

    public String getViewGoodName() {
        return viewGoodName;
    }

    public void setViewGoodName(String viewGoodName) {
        this.viewGoodName = viewGoodName;
    }

    /**
     * 设置：制造商id
     */
    public void setMfrsid(String mfrsid) {
        this.mfrsid = mfrsid;
    }

    /**
     * 获取：制造商id
     */
    public String getMfrsid() {
        return mfrsid;
    }

    /**
     * 设置：商品品种
     */
    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    /**
     * 获取：商品品种
     */
    public Integer getBrandid() {
        return brandid;
    }

    /**
     * 设置：厂家型号
     */
    public void setFactory(String factory) {
        this.factory = factory;
    }

    /**
     * 获取：厂家型号
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 设置：型号
     */
    public void setProducFactory(String producFactory) {
        this.producFactory = producFactory;
    }

    /**
     * 获取：型号
     */
    public String getProducFactory() {
        return producFactory;
    }

    /**
     * 设置：商品编号
     */
    public void setProid(String proid) {
        this.proid = proid;
    }

    /**
     * 获取：商品编号
     */
    public String getProid() {
        return proid;
    }

    /**
     * 设置：其他商品大类
     */
    public void setBig(String big) {
        this.big = big;
    }

    /**
     * 获取：其他商品大类
     */
    public String getBig() {
        return big;
    }

    /**
     * 设置：其他商品小类
     */
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     * 获取：其他商品小类
     */
    public String getSmall() {
        return small;
    }

    /**
     * 设置：计量单位
     */
    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    /**
     * 获取：计量单位
     */
    public Integer getUnitid() {
        return unitid;
    }

    /**
     * 设置：批号管理(1是、2否)
     */
    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    /**
     * 获取：批号管理(1是、2否)
     */
    public Integer getBatchid() {
        return batchid;
    }

    /**
     * 设置：税率(%)
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * 获取：税率(%)
     */
    public String getTax() {
        return tax;
    }

    /**
     * 设置：含税单价
     */
    public void setTaxPrice(String taxPrice) {
        this.taxPrice = taxPrice;
    }

    /**
     * 获取：含税单价
     */
    public String getTaxPrice() {
        return taxPrice;
    }

    /**
     * 设置：批发价格
     */
    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    /**
     * 获取：批发价格
     */
    public String getTradePrice() {
        return tradePrice;
    }

    /**
     * 设置：调货成本
     */
    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice;
    }

    /**
     * 获取：调货成本
     */
    public String getTransferPrice() {
        return transferPrice;
    }

    /**
     * 设置：标准零售价格
     */
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取：标准零售价格
     */
    public String getRetailPrice() {
        return retailPrice;
    }

    /**
     * 设置：状态(0：启用1：停用)
     */

    public Long getXsstate() {
        return xsstate;
    }

    /**
     * 获取：状态(0：启用1：停用)
     */
    public void setXsstate(Long xsstate) {
        this.xsstate = xsstate;
    }

    /**
     * 设置删除：//状态(0:删除1:未删除)
     */
    public Long getState() {
        return state;
    }

    /**
     * 获取删除：//状态(0:删除1:未删除)
     */
    public void setState(Long state) {
        this.state = state;
    }

    public String getMfrsname() {
        return mfrsname;
    }

    public void setMfrsname(String mfrsname) {
        this.mfrsname = mfrsname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
    //医疗器械经营许可证号
    private String medicinecode;

    public String getMedicinecode() {
        return medicinecode;
    }

    public void setMedicinecode(String medicinecode) {
        this.medicinecode = medicinecode;
    }
}
