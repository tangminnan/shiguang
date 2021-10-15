package com.shiguang.stock.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 库存表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-09 11:08:27
 */
public class StockDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //收货状态
    private String status;
    //工号
    private String  username;
    //商品信息id
    private String goodsxinxiid;

    public String getGoodsxinxiid() {
        return goodsxinxiid;
    }

    public void setGoodsxinxiid(String goodsxinxiid) {
        this.goodsxinxiid = goodsxinxiid;
    }

    //商品代码
    private String goodsNum;
    //商品条码
    private String goodsCode;
    //商品名称
    private String goodsName;
    //数量
    private String goodsCount;
    //商品类别
    private Integer goodsType;
    private String gdname;
    private Integer goodsid;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGdname() {
        return gdname;
    }

    public void setGdname(String gdname) {
        this.gdname = gdname;
    }
    //退回状态
    private String returnzt;

    public String getReturnzt() {
        return returnzt;
    }

    public void setReturnzt(String returnzt) {
        this.returnzt = returnzt;
    }

    //制造商id
    private String mfrsid;
    private String mfrsname;

    public String getMfrsname() {
        return mfrsname;
    }

    public void setMfrsname(String mfrsname) {
        this.mfrsname = mfrsname;
    }
    private  String brandname;

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    //标准零售价格
    private String retailPrice;
    //原价合计
    private String priceSum;
    //成本价格
    private String costPrice;
    //成本合计
    private String costSum;
    //批发价格
    private String wholePrice;
    //批发合计
    private String wholeSum;
    //仓位id
    private  String positionId;
    //部门
    private String departNumber;

    public String getDepartNumber() {
        return departNumber;
    }

    public void setDepartNumber(String departNumber) {
        this.departNumber = departNumber;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    //仓位名称
    private String positionName;
    //入库时间
    private String createTime;
    //单据编号
    private String danjuNumber;
    //订单编号
    private String orderNumber;
    //运单号
    private String yundanNumber;
    //制单人
    private String zhidanPeople;
    //单据日期
    private String danjuDay;
    //退货单号
    private String tuihuoNumber;
    //厂家订单号
    private String factoryNumber;
    //备注
    private String beizhu;
    //单位
    private String unit;
    //调货成本
    private String transferPrice;
    //调货成本合计
    private String transferPricecount;

    public String getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice;
    }

    public String getTransferPricecount() {
        return transferPricecount;
    }

    public void setTransferPricecount(String transferPricecount) {
        this.transferPricecount = transferPricecount;
    }
    //批号
    private String batch;
    //注册证号
    private String zhuceNumber;
    //生产日期
    private String produceDay;
    //效期
    private String useday;

    //尺寸
    private String size;
    //型号
    private String producFactory;
    //球镜
    private String sph;
    //柱镜
    private String cyl;
    //下加光
    private String lightbelow;
    //折射率
    private String refractivityvalue;
    //光度分类
    private String lightName;
    //材料分类
    private String lensName;

    //材质
    private String materialName;
    //镜片功能
    private String functionName;
    //渐进片分类
    private String gradualName;
    //配件型
    private String partsStyle;
    //球镜上限
    private String sphUp;
    //球镜下限
    private String sphDown;
    //球镜区间
    private String sphqj;
    //柱镜上限
    private String cylUp;
    //柱镜下限
    private String cylDown;
    //柱镜区间
    private String cylqj;
    //下加光左
    private String lightbelowRight;
    //下加光右
    private String lightbelowLeft;
    //下加光区间
    private String lightbelowqj;
    //色号
    private String producColor;
    //主容量
    private String mainCapacity;
    //次容量
    private String secondCapacity;
    //赠品名称
    private String giftName;
    // 抛弃类型
    private String typeName;
    //使用类型
    private String usageName;
    //曲率1
    private String curvatureOne;
    //-曲率1
    private String curvatureYi;
    //曲率2
    private String curvatureTwo;
    //-曲率2
    private String curvatureEr;
    //定做周期（天）
    private Long cycle;
    private  String classtype;
    //左右眼
    private String leftRight;

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public void setLeftRight(String leftRight){this.leftRight = leftRight;}

    public String getLeftRight(){return leftRight;}

    /**
     * 设置：主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 设置：商品代码
     */
    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 获取：商品代码
     */
    public String getGoodsNum() {
        return goodsNum;
    }

    /**
     * 设置：商品条码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    /**
     * 获取：商品条码
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 设置：商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取：商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置：数量
     */
    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * 获取：数量
     */
    public String getGoodsCount() {
        return goodsCount;
    }

    /**
     * 设置：商品类别
     */
    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 获取：商品类别
     */
    public Integer getGoodsType() {
        return goodsType;
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
     * 设置：原价合计
     */
    public void setPriceSum(String priceSum) {
        this.priceSum = priceSum;
    }

    /**
     * 获取：原价合计
     */
    public String getPriceSum() {
        return priceSum;
    }

    /**
     * 设置：成本价格
     */
    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取：成本价格
     */
    public String getCostPrice() {
        return costPrice;
    }

    /**
     * 设置：成本合计
     */
    public void setCostSum(String costSum) {
        this.costSum = costSum;
    }

    /**
     * 获取：成本合计
     */
    public String getCostSum() {
        return costSum;
    }

    /**
     * 设置：批发价格
     */
    public void setWholePrice(String wholePrice) {
        this.wholePrice = wholePrice;
    }

    /**
     * 获取：批发价格
     */
    public String getWholePrice() {
        return wholePrice;
    }

    /**
     * 设置：批发合计
     */
    public void setWholeSum(String wholeSum) {
        this.wholeSum = wholeSum;
    }

    /**
     * 获取：批发合计
     */
    public String getWholeSum() {
        return wholeSum;
    }

    /**
     * 设置：仓位名称
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * 获取：仓位名称
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 设置：单据编号
     */
    public void setDanjuNumber(String danjuNumber) {
        this.danjuNumber = danjuNumber;
    }

    /**
     * 获取：单据编号
     */
    public String getDanjuNumber() {
        return danjuNumber;
    }

    /**
     * 设置：订单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取：订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置：运单号
     */
    public void setYundanNumber(String yundanNumber) {
        this.yundanNumber = yundanNumber;
    }

    /**
     * 获取：运单号
     */
    public String getYundanNumber() {
        return yundanNumber;
    }

    /**
     * 设置：制单人
     */
    public void setZhidanPeople(String zhidanPeople) {
        this.zhidanPeople = zhidanPeople;
    }

    /**
     * 获取：制单人
     */
    public String getZhidanPeople() {
        return zhidanPeople;
    }

    /**
     * 设置：单据日期
     */
    public void setDanjuDay(String danjuDay) {
        this.danjuDay = danjuDay;
    }

    /**
     * 获取：单据日期
     */
    public String getDanjuDay() {
        return danjuDay;
    }

    /**
     * 设置：退货单号
     */
    public void setTuihuoNumber(String tuihuoNumber) {
        this.tuihuoNumber = tuihuoNumber;
    }

    /**
     * 获取：退货单号
     */
    public String getTuihuoNumber() {
        return tuihuoNumber;
    }

    /**
     * 设置：厂家订单号
     */
    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    /**
     * 获取：厂家订单号
     */
    public String getFactoryNumber() {
        return factoryNumber;
    }

    /**
     * 设置：备注
     */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    /**
     * 获取：备注
     */
    public String getBeizhu() {
        return beizhu;
    }
    /**
     * 设置：批号
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }
    /**
     * 获取：批号
     */
    public String getBatch() {
        return batch;
    }
    /**
     * 设置：注册证号
     */
    public void setZhuceNumber(String zhuceNumber) {
        this.zhuceNumber = zhuceNumber;
    }
    /**
     * 获取：注册证号
     */
    public String getZhuceNumber() {
        return zhuceNumber;
    }
    /**
     * 设置：生产日期
     */
    public void setProduceDay(String produceDay) {
        this.produceDay = produceDay;
    }
    /**
     * 获取：生产日期
     */
    public String getProduceDay() {
        return produceDay;
    }
    /**
     * 设置：效期
     */
    public void setUseday(String useday) {
        this.useday = useday;
    }
    /**
     * 获取：效期
     */
    public String getUseday() {
        return useday;
    }

    /**
     * 设置：尺寸
     */
    public void setSize(String size) {
        this.size = size;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    /**
     * 获取：尺寸
     */
    public String getSize() {
        return size;
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
     * 设置：球镜
     */
    public void setSph(String sph) {
        this.sph = sph;
    }

    /**
     * 获取：球镜
     */
    public String getSph() {
        return sph;
    }

    /**
     * 设置：柱镜
     */
    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    /**
     * 获取：柱镜
     */
    public String getCyl() {
        return cyl;
    }

    /**
     * 设置：下加光
     */
    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
    }

    /**
     * 获取：下加光
     */
    public String getLightbelow() {
        return lightbelow;
    }

    /**
     * 设置：折射率
     */
    public void setRefractivityvalue(String refractivityvalue) {
        this.refractivityvalue = refractivityvalue;
    }

    /**
     * 获取：折射率
     */
    public String getRefractivityvalue() {
        return refractivityvalue;
    }

    /**
     * 设置：光度分类
     */
    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    /**
     * 获取：光度分类
     */
    public String getLightName() {
        return lightName;
    }

    /**
     * 设置：材料分类
     */
    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    /**
     * 获取：材料分类
     */
    public String getLensName() {
        return lensName;
    }

    /**
     * 设置：入库时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：入库时间
     */
    public String getCreateTime() {
        return createTime;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setGradualName(String gradualName) {
        this.gradualName = gradualName;
    }

    public String getGradualName() {
        return gradualName;
    }

    public void setPartsStyle(String partsStyle) {
        this.partsStyle = partsStyle;
    }

    public String getPartsStyle() {
        return partsStyle;
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

    public void setLightbelowqj(String lightbelowqj) {
        this.lightbelowqj = lightbelowqj;
    }

    public String getLightbelowqj() {
        return lightbelowqj;
    }

    public void setProducColor(String producColor) {
        this.producColor = producColor;
    }

    public String getProducColor() {
        return producColor;
    }

    /**
     * 设置：主容量
     */
    public void setMainCapacity(String mainCapacity) {
        this.mainCapacity = mainCapacity;
    }

    /**
     * 获取：主容量
     */
    public String getMainCapacity() {
        return mainCapacity;
    }

    /**
     * 设置：次容量
     */
    public void setSecondCapacity(String secondCapacity) {
        this.secondCapacity = secondCapacity;
    }

    /**
     * 获取：次容量
     */
    public String getSecondCapacity() {
        return secondCapacity;
    }

    /**
     * 设置：赠品名称
     */
    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    /**
     * 获取：赠品名称
     */
    public String getGiftName() {
        return giftName;
    }

    public void setUsageName(String usageName) {
        this.usageName = usageName;
    }

    public String getUsageName() {
        return usageName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
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
    private String factory;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    private String producFactorycolor;
    private String materialname;
    private String count;
    private String style;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProducFactorycolor() {
        return producFactorycolor;
    }

    public void setProducFactorycolor(String producFactorycolor) {
        this.producFactorycolor = producFactorycolor;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }


//、、、、、、、、采购入库、、、、、、、、、、、、、、
    private String producNum;
    //商品条码
    private String producCode;
    //商品名称
    private String producName;
    //制造商id
//    private String mfrsid;
    //制造商
//    private String mfrsname;
    //商品品种（品牌id
    private Integer brandid;
    //品牌
//    private String brandname;
    private String brandnum;
    //型号
//    private String producFactory;

    //计量单位
    private Integer unitid;
    //单位
    private String unitname;
    //标准零售价格
//    private String retailPrice;
    //镜片类型
//    private String classtype;


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

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getBrandnum() {
        return brandnum;
    }

    public void setBrandnum(String brandnum) {
        this.brandnum = brandnum;
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
}
