package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.YizhuDao;
import com.shiguang.jiancha.domain.YizhuDO;
import com.shiguang.jiancha.service.YizhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class YizhuServiceImpl implements YizhuService {
    @Autowired
    private YizhuDao yizhuDao;

    @Override
    public YizhuDO get(Long yizhuId) {
        return yizhuDao.get(yizhuId);
    }

    //医嘱
    @Override
    public List<YizhuDO> findYizhu(Map<String, Object> map) {
        return yizhuDao.findYizhu(map);
    }

    @Override
    public int countYizhu(Map<String, Object> map) {
        return yizhuDao.countYizhu(map);
    }

    @Override
    public int save(YizhuDO yizhu) {
        return yizhuDao.save(yizhu);
    }

    @Override
    public int update(YizhuDO yizhu) {
        return yizhuDao.update(yizhu);
    }

    @Override
    public int remove(Long yizhuId) {
        return yizhuDao.remove(yizhuId);
    }

    @Override
    public int batchRemove(Long[] yizhuIds) {
        return yizhuDao.batchRemove(yizhuIds);
    }

}