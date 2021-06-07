package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.VocationDao;
import com.shiguang.baseinfomation.domain.VocationDO;
import com.shiguang.baseinfomation.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VocationServiceImpl implements VocationService {
    @Autowired
    private VocationDao vocationDao;

    @Override
    public VocationDO get(Long id){
        return vocationDao.get(id);
    }

    @Override
    public List<VocationDO> list(Map<String, Object> map){
        return vocationDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return vocationDao.count(map);
    }

    @Override
    public int save(VocationDO vocation){
        return vocationDao.save(vocation);
    }

    @Override
    public int update(VocationDO vocation){
        return vocationDao.update(vocation);
    }

    @Override
    public int remove(Long id){
        return vocationDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return vocationDao.batchRemove(ids);
    }
}
