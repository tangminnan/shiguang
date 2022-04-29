package com.shiguang.settlement.service.impl;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.JpcpDO;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.JpcpService;
import com.shiguang.product.service.JpdzService;
import com.shiguang.product.service.ProducaService;
import com.shiguang.settlement.dao.DrawbackDao;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.DrawbackService;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeCard.domain.CardDO;
import com.shiguang.storeCard.service.CardService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class DrawbackServiceImpl implements DrawbackService {
	@Autowired
	private DrawbackDao drawbackDao;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SettlementService settlementService;
	@Autowired
	private LogStatusService logStatusService;
	@Autowired
	private StockService stockService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private ProducaService producaService;
	@Autowired
	private JpdzService jpdzService;
	@Autowired
	private JpcpService jpcpService;
	@Autowired
	private CardService cardService;
	
	@Override
	public DrawbackDO get(Long id){
		return drawbackDao.get(id);
	}
	
	@Override
	public List<DrawbackDO> list(Map<String, Object> map){
		return drawbackDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return drawbackDao.count(map);
	}
	
	@Override
	public int save(DrawbackDO drawback){
		return drawbackDao.save(drawback);
	}
	
	@Override
	public int update(DrawbackDO drawback){
		return drawbackDao.update(drawback);
	}
	
	@Override
	public int remove(Long id){
		return drawbackDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return drawbackDao.batchRemove(ids);
	}

	@Override
	public List<MemberDO> memberList(Map<String, Object> map){
		return drawbackDao.memberList(map);
	}

	@Override
	public int memberCount(Map<String, Object> map){
		return drawbackDao.memberCount(map);
	}

	@Override
	@Transactional
	public R saveMoney(DrawbackDO drawbackDO){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		MemberDO memberDO = memberService.getCardNumber(drawbackDO.getMemberNumber());
		DrawbackDO drawbackDOs = new DrawbackDO();
		drawbackDO.setDrawbackNumber(String.valueOf(GuuidUtil.getUUID()));
		drawbackDO.setCreaterName(ShiroUtils.getUser().getName());
		drawbackDO.setCreateTime(new Date());
		drawbackDO.setDrawbackName(memberDO.getName());
		SettlementDO settlementDO = settlementService.getSaleNumers(drawbackDO.getSaleNumber());
		drawbackDO.setDrawbackMoney(String.valueOf(settlementDO.getPayMoney()));
		SalesDO salesDOs = new SalesDO();
		SalesDO salesDO1 = salesService.getSaleNumber(drawbackDO.getSaleNumber());
		if (null != salesDO1){
			salesDOs.setSaleType("3");
			salesDOs.setSaleNumber(drawbackDO.getSaleNumber());
			salesService.updateSale(salesDOs);
		}
		if (null != drawbackDO.getDrawbacktkMoney()){
			drawbackDO.setDrawbackMoney(drawbackDO.getDrawbacktkMoney());
		}
		String[] drackWay = drawbackDO.getDrackbackWay().split(",");
		String[] drackMoney = drawbackDO.getDrawbackMoney().split(",");
		for (int i=0;i<drackWay.length;i++){
			if ("6".equals(drackWay[i])){
				CardDO cardDO = cardService.getCardNum(drawbackDO.getChuzhiNumber());
				double tuikuanMoney = Double.valueOf(cardDO.getCardMoney()) + Double.valueOf(drackMoney[i]);
				cardDO.setCardMoney(tuikuanMoney+"");
				cardService.updateMoney(cardDO);
			} else if ("9".equals(drackWay[i])){
				double jifenMoney = Double.valueOf(drackMoney[i]) * 20;
				int integral = (int) jifenMoney;
				if (null != memberDO.getIntegral()){
					Integer integralnew = Integer.parseInt(memberDO.getIntegral()) + integral;
					memberDO.setIntegral(String.valueOf(integralnew));
					memberService.updateInteger(memberDO);
				}
			}
		}

//		CostDO costDO = new CostDO();
//		costDO.setId(settlementDO.getCostId());
//		costDO.setIsSale(2L);
//		costService.update(costDO);
		SalesDO salesDO = salesService.getSaleNumber(drawbackDO.getSaleNumber());
		LogStatusDO logStatusDO = logStatusService.getLogStatusBySaleNum(drawbackDO.getSaleNumber());
		if(null != logStatusDO){
			String storeNum = salesDO.getStoreNum();
			String[] count = salesDO.getStoreCount().split(",");
			String[] goodsCode = salesDO.getGoodsCode().split(",");
			String[] storeDescribe = salesDO.getStoreDescribe().split(",");
			Map<String,Object> map = new HashMap<>();
			map.put("companyId",ShiroUtils.getUser().getCompanyId());
			map.put("departNumber",ShiroUtils.getUser().getStoreNum());
			PositionDO positionDO = stockService.findPosition(map);
			for (int i=0;i<goodsCode.length;i++){
				StockDO stockDO = new StockDO();
				stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
				stockDO.setGoodsCode(goodsCode[i]);
				StockDO stockDO1 = stockService.getProduceCode(stockDO);
				if (null != logStatusDO){
					if ("销售完成".equals(logStatusDO.getLogisticStatus())){
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							stockService.updateGoodsCount(stockDO);
						} else {
							String[] goodsNum = salesDO.getGoodsNum().split(",");
							String[] goodsName = salesDO.getStoreName().split(",");
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							if ("镜架".equals(storeDescribe[i])){
								ProducaDO producaD = producaService.getJJInfomation(goodsNum[i]);
								if (null != producaD){
									stockDO.setUnit(producaD.getUnitname());
									stockDO.setMfrsid(producaD.getMfrsid());
									stockDO.setGoodsType(1);
									stockDO.setBrandname(producaD.getBrandname());
									stockDO.setRetailPrice(producaD.getRetailPrice());
									stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
									stockDO.setCreateTime(simpleDateFormat.format(new Date()));
									stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
									stockDO.setFactory(producaD.getFactory());
									stockDO.setUsername(ShiroUtils.getUser().getUsername());
									stockDO.setClasstype("0");
									stockDO.setStatus("0");
									stockDO.setReturnzt("1");
									stockService.save(stockDO);
								}
							}
						}

					} else if ("顾客取镜".equals(logStatusDO.getLogisticStatus())){
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							stockService.updateGoodsCount(stockDO);
						} else {
							String[] goodsNum = salesDO.getGoodsNum().split(",");
							String[] goodsName = salesDO.getStoreName().split(",");
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							if ("镜架".equals(storeDescribe[i])){
								ProducaDO producaD = producaService.getJJInfomation(goodsNum[i]);
								if (null != producaD){
									stockDO.setUnit(producaD.getUnitname());
									stockDO.setMfrsid(producaD.getMfrsid());
									stockDO.setGoodsType(1);
									stockDO.setBrandname(producaD.getBrandname());
									stockDO.setRetailPrice(producaD.getRetailPrice());
									stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
									stockDO.setCreateTime(simpleDateFormat.format(new Date()));
									stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
									if (null != producaD.getFactory() && !"".equals(producaD.getFactory())){
										stockDO.setFactory(producaD.getFactory());
									}
									stockDO.setUsername(ShiroUtils.getUser().getUsername());
									stockDO.setClasstype("0");
									stockDO.setStatus("0");
									stockDO.setReturnzt("1");
									stockService.save(stockDO);
								}
							} else if ("镜片".equals(storeDescribe[i])){
								String[] classType = salesDO.getClasstype().split(",");
								if ("2".equals(classType[i])){
									JpdzDO jpdzDOS = jpdzService.getJpdzInfomation(goodsNum[i]);
									if (null != jpdzDOS){
										stockDO.setUnit(jpdzDOS.getUnitname());
										stockDO.setMfrsid(jpdzDOS.getMfrsid());
										stockDO.setGoodsType(3);
										stockDO.setBrandname(jpdzDOS.getBrandname());
										stockDO.setRetailPrice(jpdzDOS.getRetailPrice());
										stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
										stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
										if (null != jpdzDOS.getFactory() && !"".equals(jpdzDOS.getFactory())){
											stockDO.setFactory(jpdzDOS.getFactory());
										}
										stockDO.setClasstype("2");
										stockDO.setUsername(ShiroUtils.getUser().getUsername());
										stockDO.setCreateTime(simpleDateFormat.format(new Date()));
										stockDO.setStatus("0");
										stockDO.setReturnzt("1");
										stockService.save(stockDO);
									}
								} else if ("1".equals(classType[i])){
									JpcpDO jpcpDOS = jpcpService.getJpcpInfomation(goodsNum[i]);
									if (null != jpcpDOS){
										stockDO.setUnit(jpcpDOS.getUnitname());
										stockDO.setMfrsid(jpcpDOS.getMfrsid());
										stockDO.setGoodsType(3);
										stockDO.setBrandname(jpcpDOS.getBrandname());
										stockDO.setRetailPrice(jpcpDOS.getRetailPrice());
										stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
										stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
										if (null != jpcpDOS.getProducFactory() && !"".equals(jpcpDOS.getProducFactory())){
											stockDO.setFactory(jpcpDOS.getProducFactory());
										}
										stockDO.setClasstype("1");
										stockDO.setUsername(ShiroUtils.getUser().getUsername());
										stockDO.setCreateTime(simpleDateFormat.format(new Date()));
										stockDO.setStatus("0");
										stockDO.setReturnzt("1");
										stockService.save(stockDO);
									}
								}
							}
						}
					}
				} else {
					if (!"镜架".equals(storeDescribe[i]) && !"自架".equals(storeDescribe[i]) && !"镜片".equals(storeDescribe[i])
							&& !"隐形".equals(storeDescribe[i]) && !"自片".equals(storeDescribe[i])){
						positionDO = stockService.findPosition(map);
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO2 = stockService.getProduceCode(stockDOs);
						int godsCount = Integer.parseInt(stockDO2.getGoodsCount()) + Integer.parseInt(count[i]);
						stockDOs.setGoodsCount(godsCount + "");
						stockService.updateGoodsCount(stockDOs);
					} else if ("镜架".equals(storeDescribe[i])){
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							stockService.updateGoodsCount(stockDO);
						} else {
							String[] goodsNum = salesDO.getGoodsNum().split(",");
							String[] goodsName = salesDO.getStoreName().split(",");
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) + "");
							ProducaDO producaD = producaService.getJJInfomation(goodsNum[i]);
							if (null != producaD){
								stockDO.setUnit(producaD.getUnitname());
								stockDO.setMfrsid(producaD.getMfrsid());
								stockDO.setGoodsType(1);
								stockDO.setBrandname(producaD.getBrandname());
								stockDO.setRetailPrice(producaD.getRetailPrice());
								stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
								stockDO.setCreateTime(simpleDateFormat.format(new Date()));
								stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
								if (null != producaD.getFactory() && !"".equals(producaD.getFactory())){
									stockDO.setFactory(producaD.getFactory());
								}
								stockDO.setUsername(ShiroUtils.getUser().getUsername());
								stockDO.setClasstype("0");
								stockDO.setStatus("0");
								stockDO.setReturnzt("1");
								stockService.save(stockDO);
							}
						}
					} else if ("镜片".equals(storeDescribe[i])){
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							stockService.updateGoodsCount(stockDO);
						} else {
							String[] goodsNum = salesDO.getGoodsNum().split(",");
							String[] goodsName = salesDO.getStoreName().split(",");
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) + "");
							String[] classType = salesDO.getClasstype().split(",");
							if ("1".equals(classType[i])){
								JpcpDO jpcpDOS = jpcpService.getJpcpInfomation(goodsNum[i]);
								if (null != jpcpDOS){
									stockDO.setUnit(jpcpDOS.getUnitname());
									stockDO.setMfrsid(jpcpDOS.getMfrsid());
									stockDO.setGoodsType(3);
									stockDO.setBrandname(jpcpDOS.getBrandname());
									stockDO.setRetailPrice(jpcpDOS.getRetailPrice());
									stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
									stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
									if (null != jpcpDOS.getProducFactory() && !"".equals(jpcpDOS.getProducFactory())){
										stockDO.setFactory(jpcpDOS.getProducFactory());
									}
									stockDO.setClasstype("1");
									stockDO.setUsername(ShiroUtils.getUser().getUsername());
									stockDO.setCreateTime(simpleDateFormat.format(new Date()));
									stockDO.setStatus("0");
									stockDO.setReturnzt("1");
									stockService.save(stockDO);
								}
							}
						}
					}

				}

			}
		}

		if(this.save(drawbackDO)>0){
			return R.ok("退款成功");
		}
		return R.error();
	}
	
}
