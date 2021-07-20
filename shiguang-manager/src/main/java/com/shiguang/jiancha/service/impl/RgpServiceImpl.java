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
    public int update(RgpDO rgp) {
        return rgpDao.update(rgp);
    }

    @Override
    public int remove(Long rgpId) {
        return rgpDao.remove(rgpId);
    }

    @Override
    public int batchRemove(Long[] rgpIds) {
        return rgpDao.batchRemove(rgpIds);
    }

}