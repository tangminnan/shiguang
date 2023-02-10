package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.HospitalEyeDO;
import com.shiguang.system.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.CompanyDao;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.service.CompanyService;



@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public CompanyDO get(Integer id){
		return companyDao.get(id);
	}
	
	@Override
	public List<CompanyDO> list(Map<String, Object> map){
		return companyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return companyDao.count(map);
	}
	
	@Override
	public int save(CompanyDO company){
		return companyDao.save(company);
	}
	
	@Override
	public int update(CompanyDO company){
		return companyDao.update(company);
	}
	
	@Override
	public int remove(Integer id){
		return companyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return companyDao.batchRemove(ids);
	}

	//删除修改状态

	@Override
	public int updateState(CompanyDO companyDO) {
		return companyDao.updateState(companyDO);
	}

	@Override
	public int newOlds(UserDO userDO) {
		return companyDao.newOlds(userDO);
	}

	@Override
	public List<HospitalEyeDO> findHospital(String companyId){ return companyDao.findHospital(companyId); }
}
