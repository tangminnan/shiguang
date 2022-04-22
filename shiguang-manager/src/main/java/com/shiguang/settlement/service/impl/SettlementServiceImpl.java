package com.shiguang.settlement.service.impl;

import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.settlement.dao.SettlementDao;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.tools.ant.taskdefs.Sleep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class SettlementServiceImpl implements SettlementService {
	@Autowired
	private SettlementDao settlementDao;
	@Autowired
	private SalesService salesService;
	@Autowired
	private StockService stockService;
	
	@Override
	public SettlementDO get(Long id){
		return settlementDao.get(id);
	}

	@Override
	public List<SettlementDO> getMember(String cardMember){
		return settlementDao.getMember(cardMember);
	}

	@Override
	public SettlementDO getCostId(Long costId){
		return settlementDao.getCostId(costId);
	}
	
	@Override
	public List<SettlementDO> list(Map<String, Object> map){
		return settlementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return settlementDao.count(map);
	}
	
	@Override
	public int save(SettlementDO settlement){
		return settlementDao.save(settlement);
	}
	
	@Override
	public int update(SettlementDO settlement){
		return settlementDao.update(settlement);
	}
	
	@Override
	public int remove(String id){
		return settlementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return settlementDao.batchRemove(ids);
	}

	@Override
	public SettlementDO getSaleNumers(String saleNumber){
		return settlementDao.getSaleNumers(saleNumber);
	}

	@Override
	public List<SettlementDO> findArrearsData(Map<String, Object> map){
		return settlementDao.findArrearsData(map);
	}

	@Override
	public int findArrearsDataCount(Map<String, Object> map){
		return settlementDao.findArrearsDataCount(map);
	}

	@Override
	public SettlementDO getSaleNumersByNum(String saleNumber){
		return settlementDao.getSaleNumersByNum(saleNumber);
	}

	@Override
	public List<SettlementDO> findGlassesData(Map<String, Object> map){
		return settlementDao.findGlassesData(map);
	}

	@Override
	public int findGlassesDataCount(Map<String, Object> map){
		return settlementDao.findGlassesDataCount(map);
	}

	@Override
	public int updateMethod(SettlementDO settlement){
		return settlementDao.updateMethod(settlement);
	}

	@Override
	public R deleteSale(String id) {
		SalesDO salesDO = salesService.getSaleNumber(id);
		String companyId = "";
		PositionDO positionDO = null;
		if (null != ShiroUtils.getUser().getCompanyId()) {
			companyId = ShiroUtils.getUser().getCompanyId();
			Map<String,Object> map = new HashMap<>();
			map.put("companyId", companyId);
			map.put("departNumber",ShiroUtils.getUser().getStoreNum());
			positionDO = stockService.findPosition(map);
		}
		if (null != salesDO){
			String[] saleDescribe = salesDO.getStoreDescribe().split(",");
			String[] goodsCount = salesDO.getStoreCount().split(",");
			String[] goodsStr = salesDO.getGoodsCode().split(",");
			for (int i=0;i<saleDescribe.length;i++){
				if (!"镜片".equals(saleDescribe[i]) && !"隐形".equals(saleDescribe[i])
						&& !"自架".equals(saleDescribe[i])
						&& !"自片".equals(saleDescribe[i]) && !"赠品".equals(saleDescribe[i])){
					StockDO stockDOs = new StockDO();
					if (null != positionDO){
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
					} else {
						stockDOs.setPositionId("");
					}
					stockDOs.setGoodsCode(goodsStr[i]);
					StockDO stockDO = stockService.getProduceCode(stockDOs);
					if (null != stockDO){
                        Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                        Long count = countGoods + Long.valueOf(goodsCount[i]);
                        stockDO.setGoodsCount(String.valueOf(count));
                        stockService.updateGoodsCount(stockDO);
                    }

				}
			}
		}
		salesService.removeSaleNum(id);
		this.remove(id);
		return R.ok();
	}
}
