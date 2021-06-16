package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.ProvincesDO;

import java.util.List;
import java.util.Map;

/**
 * 省份信息表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-15 17:18:59
 */
public interface ProvincesService {
	
	ProvincesDO get(Integer id);
	
	List<ProvincesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProvincesDO provinces);
	
	int update(ProvincesDO provinces);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
