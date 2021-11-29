package com.shiguang.stock.service.impl;

import com.shiguang.stock.domain.StockDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.TuihuoDao;
import com.shiguang.stock.domain.TuihuoDO;
import com.shiguang.stock.service.TuihuoService;



@Service
public class TuihuoServiceImpl implements TuihuoService {
	@Autowired
	private TuihuoDao tuihuoDao;
	
	@Override
	public TuihuoDO get(Long id){
		return tuihuoDao.get(id);
	}
	
	@Override
	public List<TuihuoDO> list(Map<String, Object> map){
		return tuihuoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tuihuoDao.count(map);
	}
	
	@Override
	public int save(TuihuoDO tuihuo){
		return tuihuoDao.save(tuihuo);
	}
	
	@Override
	public int update(TuihuoDO tuihuo){
		return tuihuoDao.update(tuihuo);
	}
	
	@Override
	public int remove(Long id){
		return tuihuoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tuihuoDao.batchRemove(ids);
	}

	@Override
	public List<StockDO> selectJingjia(Map<String, Object> map) {
		return tuihuoDao.selectJingjia(map);
	}

	@Override
	public int selectJingjiacount(Map<String, Object> map) {
		return tuihuoDao.selectJingjiacount(map);
	}

	@Override
	public List<StockDO> selectPeijian(Map<String, Object> map) {
		return tuihuoDao.selectPeijian(map);
	}

	@Override
	public int selectPeijiancount(Map<String, Object> map) {
		return tuihuoDao.selectPeijiancount(map);
	}

	@Override
	public List<StockDO> selectJpdz(Map<String, Object> map) {
		return tuihuoDao.selectJpdz(map);
	}

	@Override
	public int selectJpdzcount(Map<String, Object> map) {
		return tuihuoDao.selectJpdzcount(map);
	}

	@Override
	public List<StockDO> selectJpcp(Map<String, Object> map) {
		return tuihuoDao.selectJpcp(map);
	}

	@Override
	public int selectJpcpcount(Map<String, Object> map) {
		return tuihuoDao.selectJpcpcount(map);
	}

	@Override
	public List<StockDO> selectYxdz(Map<String, Object> map) {
		return tuihuoDao.selectYxdz(map);
	}

	@Override
	public int selectYxdzcount(Map<String, Object> map) {
		return tuihuoDao.selectYxdzcount(map);
	}

	@Override
	public List<StockDO> selectYxcp(Map<String, Object> map) {
		return tuihuoDao.selectYxcp(map);
	}

	@Override
	public int selectYxcpcount(Map<String, Object> map) {
		return tuihuoDao.selectYxcpcount(map);
	}

	@Override
	public List<StockDO> selectHly(Map<String, Object> map) {
		return tuihuoDao.selectHly(map);
	}

	@Override
	public int selectHlycount(Map<String, Object> map) {
		return tuihuoDao.selectHlycount(map);
	}

	@Override
	public List<StockDO> selectTyj(Map<String, Object> map) {
		return tuihuoDao.selectTyj(map);
	}

	@Override
	public int selectTyjcount(Map<String, Object> map) {
		return tuihuoDao.selectTyjcount(map);
	}

	@Override
	public List<StockDO> selectLhj(Map<String, Object> map) {
		return tuihuoDao.selectLhj(map);
	}

	@Override
	public int selectLhjcount(Map<String, Object> map) {
		return tuihuoDao.selectLhjcount(map);
	}

	@Override
	public List<StockDO> selectHc(Map<String, Object> map) {
		return tuihuoDao.selectHc(map);
	}

	@Override
	public int selectHccount(Map<String, Object> map) {
		return tuihuoDao.selectHccount(map);
	}

	@Override
	public List<StockDO> selectSg(Map<String, Object> map) {
		return tuihuoDao.selectSg(map);
	}

	@Override
	public int selectSgcount(Map<String, Object> map) {
		return tuihuoDao.selectSgcount(map);
	}

	@Override
	public List<TuihuoDO> orderList(Map<String, Object> map) {
		return tuihuoDao.orderList(map);
	}

	@Override
	public int orderCount(Map<String, Object> map) {
		return tuihuoDao.orderCount(map);
	}

	@Override
	public List<TuihuoDO> selectOrder(Map<String, Object> map) {
		return tuihuoDao.selectOrder(map);
	}

	@Override
	public TuihuoDO getDanju(String tuihuoNum) {
		return tuihuoDao.getDanju(tuihuoNum);
	}

	@Override
	public List<TuihuoDO> getDanjuList(Map<String, Object> map) {
		return tuihuoDao.getDanjuList(map);
	}

	@Override
	public int countall(Map<String, Object> map) {
		return tuihuoDao.countall(map);
	}
}
