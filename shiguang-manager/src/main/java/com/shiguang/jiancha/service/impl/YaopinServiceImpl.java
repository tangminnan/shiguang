package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.YaopinDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.YaopinDO;
import com.shiguang.jiancha.service.YaopinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class YaopinServiceImpl implements YaopinService {
    @Autowired
    private YaopinDao yaopinDao;

    @Override
    public YaopinDO get(Long ypId) {
        return yaopinDao.get(ypId);
    }

    @Override
    public List<YaopinDO> list(Map<String, Object> map) {
        return yaopinDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return yaopinDao.count(map);
    }

    @Override
    public int save(YaopinDO yaopin) {
        return yaopinDao.save(yaopin);
    }

    @Override
    public int saveYaopin(ResultDO result) {
        return yaopinDao.saveYaopin(result);
    }

    @Override
    public int update(YaopinDO yaopin) {
        return yaopinDao.update(yaopin);
    }

    @Override
    public int remove(Long ypId) {
        return yaopinDao.remove(ypId);
    }

    @Override
    public int upremove(YaopinDO yaopinDO) {
        return yaopinDao.upremove(yaopinDO);
    }

    @Override
    public int batchRemove(Long[] ypIds) {
        return yaopinDao.batchRemove(ypIds);
    }
}