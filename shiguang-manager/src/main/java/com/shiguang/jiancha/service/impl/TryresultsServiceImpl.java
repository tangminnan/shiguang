package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.TryresultsDao;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.service.TryresultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TryresultsServiceImpl implements TryresultsService {
    @Autowired
    private TryresultsDao tryresultsDao;

    @Override
    public TryresultsDO get(Long id) {
        return tryresultsDao.get(id);
    }

    @Override
    public List<TryresultsDO> list(Map<String, Object> map) {
        return tryresultsDao.list(map);
    }


    @Override
    public List<TryresultsDO> listUser(Map<String, Object> map) {
        return tryresultsDao.listUser(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return tryresultsDao.count(map);
    }

    @Override
    public int save(TryresultsDO tryresults) {
        return tryresultsDao.save(tryresults);
    }

    @Override
    public List<TryresultsDO> haveYanguangNum(Map<String, Object> map) {
        return tryresultsDao.haveYanguangNum(map);
    }

    @Override
    public int update(TryresultsDO tryresults) {
        return tryresultsDao.update(tryresults);
    }

    @Override
    public int remove(String ptometryNumber) {
        return tryresultsDao.remove(ptometryNumber);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return tryresultsDao.batchRemove(ids);
    }
    @Override
    public List<TryresultsDO> listDoctor(Map<String, Object> map) {
        return tryresultsDao.listDoctor(map);
    }

    @Override
    public List<TryresultsDO> listYanguang(Map<String, Object> map) {
        return tryresultsDao.listYanguang(map);
    }

    @Override
    public TryresultsDO  getTryresult(Map<String, Object> map) {
        return tryresultsDao.getTryresult(map);
    }



    @Override
    public List<TryresultsDO> yanguangListShuju(Map<String, Object> map) {
        return tryresultsDao.yanguangListShuju(map);
    }

    @Override
    public int yanguangListShujuCount(Map<String, Object> map) {
        return tryresultsDao.yanguangListShujuCount(map);
    }


    @Override
    public int updateStatus(TryresultsDO tryresultsDO) {
        return tryresultsDao.updateStatus(tryresultsDO);
    }

    @Override
    public int updateTry(TryresultsDO tryresults) {
        return tryresultsDao.updateTry(tryresults);
    }
}
