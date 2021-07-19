package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.RxjmjcjDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RxjmjcjDO;
import com.shiguang.jiancha.service.RxjmjcjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RxjmjcjServiceImpl implements RxjmjcjService {
    @Autowired
    private RxjmjcjDao rxjmjcjDao;

    @Override
    public RxjmjcjDO get(Long rxId) {
        return rxjmjcjDao.get(rxId);
    }

    @Override
    public List<RxjmjcjDO> list(Map<String, Object> map) {
        return rxjmjcjDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return rxjmjcjDao.count(map);
    }

    @Override
    public int save(RxjmjcjDO rxjmjcj) {
        return rxjmjcjDao.save(rxjmjcj);
    }

    @Override
    public int saveRxjmjcj(ResultDO result) {
        return rxjmjcjDao.saveRxjmjcj(result);
    }

    @Override
    public int update(RxjmjcjDO rxjmjcj) {
        return rxjmjcjDao.update(rxjmjcj);
    }

    @Override
    public int remove(Long rxId) {
        return rxjmjcjDao.remove(rxId);
    }

    @Override
    public int batchRemove(Long[] rxIds) {
        return rxjmjcjDao.batchRemove(rxIds);
    }

}
