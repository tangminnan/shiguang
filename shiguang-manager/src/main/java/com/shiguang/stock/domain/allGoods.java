package com.shiguang.stock.domain;

import java.io.Serializable;


/**
 * 所有的商品
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-09 11:08:27
 */
public class allGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer goodsid;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    //商品信息id(镜架
    private Long id;
    //商品信息代码
    private String producNum;
    //商品条码
    private String producCode;
    //商品名称
    private String producName;
    //制造商id
    private Integer mfrsid;
    //制造商
    private String mfrsname;
    //商品品种（品牌id
    private Integer brandid;
    //品牌
    private String brandname;
    //厂家型号（品牌维护中有）
    private String factory;
    //型号
    private String producFactory;
    //厂家色号
    private String producFactorycolor;
    //色号
    private String producColor;
    //计量单位
    private Integer unitid;
    //单位
    private String unitname;
    //批号管理(1是、2否)
    private Integer batchid;
    //镜架尺寸
    private String size;
    //工艺类型id
    private Long technologyId;
    //镜架材质id
    private Integer materialid;
    //镜架材质
    private String materialName;
    //颜色
    private String color;
    //款式id
    private Long styleId;
    //采购年份(年份后两位+两位月份)
    private String year;
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
    private Long status;
    //状态(0:删除1:未删除)
    private Long state;
    //商品编号
    private String proid;
    //配件型
    private String partsStyle;
    //折射率id
    private Integer refractivityid;
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
    //光度分类id
    private Integer lightId;
    //光度分类
    private String light;
    //渐进片分类id
    private Integer gradualId;
    //折射率
    private String refractivity;
    //镜片功能id
    private Integer functionId;
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
    //下加光左
    private Long lightbelowRight;
    //下加光右
    private Long lightbelowLeft;
    //下加光区间
    private String lightbelowqj;
    //定做周期（天）
    private Long cycle;
    private String lightName;
    //渐进片分类名称
    private String gradual;
    //镜片功能名称
    private String function;
    //联合光度【格式：1.25】
    private String combinedPhotometry;
    //柱镜为-0.25度（-25散）（1能：2不能）
    private String can;
    //曲率
    private String curvature;
    //直径
    private String diameter;

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
    //隐形类别id
    private Long invisibleId;
    //材质id
    private Long caizhiId;
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
    //使用类型
    private String usageName;
    // 抛弃类型
    private String typeName;
    //产品类型
    private String productType;
    //主容量
    private String mainCapacity;
    //次容量
    private String secondCapacity;
    //其他商品大类
    private String big;
    //其他商品小类
    private String small;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducNum() {
        return producNum;
    }

    public void setProducNum(String producNum) {
        this.producNum = producNum;
    }

    public String getProducCode() {
        return producCode;
    }

    public void setProducCode(String producCode) {
        this.producCode = producCode;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public Integer getMfrsid() {
        return mfrsid;
    }

    public void setMfrsid(Integer mfrsid) {
        this.mfrsid = mfrsid;
    }

    public String getMfrsname() {
        return mfrsname;
    }

    public void setMfrsname(String mfrsname) {
        this.mfrsname = mfrsname;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getProducFactory() {
        return producFactory;
    }

    public void setProducFactory(String producFactory) {
        this.producFactory = producFactory;
    }

    public String getProducFactorycolor() {
        return producFactorycolor;
    }

    public void setProducFactorycolor(String producFactorycolor) {
        this.producFactorycolor = producFactorycolor;
    }

    public String getProducColor() {
        return producColor;
    }

    public void setProducColor(String producColor) {
        this.producColor = producColor;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public Integer getBatchid() {
        return batchid;
    }

    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(String taxPrice) {
        this.taxPrice = taxPrice;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getPartsStyle() {
        return partsStyle;
    }

    public void setPartsStyle(String partsStyle) {
        this.partsStyle = partsStyle;
    }

    public Integer getRefractivityid() {
        return refractivityid;
    }

    public void setRefractivityid(Integer refractivityid) {
        this.refractivityid = refractivityid;
    }

    public Long getSphId() {
        return sphId;
    }

    public void setSphId(Long sphId) {
        this.sphId = sphId;
    }

    public String getSph() {
        return sph;
    }

    public void setSph(String sph) {
        this.sph = sph;
    }

    public Long getCylId() {
        return cylId;
    }

    public void setCylId(Long cylId) {
        this.cylId = cylId;
    }

    public String getCyl() {
        return cyl;
    }

    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    public Long getLightbelowId() {
        return lightbelowId;
    }

    public void setLightbelowId(Long lightbelowId) {
        this.lightbelowId = lightbelowId;
    }

    public String getLightbelow() {
        return lightbelow;
    }

    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
    }

    public Integer getLensId() {
        return lensId;
    }

    public void setLensId(Integer lensId) {
        this.lensId = lensId;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public Integer getLightId() {
        return lightId;
    }

    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public Integer getGradualId() {
        return gradualId;
    }

    public void setGradualId(Integer gradualId) {
        this.gradualId = gradualId;
    }

    public String getRefractivity() {
        return refractivity;
    }

    public void setRefractivity(String refractivity) {
        this.refractivity = refractivity;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Long getSphUp() {
        return sphUp;
    }

    public void setSphUp(Long sphUp) {
        this.sphUp = sphUp;
    }

    public Long getSphDown() {
        return sphDown;
    }

    public void setSphDown(Long sphDown) {
        this.sphDown = sphDown;
    }

    public String getSphqj() {
        return sphqj;
    }

    public void setSphqj(String sphqj) {
        this.sphqj = sphqj;
    }

    public Long getSphSpan() {
        return sphSpan;
    }

    public void setSphSpan(Long sphSpan) {
        this.sphSpan = sphSpan;
    }

    public Long getCylUp() {
        return cylUp;
    }

    public void setCylUp(Long cylUp) {
        this.cylUp = cylUp;
    }

    public Long getCylDown() {
        return cylDown;
    }

    public void setCylDown(Long cylDown) {
        this.cylDown = cylDown;
    }

    public String getCylqj() {
        return cylqj;
    }

    public void setCylqj(String cylqj) {
        this.cylqj = cylqj;
    }

    public Long getCylSpan() {
        return cylSpan;
    }

    public void setCylSpan(Long cylSpan) {
        this.cylSpan = cylSpan;
    }

    public Long getLightbelowRight() {
        return lightbelowRight;
    }

    public void setLightbelowRight(Long lightbelowRight) {
        this.lightbelowRight = lightbelowRight;
    }

    public Long getLightbelowLeft() {
        return lightbelowLeft;
    }

    public void setLightbelowLeft(Long lightbelowLeft) {
        this.lightbelowLeft = lightbelowLeft;
    }

    public String getLightbelowqj() {
        return lightbelowqj;
    }

    public void setLightbelowqj(String lightbelowqj) {
        this.lightbelowqj = lightbelowqj;
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public String getGradual() {
        return gradual;
    }

    public void setGradual(String gradual) {
        this.gradual = gradual;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCombinedPhotometry() {
        return combinedPhotometry;
    }

    public void setCombinedPhotometry(String combinedPhotometry) {
        this.combinedPhotometry = combinedPhotometry;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public String getCurvature() {
        return curvature;
    }

    public void setCurvature(String curvature) {
        this.curvature = curvature;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUseDays() {
        return useDays;
    }

    public void setUseDays(Integer useDays) {
        this.useDays = useDays;
    }

    public Integer getUpday() {
        return upday;
    }

    public void setUpday(Integer upday) {
        this.upday = upday;
    }

    public Integer getDownday() {
        return downday;
    }

    public void setDownday(Integer downday) {
        this.downday = downday;
    }

    public Long getInvisibleId() {
        return invisibleId;
    }

    public void setInvisibleId(Long invisibleId) {
        this.invisibleId = invisibleId;
    }

    public Long getCaizhiId() {
        return caizhiId;
    }

    public void setCaizhiId(Long caizhiId) {
        this.caizhiId = caizhiId;
    }

    public String getCurvatureOne() {
        return curvatureOne;
    }

    public void setCurvatureOne(String curvatureOne) {
        this.curvatureOne = curvatureOne;
    }

    public String getCurvatureYi() {
        return curvatureYi;
    }

    public void setCurvatureYi(String curvatureYi) {
        this.curvatureYi = curvatureYi;
    }

    public String getCurvatureTwo() {
        return curvatureTwo;
    }

    public void setCurvatureTwo(String curvatureTwo) {
        this.curvatureTwo = curvatureTwo;
    }

    public String getCurvatureEr() {
        return curvatureEr;
    }

    public void setCurvatureEr(String curvatureEr) {
        this.curvatureEr = curvatureEr;
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

    public String getContactLens() {
        return contactLens;
    }

    public void setContactLens(String contactLens) {
        this.contactLens = contactLens;
    }

    public String getUsageName() {
        return usageName;
    }

    public void setUsageName(String usageName) {
        this.usageName = usageName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMainCapacity() {
        return mainCapacity;
    }

    public void setMainCapacity(String mainCapacity) {
        this.mainCapacity = mainCapacity;
    }

    public String getSecondCapacity() {
        return secondCapacity;
    }

    public void setSecondCapacity(String secondCapacity) {
        this.secondCapacity = secondCapacity;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
