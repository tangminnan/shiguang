package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.KjyyDao;
import com.shiguang.jiancha.domain.KjyyDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.KjyyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class KjyyServiceImpl implements KjyyService {
    @Autowired
    private KjyyDao kjyyDao;

    @Override
    public KjyyDO get(Long kjyyId) {
        return kjyyDao.get(kjyyId);
    }

    @Override
    public List<KjyyDO> list(Map<String, Object> map) {
        return kjyyDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return kjyyDao.count(map);
    }

    @Override
    public int save(KjyyDO kjyy) {
        return kjyyDao.save(kjyy);
    }

    @Override
    public int savekjyy(ResultDO result) {
        return kjyyDao.savekjyy(result);
    }
    //    是否有保存这个验光号数据

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return kjyyDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO resultDO) {
        return kjyyDao.update(resultDO);
    }

    @Override
    public int remove(Long kjyyId) {
        return kjyyDao.remove(kjyyId);
    }

    @Override
    public int upremove(KjyyDO kjyyDO) {
        return kjyyDao.upremove(kjyyDO);
    }

    @Override
    public int batchRemove(Long[] kjyyIds) {
        return kjyyDao.batchRemove(kjyyIds);
    }
}