package com.shiguang.product.service;

import com.shiguang.product.domain.CaizhiDO;

import java.util.List;
import java.util.Map;

/**
 * 材质表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public interface CaizhiService {
	
	CaizhiDO get(Long caizhiId);
	
	List<CaizhiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CaizhiDO caizhi);
	
	int update(CaizhiDO caizhi);
	
	int remove(Long caizhiId);
	
	int batchRemove(Long[] caizhiIds);
}
