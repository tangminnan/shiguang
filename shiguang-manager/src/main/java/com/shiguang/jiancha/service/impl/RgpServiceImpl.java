package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.RgpDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RgpDO;
import com.shiguang.jiancha.service.RgpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RgpServiceImpl implements RgpService {
    @Autowired
    private RgpDao rgpDao;

    @Override
    public RgpDO get(Long rgpId) {
        return rgpDao.get(rgpId);
    }

    @Override
    public List<RgpDO> list(Map<String, Object> map) {
        return rgpDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return rgpDao.count(map);
    }

    @Override
    public int save(RgpDO rgp) {
        return rgpDao.save(rgp);
    }

    @Override
    public int saveRgp(ResultDO result) {
        return rgpDao.saveRgp(result);
    }

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return rgpDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO result) {
        return rgpDao.update(result);
    }

    @Override
    public int remove(Long rgpId) {
        return rgpDao.remove(rgpId);
    }

    @Override
    public int upremove(RgpDO rgpDO) {
        return rgpDao.upremove(rgpDO);
    }

    @Override
    public int batchRemove(Long[] rgpIds) {
        return rgpDao.batchRemove(rgpIds);
    }

    @Override
    public RgpDO chufangall(String ptometryNumber, String status) {
        return rgpDao.chufangall(ptometryNumber,status);
    }
}