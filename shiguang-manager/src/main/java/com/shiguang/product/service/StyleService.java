package com.shiguang.product.service;

import com.shiguang.product.domain.StyleDO;

import java.util.List;
import java.util.Map;

/**
 * 款式表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
public interface StyleService {
	
	StyleDO get(Long styleId);
	
	List<StyleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StyleDO style);
	
	int update(StyleDO style);
	
	int remove(Long styleId);
	
	int batchRemove(Long[] styleIds);
}
