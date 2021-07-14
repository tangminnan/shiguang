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
	//商品代码
	private String goodsNum;
	//商品条码
	private String goodsCode;
	//商品名称
	private String goodsName;
	//数量
	private Long goodsCount;
	//商品类别
	private String goodsType;
	//
	private Integer mfrsid;
	//标准零售价格
	private Double retailPrice;
	//原价合计
	private Double priceSum;
	//成本价格
	private Double costPrice;
	//成本合计
	private Double costSum;
	//批发价格
	private Double wholePrice;
	//批发合计
	private Double wholeSum;
	//仓位名称
	private String positionName;
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
	//入库时间
	private Date createTime;
	//材质
	private String materialName;
	//镜片功能
	private String functionName;
	//渐进片分类
	private String gradualName;
	//配件型
	private String partsStyle;
	//球镜上限
	private Long sphUp;
	//球镜下限
	private Long sphDown;
	//球镜区间
	private String sphqj;
	//柱镜上限
	private Long cylUp;
	//柱镜下限
	private Long cylDown;
	//柱镜区间
	private String cylqj;
	//下加光左
	private Long lightbelowRight;
	//下加光右
	private Long lightbelowLeft;
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
	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}
	/**
	 * 获取：数量
	 */
	public Long getGoodsCount() {
		return goodsCount;
	}
	/**
	 * 设置：商品类别
	 */
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：商品类别
	 */
	public String getGoodsType() {
		return goodsType;
	}
	/**
	 * 设置：
	 */
	public void setMfrsid(Integer mfrsid) {
		this.mfrsid = mfrsid;
	}
	/**
	 * 获取：
	 */
	public Integer getMfrsid() {
		return mfrsid;
	}
	/**
	 * 设置：标准零售价格
	 */
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * 获取：标准零售价格
	 */
	public Double getRetailPrice() {
		return retailPrice;
	}
	/**
	 * 设置：原价合计
	 */
	public void setPriceSum(Double priceSum) {
		this.priceSum = priceSum;
	}
	/**
	 * 获取：原价合计
	 */
	public Double getPriceSum() {
		return priceSum;
	}
	/**
	 * 设置：成本价格
	 */
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：成本价格
	 */
	public Double getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：成本合计
	 */
	public void setCostSum(Double costSum) {
		this.costSum = costSum;
	}
	/**
	 * 获取：成本合计
	 */
	public Double getCostSum() {
		return costSum;
	}
	/**
	 * 设置：批发价格
	 */
	public void setWholePrice(Double wholePrice) {
		this.wholePrice = wholePrice;
	}
	/**
	 * 获取：批发价格
	 */
	public Double getWholePrice() {
		return wholePrice;
	}
	/**
	 * 设置：批发合计
	 */
	public void setWholeSum(Double wholeSum) {
		this.wholeSum = wholeSum;
	}
	/**
	 * 获取：批发合计
	 */
	public Double getWholeSum() {
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
	 * 设置：尺寸
	 */
	public void setSize(String size) {
		this.size = size;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：入库时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public void setMaterialName(String materialName) {this.materialName = materialName;}

	public String getMaterialName(){return materialName;}

	public void setFunctionName(String functionName) {this.functionName = functionName;}

	public String getFunctionName() {return functionName;}

	public void setGradualName(String gradualName) {this.gradualName = gradualName;}

	public String getGradualName() {return gradualName;}

	public void setPartsStyle(String partsStyle) {this.partsStyle = partsStyle;}

	public String getPartsStyle() {return partsStyle;}

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

	public String getSphqj() { return sphqj; }

	public void setSphqj(String sphqj) {
		this.sphqj = sphqj;
	}

	public String getCylqj() { return cylqj; }

	public void setCylqj(String cylqj) {
		this.cylqj = cylqj;
	}

	public void setLightbelowqj(String lightbelowqj) {this.lightbelowqj = lightbelowqj;}

	public String getLightbelowqj() {return lightbelowqj;}

	public void setProducColor(String producColor) {this.producColor = producColor;}

	public String getProducColor(){return producColor;}
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

	public void setUsageName(String usageName){ this.usageName = usageName; }

	public String getUsageName(){return usageName;}

	public void setTypeName(String typeName){this.typeName=typeName;}

	public String getTypeName(){return typeName;}
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

}
