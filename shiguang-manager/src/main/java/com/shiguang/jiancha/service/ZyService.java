package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.ZyDO;

import java.util.List;
import java.util.Map;

/**
 * 框架中用表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:50:32
 */
public interface ZyService {
	
	ZyDO get(Long zyId);
	
	List<ZyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZyDO zy);

	int saveZY(ResultDO result);

	int update(ZyDO zy);
	
	int remove(Long zyId);
	
	int batchRemove(Long[] zyIds);
}
