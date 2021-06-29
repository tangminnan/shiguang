package com.shiguang.product.service;

import com.shiguang.product.domain.MbDO;

import java.util.List;
import java.util.Map;

/**
 * 制造商品牌关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-28 13:49:46
 */
public interface MbService {
	
	MbDO get(Integer id);
	
	List<MbDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(MbDO mb);
	
	int update(MbDO mb);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
