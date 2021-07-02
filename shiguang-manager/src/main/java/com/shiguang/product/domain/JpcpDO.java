package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 镜片成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
public class JpcpDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //镜片成品id
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
    //球镜名称
    private String sph;
    //柱镜id
    private Long cylId;
    //柱镜名称
    private String cyl;
    //下加光id
    private Long lightbelowId;
    //下加光名称
    private String lightbelow;
    //材料分类id
    private Integer lensId;
    //材料分类
    private String lens;
    //批号管理(1是、2否)
    private String batchid;
    //光度分类id
    private Integer lightId;
    //光度分类
    private String light;
    //渐进片分类id
    private Integer gradualId;
    //折射率id
    private Integer refractivityid;
    //折射率
    private String refractivity;
    //镜片功能id
    private Integer functionId;
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
     * 设置：镜片成品id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：镜片成品id
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
     * 设置：下加光id
     */
    public void setLightbelowId(Long lightbelowId) {
        this.lightbelowId = lightbelowId;
    }

    /**
     * 获取：下加光id
     */
    public Long getLightbelowId() {
        return lightbelowId;
    }

    /**
     * 设置：材料分类id
     */
    public void setLensId(Integer lensId) {
        this.lensId = lensId;
    }

    /**
     * 获取：材料分类id
     */
    public Integer getLensId() {
        return lensId;
    }

    /**
     * 设置：批号管理(1是、2否)
     */
    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    /**
     * 获取：批号管理(1是、2否)
     */
    public String getBatchid() {
        return batchid;
    }

    /**
     * 设置：光度分类id
     */
    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    /**
     * 获取：光度分类id
     */
    public Integer getLightId() {
        return lightId;
    }

    /**
     * 设置：渐进片分类id
     */
    public void setGradualId(Integer gradualId) {
        this.gradualId = gradualId;
    }

    /**
     * 获取：渐进片分类id
     */
    public Integer getGradualId() {
        return gradualId;
    }

    /**
     * 设置：折射率id
     */
    public void setRefractivityid(Integer refractivityid) {
        this.refractivityid = refractivityid;
    }

    /**
     * 获取：折射率id
     */
    public Integer getRefractivityid() {
        return refractivityid;
    }

    /**
     * 设置：镜片功能id
     */
    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    /**
     * 获取：镜片功能id
     */
    public Integer getFunctionId() {
        return functionId;
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

    public String getSph() {
        return sph;
    }

    public void setSph(String sph) {
        this.sph = sph;
    }

    public String getCyl() {
        return cyl;
    }

    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    public String getLens() { return lens; }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getLightbelow() { return lightbelow; }

    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
    }

    public String getLight() { return light; }

    public void setLight(String light) {
        this.light = light;
    }

    public String getRefractivity() { return refractivity; }

    public void setRefractivity(String refractivity) {
        this.refractivity = refractivity;
    }
}
