package com.shiguang.stock.service.impl;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.storeSales.domain.SalesDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.WeiwaiDao;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.WeiwaiService;



@Service
public class WeiwaiServiceImpl implements WeiwaiService {
	@Autowired
	private WeiwaiDao weiwaiDao;
	
	@Override
	public WeiwaiDO get(Long id){
		return weiwaiDao.get(id);
	}
	
	@Override
	public List<WeiwaiDO> list(Map<String, Object> map){
		return weiwaiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weiwaiDao.count(map);
	}
	
	@Override
	public int save(WeiwaiDO weiwai){
		return weiwaiDao.save(weiwai);
	}
	
	@Override
	public int update(WeiwaiDO weiwai){
		return weiwaiDao.update(weiwai);
	}
	
	@Override
	public int remove(Long id){
		return weiwaiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return weiwaiDao.batchRemove(ids);
	}

	@Override
	public List<WeiwaiDO> weiwailist(Map<String, Object> map) {
		return weiwaiDao.weiwailist(map);
	}

	@Override
	public int countList(Map<String, Object> map) {
		return weiwaiDao.countList(map);
	}

	@Override
	public DepartmentDO phoneOrAddres(Map<String,Object> map) {
		return weiwaiDao.phoneOrAddres(map);
	}

	@Override
	public List<DepartmentDO> selectDepartment(Map<String, Object> map) {
		return weiwaiDao.selectDepartment(map);
	}

	@Override
	public List<SalesDO> selectOrder(Map<String, Object> map) {
		return weiwaiDao.selectOrder(map);
	}

//	@Override
//	public int selectOrderCount(Map<String, Object> map) {
//		return weiwaiDao.selectOrderCount(map);
//	}

	//<!--确认收货   [配送][][退回][][][]-->
	@Override
	public int updateStatus(WeiwaiDO weiwaiDO) {
		return weiwaiDao.updateStatus(weiwaiDO);
	}


	@Override
	public WeiwaiDO jkPeijingdan(String danjuNumber) {
		return weiwaiDao.jkPeijingdan(danjuNumber);
	}

	@Override
	public WeiwaiDO yxPeijingdan(String danjuNumber) {
		return weiwaiDao.yxPeijingdan(danjuNumber);
	}
}
