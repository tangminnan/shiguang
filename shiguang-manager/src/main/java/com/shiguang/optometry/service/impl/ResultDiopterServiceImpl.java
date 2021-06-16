package com.shiguang.optometry.service.impl;

import com.shiguang.optometry.dao.ResultDiopterDao;
import com.shiguang.optometry.domain.ResultDiopterDO;
import com.shiguang.optometry.service.ResultDiopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResultDiopterServiceImpl implements ResultDiopterService {
    @Autowired
    private ResultDiopterDao resultDiopterDao;

    @Override
    public ResultDiopterDO get(Long id){
        return resultDiopterDao.get(id);
    }

    @Override
    public List<ResultDiopterDO> list(Map<String, Object> map){
        return resultDiopterDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return resultDiopterDao.count(map);
    }

    @Override
    public int save(ResultDiopterDO optometry){
        return resultDiopterDao.save(optometry);
    }

    @Override
    public int update(ResultDiopterDO optometry){
        return resultDiopterDao.update(optometry);
    }

    @Override
    public int remove(Long id){
        return resultDiopterDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return resultDiopterDao.batchRemove(ids);
    }
}
