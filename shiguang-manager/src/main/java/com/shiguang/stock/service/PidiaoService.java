package com.shiguang.stock.service;

import com.shiguang.stock.domain.PidiaoDO;

import java.util.List;
import java.util.Map;

/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-25 10:27:20
 */
public interface PidiaoService {
	
	PidiaoDO get(Long id);
	
	List<PidiaoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PidiaoDO pidiao);
	
	int update(PidiaoDO pidiao);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
