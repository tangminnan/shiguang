package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 隐形定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:02:16
 */
public class YxdzDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //隐形定做id
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
    //厂家型号
    private String factory;
    //型号
    private String producFactory;
    //商品编号
    private String proid;
    //计量单位
    private String unitid;
    //球镜id
    private Long sphId;
    //跨度id
    private Long spanId;
    //柱镜id
    private Long cylId;
    //球镜上限
    private Long sphUp;
    //球镜下限
    private Long sphDown;
    //球镜跨度
    private Long sphSpan;
    //柱镜上限
    private Long cylUp;
    //柱镜下限
    private Long cylDown;
    //柱镜跨度
    private Long cylSpan;
    //曲率1
    private String curvatureOne;
    //-曲率1
    private String curvatureYi;
    //曲率2
    private String curvatureTwo;
    //-曲率2
    private String curvatureEr;
    //直径
    private String diameterOne;
    //直径1
    private String diameterYi;
    //接触镜类别
    private String contactLens;
    //定做周期（天）
    private Long cycle;
    //使用类型id
    private Integer usageId;
    //使用类型
    private String usageName;
    //抛弃型分类id
    private Integer typeId;
    // 抛弃类型
    private String typeName;
    //产品可使用天数
    private Integer useDays;
    //效期提醒上限（有效期前【】天提醒进入滞销状态）
    private Integer upday;
    //效期提醒下限（有效期前【】天提醒进入即将失效状态）
    private Double downday;
    //颜色
    private String color;
    //隐形类别id
    private Long invisibleId;
    //材质id
    private Long caizhiId;
    //联合光度【格式：1.25】
    private String combinedPhotometry;
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
     * 设置：隐形定做id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：隐形定做id
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
     * 设置：跨度id
     */
    public void setSpanId(Long spanId) {
        this.spanId = spanId;
    }

    /**
     * 获取：跨度id
     */
    public Long getSpanId() {
        return spanId;
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
     * 设置：球镜上限
     */
    public void setSphUp(Long sphUp) {
        this.sphUp = sphUp;
    }

    /**
     * 获取：球镜上限
     */
    public Long getSphUp() {
        return sphUp;
    }

    /**
     * 设置：球镜下限
     */
    public void setSphDown(Long sphDown) {
        this.sphDown = sphDown;
    }

    /**
     * 获取：球镜下限
     */
    public Long getSphDown() {
        return sphDown;
    }

    /**
     * 设置：球镜跨度
     */
    public void setSphSpan(Long sphSpan) {
        this.sphSpan = sphSpan;
    }

    /**
     * 获取：球镜跨度
     */
    public Long getSphSpan() {
        return sphSpan;
    }

    /**
     * 设置：柱镜上限
     */
    public void setCylUp(Long cylUp) {
        this.cylUp = cylUp;
    }

    /**
     * 获取：柱镜上限
     */
    public Long getCylUp() {
        return cylUp;
    }

    /**
     * 设置：柱镜下限
     */
    public void setCylDown(Long cylDown) {
        this.cylDown = cylDown;
    }

    /**
     * 获取：柱镜下限
     */
    public Long getCylDown() {
        return cylDown;
    }

    /**
     * 设置：柱镜跨度
     */
    public void setCylSpan(Long cylSpan) {
        this.cylSpan = cylSpan;
    }

    /**
     * 获取：柱镜跨度
     */
    public Long getCylSpan() {
        return cylSpan;
    }

    /**
     * 设置：曲率1
     */
    public void setCurvatureOne(String curvatureOne) {
        this.curvatureOne = curvatureOne;
    }

    /**
     * 获取：曲率1
     */
    public String getCurvatureOne() {
        return curvatureOne;
    }

    /**
     * 设置：-曲率1
     */
    public void setCurvatureYi(String curvatureYi) {
        this.curvatureYi = curvatureYi;
    }

    /**
     * 获取：-曲率1
     */
    public String getCurvatureYi() {
        return curvatureYi;
    }

    /**
     * 设置：曲率2
     */
    public void setCurvatureTwo(String curvatureTwo) {
        this.curvatureTwo = curvatureTwo;
    }

    /**
     * 获取：曲率2
     */
    public String getCurvatureTwo() {
        return curvatureTwo;
    }

    /**
     * 设置：-曲率2
     */
    public void setCurvatureEr(String curvatureEr) {
        this.curvatureEr = curvatureEr;
    }

    /**
     * 获取：-曲率2
     */
    public String getCurvatureEr() {
        return curvatureEr;
    }

    public String getDiameterOne() {
        return diameterOne;
    }

    public void setDiameterOne(String diameterOne) {
        this.diameterOne = diameterOne;
    }

    public String getDiameterYi() {
        return diameterYi;
    }

    public void setDiameterYi(String diameterYi) {
        this.diameterYi = diameterYi;
    }

    /**
     * 设置：接触镜类别
     */
    public void setContactLens(String contactLens) {
        this.contactLens = contactLens;
    }

    /**
     * 获取：接触镜类别
     */
    public String getContactLens() {
        return contactLens;
    }

    /**
     * 设置：定做周期（天）
     */
    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    /**
     * 获取：定做周期（天）
     */
    public Long getCycle() {
        return cycle;
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
    public void setDownday(Double downday) {
        this.downday = downday;
    }

    /**
     * 获取：效期提醒下限（有效期前【】天提醒进入即将失效状态）
     */
    public Double getDownday() {
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
     * 设置：联合光度
     */
    public void setCombinedPhotometry(String combinedPhotometry) {
        this.combinedPhotometry = combinedPhotometry;
    }

    /**
     * 获取：联合光度
     */
    public String getCombinedPhotometry() {
        return combinedPhotometry;
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

    public void setUsageName(String usageName){ this.usageName = usageName; }

    public String getUsageName(){return usageName;}

    public void setTypeName(String typeName){this.typeName=typeName;}

    public String getTypeName(){return typeName;}
}
