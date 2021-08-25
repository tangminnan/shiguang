package com.shiguang.settlement.service.impl;

import com.shiguang.settlement.dao.SettlementDao;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.SalesDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class SettlementServiceImpl implements SettlementService {
	@Autowired
	private SettlementDao settlementDao;
	
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
	public int remove(Long id){
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
}
