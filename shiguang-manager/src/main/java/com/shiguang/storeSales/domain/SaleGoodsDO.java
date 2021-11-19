package com.shiguang.storeSales.domain;

import java.io.Serializable;

public class SaleGoodsDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //商品代码
    private String goodsNum;
    //商品条码
    private String goodsCode;
    //商品名称
    private String goodsName;
    //商品标识
    private String goodsbs;
    //销售数量
    private String saleCount;
    //订做还是成品
    private String classType;

    public void setGoodsNum(String goodsNum){this.goodsNum = goodsNum;}

    public String getGoodsNum() {return goodsNum;}

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode;}

    public String getGoodsCode() {return goodsCode;}

    public void setGoodsName(String goodsName){this.goodsName = goodsName;}

    public String getGoodsName() {return goodsName;}

    public void setSaleCount(String saleCount){this.saleCount = saleCount;}

    public String getSaleCount() {return saleCount;}

    public String getGoodsbs() {
        return goodsbs;
    }

    public void setGoodsbs(String goodsbs) {
        this.goodsbs = goodsbs;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
