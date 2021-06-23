package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.StateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 状态表

 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 14:19:37
 */
@Mapper
public interface StateDao {

	StateDO get(Integer stateId);
	
	List<StateDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StateDO state);
	
	int update(StateDO state);
	
	int remove(Integer state_id);
	
	int batchRemove(Integer[] stateIds);
}
