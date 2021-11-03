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
//		CostDO costDO = new CostDO();
//		costDO.setId(settlementDO.getCostId());
//		costDO.setIsSale(2L);
//		costService.update(costDO);
		SalesDO salesDO = salesService.getSaleNumber(drawbackDO.getSaleNumber());
		LogStatusDO logStatusDO = logStatusService.getLogStatusBySaleNum(drawbackDO.getSaleNumber());
		String storeNum = salesDO.getStoreNum();
		String[] count = salesDO.getStoreCount().split(",");
		String[] goodsCode = salesDO.getGoodsCode().split(",");
		String[] storeDescribe = salesDO.getStoreDescribe().split(",");
		Map<String,Object> map = new HashMap<>();
		map.put("companyId",ShiroUtils.getUser().getCompanyId());
		PositionDO positionDO = stockService.findBuHegePosition(map);
		for (int i=0;i<goodsCode.length;i++){
			StockDO stockDO = new StockDO();
			stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
			stockDO.setGoodsCode(goodsCode[i]);
			StockDO stockDO1 = stockService.getProduceCode(stockDO);
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
						Map<String,Object> maps = new HashMap<>();
						maps.put("producNum",goodsNum[i]);
						List<ProducaDO> producaD = producaService.list(maps);
						if (null != producaD && producaD.size() > 0){
							stockDO.setUnit(producaD.get(0).getUnitname());
							stockDO.setMfrsid(producaD.get(0).getMfrsid());
							stockDO.setGoodsType(1);
							stockDO.setBrandname(producaD.get(0).getBrandname());
							stockDO.setRetailPrice(producaD.get(0).getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							stockDO.setFactory(producaD.get(0).getFactory());
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
						Map<String,Object> maps = new HashMap<>();
						maps.put("producNum",goodsNum[i]);
						List<ProducaDO> producaD = producaService.list(maps);
						if (null != producaD && producaD.size() > 0){
							stockDO.setUnit(producaD.get(0).getUnitname());
							stockDO.setMfrsid(producaD.get(0).getMfrsid());
							stockDO.setGoodsType(1);
							stockDO.setBrandname(producaD.get(0).getBrandname());
							stockDO.setRetailPrice(producaD.get(0).getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != producaD.get(0).getFactory() && !"".equals(producaD.get(0).getFactory())){
								stockDO.setFactory(producaD.get(0).getFactory());
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
							Map<String,Object> maps = new HashMap<>();
							maps.put("producNum",goodsNum[i]);
							List<JpdzDO> jpdzDOS = jpdzService.listDz(maps);
							if (null != jpdzDOS && jpdzDOS.size() > 0){
								stockDO.setUnit(jpdzDOS.get(0).getUnitname());
								stockDO.setMfrsid(jpdzDOS.get(0).getMfrsid());
								stockDO.setGoodsType(3);
								stockDO.setBrandname(jpdzDOS.get(0).getBrandname());
								stockDO.setRetailPrice(jpdzDOS.get(0).getRetailPrice());
								stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
								stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
								if (null != jpdzDOS.get(0).getFactory() && !"".equals(jpdzDOS.get(0).getFactory())){
									stockDO.setFactory(jpdzDOS.get(0).getFactory());
								}
								stockDO.setClasstype("2");
								stockDO.setUsername(ShiroUtils.getUser().getUsername());
								stockDO.setCreateTime(simpleDateFormat.format(new Date()));
								stockDO.setStatus("0");
								stockDO.setReturnzt("1");
								stockService.save(stockDO);
							}
						} else if ("1".equals(classType[i])){
							Map<String,Object> maps = new HashMap<>();
							maps.put("producNum",goodsNum[i]);
							List<JpcpDO> jpcpDOS = jpcpService.list(maps);
							if (null != jpcpDOS && jpcpDOS.size() > 0){
								stockDO.setUnit(jpcpDOS.get(0).getUnitname());
								stockDO.setMfrsid(jpcpDOS.get(0).getMfrsid());
								stockDO.setGoodsType(3);
								stockDO.setBrandname(jpcpDOS.get(0).getBrandname());
								stockDO.setRetailPrice(jpcpDOS.get(0).getRetailPrice());
								stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
								stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
								if (null != jpcpDOS.get(0).getProducFactory() && !"".equals(jpcpDOS.get(0).getProducFactory())){
									stockDO.setFactory(jpcpDOS.get(0).getProducFactory());
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
		if(this.save(drawbackDO)>0){
			return R.ok("退款成功");
		}
		return R.error();
	}
	
}
