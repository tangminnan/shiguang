package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.UsageDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 使用类型表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
@Mapper
public interface UsageDao {

	UsageDO get(Integer usageId);
	
	List<UsageDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UsageDO usage);
	
	int update(UsageDO usage);
	
	int remove(Integer usage_id);
	
	int batchRemove(Integer[] usageIds);
}
