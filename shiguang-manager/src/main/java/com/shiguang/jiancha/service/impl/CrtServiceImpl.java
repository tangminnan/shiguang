package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.CrtDao;
import com.shiguang.jiancha.domain.CrtDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.CrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CrtServiceImpl implements CrtService {
    @Autowired
    private CrtDao crtDao;

    @Override
    public CrtDO get(Long crtId) {
        return crtDao.get(crtId);
    }

    @Override
    public List<CrtDO> list(Map<String, Object> map) {
        return crtDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return crtDao.count(map);
    }

    @Override
    public int save(CrtDO crt) {
        return crtDao.save(crt);
    }

    @Override
    public int saveCrt(ResultDO result) {
        return saveCrt(result);
    }

    @Override
    public int update(CrtDO crt) {
        return crtDao.update(crt);
    }

    @Override
    public int remove(Long crtId) {
        return crtDao.remove(crtId);
    }

    @Override
    public int upremove(CrtDO crtDO) {
        return crtDao.upremove(crtDO);
    }

    @Override
    public int batchRemove(Long[] crtIds) {
        return crtDao.batchRemove(crtIds);
    }
}
