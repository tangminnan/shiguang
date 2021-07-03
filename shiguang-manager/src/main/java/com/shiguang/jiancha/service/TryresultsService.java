package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.TryresultsDO;

import java.util.List;
import java.util.Map;

/**
 * 试戴镜结果表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-03 17:10:26
 */
public interface TryresultsService {
	
	TryresultsDO get(Long id);
	
	List<TryresultsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TryresultsDO tryresults);
	
	int update(TryresultsDO tryresults);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
