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

    //判断是否存在制造商代码
    @Override
    public List<MfrsDO> haveNum(Map<String, Object> map) {
        return mfrsDao.haveNum(map);
    }

    //【制造商页面List】
    @Override
    public List<MfrsDO> list(Map<String, Object> map) {
        return mfrsDao.list(map);
    }

    //    <!--查询制造商-->
    @Override
    public List<MfrsDO> findMfrs(Map<String, Object> map) {
        return mfrsDao.findMfrs(map);
    }


    @Override
    public int mgcount(Map<String, Object> map) {
        return mfrsDao.mgcount(map);
    }

    @Override
    public int save(MfrsDO mfrs) {
        return mfrsDao.save(mfrs);
    }

    //修改停用启用
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

    //删除修改状态
    @Override
    public int updateState(MfrsDO mfrs) {
        return mfrsDao.updateState(mfrs);
    }
}
