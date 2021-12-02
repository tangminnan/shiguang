package com.shiguang.stock.service.impl;

import com.shiguang.mfrs.domain.PositionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.PidiaoDao;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;



@Service
public class PidiaoServiceImpl implements PidiaoService {
	@Autowired
	private PidiaoDao pidiaoDao;
	
	@Override
	public PidiaoDO get(Long id){
		return pidiaoDao.get(id);
	}
	
	@Override
	public List<PidiaoDO> list(Map<String, Object> map){
		return pidiaoDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return pidiaoDao.count(map);
	}

	@Override
	public int save(PidiaoDO pidiao){
		return pidiaoDao.save(pidiao);
	}
	
	@Override
	public int update(PidiaoDO pidiao){
		return pidiaoDao.update(pidiao);
	}
	
	@Override
	public int remove(Long id){
		return pidiaoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return pidiaoDao.batchRemove(ids);
	}

	@Override
	public List<PidiaoDO> outPosition(Map<String, Object> map) {
		return pidiaoDao.outPosition(map);
	}

	@Override
	public List<PidiaoDO> indepartment(Map<String, Object> map) {
		return  pidiaoDao.indepartment(map);
	}

	@Override
	public List<PidiaoDO> selectPidiao(Map<String, Object> map) {
		return pidiaoDao.selectPidiao(map);
	}

	@Override
	public PidiaoDO getpidiao(String pidiaoNumber) {
		return pidiaoDao.getpidiao(pidiaoNumber);
	}

	@Override
	public List<PidiaoDO> getpidiaoList(Map<String, Object> map) {
		return pidiaoDao.getpidiaoList(map);
	}

	@Override
	public int updateStatus(PidiaoDO pidiaoDO) {
		return pidiaoDao.updateStatus(pidiaoDO);
	}

	@Override
	public List<PidiaoDO> returnList(Map<String, Object> map) {
		return pidiaoDao.returnList(map);
	}

	@Override
	public int updatereturnzt(PidiaoDO pidiaoDO) {
		return pidiaoDao.updatereturnzt(pidiaoDO);
	}

	@Override
	public List<PidiaoDO> pidiaodan(Map<String, Object> map) {
		return pidiaoDao.pidiaodan(map);
	}

	@Override
	public int countall(Map<String, Object> map) {
		return pidiaoDao.countall(map);
	}

	@Override
	public List<PidiaoDO> getCode(Map<String, Object> map) {
		return pidiaoDao.getCode(map);
	}

	@Override
	public List<PidiaoDO> haveOrderNum(Map<String, Object> map) {
		return pidiaoDao.haveOrderNum(map);
	}
}
