package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.PayDO;

import java.util.List;
import java.util.Map;

/**
 * 采购结算方式表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public interface PayService {
	
	PayDO get(Integer payid);
	
	List<PayDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PayDO pay);
	
	int update(PayDO pay);
	
	int remove(Integer payid);
	
	int batchRemove(Integer[] payids);
}
