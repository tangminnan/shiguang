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
        return crtDao.saveCrt(result);
    }

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return crtDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO result) {
        return crtDao.update(result);
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
    public int updatecrt(CrtDO crtDO) {
        return crtDao.updatecrt(crtDO);
    }

    @Override
    public int batchRemove(Long[] crtIds) {
        return crtDao.batchRemove(crtIds);
    }

    @Override
    public CrtDO chufangall(String ptometryNumber, String status) {
        return crtDao.chufangall(ptometryNumber,status);
    }
}
