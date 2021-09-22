package com.shiguang.stock.service;

import com.shiguang.stock.domain.WeiwaishujuDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-18 18:14:35
 */
public interface WeiwaishujuService {
	
	WeiwaishujuDO get(Long id);
	
	List<WeiwaishujuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WeiwaishujuDO weiwaishuju);
	
	int update(WeiwaishujuDO weiwaishuju);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
