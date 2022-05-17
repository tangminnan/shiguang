package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.MfrsDao;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.MfrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MfrsServiceImpl implements MfrsService {
    @Autowired
    private MfrsDao mfrsDao;

    @Override
    public MfrsDO get(Integer mfrsid) {
        return mfrsDao.get(mfrsid);
    }

    @Override
    public List<MfrsDO> haveNum(Map<String, Object> map) {
        return mfrsDao.haveNum(map);
    }

    @Override
    public List<MfrsDO> list(Map<String, Object> map) {
        return mfrsDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return mfrsDao.count(map);
    }

    @Override
    public List<MfrsDO> findMfrs(Map<String, Object> map) {
        return mfrsDao.findMfrs(map);
    }


    @Override
    public int findMfrscount(Map<String, Object> map) {
        return mfrsDao.findMfrscount(map);
    }

    @Override
    public int save(MfrsDO mfrs) {
        return mfrsDao.save(mfrs);
    }

    @Override
    public int update(MfrsDO mfrs) {
        return mfrsDao.update(mfrs);
    }

    @Override
    public int remove(Integer mfrsid) {
        return mfrsDao.remove(mfrsid);
    }

    @Override
    public int batchRemove(Integer[] mfrsids) {
        return mfrsDao.batchRemove(mfrsids);
    }

    @Override
    public int updateState(MfrsDO mfrs) {
        return mfrsDao.updateState(mfrs);
    }

    @Override
    public List<MfrsDO> getweiwailist(Map<String, Object> map) {
        return mfrsDao.getweiwailist(map);
    }
}
