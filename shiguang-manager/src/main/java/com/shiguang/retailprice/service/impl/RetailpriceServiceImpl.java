package com.shiguang.retailprice.service.impl;

import com.shiguang.product.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.retailprice.dao.RetailpriceDao;
import com.shiguang.retailprice.domain.RetailpriceDO;
import com.shiguang.retailprice.service.RetailpriceService;



@Service
public class RetailpriceServiceImpl implements RetailpriceService {
	@Autowired
	private RetailpriceDao retailpriceDao;
	
	@Override
	public RetailpriceDO get(Long id){
		return retailpriceDao.get(id);
	}
	
	@Override
	public List<RetailpriceDO> list(Map<String, Object> map){
		return retailpriceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return retailpriceDao.count(map);
	}
	
	@Override
	public int save(RetailpriceDO retailprice){
		return retailpriceDao.save(retailprice);
	}
	
	@Override
	public int update(RetailpriceDO retailprice){
		return retailpriceDao.update(retailprice);
	}
	
	@Override
	public int remove(Long id){
		return retailpriceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return retailpriceDao.batchRemove(ids);
	}


	@Override
	public List<ProducaDO> jjlist(Map<String, Object> map) {
		return retailpriceDao.jjlist(map);
	}

	@Override
	public int jjlistCount(Map<String, Object> map) {
		return retailpriceDao.jjlistCount(map);
	}

	@Override
	public List<PartsDO> pjlist(Map<String, Object> map) {
		return retailpriceDao.pjlist(map);
	}

	@Override
	public int pjlistCount(Map<String, Object> map) {
		return retailpriceDao.pjlistCount(map);
	}

	@Override
	public List<JpcpDO> jpcplist(Map<String, Object> map) {
		return retailpriceDao.jpcplist(map);
	}

	@Override
	public int jpcplistCount(Map<String, Object> map) {
		return retailpriceDao.jpcplistCount(map);
	}

	@Override
	public List<JpdzDO> jpdzlist(Map<String, Object> map) {
		return retailpriceDao.jpdzlist(map);
	}

	@Override
	public int jpdzlistCount(Map<String, Object> map) {
		return retailpriceDao.jpdzlistCount(map);
	}

	@Override
	public List<YxcpDO> yxcplist(Map<String, Object> map) {
		return retailpriceDao.yxcplist(map);
	}

	@Override
	public int yxcplistCount(Map<String, Object> map) {
		return retailpriceDao.yxcplistCount(map);
	}

	@Override
	public List<YxdzDO> yxdzlist(Map<String, Object> map) {
		return retailpriceDao.yxdzlist(map);
	}

	@Override
	public int yxdzlistCount(Map<String, Object> map) {
		return retailpriceDao.yxdzlistCount(map);
	}

	@Override
	public List<HlyDO> hlylist(Map<String, Object> map) {
		return retailpriceDao.hlylist(map);
	}

	@Override
	public int hlylistCount(Map<String, Object> map) {
		return retailpriceDao.hlylistCount(map);
	}

	@Override
	public List<TyjDO> tyjlist(Map<String, Object> map) {
		return retailpriceDao.tyjlist(map);
	}

	@Override
	public int tyjlistCount(Map<String, Object> map) {
		return retailpriceDao.tyjlistCount(map);
	}

	@Override
	public List<OldlensDO> lhjlist(Map<String, Object> map) {
		return retailpriceDao.lhjlist(map);
	}

	@Override
	public int lhjlistCount(Map<String, Object> map) {
		return retailpriceDao.lhjlistCount(map);
	}

	@Override
	public List<HcDO> hclist(Map<String, Object> map) {
		return retailpriceDao.hclist(map);
	}

	@Override
	public int hclistCount(Map<String, Object> map) {
		return retailpriceDao.hclistCount(map);
	}

	@Override
	public List<ShiguangDO> sglist(Map<String, Object> map) {
		return retailpriceDao.sglist(map);
	}

	@Override
	public int sglistCount(Map<String, Object> map) {
		return retailpriceDao.sglistCount(map);
	}

	@Override
	public List<RetailpriceDO> selectOrder(Map<String, Object> map) {
		return retailpriceDao.selectOrder(map);
	}

	@Override
	public RetailpriceDO getDanju(String number) {
		return retailpriceDao.getDanju(number);
	}
}
