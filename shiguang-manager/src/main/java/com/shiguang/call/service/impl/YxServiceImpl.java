package com.shiguang.call.service.impl;

import com.shiguang.call.dao.YxDao;
import com.shiguang.call.domain.YxDO;
import com.shiguang.call.domain.YxLineDO;
import com.shiguang.call.service.YxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class YxServiceImpl implements YxService {
	@Autowired
	private YxDao yxDao;
	
	@Override
	public YxDO get(Long id){
		return yxDao.get(id);
	}
	
	@Override
	public List<YxDO> list(Map<String, Object> map){
		return yxDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return yxDao.count(map);
	}
	
	@Override
	public int save(YxDO yx){
		return yxDao.save(yx);
	}
	
	@Override
	public int update(YxDO yx){
		return yxDao.update(yx);
	}
	
	@Override
	public int remove(Long id){
		return yxDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return yxDao.batchRemove(ids);
	}

	@Override
	public List<YxLineDO> yxlinelist(Map<String, Object> map){
		return yxDao.yxlinelist(map);
	}

	@Override
	public int yxlinecount(Map<String, Object> map){
		return yxDao.yxlinecount(map);
	}

	@Override
	public int yxlinesave(YxLineDO yxLineDO){
		return yxDao.yxlinesave(yxLineDO);
	}

	@Override
	public YxLineDO getYxLine(Long id){
		return yxDao.getYxLine(id);
	}
	
}
