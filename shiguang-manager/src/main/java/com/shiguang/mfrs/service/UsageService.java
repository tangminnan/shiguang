package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.UsageDO;

import java.util.List;
import java.util.Map;

/**
 * 使用类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public interface UsageService {
	
	UsageDO get(Integer usageId);
	
	List<UsageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UsageDO usage);
	
	int update(UsageDO usage);
	
	int remove(Integer usageId);
	
	int batchRemove(Integer[] usageIds);
}
