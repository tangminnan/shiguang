package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 隐形成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:04:25
 */
public class YxcpDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //隐形成品id
    private Long id;
    //商品信息代码
    private String producNum;
    //商品条码
    private String producCode;
    //商品名称
    private String producName;
    //制造商id
    private Integer mfrsid;
    private String mfrsname;
    //商品品种（品牌id
    private Integer brandid;
    private String brandname;
    //商品编号
    private String proid;
    //计量单位
    private String unitid;
    //球镜id
    private Long sphId;
    //柱镜id
    private Long cylId;
    //曲率
    private String curvature;
    //直径
    private String diameter;
    //厂家型号
    private String factory;
    //使用类型id
    private Integer usageId;
    //抛弃型分类id
    private Integer typeId;
    //产品可使用天数
    private Integer useDays;
    //效期提醒上限（有效期前【】天提醒进入滞销状态）
    private Integer upday;
    //效期提醒下限（有效期前【】天提醒进入即将失效状态）
    private Integer downday;
    //颜色
    private String color;
    //隐形类别id
    private Long invisibleId;
    //材质id
    private Long caizhiId;
    //税率(%)
    private String tax;
    //含税单价
    private Double taxPrice;
    //批发价格
    private Double tradePrice;
    //调货成本
    private Double transferPrice;
    //标准零售价
    private Double retailPrice;

    /**
     * 设置：隐形成品id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：隐形成品id
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
     * 设置：计量单位
     */
    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    /**
     * 获取：计量单位
     */
    public String getUnitid() {
        return unitid;
    }

    /**
     * 设置：球镜id
     */
    public void setSphId(Long sphId) {
        this.sphId = sphId;
    }

    /**
     * 获取：球镜id
     */
    public Long getSphId() {
        return sphId;
    }

    /**
     * 设置：柱镜id
     */
    public void setCylId(Long cylId) {
        this.cylId = cylId;
    }

    /**
     * 获取：柱镜id
     */
    public Long getCylId() {
        return cylId;
    }

    /**
     * 设置：曲率
     */
    public void setCurvature(String curvature) {
        this.curvature = curvature;
    }

    /**
     * 获取：曲率
     */
    public String getCurvature() {
        return curvature;
    }

    /**
     * 设置：直径
     */
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    /**
     * 获取：直径
     */
    public String getDiameter() {
        return diameter;
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
     * 设置：使用类型id
     */
    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    /**
     * 获取：使用类型id
     */
    public Integer getUsageId() {
        return usageId;
    }

    /**
     * 设置：抛弃型分类id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取：抛弃型分类id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置：产品可使用天数
     */
    public void setUseDays(Integer useDays) {
        this.useDays = useDays;
    }

    /**
     * 获取：产品可使用天数
     */
    public Integer getUseDays() {
        return useDays;
    }

    /**
     * 设置：效期提醒上限（有效期前【】天提醒进入滞销状态）
     */
    public void setUpday(Integer upday) {
        this.upday = upday;
    }

    /**
     * 获取：效期提醒上限（有效期前【】天提醒进入滞销状态）
     */
    public Integer getUpday() {
        return upday;
    }

    /**
     * 设置：效期提醒下限（有效期前【】天提醒进入即将失效状态）
     */
    public void setDownday(Integer downday) {
        this.downday = downday;
    }

    /**
     * 获取：效期提醒下限（有效期前【】天提醒进入即将失效状态）
     */
    public Integer getDownday() {
        return downday;
    }

    /**
     * 设置：颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取：颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置：隐形类别id
     */
    public void setInvisibleId(Long invisibleId) {
        this.invisibleId = invisibleId;
    }

    /**
     * 获取：隐形类别id
     */
    public Long getInvisibleId() {
        return invisibleId;
    }

    /**
     * 设置：材质id
     */
    public void setCaizhiId(Long caizhiId) {
        this.caizhiId = caizhiId;
    }

    /**
     * 获取：材质id
     */
    public Long getCaizhiId() {
        return caizhiId;
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
    public void setTaxPrice(Double taxPrice) {
        this.taxPrice = taxPrice;
    }

    /**
     * 获取：含税单价
     */
    public Double getTaxPrice() {
        return taxPrice;
    }

    /**
     * 设置：批发价格
     */
    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    /**
     * 获取：批发价格
     */
    public Double getTradePrice() {
        return tradePrice;
    }

    /**
     * 设置：调货成本
     */
    public void setTransferPrice(Double transferPrice) {
        this.transferPrice = transferPrice;
    }

    /**
     * 获取：调货成本
     */
    public Double getTransferPrice() {
        return transferPrice;
    }

    /**
     * 设置：标准零售价
     */
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取：标准零售价
     */
    public Double getRetailPrice() {
        return retailPrice;
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
}
