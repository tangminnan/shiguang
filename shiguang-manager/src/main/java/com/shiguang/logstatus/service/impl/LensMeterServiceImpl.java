package com.shiguang.logstatus.service.impl;

import com.shiguang.logstatus.dao.LensMeterDao;
import com.shiguang.logstatus.domain.LensMeterDO;
import com.shiguang.logstatus.service.LensMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LensMeterServiceImpl implements LensMeterService {
    @Autowired
    private LensMeterDao meterDao;

    @Override
    public LensMeterDO get(Long id){
        return meterDao.get(id);
    }

    @Override
    public List<LensMeterDO> list(Map<String, Object> map){
        return meterDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return meterDao.count(map);
    }

    @Override
    public int save(LensMeterDO meter){
        return meterDao.save(meter);
    }

    @Override
    public int update(LensMeterDO meter){
        return meterDao.update(meter);
    }

    @Override
    public int remove(Long id){
        return meterDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return meterDao.batchRemove(ids);
    }
}
