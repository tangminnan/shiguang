package com.shiguang.settlement.service;


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

	SettlementDO getMember(String cardMember);
	
	List<SettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SettlementDO settlement);
	
	int update(SettlementDO settlement);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}