package com.shiguang.storeSales.service.impl;

import com.shiguang.storeSales.dao.SalesDao;
import com.shiguang.storeSales.domain.*;
import com.shiguang.storeSales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesDao salesDao;
	
	@Override
	public SalesDO get(Long id){
		return salesDao.get(id);
	}
	
	@Override
	public List<SalesDO> list(Map<String, Object> map){
		return salesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return salesDao.count(map);
	}
	
	@Override
	public int save(SalesDO sales){
		return salesDao.save(sales);
	}
	
	@Override
	public int update(SalesDO sales){
		return salesDao.update(sales);
	}
	
	@Override
	public int remove(Long id){
		return salesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return salesDao.batchRemove(ids);
	}

	@Override
	public List<EyesWay> findWay(Map<String, Object> map){
		return salesDao.findWay(map);
	}

	@Override
	public SalesDO findDataByNumber(Map<String,Object> map){
		return salesDao.findDataByNumber(map);
	}

	@Override
	public List<ZipianDO> findZpian(Map<String, Object> map){
		return salesDao.findZpian(map);
	}

	@Override
	public List<ZijiaDO> findZjia(Map<String, Object> map){
		return salesDao.findZjia(map);
	}

	@Override
	public int countZpian(Map<String, Object> map){
		return salesDao.countZpian(map);
	}

	@Override
	public int countZjia(Map<String, Object> map){
		return salesDao.count(map);
	}

	@Override
	public List<Conclusion> conclusionList(Map<String, Object> map){
		return salesDao.findAll(map);
	}

	@Override
	public List<SalesDO> peijinglist(Map<String, Object> map){
		return salesDao.peijinglist(map);
	}

	@Override
	public int peijingcount(Map<String, Object> map){
		return salesDao.peijingcount(map);
	}

	@Override
	public SalesDO getSaleNumber(String saleNumber){
		return salesDao.getSaleNumber(saleNumber);
	}
}
