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
    public int update(SgjjDO sgjj) {
        return sgjjDao.update(sgjj);
    }

    @Override
    public int remove(Long sgjjId) {
        return sgjjDao.remove(sgjjId);
    }

    @Override
    public int batchRemove(Long[] sgjjIds) {
        return sgjjDao.batchRemove(sgjjIds);
    }

}
