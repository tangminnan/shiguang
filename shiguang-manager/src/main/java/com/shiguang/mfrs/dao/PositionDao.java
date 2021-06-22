package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.PositionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 仓位维护表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */
@Mapper
public interface PositionDao {

	PositionDO get(Long positionId);
	
	List<PositionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PositionDO position);
	
	int update(PositionDO position);
	
	int remove(Long position_id);
	
	int batchRemove(Long[] positionIds);
}
