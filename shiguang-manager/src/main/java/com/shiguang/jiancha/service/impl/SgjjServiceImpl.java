package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.SgjjDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SgjjDO;
import com.shiguang.jiancha.service.SgjjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SgjjServiceImpl implements SgjjService {
    @Autowired
    private SgjjDao sgjjDao;

    @Override
    public SgjjDO get(Long sgjjId) {
        return sgjjDao.get(sgjjId);
    }

    @Override
    public List<SgjjDO> list(Map<String, Object> map) {
        return sgjjDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return sgjjDao.count(map);
    }

    @Override
    public int save(SgjjDO sgjj) {
        return sgjjDao.save(sgjj);
    }

    @Override
    public int savesgjj(ResultDO result) {
        return sgjjDao.savesgjj(result);
    }

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return sgjjDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO result) {
        return sgjjDao.update(result);
    }

    @Override
    public int remove(Long sgjjId) {
        return sgjjDao.remove(sgjjId);
    }

    @Override
    public int upremove(SgjjDO sgjjDO) {
        return sgjjDao.upremove(sgjjDO);
    }

    @Override
    public int updatesgjj(SgjjDO sgjjDO) {
        return sgjjDao.updatesgjj(sgjjDO);
    }

    @Override
    public int batchRemove(Long[] sgjjIds) {
        return sgjjDao.batchRemove(sgjjIds);
    }
}