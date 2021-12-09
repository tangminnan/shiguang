package com.shiguang.settlement.service;


import com.shiguang.common.utils.R;
import com.shiguang.settlement.domain.SettlementDO;

import java.util.List;
import java.util.Map;

/**
 * 结款管理
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
public interface SettlementService {
	
	SettlementDO get(Long id);

	List<SettlementDO> getMember(String cardMember);

	SettlementDO getCostId(Long costId);
	
	List<SettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SettlementDO settlement);
	
	int update(SettlementDO settlement);
	
	int remove(String id);
	
	int batchRemove(Long[] ids);

	SettlementDO getSaleNumers(String saleNumber);

	List<SettlementDO> findArrearsData(Map<String,Object> map);

	int findArrearsDataCount(Map<String,Object> map);

	SettlementDO getSaleNumersByNum(String saleNumber);

	List<SettlementDO> findGlassesData(Map<String,Object> map);

	int findGlassesDataCount(Map<String,Object> map);

	int updateMethod(SettlementDO settlementDO);

	R deleteSale(String saleNumber);

}
