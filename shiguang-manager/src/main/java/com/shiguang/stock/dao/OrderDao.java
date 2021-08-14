package com.shiguang.stock.dao;

import com.shiguang.stock.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 采购订单表

 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-14 11:27:22
 */
@Mapper
public interface OrderDao {

	OrderDO get(Long id);
	
	List<OrderDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
