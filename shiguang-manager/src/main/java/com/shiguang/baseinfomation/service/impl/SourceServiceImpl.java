package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.SourceDao;
import com.shiguang.baseinfomation.domain.SourceDO;
import com.shiguang.baseinfomation.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceDao sourceDao;

    @Override
    public SourceDO get(Long id){
        return sourceDao.get(id);
    }

    @Override
    public List<SourceDO> list(Map<String, Object> map){
        return sourceDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return sourceDao.count(map);
    }

    @Override
    public int save(SourceDO source){
        return sourceDao.save(source);
    }

    @Override
    public int update(SourceDO source){
        return sourceDao.update(source);
    }

    @Override
    public int remove(Long id){
        return sourceDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return sourceDao.batchRemove(ids);
    }
}
