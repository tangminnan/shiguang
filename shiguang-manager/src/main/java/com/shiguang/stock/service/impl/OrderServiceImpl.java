package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.OrderDao;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderDO get(Long id){
		return orderDao.get(id);
	}

	@Override
	public List<OrderDO> list(Map<String, Object> map){
		return orderDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return orderDao.count(map);
	}

	@Override
	public int countall(Map<String, Object> map) {
		return orderDao.countall(map);
	}

	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}

	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}

	@Override
	public int remove(Long id){
		return orderDao.remove(id);
	}

	@Override
	public int batchRemove(Long[] ids){
		return orderDao.batchRemove(ids);
	}

	@Override
	public List<OrderDO> getCode(Map<String, Object> map) {
		return orderDao.getCode(map);
	}

	@Override
	public int updateStatus(OrderDO order) {
		return orderDao.updateStatus(order);
	}

	@Override
	public List<OrderDO> selectOrder(Map<String, Object> map) {
		return orderDao.selectOrder(map);
	}

	@Override
	public List<OrderDO> orderdingdan(Map<String, Object> map) {
		return orderDao.orderdingdan(map);
	}
}
