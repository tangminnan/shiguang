package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.KjjyDao;
import com.shiguang.jiancha.domain.KjjyDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.KjjyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class KjjyServiceImpl implements KjjyService {
    @Autowired
    private KjjyDao kjjyDao;

    @Override
    public KjjyDO get(Long kjjyId) {
        return kjjyDao.get(kjjyId);
    }

    @Override
    public List<KjjyDO> list(Map<String, Object> map) {
        return kjjyDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return kjjyDao.count(map);
    }

    @Override
    public int save(KjjyDO kjjy) {
        return kjjyDao.save(kjjy);
    }

    @Override
    public int savekjjy(ResultDO result) {
        return kjjyDao.savekjjy(result);
    }

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return kjjyDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO result) {
        return kjjyDao.update(result);
    }

    @Override
    public int remove(Long kjjyId) {
        return kjjyDao.remove(kjjyId);
    }

    @Override
    public int upremove(KjjyDO kjjyDO) {
        return kjjyDao.upremove(kjjyDO);
    }

    @Override
    public int batchRemove(Long[] kjjyIds) {
        return kjjyDao.batchRemove(kjjyIds);
    }
}