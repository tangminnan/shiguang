package com.shiguang.retailprice.service;

import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.retailprice.domain.RetailpriceDO;

import java.util.List;
import java.util.Map;

/**
 * 零售价价格调整表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
public interface RetailpriceService {
	
	RetailpriceDO get(Long id);
	
	List<RetailpriceDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(RetailpriceDO retailprice);
	
	int update(RetailpriceDO retailprice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<PartsDO> pjlist(Map<String, Object> map);
	int pjlistCount(Map<String, Object> map);


}
