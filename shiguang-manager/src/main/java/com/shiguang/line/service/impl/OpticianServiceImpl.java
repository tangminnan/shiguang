package com.shiguang.line.service.impl;

import com.shiguang.line.dao.OpticianDao;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.OpticianDO;
import com.shiguang.line.service.OpticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OpticianServiceImpl implements OpticianService {
    @Autowired
    private OpticianDao opticianDao;

    @Override
    public OpticianDO get(Long id){
        return opticianDao.get(id);
    }

    @Override
    public List<OpticianDO> list(Map<String, Object> map){
        return opticianDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return opticianDao.count(map);
    }

    @Override
    public int save(OpticianDO line){
        return opticianDao.save(line);
    }

    @Override
    public int update(OpticianDO line){
        return opticianDao.update(line);
    }

    @Override
    public int remove(Long id){
        return opticianDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return opticianDao.batchRemove(ids);
    }

    @Override
    public int removeQueue(){
        return opticianDao.removeQueue();
    }
}
