package com.shiguang.retailprice.service;

import com.shiguang.product.domain.*;
import com.shiguang.retailprice.domain.RetailpriceDO;
import com.shiguang.stock.domain.OrderDO;

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

	List<ProducaDO> jjlist(Map<String, Object> map);
	int jjlistCount(Map<String, Object> map);

	List<PartsDO> pjlist(Map<String, Object> map);
	int pjlistCount(Map<String, Object> map);

	List<JpcpDO> jpcplist(Map<String, Object> map);
	int jpcplistCount(Map<String, Object> map);

	List<JpdzDO> jpdzlist(Map<String, Object> map);
	int jpdzlistCount(Map<String, Object> map);

	List<YxcpDO> yxcplist(Map<String, Object> map);
	int yxcplistCount(Map<String, Object> map);

	List<YxdzDO> yxdzlist(Map<String, Object> map);
	int yxdzlistCount(Map<String, Object> map);

	List<HlyDO> hlylist(Map<String, Object> map);
	int hlylistCount(Map<String, Object> map);

	List<TyjDO> tyjlist(Map<String, Object> map);
	int tyjlistCount(Map<String, Object> map);

	List<OldlensDO> lhjlist(Map<String, Object> map);
	int lhjlistCount(Map<String, Object> map);

	List<HcDO> hclist(Map<String, Object> map);
	int hclistCount(Map<String, Object> map);

	List<ShiguangDO> sglist(Map<String, Object> map);
	int sglistCount(Map<String, Object> map);

	List<RetailpriceDO> selectOrder(Map<String, Object> map);
	RetailpriceDO getDanju(String number);


}
