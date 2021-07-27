package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 镜片定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
public class JpdzDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //镜片定做id
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
    private Integer unitid;
    //单位
    private String unitname;
    //球镜id
    private Long sphId;
    private String sph;
    //跨度id
    private Long spanId;
    //柱镜id
    private Long cylId;
    private String cyl;
    //球镜上限
    private Long sphUp;
    //球镜下限
    private Long sphDown;
    //球镜区间
    private String sphqj;
    //球镜跨度
    private Long sphSpan;
    //柱镜上限
    private Long cylUp;
    //柱镜下限
    private Long cylDown;
    //柱镜区间
    private String cylqj;
    //柱镜跨度
    private Long cylSpan;
    //下加光id
    private Long lightbelowId;
    //下加光
    private String lightbelow;
    //下加光左
    private Long lightbelowRight;
    //下加光右
    private Long lightbelowLeft;
    //下加光区间
    private String lightbelowqj;
    //材料分类id
    private Integer lensId;
    //材料分类
    private String lens;
    //定做周期（天）
    private Long cycle;
    //光度分类id
    private Integer lightId;
    private String lightName;
    //光度分类
    private String light;
    //渐进片分类id
    private Integer gradualId;
    //渐进片分类名称
    private String gradual;
    //折射率id
    private Integer refractivityid;
    //折射率
    private String refractivity;
    //镜片功能id
    private Integer functionId;
    //镜片功能名称
    private String function;
    //联合光度【格式：1.25】
    private String combinedPhotometry;
    //柱镜为-0.25度（-25散）（1能：2不能）
    private String can;
    //税率(%)
    private String tax;
    //含税单价
    private String taxPrice;
    //批发价格
    private String tradePrice;
    //调货成本
    private String transferPrice;
    //标准零售价
    private String retailPrice;

    /**
     * 设置：镜片定做id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：镜片定做id
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
     * 设置：下加光左
     */
    public void setLightbelowRight(Long lightbelowRight) {
        this.lightbelowRight = lightbelowRight;
    }

    /**
     * 获取：下加光左
     */
    public Long getLightbelowRight() {
        return lightbelowRight;
    }

    /**
     * 设置：下加光右
     */
    public void setLightbelowLeft(Long lightbelowLeft) {
        this.lightbelowLeft = lightbelowLeft;
    }

    /**
     * 获取：下加光右
     */
    public Long getLightbelowLeft() {
        return lightbelowLeft;
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
     * 设置：联合光度【格式：1.25】
     */
    public void setCombinedPhotometry(String combinedPhotometry) {
        this.combinedPhotometry = combinedPhotometry;
    }

    /**
     * 获取：联合光度【格式：1.25】
     */
    public String getCombinedPhotometry() {
        return combinedPhotometry;
    }

    /**
     * 设置：柱镜为-0.25度（-25散）（1能：2不能）
     */
    public void setCan(String can) {
        this.can = can;
    }

    /**
     * 获取：柱镜为-0.25度（-25散）（1能：2不能）
     */
    public String getCan() {
        return can;
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
     * 设置：标准零售价
     */
    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取：标准零售价
     */
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

    public String getSphqj() {
        return sphqj;
    }

    public void setSphqj(String sphqj) {
        this.sphqj = sphqj;
    }

    public String getCylqj() {
        return cylqj;
    }

    public void setCylqj(String cylqj) {
        this.cylqj = cylqj;
    }

    public String getLightbelowqj() {
        return lightbelowqj;
    }

    public void setLightbelowqj(String lightbelowqj) {
        this.lightbelowqj = lightbelowqj;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getGradual() {
        return gradual;
    }

    public void setGradual(String gradual) {
        this.gradual = gradual;
    }

    public String getRefractivity() {
        return refractivity;
    }

    public void setRefractivity(String refractivity) {
        this.refractivity = refractivity;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public String getLightbelow() {
        return lightbelow;
    }

    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
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

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }
}
