package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.domain.ResultDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.ResultDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.ResultService;



@Service
public class ResultServiceImpl implements ResultService {
	@Autowired
	private ResultDao resultDao;

	@Override
	public ResultDO get(Long id) {
		return resultDao.get(id);
	}

	@Override
	public List<ResultDO> list(Map<String, Object> map) {
		return resultDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return resultDao.count(map);
	}

	@Override
	public int save(ResultDO result) {
		return resultDao.save(result);
	}

	@Override
	public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
		return resultDao.haveYanguangNum(map);
	}

	@Override
	public int update(ResultDO result) {
		return resultDao.update(result);
	}

	@Override
	public int remove(Long id) {
		return resultDao.remove(id);
	}

	@Override
	public int upremove(ResultDO resultDO) {
		return resultDao.upremove(resultDO);
	}

	@Override
	public int batchRemove(Long[] ids) {
		return resultDao.batchRemove(ids);
	}

	@Override
	public List<ResultDO> shujulist(Map<String, Object> map) {
		return resultDao.shujulist(map);
	}

	@Override
	public int shujulistcount(Map<String, Object> map) {
		return resultDao.shujulistcount(map);
	}

	@Override
	public ResultDO getChufangAll(Map<String, Object> map) {
		return resultDao.getChufangAll(map);
	}

	@Override
	public ResultDetailDO getresult(Map<String, Object> map) {
		return resultDao.getresult(map);
	}
}