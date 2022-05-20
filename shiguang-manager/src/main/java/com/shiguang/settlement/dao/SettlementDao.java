package com.shiguang.settlement.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 结款管理
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
@Mapper
@Repository("SettlementDao")
public interface SettlementDao {

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

	List<SettlementDO> findJcGlassesData(Map<String,Object> map);

	int findJcGlassesDataCount(Map<String,Object> map);
}
