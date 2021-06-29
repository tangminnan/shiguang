package com.shiguang.settlement.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.settlement.domain.SettlementDO;
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

	SettlementDO getMember(String cardMember);
	
	List<SettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SettlementDO settlement);
	
	int update(SettlementDO settlement);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}