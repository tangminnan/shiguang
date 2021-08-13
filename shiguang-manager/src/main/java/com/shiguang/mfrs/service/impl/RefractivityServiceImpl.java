package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.RefractivityDao;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.service.RefractivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RefractivityServiceImpl implements RefractivityService {
    @Autowired
    private RefractivityDao refractivityDao;

    @Override
    public RefractivityDO get(Integer refractivityid) {
        return refractivityDao.get(refractivityid);
    }

    @Override
    public List<RefractivityDO> list(Map<String, Object> map) {
        return refractivityDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return refractivityDao.count(map);
    }

    @Override
    public int save(RefractivityDO refractivity) {
        return refractivityDao.save(refractivity);
    }

    @Override
    public int update(RefractivityDO refractivity) {
        return refractivityDao.update(refractivity);
    }

    @Override
    public int remove(Integer refractivityid) {
        return refractivityDao.remove(refractivityid);
    }

    @Override
    public int batchRemove(Integer[] refractivityids) {
        return refractivityDao.batchRemove(refractivityids);
    }
    //删除修改状态

    @Override
    public int updateState(RefractivityDO refractivityDO) {
        return refractivityDao.updateState(refractivityDO);
    }
}
