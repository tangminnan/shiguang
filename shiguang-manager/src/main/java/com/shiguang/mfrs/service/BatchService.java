package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.BatchDO;

import java.util.List;
import java.util.Map;

/**
 * 批号管理表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public interface BatchService {
	
	BatchDO get(Integer batchid);
	
	List<BatchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BatchDO batch);
	
	int update(BatchDO batch);
	
	int remove(Integer batchid);
	
	int batchRemove(Integer[] batchids);
}
