package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.PositionDO;

import java.util.List;
import java.util.Map;

/**
 * 仓位维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */
public interface PositionService {
	
	PositionDO get(Long positionId);

	List<PositionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PositionDO position);
	
	int update(PositionDO position);
	
	int remove(Long positionId);
	
	int batchRemove(Long[] positionIds);
}
