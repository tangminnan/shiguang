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



    //商品编号
    private String proid;
    //计量单位
    private Integer unitid;
    //单位
    private String unitname;
    //球镜id
    private String sphId;
    //球镜名称
    private String sph;
    //柱镜id
    private String cylId;
    //柱镜名称
    private String cyl;
    //下加光id
    private String lightbelowId;
    //下加光名称
    private String lightbelow;
    //材料分类id
    private Integer lensId;
    //材料分类
    private String lensName;
    //批号管理(1是、2否)
    private String batchid;
    //光度分类id
    private Integer lightId;
    //光度分类
    private String lightName;
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
    //型号
    private String producFactory;

    public String getProducFactory() {
        return producFactory;
    }

    public void setProducFactory(String producFactory) {
        this.producFactory = producFactory;
    }
    //盘盈盘亏的商品数量
    private String inventoryCount;
    public void setInventoryCount(String inventoryCount){this.inventoryCount = inventoryCount;}
    public String getInventoryCount() {return inventoryCount;}


    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    private String goodsid;

    public String getBrandnum() {
        return brandnum;
    }

    public void setBrandnum(String brandnum) {
        this.brandnum = brandnum;
    }
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

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    /**
     * 获取：计量单位
     */
    public Integer getUnitid() {
        return unitid;
    }

    public String getUnitname() {
        return unitname;
    }


    /**
     * 设置：球镜id
     */
    public void setSphId(String sphId) {
        this.sphId = sphId;
    }

    /**
     * 获取：球镜id
     */
    public String getSphId() {
        return sphId;
    }

    /**
     * 设置：柱镜id
     */
    public void setCylId(String cylId) {
        this.cylId = cylId;
    }

    /**
     * 获取：柱镜id
     */
    public String getCylId() {
        return cylId;
    }

    /**
     * 设置：下加光id
     */
    public void setLightbelowId(String lightbelowId) {
        this.lightbelowId = lightbelowId;
    }

    /**
     * 获取：下加光id
     */
    public String getLightbelowId() {
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

    public String getLightbelow() {
        return lightbelow;
    }

    public void setLightbelow(String lightbelow) {
        this.lightbelow = lightbelow;
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
    //医疗器械经营许可证号
    private String medicinecode;

    public String getMedicinecode() {
        return medicinecode;
    }

    public void setMedicinecode(String medicinecode) {
        this.medicinecode = medicinecode;
    }
}
