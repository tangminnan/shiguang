package com.shiguang.stock.service;

import com.shiguang.stock.domain.TuihuoDO;

import java.util.List;
import java.util.Map;

/**
 * 退货表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
public interface TuihuoService {
	
	TuihuoDO get(Long id);
	
	List<TuihuoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TuihuoDO tuihuo);
	
	int update(TuihuoDO tuihuo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
