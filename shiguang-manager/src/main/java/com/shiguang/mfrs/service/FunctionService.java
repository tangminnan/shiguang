package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.FunctionDO;

import java.util.List;
import java.util.Map;

/**
 * 镜片功能表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public interface FunctionService {
	
	FunctionDO get(Integer functionId);
	
	List<FunctionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FunctionDO function);
	
	int update(FunctionDO function);
	
	int remove(Integer functionId);
	
	int batchRemove(Integer[] functionIds);
}
