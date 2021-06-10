package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.BrandDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 12:01:40
 */
public interface BrandService {
	
	BrandDO get(Integer brandid);
	
	List<BrandDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BrandDO brand);
	
	int update(BrandDO brand);
	
	int remove(Integer brandid);
	
	int batchRemove(Integer[] brandids);
}
