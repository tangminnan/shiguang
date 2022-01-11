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
    private String mfrsname;
    //商品品种（品牌id
    private Integer brandid;
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
    private String sphUp;
    //球镜下限
    private String sphDown;
    //球镜区间
    private String sphqj;
    //球镜跨度
    private String sphSpan;
    //柱镜上限
    private String cylUp;
    //柱镜下限
    private String cylDown;
    //柱镜区间
    private String cylqj;
    //柱镜跨度
    private String cylSpan;
    //下加光id
    private Long lightbelowId;
    //下加光
    private String lightbelow;
    //下加光左
    private String lightbelowRight;
    //下加光右
    private String lightbelowLeft;
    //下加光区间
    private String lightbelowqj;
    //材料分类id
    private Integer lensId;
    //材料分类
    private String lensName;
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
    private String gradualName;
    //折射率id
    private String refractivityid;
    //折射率
    private String refractivityvalue;
    //镜片功能id
    private Integer functionId;
    //镜片功能名称
    private String functionName;
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
    //状态（0：启用1：停用）
    private Long xsstate;
    //状态(0:删除1:未删除)
    private Long state;
    private  String classtype;

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }
    //盘盈盘亏的商品数量
    private String inventoryCount;
    public void setInventoryCount(String inventoryCount){this.inventoryCount = inventoryCount;}
    public String getInventoryCount() {return inventoryCount;}

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

    public String getViewGoodName() {
        return viewGoodName;
    }

    public void setViewGoodName(String viewGoodName) {
        this.viewGoodName = viewGoodName;
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
    public void setSphUp(String sphUp) {
        this.sphUp = sphUp;
    }

    /**
     * 获取：球镜上限
     */
    public String getSphUp() {
        return sphUp;
    }

    /**
     * 设置：球镜下限
     */
    public void setSphDown(String sphDown) {
        this.sphDown = sphDown;
    }

    /**
     * 获取：球镜下限
     */
    public String getSphDown() {
        return sphDown;
    }

    /**
     * 设置：球镜跨度
     */
    public void setSphSpan(String sphSpan) {
        this.sphSpan = sphSpan;
    }

    /**
     * 获取：球镜跨度
     */
    public String getSphSpan() {
        return sphSpan;
    }

    /**
     * 设置：柱镜上限
     */
    public void setCylUp(String cylUp) {
        this.cylUp = cylUp;
    }

    /**
     * 获取：柱镜上限
     */
    public String getCylUp() {
        return cylUp;
    }

    /**
     * 设置：柱镜下限
     */
    public void setCylDown(String cylDown) {
        this.cylDown = cylDown;
    }

    /**
     * 获取：柱镜下限
     */
    public String getCylDown() {
        return cylDown;
    }

    /**
     * 设置：柱镜跨度
     */
    public void setCylSpan(String cylSpan) {
        this.cylSpan = cylSpan;
    }

    /**
     * 获取：柱镜跨度
     */
    public String getCylSpan() {
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
    public void setLightbelowRight(String lightbelowRight) {
        this.lightbelowRight = lightbelowRight;
    }

    /**
     * 获取：下加光左
     */
    public String getLightbelowRight() {
        return lightbelowRight;
    }

    /**
     * 设置：下加光右
     */
    public void setLightbelowLeft(String lightbelowLeft) {
        this.lightbelowLeft = lightbelowLeft;
    }

    /**
     * 获取：下加光右
     */
    public String getLightbelowLeft() {
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
    public void setRefractivityid(String refractivityid) {
        this.refractivityid = refractivityid;
    }

    /**
     * 获取：折射率id
     */
    public String getRefractivityid() {
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

    /**
     * 设置：状态(0：启用1：停用)
     */
    public Long getXsstate() {
        return xsstate;
    }

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

    public String getLightbelow() {
        return lightbelow;
    }

    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
    }

    public String getLightbelowqj() {
        return lightbelowqj;
    }

    public void setLightbelowqj(String lightbelowqj) {
        this.lightbelowqj = lightbelowqj;
    }

    public String getLensName() {
        return lensName;
    }

    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getGradualName() {
        return gradualName;
    }

    public void setGradualName(String gradualName) {
        this.gradualName = gradualName;
    }

    public String getRefractivityvalue() {
        return refractivityvalue;
    }

    public void setRefractivityvalue(String refractivityvalue) {
        this.refractivityvalue = refractivityvalue;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setState(Long state) {
        this.state = state;
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
