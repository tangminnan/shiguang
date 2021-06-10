package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.ReadDao;
import com.shiguang.baseinfomation.domain.ReadDO;
import com.shiguang.baseinfomation.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReadServiceImpl implements ReadService {
    @Autowired
    private ReadDao readDao;

    @Override
    public ReadDO get(Long id){
        return readDao.get(id);
    }

    @Override
    public List<ReadDO> list(Map<String, Object> map){
        return readDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return readDao.count(map);
    }

    @Override
    public int save(ReadDO read){
        return readDao.save(read);
    }

    @Override
    public int update(ReadDO read){
        return readDao.update(read);
    }

    @Override
    public int remove(Long id){
        return readDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return readDao.batchRemove(ids);
    }
}
