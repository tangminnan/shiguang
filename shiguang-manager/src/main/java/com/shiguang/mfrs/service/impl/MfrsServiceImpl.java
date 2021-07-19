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
    public List<MfrsDO> list(Map<String, Object> map) {
        return mfrsDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return mfrsDao.count(map);
    }

    //	---商品查询----
    @Override
    public List<MfrsDO> mglist(Map<String, Object> map) {
        return mfrsDao.mglist(map);
    }

    @Override
    public int mgcount(Map<String, Object> map) {
        return mfrsDao.mgcount(map);
    }

    //选择制造商
    @Override
    public List<MfrsDO> findmfrs(Map<String, Object> map) {
        return null;
    }

    @Override
    //选择制造商
    public int countmfrs(Map<String, Object> map) {
        return 0;
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

    //停用启动
    @Override
    public int stop(Integer[] ids, Long status) {
        return mfrsDao.stop(ids, status);
    }

    @Override
    public int updateStatus(MfrsDO mfrsDO) {
        return mfrsDao.update(mfrsDO);
    }
}
