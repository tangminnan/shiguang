package com.shiguang.stock.service;

import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;

import java.util.List;
import java.util.Map;

/**
 * 采购订单表

 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-14 11:27:22
 */
public interface OrderService {
	
	OrderDO get(Long id);
	
	List<OrderDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	int countall(Map<String, Object> map);

	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	List<OrderDO> getCode(Map<String, Object> map);
	List<OrderDO> gettyjCode(Map<String, Object> map);
	int updateStatus(OrderDO order);
	List<OrderDO> selectOrder(Map<String, Object> map);
	List<OrderDO> orderdingdan(Map<String,Object>map);

	List<OrderDO> haveOrderNum(Map<String, Object> map);



	List<OrderDO> orderDanList(Map<String, Object> map);
	int orderDanListcount(Map<String, Object> map);

}
