package com.shiguang.inventory.service.impl;

import com.shiguang.inventory.dao.GainLossDao;
import com.shiguang.inventory.domain.GainLossDO;
import com.shiguang.inventory.service.GainLossService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;




@Service
public class GainLossServiceImpl implements GainLossService {
	@Autowired
	private GainLossDao gainLossDao;
	@Autowired
	private StockService stockService;
	
	@Override
	public GainLossDO get(Long id){
		return gainLossDao.get(id);
	}
	
	@Override
	public List<GainLossDO> list(Map<String, Object> map){
		return gainLossDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return gainLossDao.count(map);
	}
	
	@Override
	@Transactional
	public int save(GainLossDO gainLoss){
		if (null != gainLoss.getProducCode()){
			String[] goodsCode = gainLoss.getProducCode().split(",");
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			for (int i=0;i<goodsCode.length;i++){
				StockDO stockDO = new StockDO();
				StockDO stockDO1 = new StockDO();
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				if ("护理液".equals(gainLoss.getInventoryType()) || "隐形".equals(gainLoss.getInventoryType())){
					stockDO.setGoodsCode(goodsCode[i]);
					stockDO1 = stockService.getProduceCode(stockDO);
				} else {
					stockDO.setGoodsNum(goodsNum[i]);
					stockDO1 = stockService.getProduceNum(stockDO);
				}
				StockDO stockDO2 = new StockDO();
				if (null != stockDO1){
					if ("盘盈".equals(gainLoss.getDocumentType())){
						int count = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(goodsCount[i]);
						stockDO2.setGoodsCount(String.valueOf(count));
					} else if ("盘亏".equals(gainLoss.getDocumentType())){
						int count = Integer.parseInt(stockDO1.getGoodsCount()) - Integer.parseInt(goodsCount[i]);
						if (count < 0){
							stockDO2.setGoodsCount("0");
						} else {
							stockDO2.setGoodsCount(String.valueOf(count));
						}

					}
					if ("护理液".equals(gainLoss.getInventoryType()) || "隐形".equals(gainLoss.getInventoryType())){
						stockDO2.setGoodsCode(goodsCode[i]);
						stockDO2.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.updateStockCCount(stockDO2);
					} else {
						stockDO2.setGoodsNum(goodsNum[i]);
						stockDO2.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.updateStockCountNum(stockDO2);
					}

				}
			}
		}
		return gainLossDao.save(gainLoss);
	}
	
	@Override
	public int update(GainLossDO gainLoss){
		return gainLossDao.update(gainLoss);
	}
	
	@Override
	public int remove(Long id){
		return gainLossDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return gainLossDao.batchRemove(ids);
	}

	@Override
	public GainLossDO getInventoryNumber(String inventoryNumber){
		return gainLossDao.getInventoryNumber(inventoryNumber);
	}

	@Override
	public int removeInventoryNumber(String inventoryNumber){
		return gainLossDao.removeInventoryNumber(inventoryNumber);
	}
	
}
