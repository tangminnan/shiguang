package com.shiguang.product.service;

import com.shiguang.product.domain.CylDO;

import java.util.List;
import java.util.Map;

/**
 * 柱镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:42
 */
public interface CylService {
	
	CylDO get(Integer id);
	
	List<CylDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CylDO cyl);
	
	int update(CylDO cyl);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
